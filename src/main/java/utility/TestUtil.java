package utility;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.TestBase;

public class TestUtil extends TestBase {
    public static long PAGE_LOAD_TIMEOUT = 30;
    public static long IMPLICIT_WAIT = 30;
    
public TestUtil()throws IOException,FileNotFoundException{
     //super();
    }

//Screenshot Reuse
    public static void takeScreenShot() throws IOException {
        File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(srcfile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
    }
    //Element HighlighterCode Reuse
    public static void highLightElement(WebDriver driver, WebElement element)
    {
    JavascriptExecutor js=(JavascriptExecutor)driver; 
     
    js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
     
    try 
    {
    Thread.sleep(500);
    } 
    catch (InterruptedException e) {
     
    System.out.println(e.getMessage());
    } 
     
    js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 
     
    }
    //Reuse Method for Handling Windows
  public static void closeWindow(WebDriver driver,String data) {
	  Set<String>windows=driver.getWindowHandles();
	  for(String str:windows) {
		  driver.switchTo().window(str);
		  String title=driver.getTitle();
		  if(title.equals(data)) {
			  driver.close();
			  }}}
   }



