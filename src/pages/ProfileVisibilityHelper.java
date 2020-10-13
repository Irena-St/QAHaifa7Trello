package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProfileVisibilityHelper extends PageBase {
    @FindBy(xpath = "//a[@data-tab='profile']")
    WebElement profileTab;

    @FindBy(xpath ="//button[@aria-label = 'Open Member Menu']")
    WebElement memberMenuIcon;

    @FindBy(xpath = "//input[@name='username']")
    WebElement userNameField;

    public ProfileVisibilityHelper(WebDriver driver) {
        super(driver);
    }

    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(userNameField,10);
        waitUntilElementIsVisible(profileTab,10);
    }
    public String getProfileVisibilityTabName(){
      // WebElement profileTab = driver.findElement(By.xpath("//a[@data-tab='profile']"));
        return profileTab.getText();
    }

    public String getTitleMenuIcon() {
        //WebElement memberMenuIcon = driver.findElement(By.xpath("//button[@aria-label = 'Open Member Menu']"));
        return memberMenuIcon.getAttribute("title");
    }

    public String getUserName() {
       // WebElement userNameField = driver.findElement(By.xpath("//input[@name='username']"));
        return userNameField.getAttribute("value");
    }
}

