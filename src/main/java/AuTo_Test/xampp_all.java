package AuTo_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class xampp_all {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.bin","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        System.setProperty("webdriver.chrome.driver","D:\\firefox\\chromedriver1.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://127.0.0.1:81/zentao");
        driver.manage().window().maximize();
/*
        //不输入账号与密码登录
        driver.findElement(By.xpath("//button[@id='submit']")).click();
        //弹出窗口用Alert跳进窗口进行操作
        Alert loginAlert =driver.switchTo().alert();
        //获得弹窗文字
        System.out.println(loginAlert.getText());
        Thread.sleep(1000);
        //loginAlert.accept();
        //取消
        //loginAlert.dismiss();

*/

//        WebElement element=driver.findElement(By.id("account"));
//        element.sendKeys("admin");
        driver.findElement(By.xpath("//input[@id='account']")).sendKeys("suilei");
        //driver.findElement(By.name("password")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456");
        //driver.findElement(By.id("submit")).click();
        driver.findElement(By.xpath("//button[@id='submit']")).click();



/*
        //点击我的地盘
        driver.findElement(By.xpath("//span[contains(text(),'我的地盘')]")).click();
       //产品
        WebElement product = driver.findElement(By.xpath("//a[@href='/zentao/product/']"));
        if (product.isDisplayed()){
            product.click();
        }else{
            Thread.sleep(1000);
            product.click();
        }

        //项目
        driver.findElement(By.xpath("//a[@href='/zentao/project/']")).click();
        //测试
        driver.findElement(By.xpath("//a[@href='/zentao/qa/']")).click();
        //文档
        driver.findElement(By.xpath("//a[@href='/zentao/doc/']")).click();
        //统计
        driver.findElement(By.xpath("//a[@href='/zentao/report/']")).click();
        //组织
        driver.findElement(By.xpath("//a[@href='/zentao/company/']")).click();
        //后台
        driver.findElement(By.xpath("//a[@href='/zentao/admin/']")).click();
*/

        //进入测试
        WebElement qa=driver.findElement(By.xpath("//a[@href='/zentao/qa/']"));
        qa.click();
       //打开右边的窗口
        WebElement selectMeau = driver.findElement(By.xpath("//a[@id='currentItem']"));
        selectMeau.click();
        Thread.sleep(500);
        //选择隋磊
        selectMeau.findElement(By.xpath("//a[contains(text(),' 美萍记账通_隋磊')]")).click();
        Thread.sleep(500);

/*
        //未关闭
        driver.findElement(By.xpath("//a[@href='/zentao/bug-browse-4-0-unclosed-0.html']")).click();
        //所有
        driver.findElement(By.xpath("//a[@href='/zentao/bug-browse-4-0-all-0.html']")).click();
        //指派给我
        driver.findElement(By.xpath("//a[@href='/zentao/bug-browse-4-0-assigntome-0.html']")).click();
        //由我创建
        driver.findElement(By.xpath("//a[@href='/zentao/bug-browse-4-0-openedbyme-0.html']")).click();
        //由我解决
        driver.findElement(By.xpath("//a[@href='/zentao/bug-browse-4-0-resolvedbyme-0.html']")).click();
        //未确认
        driver.findElement(By.xpath("//a[@href='/zentao/bug-browse-4-0-unconfirmed-0.html']")).click();
        //未指派
        driver.findElement(By.xpath("//a[@href='/zentao/bug-browse-4-0-assigntonull-0.html']")).click();
        //未解决
        driver.findElement(By.xpath("//a[@href='/zentao/bug-browse-4-0-unresolved-0.html']")).click();
        //待关闭
        driver.findElement(By.xpath("//a[@href='/zentao/bug-browse-4-0-toclosed-0.html']")).click();
        //久未处理
        driver.findElement(By.xpath("//a[@href='/zentao/bug-browse-4-0-longlifebugs-0.html']")).click();
        //被延迟
        driver.findElement(By.xpath("//a[@href='/zentao/bug-browse-4-0-postponedbugs-0.html']")).click();
        //需求变动
        driver.findElement(By.xpath("//a[@href='/zentao/bug-browse-4-0-needconfirm-0.html']")).click();
        //搜索
        driver.findElement(By.xpath("//a[@href='#']")).click();
*/

        //返回测试
        driver.findElement(By.xpath("//a[@href='/zentao/qa/']")).click();
        //提bug
        driver.findElement(By.xpath("//a[contains(text(),' 提Bug')]")).click();
        Thread.sleep(1000);
        //所属产品
        driver.findElement(By.xpath("//span[@title='美萍记账通_隋磊']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[contains(text(),'美萍记账通_隋磊')]")).click();
//         江老板写的
//        driver.findElement(By.xpath("//div[@id='product_chosen']")).click();
//        driver.findElement(By.xpath("/[contains(text(),'美萍记帐通-江灿华')]")).click();

        //所属模块
        driver.findElement(By.xpath("//span[@title='/']")).click();
        driver.findElement(By.xpath("//li[contains(text(),'/界面模块')]")).click();

//        //所属模块江老板
//        driver.findElement(By.xpath("//div[@id='module_chosen']")).click();
//        driver.findElement(By.xpath("/[contains(text(),'/登录')]")).click();

        //所属项目
        driver.findElement(By.xpath("//a[@class='chosen-single chosen-default']")).click();
        driver.findElement(By.xpath("//li[contains(text(),'美萍软件第一期_隋磊')]")).click();
//      江老板写的
//        driver.findElement(By.xpath("//span[@id='projectIdBox']")).click();
//        driver.findElement(By.xpath("/[contains(text(),'美萍记帐通+江灿华')]")).click();

        Thread.sleep(500);
        //定位版本位置
        WebElement version=driver.findElement(By.xpath("//span[@id='buildBox']"));
        version.click();
        driver.findElement(By.xpath("//li[contains(text(),'MP_V1.0')]")).click();

        //刷新按钮
        List<WebElement> shuaxin = driver.findElements(By.xpath("//button[@class='btn btn-default']"));
        shuaxin.get(2).click();
        Thread.sleep(200);
        //当前指派

        driver.findElement(By.xpath("//span[@id='assignedToBox']")).click();
        driver.findElement(By.xpath("//div[@id='assignedTo_chosen']")).click();//江老板先定位框
        driver.findElement(By.xpath("//li[contains(text(),'S:隋磊')]")).click();

        //bug类型
        Select bug=new Select(driver.findElement(By.xpath("//select[@name='type']")));
        bug.selectByValue("interface");
        //操作系统
        Select os=new Select(driver.findElement(By.xpath("//select[@name='os']")));
        os.selectByValue("win7");
        //浏览器
        Select browser=new Select(driver.findElement(By.xpath("//select[@name='browser']")));
        browser.selectByValue("ie11");
        //bug标题颜色
        driver.findElement(By.xpath("//div[@class='colorpicker input-group-btn']")).click();
        List<WebElement> color = driver.findElements(By.xpath("//a[@class='cp-tile']"));
        color.get(7).click();
        //driver.findElement(By.xpath("//a[@data-color='#3f51b5']")).click();//江老板

        //输入bug标题
        WebElement text=driver.findElement(By.xpath("//input[@id='title']"));
        text.click();
        text.sendKeys("页面丑到自己怕");
        //严重程度选择和优先级选择
        List<WebElement> xuan=driver.findElements(By.xpath("//div[@class='input-group-btn dropdown-pris']"));
        xuan.get(0).click();
        driver.findElement(By.xpath("//span[@class='severity3']")).click();

        xuan.get(1).click();
        driver.findElement(By.xpath("//span[@class='pri2']")).click();
//！！！！！！！！操作步骤  用.frame(里边是元素时，下面第一条是错的，没有放回元素)
        //driver.switchTo().frame(By.xpath("//iframe[@class='ke-edit-iframe']"));
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='ke-edit-iframe']")));

        //
        Thread.sleep(1000);

        WebElement aa=driver.findElement(By.xpath("//p[contains(text(),'[步骤]')]"));
        //强行获取焦点
        Actions actions = new Actions(driver);
        actions.moveToElement(aa);
        actions.click();
        actions.sendKeys("打开冰箱,塞进去,关上冰箱。");
        actions.build().perform();
