package graduation.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ThemePage {
    private WebDriver webDriver;
    private By bodyTheme = By.xpath("//article[@class='misago-markup']//p[1]");
    private By buttonReply = By.xpath("//button[text() = 'Ответить']");
    private By buttonSubmit = By.xpath("//button[@type='submit']");
    private By fieldResponse = By.xpath("//textarea[@class='form-control']");
    private By fieldSendResponse = By.xpath("(//article[@class='misago-markup']//p)[2]");
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
    private By alertSuccess = By.xpath("//p[text()='Ваш голос был сохранен.']");
    private By checksBoxAnswer = By.xpath("//span[text()='check_box_outline_blank']");
    private By activeSubscribeStatus = By.xpath("(//ul[contains(@class,'dropdown-menu dropdown-menu-right')]//button)[2]");
    private By dropDownMenu = By.xpath("(//button[@data-toggle='dropdown'])[2]");
    private By alertYouCantSendAnswersSoFastly = By.xpath("//p[text()='Вы не можете опубликовать сообщение так быстро после предыдущего.']");
    private By activeSubscribeStatusAfterSub = By.xpath("(//div[@class='dropdown']//button)[1]");

    public ThemePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private boolean elementExist(By by) {
        try {
            webDriver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String bodyTheme() {
        return webDriver.findElement(bodyTheme).getText();

    }

    public ThemePage clickAstivSubscribeStatus() {
        WebElement element = webDriver.findElement(activeSubscribeStatus);
        webDriverWaitTimerClick(element);
        return this;
    }

    public ThemePage clickDropDownMenu() {
        webDriverWaitVisibility(dropDownMenu).click();
        return this;
    }

    public String dropDownMenuStatusGetText() {
        StringBuilder stb = new StringBuilder(webDriverWaitVisibility(activeSubscribeStatusAfterSub).getText());
        stb.delete(0, 9);
        return String.valueOf(stb);
    }

    public ThemePage clickRandomCheckBox() {
        webDriverWaitVisibility(checksBoxAnswer).click();
        return this;
    }

    public ThemePage clickButtonSaveYourAnswer() {
        webDriverWaitVisibility(buttonSubmit).click();
        return this;
    }


    public WebElement alertSuccessMessage() {
        return webDriverWaitVisibility(alertSuccess);


    }

    public void writeVoit(String nameVoting, String answerQFirst, String answerQSecond, int numberDays, int allowedAnswerOptions) {
        sendKeyFieldQuestion(nameVoting);
        sendKeyfiledAvailableOptions1(answerQFirst);
        sendKeyfiledAvailableOptions2(answerQSecond);
        sendKeyfieldNumberDaysVoit(String.valueOf(numberDays));
        sendKeyfieldNumberOfOptions(String.valueOf(allowedAnswerOptions));
    }

    public ThemePage clickButtonSendMessageWithVoting() {
        WebElement element = webDriver.findElement(buttonSubmit);
        webDriverWaitTimerClick(element);
        return this;
    }

    public ThemePage sendKeyfieldNumberOfOptions(String numberOfOptions) {
        WebElement element = webDriver.findElement(fieldNumberOfOptions);
        webDriverWaitTimerClick(element);
        element.clear();
        element.sendKeys(numberOfOptions);
        return this;
    }

    public ThemePage sendKeyfieldNumberDaysVoit(String numberDaysVoit) {
        WebElement element = webDriver.findElement(fieldNumberDaysVoit);
        webDriverWaitTimerClick(element);
        element.clear();
        element.sendKeys(numberDaysVoit);
        return this;
    }

    public ThemePage sendKeyfiledAvailableOptions2(String availableOptions2) {
        WebElement element = webDriver.findElement(filedAvailableOptions2);
        webDriverWaitTimerClick(element);
        element.sendKeys(availableOptions2);
        return this;
    }

    public ThemePage sendKeyfiledAvailableOptions1(String availableOptions1) {
        WebElement element = webDriver.findElement(filedAvailableOptions1);
        webDriverWaitTimerClick(element);
        element.sendKeys(availableOptions1);
        return this;
    }

    public ThemePage sendKeyFieldQuestion(String question) {
        WebElement element = webDriver.findElement(fieldQuestion);
        webDriverWaitTimerClick(element);
        element.sendKeys(question);
        return this;
    }

    public ThemePage clickButtonAddSurvey() {
        WebElement element = webDriver.findElement(buttonAddSurvey);
        webDriverWaitTimerClick(element);
        return this;
    }

    public boolean buttonSaveChangeThemeNameIsDisplayed() {
        return webDriverWaitVisibility(buttonSaveChangeThemeName).isDisplayed();
    }

    public String getNameTheme() {
        return webDriverWaitVisibility(nameTheme).getText();

    }

    public ThemePage clickButtonChangeNameTheme() {
        WebElement element = webDriver.findElement(buttonChangeNameTheme);
        webDriverWaitTimerClick(element);
        return this;
    }

    public ThemePage clickButtonSaveChangeThemeName() {
        WebElement element = webDriver.findElement(buttonSaveChangeThemeName);
        webDriverWaitTimerClick(element);
        return this;
    }

    public ThemePage sendKeyFieldNameTheme(String message) {

        WebElement element = webDriver.findElement(fieldNameTheme);
        webDriverWaitTimerClick(element);
        element.clear();
        element.sendKeys(message);
        return this;

    }

    public ThemePage clickButtonReply() {
        webDriverWaitVisibility(buttonReply).click();
        return this;
    }

    public ThemePage sendKeyRespons(String message) {
        WebElement webElement = webDriver.findElement(fieldResponse);
        webElement.sendKeys(message);
        return this;
    }

    public ThemePage clickButtonSendResponse() throws InterruptedException {
        WebElement element = webDriver.findElement(buttonSubmit);
        element.click();

        if (elementExist(alertYouCantSendAnswersSoFastly)) {
            if (webDriverWaitVisibility(alertYouCantSendAnswersSoFastly).isDisplayed()) {
                Thread.sleep(1500);
                element.click();
            }
        }
        return this;
    }

    public ThemePage closeWeb() {
        webDriver.close();
        return this;
    }

    public boolean getMyLastRespons(String text) {
        if (elementExist(buttonSubmit)) {
            WebElement element = webDriver.findElement(buttonSubmit);
            element.click();
        }
        return (new WebDriverWait(webDriver, 15)).
                until(ExpectedConditions.textToBePresentInElementLocated(fieldSendResponse, text));
    }

    public void webDriverWaitTimerClick(WebElement webElement) {
        (new WebDriverWait(webDriver, 15)).
                until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }

    public WebElement webDriverWaitVisibility(By webElement) {
        return (new WebDriverWait(webDriver, 15)).
                until(ExpectedConditions.visibilityOfElementLocated(webElement));
    }


}
