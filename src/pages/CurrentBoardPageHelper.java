package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CurrentBoardPageHelper extends PageBase {
    @FindBy(id = "workspace-preamble-board-header-button")
    WebElement boardsButton;

    @FindBy(tagName = "h1")
    WebElement header;

    @FindBy(css = "a.icon-close.dark-hover")
    WebElement xButton;


    public CurrentBoardPageHelper(WebDriver driver,String boardName) {
        super(driver);
        this.boardName = boardName;
        PageFactory.initElements(driver,this);
    }
    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(boardsButton,15);
        waitUntilElementIsVisible(header,10);
    }

    public String getCurrentBoardHeader(){
        return header.getText();
    }

    public boolean isCorrectCurrentBoard() {
        return header.getText().equals(this.boardName);
    }

    public int getListsQuantity(){
        waitUntilElementsAreVisible(By.xpath("//div[@class = 'list js-list-content']"),10);
        return driver.findElements(By.xpath("//div[@class = 'list js-list-content']")).size();
    }
    public void cancelTheNewAddingList() {
       // WebElement xButton = driver.findElement(By.cssSelector("a.icon-close.dark-hover"));
        xButton.click();
        waitUntilElementIsInvisible(xButton,5);
    }

    public void fillTheNameAndSubmit(String name) {
        WebElement addNamelistField = driver.findElement(By.xpath("//input[@name='name']"));
        addNamelistField.click();
        addNamelistField.clear();
        addNamelistField.sendKeys(name);
        WebElement submitNewList = driver.findElement(By.xpath("//input[@type='submit']"));
        submitNewList.click();
    }

    public void initiateAddList() {
        WebElement addListButton = driver.findElement(By.xpath("//span[@class='placeholder']"));
        addListButton.click();
    }

    public String getNameOfAddListButton(){
        WebElement addListButton = driver.findElement(By.cssSelector("a.open-add-list"));
        return addListButton.getText();
    }

    public void createNewList() {
        this.initiateAddList();
        this.fillTheNameAndSubmit("test");
        this.cancelTheNewAddingList();
    }
    public void putTheListToArchive() {
        waitUntilElementIsClickable(By.cssSelector("a.js-close-list"),15);
        WebElement closeExtraMenu = driver.findElement(By.cssSelector("a.js-close-list"));
        closeExtraMenu.click();
        waitUntilElementIsInvisible(By.cssSelector("a.js-close-list"),5);
    }

    public void openExtraMenuForFirstList() {
        WebElement extraMenu = driver.findElement(By.cssSelector("a.list-header-extras-menu"));
        extraMenu.click();
    }
    public void openMenuPage() {
        waitUntilElementIsClickable(By.xpath("//button[@aria-label = 'Open Member Menu']"),10);
        driver.findElement(By.xpath("//button[@aria-label = 'Open Member Menu']")).click();
    }

}

