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
        JsonReader reader = new JsonReader();
        TestCase myArray[] = reader.read();
       // System.out.println(myArray);
        LoginTest logintest=new LoginTest();
        boolean result = logintest.test(myArray);
        System.out.println(result);

            }


}