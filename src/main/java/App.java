import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class App {

    public static void main(String[] args) {

        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("D:\\experiments\\java_projects\\Selenium_JSON_Login\\src\\credentials.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray cases =(JSONArray) jsonObject.get("Testcases");

            System.out.printf("Successfully read %d cases\n", cases.size());
            for(int i=0; i<cases.size();i++){
                JSONObject testcase = (JSONObject) cases.get(i);
                String email = testcase.get("email").toString();
                String password = (String) testcase.get("password");
                String pageTitle = (String) testcase.get("pageTitle");
                System.out.printf("Testcase %d: email %s\t\t pass %s\n", i,email,password);

                WebDriver driver = new FirefoxDriver();
                driver.get("http://www.phptravels.net/login");
                driver.findElement(By.name("username")).sendKeys(email);
                driver.findElement(By.name("password")).sendKeys(password);
                Thread.sleep(1000);
                driver.findElement(By.xpath(".//*[@id='loginfrm']/div[1]/div[5]/button")).click();
                Thread.sleep(1000);

                String actualTitle =driver.getTitle();
                System.out.println("Title is: "+actualTitle);
                if(actualTitle.equals(pageTitle)){
                    System.out.println("Test passed");
                } else{
                    System.out.println("Test failed");
                }
                Thread.sleep(9000);
                driver.close();

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}