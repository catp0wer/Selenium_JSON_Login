import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.LogInPage;

public class LoginTest {

    boolean result;

    public boolean test(TestCase[] credentialArray){
        for(int i=0;i<credentialArray.length;i++){
            WebDriver driver = new FirefoxDriver();
            driver.get("http://www.phptravels.net/login");
            LogInPage.userName_Field(driver).sendKeys(credentialArray[i].email);
           // driver.findElement(By.name("username")).sendKeys(credentialArray[i].email);
            LogInPage.password_Field(driver).sendKeys(credentialArray[i].password);
           // driver.findElement(By.name("password")).sendKeys(credentialArray[i].password);
           // boolean present;
            try {
                Thread.sleep(1000);
                LogInPage.login_Button(driver).click();

                Thread.sleep(2000);
                WebDriverWait wait = new WebDriverWait(driver, 15);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='body-section']/div/div[1]/div/div[1]/h3")));

//                boolean present=driver.findElements(By.xpath("//*[@id='body-section']/div/div[1]/div/div[1]/h3")).size()!=0;
//                       // (By.xpath(credentialArray[i].element)).size()!=0;
//                        ///"[contains(text(),'Hi, DVhbCERv IlqEZZxz')]")).size()!=0;
//               // String actualTitle = driver.getTitle();
//               // System.out.println("Title is: " + actualTitle);
//
//               // result = actualTitle.equals(credentialArray[i].pageTitle);
//                if (present) {
//                    result = true;
//                } else {
//                    result = false;
//                }

                //just to see by myself the page
                Thread.sleep(9000);
                driver.close();
                System.out.println("Test case nb " +i+ " is true");
                return true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }catch (NotFoundException e){

                System.out.println("Test case nb " +i+ " is false");
               // Thread.sleep(9000);
                driver.close();
                return false;
            }
        }
        return result;
    }
}
