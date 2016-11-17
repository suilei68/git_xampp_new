package fengZhuang;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
/**
 * Created by Administrator on 2016-11-08.
 * 元素定位与操作
 */
public class ElementOperate extends BrowserUtil{
    public ElementOperate(int driverType) {
        super(driverType);
    }
    /**
     * TODO 元素定位 -- id
     * 
     * @author Administrator
     * @dateTime 2016-11-08 18:52 
     * @param  id String
     * @return WebElement
    */
    public WebElement FindElementBy_id(String id){
       WebElement element=MyFindElement(By.id(id));
        return element;
    }
    /**
     * TODO 元素定位 -- name
     *
     * @author Administrator
     * @dateTime 2016-11-08 18:29
     * @param  name String
     * @return WebElement
    */
    public WebElement FindElementBy_name(String name){
        WebElement element=MyFindElement(By.name(name));
        return element;
    }
    /**
     * TODO 元素定位 -- classname
     *
     * @author Administrator
     * @dateTime 2016-11-08 18:31
     * @param classname String
     * @return WebElement
    */
    public WebElement FindElementBy_class(String classname){
        WebElement element=MyFindElement(By.className(classname));
        return element;
    }
    /**
     * TODO 元素定位 -- linkText
     *
     * @author Administrator
     * @dateTime 2016-11-08 18:34
     * @param  linkText String
     * @return WebElement
    */
    public WebElement FindElementBy_linkText(String linkText){
        WebElement element=MyFindElement(By.linkText(linkText));
        return element;
    }
    /**
     * TODO 元素定位 --xpath
     *
     * @author Administrator
     * @dateTime 2016-11-08 18:27
     * @param  xpath String
     * @return WebElement
    */
    public WebElement FindElementBy_xpath(String xpath){
        WebElement element=MyFindElement(By.xpath(xpath));
        return element;
    }
//    public WebElement FindElementBy_xpath(String xpath){
//        WebElement element;
//        //判断元素是否存在，存在就返回元素
//        if (isExist(By.xpath(xpath))) {
//            element = driver.findElement(By.xpath(xpath));
//            System.out.println("找到元素By xpath： \"" + xpath + "\"");
//            return element;
//            //不存在就开启显性等待
//        }else {
//            try{
//                System.out.println("暂未找到，开启明确等待");
//                element=wait(By.xpath(xpath));
//                return element;
//            }
//            catch (Exception e){
//                showErro(e, false);
//                JieTu();
//                return null;
//            }
//        }
//    }
    /**
     * TODO 元素定位 -- select
     * 
     * @author Administrator
     * @dateTime 2016-11-08 21:42 
     * @param  
     * @return 
    */
    public void SelectByValue(By by_type,String selectByValue){
        try {
            Select role=new Select(driver.findElement(by_type));
            role.selectByValue(selectByValue);
            System.out.println("找到Select元素："+by_type+"及它的值："+selectByValue);
        }catch (Exception e){
            showErro(e,false);
            JieTu();
        }
    }
    public void SelectByVisibleText(By by_type,String Text){
        try {
            Select select = new Select(driver.findElement(by_type));
            select.selectByVisibleText(Text);
            System.out.println("找到Select元素：" + select + "及它的值：" + Text);
        }catch (Exception e){
            showErro(e,false);
            JieTu();
        }
    }
    /**
     * TODO 元素定位 -- List<WebElement>
     *
     * @author Administrator
     * @dateTime 2016-11-08 21:45
     * @param
     * @return
    */
    public WebElement List(By by_type,int index){
        try {
            List<WebElement> kong=driver.findElements(by_type);
            System.out.println("找到一组元素集合,选择的索引值是:"+index);
            return kong.get(index);
        }catch (Exception e){
            showErro(e,false);
            JieTu();
            return null;
        }
    }
    /**
     * TODO ClickButton
     *
     * @author Administrator
     * @dateTime 2016-11-11 20:09
     * @param
     * @return
     */
//    public void ClickButton(By by){
//        MyFindElement(by).click();
//    }
//    public void SendKeysMy(By by,String s){
//        MyFindElement(by).sendKeys(s);
//    }
    /**
     * TODO 用定位的元素定位元素
     *
     * @author Administrator
     * @dateTime 2016-11-09 14:35
     * @param
     * @return
    */
    public void elementToelement(By by_type1,By by_type2){
        //打开右边的窗口
        WebElement selectMeau = driver.findElement(by_type1);
        selectMeau.click();
        //选择隋磊
        selectMeau.findElement(by_type2).click();
    }
    /**
     * TODO 元素定位 -- 保存
     *
     * @author Administrator
     * @dateTime 2016-11-08 23:14
     * @param
     * @return
    */
    public void Submit(By by){
        if (isExist(by)){
            driver.findElement(by).submit();
            System.out.println("成功定位到保存按钮");
        }else {
            try {
                wait(by).submit();
            }catch (Exception e){
                showErro(e,false);
                JieTu();
            }
        }
    }
    public void Submit(String xpath){
        if (isExist(By.xpath(xpath))){
            FindElementBy_xpath(xpath).submit();
            System.out.println("成功定位到保存按钮");
        }else {
            try {
                wait(By.xpath(xpath)).submit();
            }catch (Exception e){
                showErro(e,false);
                JieTu();
            }
        }
    }
    /**
     * TODO 清除 -- clear
     *
     * @author Administrator
     * @dateTime 2016-11-09 11:18
     * @param
     * @return
    */
    public WebElement Clear(By by_type){
        WebElement element;
        if (isExist(by_type)){
            element=driver.findElement(by_type);
            element.clear();
            System.out.println("找到需要清空内容的元素"+by_type);
            return element;
        }else {
            try {
                element=wait(by_type);
                element.clear();
                System.out.println("清空元素成功");
                return element;
            }catch (Exception e){
                System.out.println("清空元素失败");
                showErro(e,false);
                JieTu();
                return null;
            }
        }
    }

