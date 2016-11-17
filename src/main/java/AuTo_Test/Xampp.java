package AuTo_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Xampp {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.firefox.bin","D:\\电脑管家软件下载\\火狐浏览器\\firefox.exe");
        //System.setProperty("webdriver.chrome.bin","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        System.setProperty("webdriver.firefox.marionette","D:\\firefox\\geckodriver.exe");
        //System.setProperty("webdriver.chrome.driver","D:\\firefox\\chromedriver1.exe");

        WebDriver driver = new FirefoxDriver();
        //WebDriver driver =new ChromeDriver();

        driver.get("http://192.168.1.213:81/zentao");
        driver.manage().window().maximize();

        WebElement element=driver.findElement(By.id("account"));
        element.sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("123456");
        //driver.findElement(By.id("submit")).click();

        //登录界面其他元素定位
        driver.findElement(By.id("keepLoginon")).click();

        driver.findElement(By.className("icon-mobile")).click();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Thread.sleep(500);
        driver.findElement(By.className("icon-mobile")).click();
        Thread.sleep(500);
        driver.findElement(By.linkText("忘记密码")).click();
        Thread.sleep(500);
        driver.navigate().back();
        WebElement language = driver.findElement(By.id("langs"));
        language.click();
        Thread.sleep(500);
        language.findElement(By.linkText("English")).click();

        //language.findElement(By.xpath("//a[@href='###']"));


//        List<WebElement> testButton= driver.findElements(By.linkText("测试"));
//        testButton.get(0).click();
//        driver.navigate().back();
//        driver.navigate().forward();
//        driver.navigate().refresh();
    }
}
