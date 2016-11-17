package fengZhuang;

import org.ho.yaml.Yaml;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 * Created by Administrator on 2016-11-11.
 */

public class YamlUtils {
    String yamlFile;
    public HashMap<String,HashMap<String,String>> keyMap;
//    WebDriver driver;
//    public YamlUtils(WebDriver driver){
//        this.driver=driver;
//    }
    /**
     * TODO
     *
     * @author Administrator
     * @dateTime 2016-11-11 18:22
     * @param
     * @return
    */
    public void SetYamlFile(String yamlFile){
        this.yamlFile=yamlFile;
    }
    /**
     * TODO 从yaml文件中读取元素数据，存入HashMap
     *
     * @author Administrator
     * @dateTime 2016-11-11 10:24
     * @param
     * @return
    */
    protected HashMap<String,HashMap<String,String>> getYamlFile(){
       // HashMap<String,HashMap<String,String>> keyMap=null;
        //定位文件位置
        File file = new File("elements/"+yamlFile+".yaml");
        //将yaml文件中的数据以流的形式转化成Map
        try {
            keyMap= Yaml.loadType(new FileInputStream(file.getAbsolutePath()),HashMap.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("未找到文件");
        }
        return keyMap;
    }
    /**
     * TODO 获取By
     *
     * @author Administrator
     * @dateTime 2016-11-11 11:11
     * @param
     * @return
    */
    public By getby(String type,String value){
        By by=null;
        if (type.equals("id")){
            by=By.id(value);
        }
        else if (type.equals("xpath")){
            by=By.xpath(value);
        }
        else if (type.equals("name")){
            by=By.name(value);
        }
        else if (type.equals("classname")){
            by=By.className(value);
        }
        else if (type.equals("linkText")){
            by=By.linkText(value);
        }
        return by;
    }
///**
// * TODO 元素封装findElement
// *
// * @author Administrator
// * @dateTime 2016-11-11 15:53
// * @param
// * @return
//*/
//    public WebElement findElement(String key){
//        String type = keyMap.get(key).get("type");
//        String value = keyMap.get(key).get("value");
//        return driver.findElement(this.getby(type,value));
//    }


}
