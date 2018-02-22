package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Liuda on 2/22/2018.
 */
public class LogInPage {

    private static WebElement element = null;

    public static WebElement userName_Field(WebDriver driver){
        element = driver.findElement(By.name("username"));
       return element;
    }

    public static WebElement password_Field(WebDriver driver){
        element = driver.findElement(By.name("password"));
        return element;
    }
    public static WebElement login_Button(WebDriver driver){
        element = driver.findElement(By.xpath("//*[contains(@class, 'loginbtn')]"));
        return element;
    }

}

//
//public class LogIn_Page {
//
//    private static WebElement element = null;
//
//    public static WebElement txtbx_UserName(WebDriver driver){
//
//        element = driver.findElement(By.id("log"));
//
//        return element;
//
//    }