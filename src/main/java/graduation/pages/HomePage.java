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
    private By buttonNewTheme = By.xpath("//button[contains(@class,'btn btn-primary')]");
    private By headTheme = By.xpath("//input[@placeholder='Заголовок темы']");
    private By bodyTheme = By.xpath("//textarea[@class='form-control']");
    private By buttonCreatTheme = By.xpath("//button[text()='Опубликовать тему']");
    private By userAvatar = By.xpath("(//a[@data-toggle='dropdown'])[2]");
    private By openProfile = By.xpath("(//ul[@role='menu']//a)[1]");
    private By openSetting = By.xpath("//a[@href='/options/']");

    private WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public HomePage openSetting() {
        WebElement webElement = webDriver.findElement(openSetting);
        webElement.click();
        return this;
    }
    //todo
    public HomePage openAuthorizationPanel() {
        WebElement element = webDriver.findElement(buttonAuthorization);
        (new WebDriverWait(webDriver, 10)).
                until(ExpectedConditions.elementToBeClickable(element)).click();

        return this;
    }

    public HomePage clickUserAvatar() {
        WebElement webElement = webDriver.findElement(userAvatar);
        webElement.click();
        return this;
    }

    public HomePage clickOpenProfile() {
        WebElement webElement = webDriver.findElement(openProfile);
        webElement.click();
        return this;
    }


    public boolean newThemeIsDisplayed() {
        WebElement element = webDriver.findElement(buttonNewTheme);
        return element.isDisplayed();
    }

    public HomePage clickCreatTheme() {
        WebElement element = webDriver.findElement(buttonCreatTheme);
        element.click();
        return this;
    }

    public HomePage clickNewTheme() {
        WebElement element = webDriver.findElement(buttonNewTheme);
        element.click();
        return this;
    }
    //todo
    public HomePage clickButtonEnterLogin() {
        WebElement element = webDriver.findElement(buttonEnterLogin);
        (new WebDriverWait(webDriver, 10)).
                until(ExpectedConditions.elementToBeClickable(element)).click();

        return this;
    }
    //todo
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



    public void authorization(String login, String password) throws InterruptedException {
        webDriver.manage().window().maximize();
        webDriver.get("https://dev.n7lanit.ru/");
        openAuthorizationPanel();
        sendKeysLogin(login);
        sendKeysPass(password);
        clickButtonEnterLogin();
    }

    public String getAlert() {
        WebElement element = webDriver.findElement(alert);
        return element.getText();
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


    public void writeNewTheme(String nameTheme, String bodyTheme) throws InterruptedException {
        sendKeysNameTheme(nameTheme);
        sendKeysBodyTheme(bodyTheme);
        Thread.sleep(3000);
    }

    public void creatNewTheme(String nameTheme, String bodyTheme) throws InterruptedException {
        Thread.sleep(4000);
        clickNewTheme();
        Thread.sleep(3000);
        writeNewTheme(nameTheme, bodyTheme);
        clickCreatTheme();
        Thread.sleep(4000);
    }
}
