package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPageHelper extends PageBase {
    @FindBy(xpath = "//a[@data-test-id = 'header-member-menu-profile']")
    WebElement profileVisibility;


    public MenuPageHelper(WebDriver driver) {
        super(driver);

    }
    public MenuPageHelper waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(profileVisibility,10);
        return this;
    }

    public MenuPageHelper openProfileVisibility() {
        profileVisibility.click();
        return this;
    }
}
