package fengZhuang;

/**
 * Created by Administrator on 2016-11-15.
 */
public class BugPage {
    PageNew page;
    public BugPage(PageNew page){
        this.page=page;
    }
    public void Bug(){
        page.yaml.SetYamlFile("bug");
        page.ClickMy("点击项目");
        page.ClickMy("点击bug");
        page.ClickMy("项目选择");
        page.ClickMy("选择项目");
        page.ClickMy("点击提Bug");
        page.ClickMy("所属产品");
        page.ClickMy("选择产品");
        page.ClickMy("所属模块");
        page.ClickMy("选择模块");
        page.ClickMy("所属项目");
        page.ClickMy("所属项目选择");
        page.ClickMy("影响版本");
        page.ClickMy("选择版本");
        page.ListMy("刷新按钮",2,true);
        page.ClickMy("当前指派");
        page.ClickMy("选择指派人");
        page.SelectMy("bug类型","interface");
        page.SelectMy("操作系统","win7");
        page.SelectMy("浏览器","ie11");
        page.Color(5);
        page.SendKeysMy("输入bug标题","页面丑到自己怕");
        page.ListMy("等级选择",0,true);
        page.Yanzhongchengdu(1);
        page.ListMy("等级选择",1,true);
        page.Youxianji(1);
    }

}
