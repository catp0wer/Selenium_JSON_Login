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

            log.logEntry("Before waiting");
            String actualText = "";
            if(credentialArray[i].expectedLogin.equals("Login_Successfully")) {
                log.logEntry("Wait before logging in");

                WebDriverWait wait = new WebDriverWait(driver, 9000);
                wait.until(ExpectedConditions.visibilityOf(HomePage.yourSites(driver)));
                log.logEntry("Before text element");
                actualText = HomePage.yourSites(driver).getText();
                log.logEntry(actualText);

                //wait until the element text is loaded
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.logEntry("Retrieving text context");
                actualText = HomePage.yourSites(driver).getText();
                log.logEntry(actualText);

            }
             else if(credentialArray[i].expectedLogin.equals("Login_Unsuccessfully")) {
                WebDriverWait wait = new WebDriverWait(driver, 1000);
                System.out.println("Unsuccessfully");
                wait.until(ExpectedConditions.visibilityOf(LogInPage.invalidEmailOrPassword(driver)));
                actualText = LogInPage.invalidEmailOrPassword(driver).getText();
            }
            log.logEntry(actualText);
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
