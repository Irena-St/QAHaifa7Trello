package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    public static final String LOGIN = "semenchuk833@gmail.com";
    public static final String PASSWORD = "123eva456bel";
    WebDriver driver;

    @BeforeMethod
    public void StartApp1() throws InterruptedException {
        //Driver initialization. Open Trello application
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=" + "en");
        driver = new ChromeDriver(options);
        driver.get("https://trello.com/");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();

    }

}
