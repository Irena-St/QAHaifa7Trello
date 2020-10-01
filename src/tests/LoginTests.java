package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void initTests() {

        WebElement loginIcon = driver.findElement(By
                .xpath("//*[@class='btn btn-sm btn-link text-white']"));
        loginIcon.click();
       // waitUntilElementIsVisible(By.id("password"),10);
       // Thread.sleep(10000);
    }


    @Test
    public void loginNegativeLoginEmpty()  {
        // Enter empty login and password
        waitUntilElementIsClickable(By.id("password"),15);
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("marinaqa");
        waitUntilElementIsClickable(By.id("login"),10);
        //Press login button
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        waitUntilElementIsPresent(By.id("error"), 10);
        //.sleep(5000);
        //Print error message
        System.out.println("Error: " + driver
                .findElement(By.id("error")).getText());
        Assert.assertEquals(driver.findElement(By.id("error")).getText(),"Missing email",
                "The text of the error message is not correct");
    }
    @Test
    public void loginNegativeTest() {
        waitUntilElementIsClickable(By.id("user"),10);
        WebElement enterEmail = driver.findElement((By.id("user")));
        enterEmail.click();
        enterEmail.clear();
        enterEmail.sendKeys("12345@");
        waitUntilElementIsClickable(By.id("password"),10);
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("123123");
        waitUntilElementIsClickable(By.id("login"),10);
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        waitUntilElementIsClickable(By.id("error"),20);
        System.out.println("Error: " + driver
                .findElement(By.id("error")).getText());
        Assert.assertEquals(driver.findElement(By.id("error")).getText(),"There isn't an account for this email",
                "The text of the error message is not correct");
    }
    @Test
    public void negativeTestWrongPass() {
        waitUntilElementIsClickable(By.id("user"),10);
        WebElement enterEmail = driver.findElement((By.id("user")));
        enterEmail.click();
        enterEmail.clear();
        enterEmail.sendKeys(LOGIN);
        waitUntilElementIsClickable(By.xpath("//input[@value='Log in with Atlassian']"),10);
        WebElement atlassian = driver.findElement(By.xpath("//input[@value='Log in with Atlassian']"));
        atlassian.click();
        waitUntilElementIsClickable(By.id("password"),10);
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("123123123");
        waitUntilElementIsClickable(By.xpath("//button[@id='login-submit']"),20);
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='login-submit']"));
        loginButton.click();
        waitUntilElementIsClickable(By.xpath("//div[@id='login-error']"),15);
        /*System.out.println("Error: " + driver
                .findElement(By.xpath("//div[@id='login-error']")).getText());*/
         Assert.assertTrue(driver.findElement(By.xpath("//div[@id='login-error']"))
                         .getText().equals("Incorrect email address and/ or password.Do you need help logging in?"));
    }
    @Test
    public void positiveTest() {

        waitUntilElementIsClickable(By.id("user"),10);
        WebElement enterEmail = driver.findElement((By.id("user")));
        enterEmail.click();
        enterEmail.clear();
        enterEmail.sendKeys(LOGIN);
        waitUntilElementIsClickable(By.xpath("//input[@value='Log in with Atlassian']"),10);
        // Thread.sleep(2000);
        WebElement atlassian = driver.findElement(By.xpath("//input[@value='Log in with Atlassian']"));
        atlassian.click();
        waitUntilElementIsClickable(By.id("password"),15);
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(PASSWORD);
        waitUntilElementIsClickable(By.id("login-submit"),15);
        WebElement loginButton = driver.findElement(By
                .xpath("//button[@id='login-submit']//span[@class='css-t5emrf']"));
        loginButton.click();
        //Thread.sleep(30000);
        waitUntilElementIsClickable(By.xpath("//button[@data-test-id = 'header-boards-menu-button']"),45);
       /* System.out.println("Button text is: "+driver
                .findElement(By.xpath("//button[@data-test-id " +
                        "= 'header-boards-menu-button']")).getText());*/
       Assert.assertTrue (driver.findElement(By.xpath("//button[@data-test-id = 'header-boards-menu-button']"))
                                       .getText().equals("Boards"), "The text on the button is not correct");

    }
}
