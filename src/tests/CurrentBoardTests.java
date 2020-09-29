package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CurrentBoardTests extends TestBase {

    @BeforeMethod
    public void initTests() {

        WebElement loginIcon = driver.findElement(By
                .xpath("//*[@class='btn btn-sm btn-link text-white']"));
        loginIcon.click();
        //Thread.sleep(5000);
        waitUntilElementIsClickable(By.id("user"),15);
        WebElement loginField = driver.findElement(By.id("user"));
        loginField.click();
        loginField.clear();
        loginField.sendKeys(LOGIN);
        //Thread.sleep(3000);
        waitUntilElementIsClickable(By.xpath("//input[@value='Log in with Atlassian']"),10);
        WebElement loginAttlButton = driver.findElement(By.id("login"));
        loginAttlButton.click();
        //Thread.sleep(3000);
        waitUntilElementIsClickable(By.id("password"),20);
        WebElement passAttlField = driver.findElement(By.id("password"));
        passAttlField.click();
        passAttlField.clear();
        passAttlField.sendKeys(PASSWORD);
        waitUntilElementIsClickable(By.id("login-submit"),15);
        driver.findElement(By.id("login-submit")).click();
        //Thread.sleep(15000);
        waitUntilElementIsClickable(By.xpath("//button[@data-test-id = 'header-boards-menu-button']"),45);
        WebElement boardQAHaifa7 = driver.findElement(By.xpath("//li[@class='boards-page-board-section-list-item'][.//div[@title ='QA Haifa7']]"));
        boardQAHaifa7.click();
        waitUntilElementIsClickable(By.id("workspaces-preamble-board-header-button"),15);
        waitUntilElementIsPresent(By.tagName("h1"),10);

    }
    @Test
    public void isCorrectCurrentBoard(){
        System.out.println("Header of the current board: " +driver.findElement(By.tagName("h1")).getText());
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(),"QA Haifa7" ,
                "The header of a screen is not 'QA Haifa7' ");
    }

    @Test
    public void CreateListPositive() throws InterruptedException {

        waitUntilElementsAreVisible(By.xpath("//div[@class='list js-list-content']"),10);
        System.out.println("Lists quantity before: "+ driver
                .findElements(By.xpath("//div[@class='list js-list-content']")).size());
        int quantityListsInTheBegining = driver
                .findElements(By.xpath("//div[@class = 'list js-list-content']")).size();
        waitUntilElementIsClickable(By.className("placeholder"),5);
        WebElement addAListButton = driver.findElement(By.className("placeholder"));
        addAListButton.click();
        waitUntilElementIsClickable(By.xpath("//input[@type='submit']"), 5);
        WebElement enterListTitle = driver.findElement(By.name("name"));
        enterListTitle.click();
        enterListTitle.clear();
        enterListTitle.sendKeys("Test");
        WebElement submitNewList = driver.findElement(By.xpath("//input[@type='submit']"));
        submitNewList.click();
        waitUntilElementIsClickable(By.cssSelector("a.icon-close.dark-hover"), 5);
        WebElement xButton = driver.findElement(By.cssSelector("a.icon-close.dark-hover"));
        xButton.click();
        waitUntilElementIsInvisible(By.cssSelector("a.icon-close.dark-hover"), 5);
        int quantityListsAtTheEnd = driver
                .findElements(By.xpath("//div[@class = 'list js-list-content']")).size();
        System.out.println("Lists quantity after: "+driver
                .findElements(By.xpath("//div[@class='list js-list-content']")).size());
        Assert.assertEquals(quantityListsAtTheEnd, quantityListsInTheBegining+1);
    }

    @Test
    public void putAnyListToArchive() throws InterruptedException {
        //System.out.println("Lists quantity before: "+ driver
              //  .findElements(By.xpath("//div[@class='list js-list-content']")).size());
        WebElement addListButton = driver.findElement(By.cssSelector("a.open-add-list"));
        if (addListButton.getText().equals("Add a list")) {
            addListButton.click();
            waitUntilElementIsClickable(By.xpath("//input[@type='submit']"), 5);
            WebElement addNameListField = driver.findElement(By.xpath("//input[@name='name']"));
            addNameListField.click();
            addNameListField.clear();
            addNameListField.sendKeys("test");
            WebElement submitNewList = driver.findElement(By.xpath("//input[@type='submit']"));
            submitNewList.click();
            waitUntilElementIsClickable(By.cssSelector("a.icon-close.dark-hover"), 5);
            WebElement xButton = driver.findElement(By.cssSelector("a.icon-close.dark-hover"));
            xButton.click();
            waitUntilElementIsInvisible(By.cssSelector("a.icon-close.dark-hover"), 5);
        }
        waitUntilElementsAreVisible(By.xpath("//div[@class='list js-list-content']"),10);
            System.out.println("Lists quantity before: "+ driver
                    .findElements(By.xpath("//div[@class='list js-list-content']")).size());
            int quantityListsInTheBegining = driver
                    .findElements(By.xpath("//div[@class = 'list js-list-content']")).size();
            addListButton = driver.findElement(By.cssSelector("a.open-add-list"));
        System.out.println("Text on the button: " +addListButton.getText());
      WebElement extraMenu = driver.findElement(By.cssSelector("a.list-header-extras-menu"));
      extraMenu.click();
      waitUntilElementIsClickable(By.cssSelector("a.js-close-list"),15);
      WebElement closeExtraMenu = driver.findElement(By.cssSelector("a.js-close-list"));
      closeExtraMenu.click();
      waitUntilElementIsInvisible(By.cssSelector("a.js-close-list"),5);
      int quantityListsAtTheEnd = driver
              .findElements(By.xpath("//div[@class = 'list js-list-content']")).size();
        System.out.println("Lists quantity after: "+driver
                .findElements(By.xpath("//div[@class='list js-list-content']")).size());
        Assert.assertEquals(quantityListsAtTheEnd, quantityListsInTheBegining-1);
    }

}
