package graduation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ThemePage {
    private WebDriver webDriver;
    private final String login = "Torf";
    private final String password = "654321ss";
    private By bodyTheme = By.xpath("//article[@class='misago-markup']//p[1]");
    private By buttonReply = By.xpath("(//button[contains(@class,'btn btn-primary')])[1]");
    private By buttonSendResponse = By.xpath("//button[@type='submit']");
    private By fieldResponse = By.xpath("//textarea[@class='form-control']");
    private By fieldSendedRespons = By.xpath("//article[@class='misago-markup']//p");
    private By buttonChangeNameTheme = By.xpath("//button[@title='Изменить название']");
    private By fieldNameTheme = By.xpath("(//input[@class='form-control'])[2]");
    private By buttonSaveChangeThemeName = By.xpath("//button[@title='Изменить название']");
    private By nameTheme = By.tagName("h1");
    private By buttonAddSurvey = By.xpath("(//div[@class='col-sm-4 hidden-xs']//button)[1]");
    private By fieldQuestion = By.xpath("(//input[@class='form-control'])[2]");
    private By filedAvailableOptions1 = By.xpath("(//input[@placeholder='выбрать метку'])[1]");
    private By filedAvailableOptions2 = By.xpath("(//input[@placeholder='выбрать метку'])[2]");
    private By fieldNumberDaysVoit = By.xpath("(//input[@class='form-control'])[3]");
    private By fieldNumberOfOptions = By.xpath("(//input[@class='form-control'])[4]");
    private By buttonSendMessageWithVoting = By.xpath("//button[@type='submit']");
    private By alertSuccess = By.xpath("//p[@class='alert alert-success']");
    private By checksBoxAnswer = By.xpath("//button[@class='btn']//span");
    private By buttonSaveYourAnswer = By.xpath("");


    public ThemePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String bodyTheme() {
        return webDriver.findElement(bodyTheme).getText();

    }

    public ThemePage clickRandomCheckBox() {
        List<WebElement> webElementList = webDriver.findElements(checksBoxAnswer);
        WebElement webElement = webElementList.get((int) (Math.random() + webElementList.size() - 1));
        webElement.click();
        return this;
    }
    public ThemePage clickButtonSaveYourAnswer() {
        WebElement webElement = webDriver.findElement(buttonSaveYourAnswer);
        webElement.click();
        return this;
    }


    public boolean alertSuccessMessage() {
        WebElement webElement = webDriver.findElement(alertSuccess);
        return webElement.isDisplayed();

    }

    public ThemePage clickButtonSendMessageWithVoting() {
        WebElement webElement = webDriver.findElement(buttonSendMessageWithVoting);
        webElement.click();
        return this;
    }

    public ThemePage sendKeyfieldNumberOfOptions(String numberOfOptions) {
        WebElement webElement = webDriver.findElement(fieldNumberOfOptions);
        webElement.click();
        webElement.clear();
        webElement.sendKeys(numberOfOptions);
        return this;
    }

    public ThemePage sendKeyfieldNumberDaysVoit(String numberDaysVoit) {
        WebElement webElement = webDriver.findElement(fieldNumberDaysVoit);
        webElement.click();
        webElement.clear();
        webElement.sendKeys(numberDaysVoit);
        return this;
    }

    public ThemePage sendKeyfiledAvailableOptions2(String availableOptions2) {
        WebElement webElement = webDriver.findElement(filedAvailableOptions2);
        webElement.click();
        webElement.sendKeys(availableOptions2);
        return this;
    }

    public ThemePage sendKeyfiledAvailableOptions1(String availableOptions1) {
        WebElement webElement = webDriver.findElement(filedAvailableOptions1);
        webElement.click();
        webElement.sendKeys(availableOptions1);
        return this;
    }

    public ThemePage sendKeyFieldQuestion(String question) {
        WebElement webElement = webDriver.findElement(fieldQuestion);
        webElement.click();
        webElement.sendKeys(question);
        return this;
    }

    public ThemePage clickButtonAddSurvey() {
        WebElement webElement = webDriver.findElement(buttonAddSurvey);
        webElement.click();
        return this;
    }

    public boolean buttonSaveChangeThemeNameIsDisplayed() {
        WebElement webElement = webDriver.findElement(buttonSaveChangeThemeName);
        return webElement.isDisplayed();
    }

    public String getNameTheme() {
        WebElement webElement = webDriver.findElement(nameTheme);
        return webElement.getText();

    }

    public ThemePage clickButtonChangeNameTheme() {
        WebElement webElement = webDriver.findElement(buttonChangeNameTheme);
        webElement.click();
        return this;
    }

    public ThemePage clickButtonSaveChangeThemeName() {
        WebElement webElement = webDriver.findElement(buttonSaveChangeThemeName);
        webElement.click();
        return this;
    }

    public ThemePage sendKeyFieldNameTheme(String message) {
        WebElement webElement = webDriver.findElement(fieldNameTheme);
        webElement.click();
        webElement.clear();
        webElement.sendKeys(message);
        return this;
    }

    public ThemePage clickButtonReply() {
        WebElement webElement = webDriver.findElement(buttonReply);
        webElement.click();
        return this;
    }

    public ThemePage sendKeyRespons(String message) {
        WebElement webElement = webDriver.findElement(fieldResponse);
        webElement.sendKeys(message);
        return this;
    }

    public ThemePage clickButtonSendResponse() {
        WebElement webElement = webDriver.findElement(buttonSendResponse);
        webElement.click();
        return this;
    }

    public ThemePage closeWeb() {
        webDriver.close();
        return this;
    }

    public String getMyLastRespons() {
        List<WebElement> webElementList = webDriver.findElements(fieldSendedRespons);
        return webElementList.get(webElementList.size() - 1).getText();
    }
}
