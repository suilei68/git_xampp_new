package fengZhuang.test;

import fengZhuang.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;


public class XamppTest {
    PageNew pageNew= new PageNew(1);
//    @Test
//    @Parameters({"login_user","login_password"})
//    public void LoginTest(String login_user,String login_password) {
//        LoginPage login=new LoginPage(pageNew);
//        pageNew.OpenURL("http://127.0.0.1:81/zentao");
//        login.Login(login_user,login_password);
//    }
    //数据的提供商
    public static String fileName="Xampp";
    public static String sheetName="login";
    @DataProvider(name = "db")
    public Object[][] getData() throws IOException {
        ExportExcel excel = new ExportExcel(fileName, sheetName);
        return excel.getExcelData();
    }
    //数据的使用者放在page类的测试类中
    @Test(dataProvider = "db")
    public void LoginTest(HashMap<String, String> data) {
        LoginPage login=new LoginPage(pageNew);
        pageNew.OpenURL("http://127.0.0.1:81/zentao");
        login.Login(data.get("user_name"),data.get("user_password").replace(".0",""));
    }

    @Parameters({"department"})
    @Test
    public void Test1Test(String department){
        test1Page test1=new test1Page(pageNew);
        test1.addDepartment(department);
    }

}