//        WebElement bb=driver.findElement(By.xpath("//p[contains(text(),'[结果]')]"));
//        bb.sendKeys("2222222222");
//        WebElement cc=driver.findElement(By.xpath("//p[contains(text(),'[期望]')]"));
//        cc.sendKeys("3333333333");

//!!!!!!!注意一定要跳出frame才能进行下面主frame的定位！！！！！！！！！！！！！！！！！！！！！！！
        driver.switchTo().defaultContent();
        //相关需求
        Thread.sleep(800);
        driver.findElement(By.xpath("//div[@id='story_chosen']")).click();
        driver.findElement(By.xpath("//li[contains(text(),'66:收入记账(优先级:0,预计工时:0)')]")).click();


        //抄送人
        driver.findElement(By.xpath("//div[@id='mailto_chosen']")).click();
        driver.findElement(By.xpath("//div[@id='mailto_chosen']/div/ul/li[4]")).click();

//        //抄送给，谢昭富写的
//        driver.findElement(By.xpath("//input[@value='选择要发信通知的用户...']")).click();
//        driver.findElement(By.xpath("//li[contains(text(),'L:刘美琼')]")).click();



        //关键字
        Thread.sleep(800);
        WebElement guan=driver.findElement(By.xpath("//input[@name='keywords']"));
        guan.sendKeys("界面丑");
        //上传文件的元素操作：
        WebElement adFileUpload = driver.findElement(By.className("fileControl"));
        String filePath = "E:/abc.txt";
        adFileUpload.sendKeys(filePath);

        //保存
        WebElement approve = driver.findElement(By.id("dataform"));
        approve.submit();





    /*
        //账号管理
        driver.findElement(By.xpath("//a[contains(text(),'隋磊')]")).click();
        driver.findElement(By.xpath("//a[@href='/zentao/my-profile.html?onlybody=yes']")).click();

        driver.switchTo().frame("modalIframe");
        driver.findElement(By.xpath("//a[@href='/zentao/my-editprofile.html?onlybody=yes']")).click();

        WebElement mobile=driver.findElement(By.xpath("//input[@name='mobile']"));

        mobile.clear();
        mobile.sendKeys("15773231891");

        WebElement mima=driver.findElement(By.xpath("//input[@name='verifyPassword']"));
        mima.sendKeys("123456");

        WebElement baocun = driver.findElement(By.className("form-condensed"));
        baocun.submit();

        //driver.switchTo().defaultContent();
  WebElement close=driver.findElement(By.xpath("//div[@id='ajaxModal']")).findElement(By.xpath("/button[@class='close']"));
//        close.click();//定位到×，并点击关闭
    */


    }
}
