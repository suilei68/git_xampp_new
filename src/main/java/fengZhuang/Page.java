//package fengZhuang;
//
//public class Page extends ElementOperate{
//    public Page(int driverType) {
//        super(driverType);
//    }
//
//    public void Login(String login_user,String login_password){
//        yaml.SetYamlFile("login");
//        //定位用户名并输入
//        //SendKeysMy(login_userkey,login_user);
//        SendKeysMy("登录用户",login_user);
//        //定位密码并输入
//        //SendKeysMy(login_passwordkey,login_password);
//        SendKeysMy("登录密码",login_password);
//        //点击登录按钮
//        ClickMy("登录按钮");
//    }
//    public void test1(String department) {
//        yaml.SetYamlFile("test1");
//        ClickMy("定位组织");
//        ClickMy("定位部门");
//        SendKeysMy("添加部门",department);
//        //ListMy("添加部门",0,false).sendKeys(department);
//        SubmitMy("部门保存");
//        ClickMy("删除部门");
//        AlertAccept();
//
//        //添加用户
//
//    }
//    public void Project(String projectname,String projectcode,String teamname,String projecttype,String description){
//        yaml.SetYamlFile("project");
//        ClickMy("点击项目");
//        ClickMy("添加项目");
//        SendKeysMy("项目名称",projectname);
//        SendKeysMy("项目代号",projectcode);
//        ClearMy("起始时间",getNowTime("yyyy-MM-dd"));
//        //手动输入截止时间(这里要加上点击外面的表格，让选择日期的框回缩才能执行下面的定位)
//        //SendKeysMy("截止时间","2016-11-19");
//        //ClickMy("添加项目表单名");
//        TimeLength(1);// 选择项目周期
//        SendKeysMy("团队名称",teamname);
//        SelectMy("项目类型",projecttype);
//        ClickMy("关联产品");
//        ClickMy("选择产品");
//        SwitchToBy_WebElementMy("跳进项目描述");
//        SendKeysMy("项目描述",description);
//        SwitchTo_junpOut();
//        ClickMy("添加项目表单名");//通过点击表单来执行后续定位
//        ClickMy("私有访问权限");
//        SubmitMy("保存项目");
//    }
//}
