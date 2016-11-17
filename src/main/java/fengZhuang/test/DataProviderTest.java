package fengZhuang.test;

import fengZhuang.ExportExcel;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Administrator on 2016-11-15.
 */
public class DataProviderTest {
    public static String fileName="Xampp";
    public static String sheetName="login";
    @DataProvider(name = "xampp")
    //数据的提供商
    public Object[][] getData() throws IOException {
        ExportExcel excel = new ExportExcel(fileName, sheetName);
        return excel.getExcelData();
    }

    //数据的使用者放在page类的测试类中
    @Test(dataProvider = "xampp")
    public void test(HashMap<String, String> data) {
        //System.out.println(data.toString());
        Iterator iterator = data.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            String key = entry.getKey().toString();
            String val = entry.getValue().toString();
        }
        System.out.println(data.get("user_name"));
        //System.out.println(data.get("login_password").replace(".0",""));
    }
}
