
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
//import net.sf.json.JSONArray;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class App {

    public static void main(String[] args) {

        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("D:\\Git_projects\\Selenium_JSON_Login\\src\\main\\java\\credentials.json"));
            JSONObject jsonObject = (JSONObject) obj;
           // jsonObject.
           JSONArray cases =(JSONArray) jsonObject.get("Testcases");

           System.out.printf("Successfully read %d cases\n", cases.size());
           for(int i=0; i<cases.size();i++){
               JSONObject testcase = (JSONObject) cases.get(i);
               String email = testcase.get("email").toString();
               String password = (String) testcase.get("password");
               System.out.printf("Testcase %d: email %s\t\t pass %s\n", i,email,password);


               WebDriver driver = new FirefoxDriver();
               driver.get("http://www.phptravels.net/login");
               driver.findElement(By.name("username")).sendKeys(email);
               driver.findElement(By.name("password")).sendKeys(password);
               Thread.sleep(4000);
               driver.close();
               Thread.sleep(4000);
           }
  //          Iterator<JSONObject> testcaseiterator = cases.iterator();
//            while(testcaseiterator.hasNext()){
//                System.out.println(testcaseiterator);
//                System.out.println("poloboku");
//           }


            //System.out.println("Name is: " +email);



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
