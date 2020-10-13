 package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

 public class ProfileVisibilityTest extends TestBase{
     LoginPageHelper loginPage;
     BoardsPageHelper boardsPage;
     CurrentBoardPageHelper qaHaifa7CurrentBoard;
     HomePageHelper homePage;
     MenuPageHelper menuPage;
     ProfileVisibilityHelper profileVisibility;


     @BeforeMethod
    public void initTests() {
         loginPage = new LoginPageHelper(driver);
         boardsPage = new BoardsPageHelper(driver);
         homePage = new HomePageHelper(driver);
         qaHaifa7CurrentBoard= new CurrentBoardPageHelper(driver,"QA Haifa7");
         menuPage = new MenuPageHelper(driver);
         profileVisibility = new ProfileVisibilityHelper(driver);

         homePage.waitUntilPageIsLoaded();
         homePage.openLoginPage();
         loginPage.waitUntilPageIsLoaded();
         loginPage.loginAsAtlassian(LOGIN, PASSWORD);
         boardsPage.waitUntilPageIsLoaded();
         boardsPage.openCurrentBoardPage( "QA Haifa 7");
         qaHaifa7CurrentBoard.waitUntilPageIsLoaded();
         qaHaifa7CurrentBoard.openMenuPage();
         menuPage.waitUntilMenuPageIsLoaded();
         menuPage.openProfileVisibility();
         profileVisibility.waitUntilPageIsLoaded();
    }

     @Test
    public void isProfileVisibilityPage(){
         Assert.assertEquals(profileVisibility.getProfileVisibilityTabName(), "Profile and Visibility");
    }

    @Test
    public void userNameVerification(){
         String titleMenu = profileVisibility.getTitleMenuIcon();
         String userNameInTitle = titleMenu.substring(titleMenu.indexOf("(")+1,titleMenu.length()-1);
         String userName = profileVisibility.getUserName();
         Assert.assertEquals(userNameInTitle, userName);
    }
}

