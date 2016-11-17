//package fengZhuang.test;
//import fengZhuang.Page;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//public class PageTest {
//    Page page=new Page(1);
//
//    @Parameters({"login_user","login_password"})
//    @Test
//    public void LoginTest(String login_user,String login_password) {
//        page.OpenURL("http://127.0.0.1:81/zentao");
//        page.Login(login_user,login_password);
//    }
//    @Parameters({"department"})
//    @Test
//    public void Test1Test(String department){
//        page.test1(department);
//    }
//
//    @Parameters({"projectname","projectcode","teamname","projecttype","description"})
//    @Test
//    public void ProjectTest(String projectname,String projectcode,String teamname,String projecttype,String description) {
//        page.Project(projectname, projectcode, teamname, projecttype, description);
//    }
//    public void BugTest(){
//        page.Bug();
//    }
//}
