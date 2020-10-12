package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
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
    public void initTests()  {
        loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
        boardsPage = PageFactory.initElements(driver, BoardsPageHelper.class);
        homePage = PageFactory.initElements(driver,HomePageHelper.class);
        qaHaifa7CurrentBoard = new CurrentBoardPageHelper(driver,"QA Haifa7");

        homePage.waitUntilPageIsLoaded();
        homePage.openLoginPage();
        loginPage.waitUntilPageIsLoaded();
        loginPage.loginAsAtlassian(LOGIN,PASSWORD);
        boardsPage.waitUntilPageIsLoaded();
        boardsPage.openCurrentBoardPage("QA Haifa7");
        qaHaifa7CurrentBoard.waitUntilPageIsLoaded();
    }


    @Test
    public void isCorrectCurrentBoard(){
        Assert.assertEquals(qaHaifa7CurrentBoard.getCurrentBoardHeader(),"QA Haifa7",
                "The header of the screen is not 'QA Haifa7'");
    }

    @Test
    public void isCorrectCurrentBoard2(){
        Assert.assertTrue(qaHaifa7CurrentBoard.isCorrectCurrentBoard(),
                "The header of the screen is not 'QA Haifa7'");
    }


    @Test
    public void createListPositive()  {
        int listsBeforeAdding = qaHaifa7CurrentBoard.getListsQuantity();
        qaHaifa7CurrentBoard.createNewList();
        int listsAfterAdding = qaHaifa7CurrentBoard.getListsQuantity();
        Assert.assertEquals(listsBeforeAdding +1, listsAfterAdding,
                "The quantity of lists is not equal to expected quantitty");

    }

    @Test
    public void putAnyListToArchive()  {
        if (qaHaifa7CurrentBoard.getNameOfAddListButton().equals("Add a list"))
        {
            qaHaifa7CurrentBoard.createNewList();
        }
        int quantityListsInTheBeginning = qaHaifa7CurrentBoard.getListsQuantity();
        qaHaifa7CurrentBoard.openExtraMenuForFirstList();
        qaHaifa7CurrentBoard.putTheListToArchive();
        int quantityListsAtTheEnd = qaHaifa7CurrentBoard.getListsQuantity();
        Assert.assertEquals(quantityListsAtTheEnd,quantityListsInTheBeginning-1,
                "The quantityListsAtTheEnd is not quantityListsInTheBeginning-1");
    }




}
