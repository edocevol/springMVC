import org.testng.annotations.Test;

/**
 * Created by Administrator on 2016/7/4.
 */
class People{
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public People(String userName) {
        this.userName = userName;
    }


}
public class ClassTest extends People{
    private int age;

    public ClassTest(String userName, int age) {
        super(userName);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Test
    public static void test1()
    {
        People classTest = new ClassTest("xiaoniu",23);
        System.out.println(classTest.getUserName());
    }
}
