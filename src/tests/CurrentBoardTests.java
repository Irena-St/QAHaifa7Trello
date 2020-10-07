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
import pages.BoardsPageHelper;
import pages.CurrentBoardPageHelper;
import pages.HomePageHelper;
import pages.LoginPageHelper;

public class CurrentBoardTests extends TestBase {
LoginPageHelper loginPage;
BoardsPageHelper boardsPage;
CurrentBoardPageHelper qaHaifa7CurrentBoard;
HomePageHelper homePage;


    @BeforeMethod
    public void initTests() {
        loginPage = new LoginPageHelper(driver);
        boardsPage = new BoardsPageHelper(driver);
        qaHaifa7CurrentBoard= new CurrentBoardPageHelper(driver,"QA Haifa7");

        homePage.waitUntilPageIsLoaded();
        homePage.openLoginPage();
        loginPage.waitUntilPageIsLoaded();
        loginPage.loginAsAtlassian(LOGIN, PASSWORD);
        boardsPage.waitUntilPageIsLoaded();
        boardsPage.openCurrentBoardPage( "QA Haifa 7");
        qaHaifa7CurrentBoard.waitUntilPageIsLoaded();
    }

    @Test
    public void isCorrectCurrentBoard(){
        Assert.assertEquals(qaHaifa7CurrentBoard.getCurrentBoardHeader(),"QA Haifa7" ,
                "The header of a screen is not 'QA Haifa7' ");

    }
    public String getCurrentBoardHeader(){
        return driver.findElement(By.tagName("h1")).getText();
    }

    @Test
    public void CreateListPositive() {

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
