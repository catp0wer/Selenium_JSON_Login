package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.HomePage;
import pageObject.LogInPage;


public class LoginTest {
    Logs log;

    public LoginTest(Logs log){
        this.log = log;
    }

    boolean result;

    public boolean test(TestCase[] credentialArray) {

        for (int i = 0; i < credentialArray.length; i++) {
            WebDriver driver = new FirefoxDriver();
            driver.get("https://wordpress.com/log-in");
            log.logEntry("Navigate to the site.");
            LogInPage.Login(credentialArray[i].email, credentialArray[i].password,driver);
            log.logEntry("Entered email and password");


            String actualText = "";
            if(credentialArray[i].expectedLogin.equals("Login_Successfully")) {
                log.logEntry("Before logging in: Wait until element 'My Sites' is visible.");

                WebDriverWait wait = new WebDriverWait(driver, 9000);
                wait.until(ExpectedConditions.visibilityOf(HomePage.yourSites(driver)));
                actualText = HomePage.yourSites(driver).getText();
                log.logEntry("Actual text (text of the element 'My Site) before waiting is equal to: "+ actualText);

                //It seems that the site is made in such a way that the element is loaded firstly,
                // and after that is loaded the text of the element
                // that is why I wait until the element text is loaded
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.logEntry("Retrieving text from the element 'My Site'");
                actualText = HomePage.yourSites(driver).getText();
                log.logEntry("Actual text of element 'My Site' after waiting is :" + actualText);

            }
             else if(credentialArray[i].expectedLogin.equals("Login_Unsuccessfully")) {
                WebDriverWait wait = new WebDriverWait(driver, 1000);
                log.logEntry("Waiting for the visibility of the element 'invalidEmailOrPassword'");
                wait.until(ExpectedConditions.visibilityOf(LogInPage.invalidEmailOrPassword(driver)));
                actualText = LogInPage.invalidEmailOrPassword(driver).getText();
                log.logEntry("Actual text of the element 'invalidEmailOrPassword' is: "+actualText);
            }

            if (actualText.equals(credentialArray[i].element_text)) {
                result = true;
            } else {
                result = false;
            }

            driver.close();
            log.logEntry("Test case nb " + i + " is: " + result);

        }return result;
    }
}
