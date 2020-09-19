package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void initTests() throws InterruptedException {

        WebElement loginIcon = driver.findElement(By
                .xpath("//*[@class='btn btn-sm btn-link text-white']"));
        loginIcon.click();
        Thread.sleep(10000);
    }
    @Test
    public void loginNegativeLoginEmpty() throws InterruptedException {
        // Enter empty login and password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("marinaqa");
        //Press login button
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        Thread.sleep(5000);
        //Print error mssage
        System.out.println("Error: " + driver
                .findElement(By.id("error")).getText());
    }
    @Test
    public void loginNegativeTest() throws InterruptedException {

        WebElement enterEmail = driver.findElement((By.id("user")));
        enterEmail.click();
        enterEmail.clear();
        enterEmail.sendKeys("12345@");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("123123");
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        Thread.sleep(5000);
        System.out.println("Error: " + driver
                .findElement(By.id("error")).getText());
    }
    @Test
    public void negativeTestWrongPass() throws InterruptedException {

        WebElement enterEmail = driver.findElement((By.id("user")));
        enterEmail.click();
        enterEmail.clear();
        enterEmail.sendKeys("semenchuk833@gmail.com");
        Thread.sleep(3000);
        WebElement atlassian = driver.findElement(By.id("login"));
        atlassian.click();
        Thread.sleep(5000);
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("123123123");
        Thread.sleep(3000);
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='login-submit']//span[@class='css-t5emrf']"));
        loginButton.click();
        Thread.sleep(5000);
        System.out.println("Error: " + driver
                .findElement(By.id("login-error")).getText());
    }
    @Test
    public void positiveTest() throws InterruptedException {

        WebElement enterEmail = driver.findElement((By.id("user")));
        enterEmail.click();
        enterEmail.clear();
        enterEmail.sendKeys("semenchuk833@gmail.com");
        Thread.sleep(2000);
        WebElement atlassian = driver.findElement(By.id("login"));
        atlassian.click();
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("123eva456bel");
        Thread.sleep(2000);
        WebElement loginButton = driver.findElement(By
                .xpath("//button[@id='login-submit']//span[@class='css-t5emrf']"));
        loginButton.click();
        Thread.sleep(30000);
        System.out.println("Button text is: "+driver
                .findElement(By.xpath("//button[@data-test-id " +
                        "= 'header-boards-menu-button']")).getText());
        }
    @Test
    public void loginPositive() throws InterruptedException {
        //Enter login field for Atlassian
        WebElement loginField = driver.findElement(By.id("user"));
        loginField.click();
        loginField.clear();
        loginField.sendKeys(LOGIN);
        Thread.sleep(3000);
        //Submit login Atlassian
        WebElement loginAttlButton = driver.findElement(By.id("login"));
        loginAttlButton.click();
        Thread.sleep(15000);
        //Enter Atlassian password and submit it
        WebElement passAttlField = driver.findElement(By.id("password"));
        passAttlField.click();
        passAttlField.clear();
        passAttlField.sendKeys(PASSWORD);
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(30000);
        System.out.println("Boards button text: "
                + driver.findElement(By.xpath("//button[@data-test-id " +
                "= 'header-boards-menu-button']")).getText());
    }

}
