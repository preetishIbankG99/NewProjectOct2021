package pagestest;

import java.io.IOException;

import org.automationtesting.excelreport.Xl;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.AdminLogin;
//@Listeners(utility.TestNGListener.class)//Require for TestNG Listeners
public class AdminLogintest extends TestBase{
    public static AdminLogin adminLogin;
    public AdminLogintest()throws IOException{
        super();
    }
   @BeforeMethod
    public void setUp()throws IOException{
        initialization();
        adminLogin=new AdminLogin();
   }

    @Test()
public void logincredential(){
        adminLogin.setUsername(prop.getProperty("username"));
        logger.info("Username:::Entered");
        adminLogin.setPassword(prop.getProperty("password"));
        logger.info("Password:::Entered");
        adminLogin.clickLoginbtn();
        logger.info("Button::::Clicked");
        System.out.println("Credentials Passed");
    }

    @Test()
    public  void checkingLogo()throws IOException,InterruptedException{

    adminLogin.Checklogo();
    logger.info("::logo::Checked::");


}
    @Test()
    public  void checkingLink(){

        adminLogin.linkVerification();
        logger.info("::link::Checked::");

    }

@AfterMethod
    public  void teardown() throws InterruptedException
{
//	 TestUtil.sendMail();
//    Thread.sleep(3000);
//    SendAMail.sendMail();
    driver.close();
    
}
/*@AfterSuite
public void generateReport() throws Exception {
	Thread.sleep(3000);
	Xl.generateReport("Report_Excel.xlsx");
}*/

}
