package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageHelper extends PageBase{
    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "login")
    WebElement loginButton;

    @FindBy(id = "user")
    WebElement loginField;

    @FindBy(id = "error")
    WebElement errorMessage;

    @FindBy(id = "login-error")
    WebElement errorMessageAtl;

    @FindBy(xpath = "//input[@value='Log in with Atlassian']")
    WebElement loginButtonAtl;

    @FindBy(id = "login-submit")
    WebElement loginSubmitButton;

    public LoginPageHelper(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void loginAsAtlassian(String login, String password) {
        enterLoginAsAtlassian(login);
        submitAsAtlassian();
        enterPasswordAsAtlassian(password);
    }

    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(passwordField,15);
        waitUntilElementIsClickable(loginButton,10);
        waitUntilElementIsClickable(loginField,15);
    }

    public String getErrorMessage(){
        waitUntilElementIsVisible(errorMessage, 15);
        return errorMessage.getText();
    }

    public String getAtlassianErrorMessage(){
        waitUntilElementIsVisible(errorMessageAtl, 15);
        return errorMessageAtl.getText();
    }

    public void pressLoginButton() {
        waitUntilElementIsClickable(loginButton,10);
        loginButton.click();
    }

    public void enterNotAtlassianPassword(String password) {
       // WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void enterNotAtlassianLogin(String login) {
        //WebElement loginField = driver.findElement(By.id("user"));
        loginField.click();
        loginField.clear();
        loginField.sendKeys(login);
    }

    public void enterLoginAsAtlassian(String login) {
       // WebElement loginField = driver.findElement(By.id("user"));
        loginField.click();
        loginField.clear();
        loginField.sendKeys(login);
    }
    public void submitAsAtlassian() {
        waitUntilElementIsClickable( loginButtonAtl,10);
       // WebElement loginAttlButton = driver.findElement(By.xpath("//input[@value='Log in with Atlassian']"));
        loginButtonAtl.click();
        waitUntilElementIsClickable(passwordField,20);
    }
    public void enterPasswordAsAtlassian(String password) {
        //WebElement passwordAtlField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
        loginSubmitButton.click();
    }
    public void loginNotAtlassian(String login, String password) {
        enterNotAtlassianLogin(login);
        enterNotAtlassianPassword(password);
        pressLoginButton();
    }

}
