package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LogInPage {
    public WebDriver driver;

//    public LogInPage(WebDriver driver){
//        this.driver = driver;
//   }

    public static WebElement userName_Field(WebDriver driver){

        return driver.findElement(By.id("usernameOrEmail"));
    }

    public static WebElement password_Field(WebDriver driver){

        return driver.findElement(By.id("password"));
    }
    //button[@class='button form-button is-primary']

    public static WebElement login_Button(WebDriver driver){
        return driver.findElement(By.xpath("//button[@class='button form-button is-primary']"));
    }
    public static WebElement invalidEmailOrPassword(WebDriver driver){

        return driver.findElement(By.xpath("//div[@class='form-input-validation is-error']"));
    }

    public static void Login(String email, String password,WebDriver driver){

        LogInPage.userName_Field(driver).sendKeys(email);
        LogInPage.login_Button(driver).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            LogInPage.password_Field(driver).sendKeys(password);
            //added sleep to wait while Login page is clickable
        }catch(ElementNotInteractableException e){
            System.out.println("Username is wrong.");
            return;
        }


        LogInPage.login_Button(driver).click();

    }
}