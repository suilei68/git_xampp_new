package classNo1;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class Selenium_class1 {
    public static void main(String[] args) throws Exception{
        System.setProperty("webdriver.firefox.bin","D:\\电脑管家软件下载\\火狐浏览器\\firefox.exe");
        System.setProperty("webdriver.firefox.marionette","D:\\firefox\\geckodriver.exe");
        WebDriver driver =new FirefoxDriver();
/*
        //打开百度
        //driver.get("http://www.baidu.com");
        driver.navigate().to("http://wwww.baidu.com");
        //driver.manage().window().setPosition(new Point(10,10));
        driver.manage().window().maximize();

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        System.out.println(driver.getWindowHandle());//打印网页句柄
*/

        driver.get("http://127.0.0.1:81/zentao");
        driver.manage().window().maximize();
        Thread.sleep(200);
        driver.findElement(By.xpath("//input[@id='account']")).sendKeys("suilei");
        //模拟鼠标Tab
//        Actions action = new Actions(driver);
//        action.sendKeys(Keys.TAB).click().perform();
        //截图
        File screenShotFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShotFile1, new File("screen\\text.png"));


        //driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456");
        //driver.findElement(By.xpath("//button[@id='submit']")).click();
    }
}