    /**
     * TODO 上传文件
     *
     * @author Administrator
     * @dateTime 2016-11-10 19:17
     * @param
     * @return
    */
    public void UploadFile(String filePath){
        //上传文件的元素操作：
        WebElement adFileUpload = driver.findElement(By.className("fileControl"));
        adFileUpload.sendKeys(filePath);
    }
    /**
     * TODO  输出报错信息第一行
     *
     * @author Administrator
     * @dateTime 2016-11-08 下午 11:06
     * @param e exception moreInfo Boolean
     * @return
     */
    public void showErro(Exception e, Boolean moreInfo) {
        //我只想看第一句的报错信息，用\n 截取第一段文字，并输出
        String message[] = e.getMessage().split("\n");
        System.out.print("错误信息为： " + message[0] + "\n");
        if (moreInfo) {
            e.printStackTrace();
        }
    }
    /**
     * TODO 判断是否存在
     *
     * @author Administrator
     * @dateTime 2016-11-10 10:53
     * @param
     * @return
    */
    public boolean isExist(By by_type) {
        try {
            driver.findElement(by_type);
            return true;
        } catch (NoSuchElementException e) {
            showErro(e, false);
            return false;
        }
    }
    /**
     * TODO 弹窗点击确定AlertAccept
     *
     * @author Administrator
     * @dateTime 2016-11-09 17:28
     * @param
     * @return
    */
    public void AlertAccept(){
        Alert loginAlert =driver.switchTo().alert();
        System.out.println(loginAlert.getText());
        loginAlert.accept();
        System.out.println("确认");
    }
    /**
     * TODO 选择项目周期
     *
     * @author Administrator
     * @dateTime 2016-11-09 9:48
     * @param
     * @return
     */
    public void TimeLength(int timelength){
        switch (timelength) {
            case 1:
                FindElementBy_id("delta7").click();
            break;
            case 2:
                FindElementBy_id("delta14").click();
            break;
            case 3:
                FindElementBy_id("delta31").click();
            break;
            case 4:
                FindElementBy_id("delta62").click();
            break;
            case 5:
                FindElementBy_id("delta93").click();
            break;
            case 6:
                FindElementBy_id("delta186").click();
            break;
            case 7:
                FindElementBy_id("delta365").click();
            break;
            default:
                System.out.println("选择周期无效！！！");
        }

    }
    /**
     * TODO 优先级选择
     *
     * @author Administrator
     * @dateTime 2016-11-09 19:50
     * @param
     * @return
    */
    public void Youxianji(int number){
//        FindElementBy_xpath("//div[@class='input-group-btn dropdown-pris']").click();
        switch (number){
            case 1:
                FindElementBy_class("pri1").click();
                break;
            case 2:
                FindElementBy_class("pri2").click();
                break;
            case 3:
                FindElementBy_class("pri3").click();
                break;
            case 4:
                FindElementBy_class("pri4").click();
                break;
            default:
                System.out.println("输入的优先级有误");
        }
    }
    /**
     * TODO 严重程度
     *
     * @author Administrator
     * @dateTime 2016-11-13 13:18
     * @param
     * @return
    */
    public void Yanzhongchengdu(int number){
//        FindElementBy_xpath("//div[@data-prefix='severity']").click();
        switch (number){
            case 1:
                FindElementBy_class("severity1").click();
                break;
            case 2:
                FindElementBy_class("severity2").click();
                break;
            case 3:
                FindElementBy_class("severity3").click();
                break;
            case 4:
                FindElementBy_class("severity4").click();
                break;
            default:
                System.out.println("输入的优先级有误");
        }
    }
    /**
     * TODO 颜色
     *
     * @author Administrator
     * @dateTime 2016-11-10 19:33
     * @param
     * @return
    */
    public void Color(int number) {
        FindElementBy_xpath("//div[@data-toggle='tooltip']").click();
        List(By.xpath("//a[@class='cp-tile']"), number).click();
    }
    /**
     * TODO 选择并执行用例   删除用例
     *
     * @author Administrator
     * @dateTime 2016-11-10 21:41
     * @param
     * @return
    */
    public void Run_Delete(int ID,int Run_1_Delete_2){
        FindElementBy_xpath("//input[@value='"+ID+"']").click();
        switch(Run_1_Delete_2){
            case 1:
                FindElementBy_xpath("//a[@href='/zentao/testtask-runCase-0-"+ID+"-1.html']").click();
                break;
            case 2:
                FindElementBy_xpath("//a[@href='javascript:ajaxDelete(\"/zentao/testcase-delete-"+ID+"-yes.html\",\"caseList\",confirmDelete)']").click();
                break;
            default:
                System.out.println("只勾选不执行任何操作");
        }
    }
    /**
     * TODO 跳转iframe
     *
     * @author Administrator
     * @dateTime 2016-11-10 16:02
     * @param
     * @return
     */
    //跳转iframe
    public void SwitchToBy_ID_Name(String s){
        driver.switchTo().frame(s);
    }
    public  void SwitchToBy_WebElement(By by_type){
        WebElement element =MyFindElement(by_type);
            driver.switchTo().frame(element);
            System.out.println("成功跳转至当前iframe");
    }

