package Auto_页面操作_Xampp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class auto_1104 {
    public static void main(String[] args) throws InterruptedException {
        final String URL="http://127.0.0.1:81/zentao";
        System.setProperty("webdriver.chrome.bin","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        System.setProperty("webdriver.chrome.driver","D:\\firefox\\chromedriver1.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        Thread.sleep(800);
        driver.findElement(By.xpath("//input[@id='account']")).sendKeys("suilei");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@id='submit']")).click();


        //打开测试
        Thread.sleep(1000);
        WebElement qa=driver.findElement(By.xpath("//a[@href='/zentao/qa/']"));
        qa.click();
        //打开右边的窗口
        WebElement selectMeau = driver.findElement(By.xpath("//a[@id='currentItem']"));
        selectMeau.click();
        Thread.sleep(2000);
        //选择隋磊
        selectMeau.findElement(By.xpath("//a[contains(text(),' 美萍记账通_隋磊')]")).click();
        Thread.sleep(1000);
        //点击搜索
        driver.findElement(By.xpath("//a[@href='#']")).click();
        Thread.sleep(1000);


        //第一个框下拉选择
        WebElement selectelement1=driver.findElement(By.xpath("//select[@name='field1']"));
        Select select1=new Select(selectelement1);
        select1.selectByValue("severity");
        //第二个框下拉选择
        Thread.sleep(1000);
        WebElement selectelement2=driver.findElement(By.xpath("//select[@id='operator1']"));
        Select select2=new Select(selectelement2);
        select2.selectByValue(">");
        //第三个框下拉选择
        driver.findElement(By.xpath("//td[@id='valueBox1']")).click();
        //driver.findElement(By.id("value4_chosen"))
        driver.findElement(By.xpath("//li[contains(text(),'2')]")).click();
        //并且下拉框
        WebElement selectelement4=driver.findElement(By.xpath("//select[@name='groupAndOr']"));
        Select select4=new Select(selectelement4);
        select4.selectByValue("or");

        Thread.sleep(1000);
        //第二组第一个选择框
        WebElement selectelement5=driver.findElement(By.xpath("//select[@id='field4']"));
        Select select5=new Select(selectelement5);
        select5.selectByValue("os");
        //第二组第二个
        WebElement selectelement6=driver.findElement(By.xpath("//select[@id='operator4']"));
        Select select6=new Select(selectelement6);
        select6.selectByValue("=");
        //第二组第三个
        //driver.findElement(By.xpath("//td[@id='valueBox4']")).click();
        driver.findElement(By.xpath("//div[@classname='chosen-container chosen-container-single chosen-container-active chosen-with-drop']")).click();
        driver.findElement(By.xpath("//li[contains(text(),'Windows 7')]")).click();
        Thread.sleep(1000);
        //点击搜索
        driver.findElement(By.xpath("//button[contains(text(),'搜索')]")).click();

    }
}
