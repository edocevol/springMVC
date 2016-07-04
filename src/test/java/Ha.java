import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.SimpleLog;
import org.springframework.util.CommonsLogWriter;
import org.springframework.util.StringUtils;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Administrator on 2016/6/25.
 */
public class Ha {
    private class Name {
        public void sayHello() {
            Ha.this.sayHello();
        }
    }

    public void sayHello() {
        System.out.println("Hello");
    }

    public void use() {
        Name name = new Name();
        name.sayHello();
    }

    public static void main(String[] args) {
        Ha ha = new Ha();
        ha.use();

        String originStr= "hello,my,name,is,frank";
        String [] lines = StringUtils.commaDelimitedListToStringArray(originStr);
        for (String line : lines) {
            System.out.println(line);
        }
    }
    @Test
    public void funct()
    {
        System.out.println("Yes, smida");
    }
    @Test
    public void testExtension()
    {
        String fileNmae ="index.jsp";
        System.out.println(StringUtils.stripFilenameExtension(fileNmae));
    }
    @Test
    public void testCallDefaultRequestToViewName()
    {
        //以下测试时失败的，因为他的方法是受保护的。。。。
/*        DefaultRequestToViewNameTranslator defaultRequestToViewNameTranslator = new DefaultRequestToViewNameTranslator();
        String res = defaultRequestToViewNameTranslator.*/
    }

    @Test
    public void testCommonLogWriter() throws IOException {
        Log log =new SimpleLog("log");
        CommonsLogWriter logWriter =new CommonsLogWriter(log);
        logWriter.write("我是中国人");
    }
}
