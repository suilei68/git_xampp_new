package fengZhuang;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016-11-08.
 * 浏览器操作类
 */
public class BrowserUtil extends Browser{
    //重写父类的构造方法
    public BrowserUtil(int driverType) {
        super(driverType);
    }
    //窗口最大化
    public void WindowMax(){
        driver.manage().window().maximize();
    }
    /**
     * TODO 显性休眠
     *
     * @author Administrator
     * @dateTime 2016-11-08 18:45
     * @param  millisecond long
     * @return
    */
    public void pause(long millisecond){
        if (millisecond<=0){
            return;
        }
        try {
            Thread.sleep(millisecond);
            System.out.println("暂停了"+millisecond+"毫秒");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /**
     * TODO 明确等待
     * 页面元素在页面中存在则继续
     * 默认等待 5 秒
     *@return WebElements
     */

    protected WebElement wait(final By param_by) {
        return (new WebDriverWait(driver,5)).until(new ExpectedCondition<WebElement>(){
                    public WebElement apply(WebDriver driver) {
                        WebElement waitelement=driver.findElement(param_by);
                        System.out.println("明确wait5秒找到元素 "+param_by);
                        return waitelement;
                    }
                }
        );
    }
    /**
     * TODO 打开网址
     *
     * @author Administrator
     * @dateTime 2016-11-10 15:59
     * @param
     * @return
    */
    public void OpenURL(String URL){
        driver.get(URL);
        //窗口最大化
        WindowMax();
        System.out.println("打开 ["+URL+"]页面");
    }
    /**
     * TODO 截图--自动添加以时间为标题的截图名
     *
     * @author Administrator
     * @dateTime 2016-11-08 22:12
     * @param
     * @return
    */
    public void JieTu() {
        //获取当前的地址
        //String currentPath = System.getProperty("user.dir");
        String currentPath = "screen//";
        //获取截图
        File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //将截图 写入到磁盘中
        try {
            FileUtils.copyFile(screenShotFile, new File(currentPath + getNowTime("yyyy-MM-dd HH-mm-ss") + ".png"));
            System.out.println("截图成功");
            System.out.println("当前截图名:" + getNowTime("yyyy-MM-dd HH-mm-ss") + ".png");
            //输出错误信息
        } catch (Exception e) {
            System.out.println("截图失败");
            e.printStackTrace();
        }

    }
    /**
     * TODO 自动获取当天时间
     *
     * @author Administrator
     * @dateTime 2016-11-09 9:27
     * @param
     * @return
    */
    //获取当天时间
    public String getNowTime(String dateformat){
        //获取系统的时间
        Date nowTime = new Date();
        //自定义时间的格式  （"yyyy-MM-dd HH-mm-ss"）精确到秒
        SimpleDateFormat dateFormat = new SimpleDateFormat(dateformat);
        String time = dateFormat.format(nowTime);
        return time;
    }
}
