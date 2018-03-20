package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    public static WebElement welcome_el(WebDriver driver) {
        return driver.findElement(By.xpath("//h3[contains(@class,'RTL')]"));
    }
}
