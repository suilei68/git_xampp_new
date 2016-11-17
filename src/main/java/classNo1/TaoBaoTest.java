package classNo1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaoBaoTest {
    public static void main(String[] args) throws Exception {
          //System.setProperty("webdriver.firefox.bin","D:\\电脑管家软件下载\\火狐浏览器\\firefox.exe");
          System.setProperty("webdriver.chrome.bin","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
         //System.setProperty("webdriver.firefox.marionette","");
         //System.setProperty("webdriver.gecko.driver","");
          System.setProperty("webdriver.chrome.driver","D:\\firefox\\chromedriver1.exe");

        //WebDriver driver = new FirefoxDriver();//创建火狐
        WebDriver driver = new ChromeDriver();//创建谷歌

        //driver.get("http://www.baidu.com");//打开百度
        driver.get("http://www.taobao.com");//淘宝
        //driver.navigate().refresh();刷新
        driver.manage().window().maximize();//最大化

        //driver.wait(1000);
        //定位输入框，返回一个页面element元素对象
        //WebElement element = driver.findElement(By.id("kw"));
        WebElement element = driver.findElement(By.id("q"));
        element.sendKeys("笔记本");//输入值
        //driver.findElement(By.id("su")).click();
        driver.findElement(By.className("btn-search")).click();
        driver.findElement(By.id("J_Itemlist_Pic_525384788592")).click();
        driver.findElement(By.xpath("//a[contains(text(),'银灰色')]")).click();
        driver.findElement(By.id("J_LinkBuy")).click();
        //driver.close();
    }
}