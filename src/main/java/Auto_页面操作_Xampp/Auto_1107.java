package Auto_页面操作_Xampp;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * TODO 第一个用例
 * Created by Administrator on 2016-11-07.
 * 1、登录禅道，添加组织AutoTest，添加用户AutoTester
 * 2、新建产品Auto，添加模块，然后新建需求Automation
 */
public class Auto_1107 {
    public static void main(String[] args) throws InterruptedException {
        final String URl="http://192.168.1.213:81/zentao";
        System.setProperty("webdriver.chrome.bin","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        System.setProperty("webdriver.chrome.driver","D:\\firefox\\chromedriver1.exe");

        WebDriver driver=new ChromeDriver();
        driver.get(URl);
        driver.manage().window().maximize();
        //定位账号输入框
        driver.findElement(By.xpath("//input[@id='account']")).sendKeys("admin");
        //我不信开发那二狗子会改密码输入框
        //模拟键盘操作
        Actions action= new Actions(driver) ;
        action.sendKeys(Keys.TAB).sendKeys("123456").perform();
        action.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        //定位元素输入密码和点击登录
        //driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456");
        //driver.findElement(By.xpath("//button[@id='submit']")).click();
        Thread.sleep(800);
//-------------------------------------------------------------------------------------------------

        //定位组织
        driver.findElement(By.xpath("//a[@href='/zentao/company/']")).click();
        //定位组织-用户
        driver.findElement(By.xpath("//a[@href='/zentao/company-browse.html']")).click();
        //定位组织-部门
        driver.findElement(By.xpath("//a[@href='/zentao/dept-browse.html']")).click();
        //定位组织-权限
        driver.findElement(By.xpath("//a[@href='/zentao/group-browse.html']")).click();
        //定位组织-公司
        driver.findElement(By.xpath("//a[@href='/zentao/company-view.html']")).click();
        //定位组织-动态
        driver.findElement(By.xpath("//a[@href='/zentao/company-dynamic.html']")).click();

//----------------------------------------------------------------------------------------------


        //返回到组织-部门
        driver.findElement(By.xpath("//a[@href='/zentao/dept-browse.html']")).click();
        //添加部门(没有输入东西的一列输入框)
//        List<WebElement> kong=driver.findElements(By.xpath("//input[@id='depts[]']"));
//        kong.get(0).sendKeys("市场部AutoTest");
//        kong.get(1).sendKeys("tatata");
        driver.findElement(By.xpath("//input[@id='depts[]']")).sendKeys("市场部AutoTest");
        //点击保存
        WebElement baocun=driver.findElement(By.xpath("//form[@class='form-condensed']"));
        baocun.submit();
        //删除部门
        Thread.sleep(2000);
        driver.findElement(By.xpath("//ul[@id='deptTree']/li/span/a[.='市场部AutoTest']/parent::span/following-sibling::div/a[.='删除']")).click();
        Thread.sleep(2000);
        //弹窗确认
        Alert loginAlert =driver.switchTo().alert();
        System.out.println(loginAlert.getText());
        Thread.sleep(2000);
        loginAlert.accept();
        Thread.sleep(2000);



        //点击添加用户
        driver.findElement(By.xpath("//a[@href='/zentao/user-create-0.html']")).click();
        //定位所属部门
        driver.findElement(By.xpath("//span[@title='/']")).click();
        driver.findElement(By.xpath("//li[contains(text(),'/AutoTest')]")).click();
        //定位用户名
        driver.findElement(By.xpath("//input[@id='account']")).sendKeys("AutoTester2");
        //真实姓名
        driver.findElement(By.xpath("//input[@id='realname']")).sendKeys("自动化测试工程师");
        //密码
        driver.findElement(By.xpath("//input[@id='password1']")).sendKeys("123456");
        //重复密码
        driver.findElement(By.xpath("//input[@id='password2']")).sendKeys("123456");
        //定位职位
        Select role=new Select(driver.findElement(By.xpath("//select[@id='role']")));
        role.selectByValue("qd");
        //分组
        driver.findElement(By.xpath("//div[@id='group_chosen']")).click();
        driver.findElement(By.xpath("//div[@id='group_chosen']/div/ul/li[3]")).click();
        //邮箱
        //action.sendKeys(Keys.TAB).sendKeys("AutoTester@163.com").perform();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("AutoTester@163.com");
        //源代码账号
        //action.sendKeys(Keys.TAB).sendKeys("admin").perform();
        driver.findElement(By.xpath("//input[@id='commiter']")).sendKeys("admin");
        //入职时间
        driver.findElement(By.xpath("//input[@id='join']")).sendKeys("2016-12-15");
        //性别选择女
        driver.findElement(By.xpath("//input[@id='genderf']")).click();
        //请输入你的密码
        driver.findElement(By.xpath("//input[@id='verifyPassword']")).sendKeys("123456");
        //点击保存
        WebElement baocun2=driver.findElement(By.xpath("//form[@id='dataform']"));
        baocun2.submit();

//--------------------------------------------------------------------------------------------------

        //返回产品
        driver.findElement(By.xpath("//a[@href='/zentao/product/']")).click();
        //添加产品
        driver.findElement(By.xpath("//a[@href='/zentao/product-create.html']")).click();
        //产品名称
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Auto2");
        //后面的需求中的产品也要改
        //产品代号
        driver.findElement(By.xpath("//input[@id='code']")).sendKeys("Auto2");
        //产品负责人
        driver.findElement(By.xpath("//div[@id='PO_chosen']")).click();
        driver.findElement(By.xpath("//div[@id='PO_chosen']/div/ul/li[4]")).click();
        //测试负责人
        driver.findElement(By.xpath("//div[@id='QD_chosen']")).click();
        driver.findElement(By.xpath("//div[@id='QD_chosen']/div/ul/li[1]")).click();
        //发布负责人
        driver.findElement(By.xpath("//div[@id='RD_chosen']")).click();
        driver.findElement(By.xpath("//div[@id='RD_chosen']/div/ul/li[5]")).click();
        //产品类型
        Select leixing=new Select(driver.findElement(By.xpath("//select[@id='type']")));
        leixing.selectByValue("platform");//多平台
        //产品描述
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='ke-edit-iframe']")));
        WebElement shuru=driver.findElement(By.xpath("//body[@class='article-content']"));
        shuru.sendKeys("自动化脚本");
        //跳出
        driver.switchTo().defaultContent();
        Thread.sleep(500);

//------------------------------------------------------------------------------------------------
//------------------跳出啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊----------------------------------
        //访问控制(可用兄弟节点),或使用键盘模拟操作
        //使用兄弟节点(后一个节点)（前一个preceding-sibling::* ）
        //List<WebElement> danxuan=driver.findElements(By.xpath("//th[contains(text(),'访问控制')]/following-sibling::td/div/label/input"));
        //danxuan.get(2).click();
        driver.findElement(By.xpath("//form[@class='form-condensed']")).click();
        driver.findElement(By.xpath("//input[@id='aclcustom']")).click();
        //自定义白名单选择多选按钮
        driver.findElement(By.xpath("//form[@class='form-condensed']")).click();
        driver.findElement(By.xpath("//input[@id='whitelist1']")).click();
        driver.findElement(By.xpath("//input[@id='whitelist3']")).click();
        driver.findElement(By.xpath("//input[@id='whitelist8']")).click();
        driver.findElement(By.xpath("//input[@id='whitelist13']")).click();
        //点击保存
        WebElement mokuaibaocun=driver.findElement(By.xpath("//form[@class='form-condensed']"));
        mokuaibaocun.submit();

//-------------------------------------------------------------------------------------------------

        //产品添加模块和需求
        //返回产品
        driver.findElement(By.xpath("//a[@href='/zentao/product/']")).click();
        //选择产品
        driver.findElement(By.xpath("//a[@id='currentItem']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//a[contains(text(),'Auto')]")).click();


        //选择模块
        driver.findElement(By.linkText("模块")).click();
        //输入模块名称
        List<WebElement> automokuai=driver.findElements(By.xpath("//input[@name='modules[]']"));
        automokuai.get(0).sendKeys("自动化");
        List<WebElement> autojiancheng=driver.findElements(By.xpath("//input[@name='shorts[]']"));
        autojiancheng.get(0).sendKeys("zdh");

        automokuai.get(1).sendKeys("登录");
        autojiancheng.get(1).sendKeys("login");
        automokuai.get(2).sendKeys("界面");
        autojiancheng.get(2).sendKeys("jm");
        automokuai.get(3).sendKeys("系统设置");
        autojiancheng.get(3).sendKeys("xtsz");
        automokuai.get(4).sendKeys("退出");
        autojiancheng.get(4).sendKeys("logout");

        //保存
        WebElement baocun3=driver.findElement(By.xpath("//form[@id='childrenForm']"));
        baocun3.submit();


        //点击需求
        driver.findElement(By.linkText("需求")).click();
        //点击提需求
        Thread.sleep(800);
        //driver.findElement(By.xpath("//a[@href='/zentao/story-create-23-0-0.html']")).click();
        driver.findElement(By.linkText("提需求")).click();

        //所属产品----------------------这里的产品名称和上面设置的要一样
        driver.findElement(By.xpath("//span[@title='Auto2']")).click();
        driver.findElement(By.xpath("//div[@class='chosen-drop']/ul/li[1]")).click();
        //所有平台
        Select pingtai=new Select(driver.findElement(By.xpath("//select[@name='branch']")));
        pingtai.selectByValue("0");
        //所属模块
        driver.findElement(By.xpath("//span[@title='/']")).click();
        driver.findElement(By.xpath("//div[@id='moduleIdBox']/div/div/ul/li[2]")).click();
        //需求来源
        Select from =new Select(driver.findElement(By.xpath("//select[@name='source']")));
        from.selectByValue("market");
        //由谁评审
        driver.findElement(By.xpath("//div[@id='assignedTo_chosen']")).click();
        driver.findElement(By.xpath("//li[contains(text(),'A:自动化测试工程师')]")).click();
        //不需要评审
        driver.findElement(By.xpath("//div[@class='input-group']/span/label/input")).click();
        //需求名称颜色
        driver.findElement(By.xpath("//div[@class='colorpicker input-group-btn']")).click();
        List<WebElement>  color =driver.findElements(By.xpath("//a[@class='cp-tile']"));
        color.get(4).click();
        //需求名称
        List<WebElement>  wenbenkuangshuru=driver.findElements(By.xpath("//input[@id='title']"));
        wenbenkuangshuru.get(0).sendKeys("Automation1");
        //优先级
        driver.findElement(By.xpath("//div[@class='input-group-btn dropdown-pris']")).click();
        driver.findElement(By.xpath("//span[@class='pri4']")).click();
        //预计时间
        driver.findElement(By.id("estimate")).sendKeys("12");

        //需求描述 跳进iframe
        //driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='ke-edit-iframe']")));
        List<WebElement> iframe=driver.findElements(By.xpath("//iframe[@class='ke-edit-iframe']"));
        driver.switchTo().frame(iframe.get(0));
        driver.findElement(By.xpath("//body[@class='article-content']")).sendKeys("自动执行一天脚本");
        driver.switchTo().defaultContent();
        //跳出这个iframe发现下一个的class一样 使用模拟键盘TAB
        //action.sendKeys(Keys.TAB).sendKeys("执行一天一夜不准给老衲休息").perform();
        driver.switchTo().frame(iframe.get(1));
        driver.findElement(By.xpath("//body[@class='article-content']")).sendKeys("执行一天一夜不准给老衲休息");
        driver.switchTo().defaultContent();
        //抄送给


        driver.findElement(By.xpath("//form[@class='form-condensed']")).click();
        driver.findElement(By.xpath("//div[@id='mailto_chosen']")).click();
        driver.findElement(By.xpath("//div[@id='mailto_chosen']/div/ul/li[5]")).click();

        //关键字
        driver.findElement(By.id("keywords")).sendKeys("自动化");
        //上传文件
        WebElement upload=driver.findElement(By.xpath("//input[@class='fileControl']"));
        String filepath="E:/abc.txt";
        upload.sendKeys(filepath);
        //标题
        driver.findElement(By.xpath("//input[@name='labels[]']")).sendKeys("zdh");
        //保存
        WebElement xuqiubaocun=driver.findElement(By.xpath("// form[@class='form-condensed']"));
        xuqiubaocun.submit();

    }
}
