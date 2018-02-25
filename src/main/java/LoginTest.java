import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.HomePage;
import pageObject.LogInPage;

public class LoginTest {

    boolean result;

    public boolean test(TestCase[] credentialArray) {

        for (int i = 0; i < credentialArray.length; i++) {
            WebDriver driver = new FirefoxDriver();
            driver.get("http://www.phptravels.net/login");
            LogInPage.Login(credentialArray[i].email, credentialArray[i].password,driver);

            System.out.println("Before waiting");

            String actualText = "";
            if(credentialArray[i].expectedLogin.equals("Login_Successfully")) {
                WebDriverWait wait = new WebDriverWait(driver, 1000);
                wait.until(ExpectedConditions.visibilityOf(HomePage.welcome_el(driver)));
                System.out.println("Before text element");
                actualText = HomePage.welcome_el(driver).getText();
            }
            else if(credentialArray[i].expectedLogin.equals("Login_Unsuccessfully")) {
                WebDriverWait wait = new WebDriverWait(driver, 1000);
                System.out.println("Unsuccessfully");
                wait.until(ExpectedConditions.visibilityOf(LogInPage.invalidEmailOrPassword(driver)));
                actualText = LogInPage.invalidEmailOrPassword(driver).getText();
            }

            if (actualText.equals(credentialArray[i].element_text)) {
                result = true;
            } else {
                result = false;
            }

            driver.close();
            System.out.println("Test case nb " + i + " is: " + result);

        }return result;
    }
}
