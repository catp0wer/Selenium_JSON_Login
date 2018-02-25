package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LogInPage {
    public WebDriver driver;

//    public LogInPage(WebDriver driver){
//        this.driver = driver;
//   }

    public static WebElement userName_Field(WebDriver driver){
       return driver.findElement(By.name("username"));
    }

    public static WebElement password_Field(WebDriver driver){
        return driver.findElement(By.name("password"));
    }
    public static WebElement login_Button(WebDriver driver){
        return driver.findElement(By.xpath("//*[contains(@class, 'btn btn-action btn-lg btn-block loginbtn')]"));
    }
    public static WebElement invalidEmailOrPassword(WebDriver driver){
        return driver.findElement(By.xpath("//*[contains(@class, 'alert alert-danger')]"));
    }

    public static void Login(String email, String password,WebDriver driver){

        LogInPage.userName_Field(driver).sendKeys(email);
        LogInPage.password_Field(driver).sendKeys(password);
        //added sleep to wait while Login page is clickable
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LogInPage.login_Button(driver).click();

    }
}