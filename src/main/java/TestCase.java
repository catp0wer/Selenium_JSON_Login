
public class TestCase {

    String email;
    String password;
    String element_text;
    String expectedLogin;

    public TestCase(String email, String password,String element_text,String expectedLogin){
        this.email = email;
        this.password = password;
        this.element_text = element_text;
        this.expectedLogin = expectedLogin;

    }
}
