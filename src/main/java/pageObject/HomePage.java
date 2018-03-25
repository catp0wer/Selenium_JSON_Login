package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    public static WebElement yourSites(WebDriver driver) {
        return driver.findElement(By.xpath("(//span[@class='masterbar__item-content'])[1]"));
    }
}