    //跳出iframe
    public void SwitchTo_junpOut(){
        driver.switchTo().defaultContent();
    }
    /**
     * TODO MyFindElement
     *
     * @author Administrator
     * @dateTime 2016-11-11 18:32
     * @param
     * @return
    */
    public WebElement MyFindElement(By by){
        WebElement element;
        if (isExist(by)){
            element=driver.findElement(by);
            System.out.println("找到元素: \""+by+"\"");
            return element;
        }else {
            try {
                System.out.println("暂未找到，开启明确等待");
                element=wait(by);
                return element;
            }catch (Exception e){
                showErro(e,false);
                JieTu();
                return null;
            }
        }

    }
    /**
     * TODO 调用YamlUtils类方法的封装元素
     *
     * @author Administrator
     * @dateTime 2016-11-11 16:23
     * @param
     * @return
    */

    YamlUtils yaml=new YamlUtils();

    public WebElement findElement(String key){
        String type =  yaml.getYamlFile().get(key).get("type");
        String value = yaml.getYamlFile().get(key).get("value");
        return MyFindElement(yaml.getby(type,value));
    }
    //元素封装后的clear
    public void ClearMy(String key,String s){
        String type =  yaml.getYamlFile().get(key).get("type");
        String value = yaml.getYamlFile().get(key).get("value");
        Clear(yaml.getby(type,value)).sendKeys(s);
    }
    public void ClickMy(String key){
        String type =  yaml.getYamlFile().get(key).get("type");
        String value = yaml.getYamlFile().get(key).get("value");
        MyFindElement(yaml.getby(type,value)).click();
    }
    public void SendKeysMy(String key,String s){
        String type =  yaml.getYamlFile().get(key).get("type");
        String value = yaml.getYamlFile().get(key).get("value");
        MyFindElement(yaml.getby(type,value)).sendKeys(s);
    }
    public void SelectMy(String key,String selectByValue){
        String type =  yaml.getYamlFile().get(key).get("type");
        String value = yaml.getYamlFile().get(key).get("value");
        SelectByValue(yaml.getby(type,value),selectByValue);
    }
    public WebElement ListMy(String key,int index,boolean clickYN){
        String type =  yaml.getYamlFile().get(key).get("type");
        String value = yaml.getYamlFile().get(key).get("value");
        if (clickYN){
            List(yaml.getby(type,value),index).click();
        }
        return List(yaml.getby(type,value),index);
    }
    public void SwitchToBy_WebElementMy(String key){
        String type =  yaml.getYamlFile().get(key).get("type");
        String value = yaml.getYamlFile().get(key).get("value");
        SwitchToBy_WebElement(yaml.getby(type,value));
    }
    public void SubmitMy(String key){
        String type=yaml.getYamlFile().get(key).get("type");
        String value = yaml.getYamlFile().get(key).get("value");
        Submit(yaml.getby(type,value));
    }
}
