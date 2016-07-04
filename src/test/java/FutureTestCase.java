import org.testng.annotations.Test;

import java.util.concurrent.*;

/**
 * Created by Administrator on 2016/7/4.
 */
public class FutureTestCase {

    @Test
    public void test1() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Double data[] = new Double[]{210.32, 289.00, -2354.90, -122.187};

        //获取前两个比较大的数据
        BiggerCallable c1 = new BiggerCallable(data[0],data[1]);
        Future<Double> future1 = executorService.submit(c1);
       //获取后两个里比较大的数据
        BiggerCallable c2= new BiggerCallable(data[2], data[3]);
        Future<Double> future2 = executorService.submit(c2);
        BiggerCallable c3 = new BiggerCallable(future1.get(), future2.get());

        //最终2选一
        Future<Double> future3 = executorService.submit(c3);

        //输出结果并关闭连接
        System.out.println(future3.get());
        executorService.shutdown();
    }

}

class BiggerCallable implements Callable {
    Double d1, d2;

    public BiggerCallable(Double d1, Double d2) {
        this.d1 = d1;
        this.d2 = d2;
    }

    public Object call() throws Exception {
        return d1 > d2 ? d1 : d2;
    }
}
