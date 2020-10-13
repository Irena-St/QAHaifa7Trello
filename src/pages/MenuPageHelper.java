package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPageHelper extends PageBase {
    public MenuPageHelper(WebDriver driver) {
        super(driver);
    }
    public void waitUntilMenuPageIsLoaded() {
        waitUntilElementIsClickable(By.xpath("//a[@data-test-id = 'header-member-menu-profile']"),10);
    }

    public void openProfileVisibility() {
        driver.findElement(By.xpath("//a[@data-test-id = 'header-member-menu-profile']")).click();
    }
}
