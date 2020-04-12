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
