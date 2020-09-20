package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CurrentBoardTests extends TestBase{

    @BeforeMethod
    public void initTests() throws InterruptedException {

        WebElement loginIcon = driver.findElement(By
                .xpath("//*[@class='btn btn-sm btn-link text-white']"));
        loginIcon.click();
        Thread.sleep(5000);
        WebElement loginField = driver.findElement(By.id("user"));
        loginField.click();
        loginField.clear();
        loginField.sendKeys(LOGIN);
        Thread.sleep(3000);
        WebElement loginAttlButton = driver.findElement(By.id("login"));
        loginAttlButton.click();
        Thread.sleep(3000);
        WebElement passAttlField = driver.findElement(By.id("password"));
        passAttlField.click();
        passAttlField.clear();
        passAttlField.sendKeys(PASSWORD);
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(15000);
        WebElement boardQAHaifa7 = driver.findElement(By.xpath("//div[@title='QA Haifa7']"));
        boardQAHaifa7.click();
        Thread.sleep(10000);
    }

    @Test
    public void CreateListPositive() throws InterruptedException {

        System.out.println("Lists quantity before: "+ driver
                .findElements(By.xpath("//div[@class='list js-list-content']")).size());
        WebElement addAListButton = driver.findElement(By.className("placeholder"));
        addAListButton.click();
        WebElement enterListTitle = driver.findElement(By.name("name"));
        enterListTitle.click();
        enterListTitle.sendKeys("Test");
        driver.findElement(By.xpath("//input[@class='primary mod-list-add-button js-save-edit']")).click();
        Thread.sleep(5000);
        System.out.println("Lists quantity after: "+driver
                .findElements(By.xpath("//div[@class='list js-list-content']")).size());
    }

    @Test
    public void DeleteListTest() throws InterruptedException {
        System.out.println("Lists quantity before: "+ driver
                .findElements(By.xpath("//div[@class='list js-list-content']")).size());
        WebElement listMenuIcon= driver.findElement(By.xpath("//div[@class=" +
               "'board-main-content']//div[1]//div[1]//div[1]//div[2]//a[1]"));
        listMenuIcon.click();
        WebElement archiveThisList = driver.findElement(By.xpath("//a[@class='js-close-list']"));
        archiveThisList.click();
        Thread.sleep(5000);
        System.out.println("Lists quantity after: "+driver
                .findElements(By.xpath("//div[@class='list js-list-content']")).size());
    }

}
