package fengZhuang;

/**
 * Created by Administrator on 2016-11-14.
 */

public class LoginPage {
    PageNew page;
    public LoginPage(PageNew page){
        this.page=page;
    }
    public void Login(String login_user,String login_password){
        page.yaml.SetYamlFile("login");
        page.SendKeysMy("登录用户",login_user);
        page.SendKeysMy("登录密码",login_password);
        page.ClickMy("登录按钮");
    }
}
