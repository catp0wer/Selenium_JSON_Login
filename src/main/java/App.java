
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
            Object obj = parser.parse(new FileReader("D:\\experiments\\Java\\Selenium_JSON_Login\\src\\main\\java\\credentials.json"));
            JSONObject jsonObject = (JSONObject) obj;
            String email = jsonObject.get("email").toString();
            String password = (String) jsonObject.get("password");
            //System.out.println("Name is: " +email);


            WebDriver driver = new FirefoxDriver();
            driver.get("http://www.phptravels.net/login");
            driver.findElement(By.name("username")).sendKeys(email);
            driver.findElement(By.name("password")).sendKeys(password);
            //driver.findElement(By.name("btnK")).click();
            //driver.close();

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
