package graduation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class HomePage {
    private By buttonAuthorization = By.xpath("//button[text() = 'Войти']");
    private By buttonEnterLogin = By.xpath("//button[@type='submit']");
    private By loginInput = By.id("id_username");
    private By passwordInput = By.id("id_password");
    private By alert = By.xpath("//p[@class='alert alert-danger']");
    private By headTheme = By.xpath("//input[@placeholder='Заголовок темы']");
    private By bodyTheme = By.xpath("//textarea[@class='form-control']");
    private By buttonCreatTheme = By.xpath("//button[text()='Опубликовать тему']");
    private By userAvatar = By.xpath("(//a[@data-toggle='dropdown'])[2]");
    private By openProfile = By.xpath("(//ul[@role='menu']//a)[1]");
    private By openSetting = By.xpath("//a[@href='/options/']");
    private By buttonNewTheme = By.xpath("//button[text() = 'Новая тема']");

    private WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public HomePage openSetting() {
        WebElement element = webDriver.findElement(openSetting);
        webDriverWaitTimerClick(element);
        return this;
    }

    public HomePage openAuthorizationPanel() {
        WebElement element = webDriver.findElement(buttonAuthorization);
        webDriverWaitTimerClick(element);

        return this;
    }

    public HomePage clickUserAvatar() {
        WebElement element = webDriver.findElement(userAvatar);
        webDriverWaitTimerClick(element);
        return this;
    }

    public HomePage clickOpenProfile() {
        WebElement element = webDriver.findElement(openProfile);
        webDriverWaitTimerClick(element);
        return this;
    }


    public boolean newThemeIsDisplayed() {
        WebElement element = webDriver.findElement(buttonNewTheme);
        return element.isDisplayed();
    }

    public HomePage clickCreatTheme() {
        webDriverWaitElementClick(buttonCreatTheme);
        return this;
    }

    public HomePage clickNewTheme() {
        WebElement element = webDriver.findElement(buttonNewTheme);
        webDriverWaitTimerClick(element);
        return this;
    }

    public HomePage clickButtonEnterLogin() {
        WebElement element = webDriver.findElement(buttonEnterLogin);
        webDriverWaitTimerClick(element);
        return this;
    }

    private HomePage sendKeysLogin(String login) {
        WebElement element = webDriver.findElement(loginInput);
        element.sendKeys(login);
        return this;
    }

    private HomePage sendKeysPass(String password) {
        WebElement element = webDriver.findElement(passwordInput);
        element.sendKeys(password);
        return this;
    }

    public HomePage closeWeb() {
        webDriver.close();
        return this;
    }


    public void authorization(String login, String password)  {
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webDriver.get("https://dev.n7lanit.ru/");
        openAuthorizationPanel();
        sendKeysLogin(login);
        sendKeysPass(password);
        clickButtonEnterLogin();
    }

    public String getAlert() {
        WebElement element = webDriver.findElement(alert);
        return webDriverWaitTimerGetText(element).getText();
    }

    private HomePage sendKeysNameTheme(String stringNameTheme) {
        WebElement element = webDriver.findElement(headTheme);
        element.sendKeys(stringNameTheme);
        return this;
    }

    private HomePage sendKeysBodyTheme(String stringBodyTheme) {
        WebElement element = webDriver.findElement(bodyTheme);
        element.sendKeys(stringBodyTheme);
        return this;
    }


    public void writeNewTheme(String nameTheme, String bodyTheme)  {
        sendKeysNameTheme(nameTheme);
        sendKeysBodyTheme(bodyTheme);

    }

    public void creatNewTheme(String nameTheme, String bodyTheme)  {
        clickNewTheme();
        writeNewTheme(nameTheme, bodyTheme);
        clickCreatTheme();
    }

    public void webDriverWaitTimerClick(WebElement webElement) {
        (new WebDriverWait(webDriver, 15)).
                until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }


    public WebElement webDriverWaitTimerGetText(WebElement webElement) {
        return (new WebDriverWait(webDriver, 15)).
                until(ExpectedConditions.visibilityOf(webElement));
    }

    public void webDriverWaitElementClick(By xp) {
        (new WebDriverWait(webDriver, 15)).
                until(ExpectedConditions.elementToBeClickable(xp)).submit();
    }

}
