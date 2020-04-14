package graduation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage {
    private By buttonAuthorization = By.xpath("//button[text() = 'Войти']");
    private By buttonEnterLogin = By.xpath("//button[@type='submit']");
    private By loginInput = By.id("id_username");
    private By passwordInput = By.id("id_password");
    private By allert = By.xpath("//p[@class='alert alert-danger']");
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

    public HomePage openAuthorizationPanel() throws InterruptedException {
        WebElement element = webDriver.findElement(buttonAuthorization);
        element.click();
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


    public boolean newThemeIsDisplayed() throws InterruptedException {
        WebElement element = webDriver.findElement(buttonNewTheme);
        return element.isDisplayed();
    }

    public HomePage clickCreatTheme() {
        WebElement element = webDriver.findElement(buttonCreatTheme);
        element.click();
        return this;
    }

    public HomePage clickNewTheme() throws InterruptedException {
        WebElement element = webDriver.findElement(buttonNewTheme);
        element.click();
        return this;
    }

    public HomePage clickButtonEnterLogin() throws InterruptedException {
        WebElement element = webDriver.findElement(buttonEnterLogin);
        element.click();
        return this;
    }

    private HomePage sendKeysLogin(String login) throws InterruptedException {
        WebElement element = webDriver.findElement(loginInput);
        element.sendKeys(login);
        return this;
    }

    private HomePage sendKeysPass(String password) throws InterruptedException {
        WebElement element = webDriver.findElement(passwordInput);
        element.sendKeys(password);
        return this;
    }

    public HomePage closeWeb() {
        webDriver.close();
        return this;
    }

    public void authorization(String login, String password) throws InterruptedException {
        webDriver.get("https://dev.n7lanit.ru/");
        openAuthorizationPanel();
        Thread.sleep(4000);
        sendKeysLogin(login);
        sendKeysPass(password);
        clickButtonEnterLogin();
        Thread.sleep(2000);
    }

    public String getAlert() {
        WebElement element = webDriver.findElement(allert);
        return element.getText();
    }

    private HomePage sendKeysNameTheme(String stringNameTheme) throws InterruptedException {
        WebElement element = webDriver.findElement(headTheme);
        element.sendKeys(stringNameTheme);
        return this;
    }

    private HomePage sendKeysBodyTheme(String stringBodyTheme) throws InterruptedException {
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
