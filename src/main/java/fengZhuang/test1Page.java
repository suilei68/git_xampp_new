package fengZhuang;

/**
 * Created by Administrator on 2016-11-14.
 */
public class test1Page {
    PageNew page;
    public test1Page(PageNew page){
        this.page=page;
    }

    public void addDepartment(String department) {
        page.yaml.SetYamlFile("test1");
        page.ClickMy("定位组织");
        page.ClickMy("定位部门");
        page.SendKeysMy("添加部门",department);
        //ListMy("添加部门",0,false).sendKeys(department);
        page.SubmitMy("部门保存");
        page.ClickMy("删除部门");
        page.AlertAccept();

    }
}