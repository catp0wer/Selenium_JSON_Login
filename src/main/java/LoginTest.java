import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {
    String email;
    String password;
    String pageTitle;
    boolean result;

    public boolean test(TestCase[] credentialArray){
        for(int i=0;i<credentialArray.length;i++){
            WebDriver driver = new FirefoxDriver();
            driver.get("http://www.phptravels.net/login");
            driver.findElement(By.name("username")).sendKeys(credentialArray[i].email);
            driver.findElement(By.name("password")).sendKeys(credentialArray[i].password);
            try {
                Thread.sleep(1000);

                driver.findElement(By.xpath(".//*[@id='loginfrm']/div[1]/div[5]/button")).click();
                Thread.sleep(1000);


                String actualTitle = driver.getTitle();
                System.out.println("Title is: " + actualTitle);

               // result = actualTitle.equals(credentialArray[i].pageTitle);
                if (actualTitle.equals(credentialArray[i].pageTitle)) {
                    result = true;
                } else {
                    result = false;
                }
                Thread.sleep(9000);
                driver.close();
                System.out.println("Test case nb " +i+ " is: "+result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }}
        return result;
    }
}
