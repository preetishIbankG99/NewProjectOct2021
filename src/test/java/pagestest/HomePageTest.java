package pagestest;

import base.TestBase;
import pages.AdminLogin;
import pages.Homepage;
import pages.NewCustomer;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class HomePageTest extends TestBase {
    public static AdminLogin adminLogin;
    public static Homepage homepage;
    public HomePageTest()throws FileNotFoundException,IOException{
    super();
    }
    @BeforeMethod
    public void setUp()throws IOException,InterruptedException{
        initialization();
        homepage=new Homepage();
        adminLogin=new AdminLogin();
        adminLogin.setUsername(prop.getProperty("username"));
        adminLogin.setPassword(prop.getProperty("password"));
        adminLogin.clickLoginbtn();

    }

    @Test()
    public void homePageElementsVerification()throws IOException{

        homepage.checkNewAccountLink();

    }

    @AfterMethod
    public void tearDown(){

    driver.quit();
    }
}



