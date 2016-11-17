package TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2016-11-13.
 */
public class TestNG_demo {
    @Parameters({"name","age"})
    @Test(groups = {"class","newDream"})
    public void setName(String name,int age){
        System.out.println("姓名="+name);
        System.out.println("年龄="+age);
    }
    @Parameters({"number"})
    @Test(groups = {"class"})
    public void setNumber(int number){
        System.out.println("输入为："+number);
    }
    @Parameters({"sex"})
    @Test(groups = {"newDream"})
    public void setSex(String sex){
        System.out.println("性别为："+sex);
    }
}
