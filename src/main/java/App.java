
public class App {

    public static void main(String[] args) {
        Logs log = new Logs();
        JsonReader reader = new JsonReader();
        TestCase myArray[] = reader.read();

        LoginTest logintest=new LoginTest(log);
        boolean result = logintest.test(myArray);
        System.out.println(result);
        log.closeFile();


            }


}