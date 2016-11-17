package fengZhuang;
/**
 * Created by Administrator on 2016-11-08.
 * 打开浏览器类
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import java.io.IOException;
//封装启动浏览器
public class Browser {
    WebDriver driver;
    public  Browser(int driverType){
        switch (driverType){
            case 1:
                CloseBrower("chrome",true);
                OpenChrome();
                break;
            case 2:
                CloseBrower("firefox",true);
                OpenFirefox();
                break;
            case 3:
                CloseBrower("firefox",true);
                OpenFirefox("default");
                break;
            default:
                System.out.println("选择无效浏览器");
        }
    }
    //启动谷歌浏览器
    public void OpenChrome(){
        System.setProperty("webdriver.chrome.bin","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        System.setProperty("webdriver.chrome.driver","D:\\firefox\\chromedriver1.exe");
        driver=new ChromeDriver();
        System.out.println("启动谷歌浏览器成功");
    }
    //启动全新的火狐浏览器
    public void OpenFirefox(){
        System.setProperty("webdriver.firefox.bin","D:\\电脑管家软件下载\\火狐浏览器\\firefox.exe");
        System.setProperty("webdriver.firefox.marionette","D:\\firefox\\geckodriver.exe");
        driver=new FirefoxDriver();
        System.out.println("启动火狐浏览器成功");
    }
    //启动默认配置的firefox
    public void OpenFirefox(String type){
        ProfilesIni allProfiles = new ProfilesIni();
        FirefoxProfile profile = allProfiles.getProfile(type);
        System.setProperty("webdriver.firefox.bin","D:\\电脑管家软件下载\\火狐浏览器\\firefox.exe");
        System.setProperty("webdriver.firefox.marionette","D:\\firefox\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver(profile);
    }
    //关闭已经存在的浏览器进程
    public void CloseBrower(String name, boolean onOrOff) {
        Runtime runtime = Runtime.getRuntime();
        if (onOrOff) {
            try {
                runtime.exec("taskkill /f /im " + name + ".exe");
                System.out.println("关闭全部的" + name + "浏览器成功!");
            } catch (IOException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
