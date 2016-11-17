package fengZhuang;

import org.openqa.selenium.By;

public class Encapsulation_Xampp extends ElementOperate{
    public Encapsulation_Xampp(int driverType) {
        super(driverType);
    }
    public static void main(String[] args) {
        //这里构造方法的时候就输入想要打开的浏览器，1为谷歌浏览器
        Encapsulation_Xampp test=new Encapsulation_Xampp(1);
        test.OpenURL("http://127.0.0.1:81/zentao");
        //test.Login();
        //test.Project();
        //弹框处理
        //test.AlertAccept();
        //关联需求
        //test.Requirement();
        //给项目添加特定的项目成员
        //test.Member();
        //创建项目版本1.0
        //test.Version();
        //新建任务
        //test.Mission();
        test.BuildUseCase();
        test.ImplementUseCase();
        test.DeleteUseCase();
    }
    /**
     * TODO AutoTest_第二个用例
     *
     * @author Administrator
     * @dateTime 2016-11-09 9:08
     * @param
     * @return
     * 1、新建项目AutoProject，关联产品Auto，关联需求Automation
     * 2、给项目添加特定的项目成员
     * 3、创建AutoProject项目版本1.0
     * 4、新建任务AutoTest
     */
//    public void Login(){
//        //定位账号输入框并输入
//        super.FindElementBy_id("account").sendKeys("admin");
//        //定位密码输入框并输入
//        super.FindElementBy_name("password").sendKeys("123456");
//        //定位登录按钮
//        super.FindElementBy_xpath("//button[@id='submit']").click();
//    }
//    public void Project(){
//        //点击项目
//        super.FindElementBy_xpath("//a[@href='/zentao/project/']").click();
//        //添加项目
//        super.FindElementBy_xpath("//a[@href='/zentao/project-create.html']").click();
//        //项目名称
//        super.FindElementBy_id("name").sendKeys("AutoProject");
//        //项目代号
//        super.FindElementBy_id("code").sendKeys("APJ");
//        //起始时间
//        super.Clear(By.id("begin")).sendKeys(super.getNowTime("yyyy-MM-dd"));
//
//        //手动输入截止时间(这里要加上点击外面的表格，让选择日期的框回缩才能执行下面的定位)
//        //test.FindElementBy_id("end").sendKeys("2016-11-19");
//        //test.FindElementBy_id("dataform").click();
//        //选择项目周期
//        super.TimeLength(1);
//
//        //团队名称
//        super.FindElementBy_id("team").sendKeys("隋式集团");
//        //项目类型
//        super.SelectByValue(By.id("type"),"ops");
//        //关联产品
//        super.SelectAndInput(By.id("products0_chosen"),By.xpath("//div[@id='products0_chosen']/div/ul/li[1]"));
//        //跳进项目描述iframe
//        super.SwitchToBy_WebElement("//iframe[@class='ke-edit-iframe']");
//        super.FindElementBy_xpath("//body[@class='article-content']").sendKeys("这是一个自动化项目");
//        super.SwitchTo_junpOut();
//        //访问权限
//        super.FindElementBy_id("dataform").click();//通过点击表单来执行后续定位
//        super.FindElementBy_xpath("//input[@id='aclprivate']").click();
//        //保存
//        super.Submit("//td[@class='text-center']/button");
//    }
    public void Requirement(){
        //点击项目
        super.FindElementBy_xpath("//a[@href='/zentao/project/']").click();
        //点击需求
        super.FindElementBy_linkText("需求").click();
        //点击右边的产品选择
        super.FindElementBy_id("currentItem").click();
        super.FindElementBy_xpath("//div[@id='defaultMenu']//a[.=' AutoProject']").click();
        //关联需求
        super.FindElementBy_linkText("关联需求").click();
        //勾选需求
        super.FindElementBy_xpath("//input[@value='89']").click();
        //点击保存
        super.Submit("//form[@id='linkStoryForm']");
    }
    public void Member(){
        //点击项目
        super.FindElementBy_xpath("//a[@href='/zentao/project/']").click();
        //点击团队
        super.FindElementBy_linkText("团队").click();
        //点击右边的产品选择
        super.FindElementBy_id("currentItem").click();
        super.FindElementBy_xpath("//div[@id='defaultMenu']//a[.=' AutoProject']").click();
        //点击团队管理
        super.FindElementBy_linkText("团队管理").click();
        //团队管理-选择部门
        super.FindElementBy_xpath("//div[@id='dept_chosen']").click();
        super.FindElementBy_xpath("//li[contains(text(),'/开发部')]").click();
        //输入用户
        super.FindElementBy_xpath("//div[@id='accounts_chosen']").click();
        super.FindElementBy_xpath("//li[contains(text(),'S:隋磊')]").click();
        //角色
        super.Clear(By.id("role2")).sendKeys("总经理");
        //可用工日
        super.Clear(By.xpath("//input[@id='days2']")).sendKeys("15");
        //可用工时
        super.Clear(By.xpath("//input[@id='hours2']")).sendKeys("5.0");
        //保存
        super.Submit("//form[@id='teamForm']");
    }
    public void Version(){
        //点击项目
        super.FindElementBy_xpath("//a[@href='/zentao/project/']").click();
        //点击版本
        super.FindElementBy_linkText("版本").click();
        //点击右边的产品选择
        super.FindElementBy_id("currentItem").click();
        super.FindElementBy_xpath("//div[@id='defaultMenu']//a[.=' AutoProject']").click();
        //点击创建版本
        super.FindElementBy_linkText("创建版本").click();
        //名称编号
        super.FindElementBy_id("name").sendKeys("1.0");

        //保存
        super.Submit("//form[@id='dataform']");
    }
    public void Mission(){
        //点击任务
        super.FindElementBy_linkText("任务").click();
        //点击右边的产品选择
        super.FindElementBy_id("currentItem").click();
        super.FindElementBy_xpath("//div[@id='defaultMenu']//a[.=' AutoProject']").click();
        //点击建任务
        super.FindElementBy_linkText("建任务").click();
        //所属模块
        super.FindElementBy_xpath("//div[@id='module_chosen']").click();
        super.FindElementBy_xpath("//li[contains(text(),'/自动化')]").click();
        //任务类型
        super.SelectByValue(By.id("type"),"test");
        //指派给
        super.FindElementBy_xpath("//div[@id='assignedTo_chosen']").click();
        super.FindElementBy_xpath("//li[contains(text(),'S:隋磊')]").click();
        //相关需求
        super.FindElementBy_xpath("//div[@id='story_chosen']").click();
        super.FindElementBy_xpath("//li[contains(text(),'89:Automation1(优先级:4,预计工时:12)')]").click();
        //任务名称及颜色
        super.FindElementBy_xpath("//div[@data-toggle='tooltip']").click();
        super.List(By.xpath("//a[@class='cp-tile']"),4).click();
        super.Clear(By.xpath("//input[@id='name']")).sendKeys("自动化任务");
        //同需求按钮
        super.FindElementBy_id("copyButton").click();
        //优先级
        super.Youxianji(4);
        //预计时间
        super.FindElementBy_id("estimate").sendKeys("15");
        //跳进任务描述iframe
        super.SwitchToBy_WebElement(By.xpath("//iframe[@class='ke-edit-iframe']"));
        super.FindElementBy_xpath("//body[@class='article-content']").sendKeys("这是一个自动化任务");
        super.SwitchTo_junpOut();
        //日程规划
        super.FindElementBy_id("estStarted").sendKeys(super.getNowTime("yyyy-MM-dd"));

        //抄送给
        super.FindElementBy_xpath("//div[@id='mailto_chosen']").click();
        super.FindElementBy_xpath("//div[@id='mailto_chosen']/div/ul/li[2]").click();
        //标题
        super.FindElementBy_name("labels[]").sendKeys("自动化任务");
        //添加之后
        super.FindElementBy_class("form-condensed").click();
        super.List(By.name("after"),2).click();
        //保存
        super.Submit("//form[@class='form-condensed']");
        //test.FindElementBy_xpath("//tbody//*[@id='submit']").click();

    }
    /**
     * TODO 第三个用例
     *
     * @author Administrator
     * @dateTime 2016-11-10 16:07
     * @param
     * @return
     * 1、对需求建三个用例
     * 2、分别执行三个用例
     * 3、第一个测试用例的测试结果都为通过，输入测试结果(成功不用输入结果)
     * 4、第二个测试用例的测试结果都为失败，输入测试结果，并上传报错截图
     * ----执行跳不出？？？？
     * 5、删除第三个用例
     * 6、新建多个用例
     * 7、批量删除用例编号为2，4，6，9的用例
    */
    public void BuildUseCase(){
        //点击测试
        super.FindElementBy_xpath("//a[@href='/zentao/qa/']").click();
        //点击用例
        super.FindElementBy_linkText("用例").click();
        //选择产品
        super.FindElementBy_id("currentItem").click();
        super.FindElementBy_xpath("//div[@id='defaultMenu']//a[contains(text(),'Auto')]").click();
        //点击建用例
        super.FindElementBy_linkText("建用例").click();
        //所属产品
        super.FindElementBy_xpath("//div[@id='product_chosen']").click();
        super.FindElementBy_xpath("//div[@class='chosen-drop']//li[contains(text(),'Auto')]").click();
        //所属模块
        super.FindElementBy_xpath("//div[@id='module_chosen']").click();
        super.FindElementBy_xpath("//div[@class='chosen-drop']//li[contains(text(),'/登录')]").click();
        //用例类型
        super.FindElementBy_xpath("//div[@id='type_chosen']").click();
        super.FindElementBy_xpath("//div[@id='type_chosen']/div/ul/li[6]").click();
        //适用阶段
        super.FindElementBy_xpath("//div[@id='stage_chosen']").click();
        super.FindElementBy_xpath("//div[@id='stage_chosen']/div/ul/li[2]").click();
        //相关需求
        super.FindElementBy_xpath("//div[@id='story_chosen']").click();
        super.FindElementBy_xpath("//div[@id='story_chosen']/div/ul/li[1]").click();
        //用例标题颜色
//        super.FindElementBy_xpath("//div[@data-toggle='tooltip']").click();
//        super.List(By.xpath("//a[@class='cp-tile']"),4).click();
        super.Color(6);
        //super.Clear(By.xpath("//input[@id='title']")).sendKeys("用户名输入特殊字符");
        super.Clear(By.xpath("//input[@id='title']")).sendKeys("密码输入2位数字");
        //优先级
        super.Youxianji(2);
        //前置条件
        super.FindElementBy_id("precondition").sendKeys("进入登录界面");
        //用例步骤
        //super.List(By.xpath("//textarea[@id='steps[]']"),0).sendKeys("点击用户名输入框");
        super.List(By.xpath("//textarea[@id='steps[]']"),0).sendKeys("点击密码输入框");
        super.List(By.xpath("//textarea[@id='expects[]']"),0).sendKeys("可点击");
        //super.List(By.xpath("//textarea[@id='steps[]']"),1).sendKeys("输入非法用户名@@#￥%…………");
        super.List(By.xpath("//textarea[@id='steps[]']"),1).sendKeys("输入12345");
        //super.List(By.xpath("//textarea[@id='expects[]']"),1).sendKeys("不允许输入");
        super.List(By.xpath("//textarea[@id='expects[]']"),1).sendKeys("成功输入");
        //关键字
        //super.FindElementBy_id("keywords").sendKeys("输入非法用户名");
        super.FindElementBy_id("keywords").sendKeys("输入正确密码");
        //上传文件
        super.UploadFile("E:/abc.txt");
        //保存
        super.Submit("//tbody//*[@id='submit']");
    }
    public void ImplementUseCase(){
        //点击测试
        super.FindElementBy_xpath("//a[@href='/zentao/qa/']").click();
        //点击用例
        super.FindElementBy_linkText("用例").click();
        //选择产品
        super.FindElementBy_id("currentItem").click();
        super.FindElementBy_xpath("//div[@id='defaultMenu']//a[contains(text(),'Auto')]").click();
        //选择一个用例执行
        super.Run_Delete(26,1);
        //跳转执行页面
        super.SwitchToBy_ID_Name("modalIframe");
        //测试结果
        super.SelectByVisibleText(By.id("steps81"),"通过");
        super.SelectByVisibleText(By.id("steps82"),"通过");
        //保存
        super.Submit("//form[@class='form-condensed']");
        super.SwitchTo_junpOut();
        //选择一个用例执行
//        super.Run_Delete(26,1);
//        super.SwitchToBy_ID_Name("modalIframe");
//        super.SelectByValue(By.id("steps81"),"fail");
//        super.FindElementBy_id("reals[81]").sendKeys("不可点击");
//        super.SelectByValue(By.id("steps82"),"fail");
//        super.FindElementBy_id("reals[82]").sendKeys("没输入");
//        super.FindElementBy_xpath("//button[@type='button']").click();
//        //上传文件
//        super.UploadFile("E:/abc.txt");
//        super.FindElementBy_xpath("//input[@name='labels81[]']").sendKeys("bug截图");
//        super.Submit("//form[@class='form-condensed']");
//        super.Submit("//form[@class='form-condensed']");
//        super.SwitchTo_junpOut();

    }
    public void DeleteUseCase(){
        //点击测试
        //super.FindElementBy_xpath("//a[@href='/zentao/qa/']").click();
        //点击用例
        super.FindElementBy_linkText("用例").click();
        //选择产品
        super.FindElementBy_id("currentItem").click();
        super.FindElementBy_xpath("//div[@id='defaultMenu']//a[contains(text(),'Auto')]").click();
        //删除一条用例
//        super.Run_Delete(31,2);
//        super.AlertAccept();
        //删除多条用例
        super.Run_Delete(30,3);
        super.Run_Delete(34,3);
        super.Run_Delete(35,3);
        super.FindElementBy_xpath("//div[@class='btn-group dropup']/button[@class='btn dropdown-toggle']").click();
        super.FindElementBy_xpath("//div[@class='table-actions clearfix']/div[2]/ul/li[1]").click();
        super.AlertAccept();
    }
}
