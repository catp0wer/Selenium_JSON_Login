package core;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class JsonReader {


    public TestCase[] read() {
        JSONParser parser = new JSONParser();

        TestCase credentialArray[] = new TestCase[2];
        try {
            Object obj = parser.parse(new FileReader("D:\\Git projects\\Selenium_JSON_Login\\src\\main\\java\\credentials.json"));

            JSONObject jsonObject = (JSONObject) obj;
            JSONArray cases = (JSONArray) jsonObject.get("Testcases");

            System.out.printf("Successfully read %d cases\n", cases.size());
            for (int i = 0; i < cases.size(); i++) {

                JSONObject testcase = (JSONObject) cases.get(i);
                String email = testcase.get("email").toString();
                String password = (String) testcase.get("password");
                String element_text = (String) testcase.get("element_text");
                String expectedLogin = (String) testcase.get("expectedLogin");
               // String pageTitle = (String) testcase.get("pageTitle");
                System.out.printf("Testcase %d: email %s\t\t pass %s\n", i, email, password);


                TestCase testc1 = new TestCase(email, password, element_text, expectedLogin);
                credentialArray[i] = testc1;

            }
            //System.out.println(credentialArray.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return credentialArray;
    }
}
