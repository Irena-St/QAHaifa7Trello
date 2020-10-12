package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BoardsPageHelper;
import pages.HomePageHelper;
import pages.LoginPageHelper;

public class LoginTests extends TestBase {
LoginPageHelper loginPage;
BoardsPageHelper boardsPage;
HomePageHelper homePage;

    @BeforeMethod
    public void initTests() {
        loginPage = new LoginPageHelper(driver);
        boardsPage = new BoardsPageHelper(driver);
        homePage = new HomePageHelper(driver);
        homePage.waitUntilPageIsLoaded();
        homePage.openLoginPage();
        loginPage.waitUntilPageIsLoaded();
    }
    @Test
    public void loginNegativeLoginEmpty()  {
        loginPage.loginNotAtlassian("",PASSWORD);
        loginPage.pressLoginButton();
        Assert.assertEquals(loginPage.getErrorMessage(),"Missing email",
                "The text of the error message is not correct");
    }
    @Test
    public void loginNegativeTest() {
        loginPage.loginNotAtlassian("123456", PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessage(), "There isn't an account for this username",
                "The error message is not 'There isn't an account for this username'");
    }
    @Test
    public void loginNegativePasswordIncorrect() {
       loginPage.loginAsAtlassian(LOGIN, PASSWORD+"1");
        Assert.assertTrue(loginPage.getAtlassianErrorMessage().contains("Incorrect email address and"),
                 "The error message is not contains the text 'Incorrect email address and'");
    }
    @Test
    public void positiveTest() {
        loginPage.loginAsAtlassian(LOGIN, PASSWORD);
        boardsPage.waitUntilPageIsLoaded();
        //Assert.assertTrue(loginPage.getBoardsIconName().equals("Boards"), "The text on the button is not correct");

    }

}
