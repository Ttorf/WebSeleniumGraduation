package graduation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SettingPage {
    private By editDetailsWithWindowMaximize = By.xpath("(//a[@class='list-group-item'])[1]");
    private By fieldRealName = By.xpath("(//input[@class='form-control'])[2]");
    private By buttonSaveChanges = By.xpath("//button[@type='submit']");
    private By alertUpdate = By.xpath("//p[text()='Личные данные обновлены.']");

    private WebDriver webDriver;

    public SettingPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String alertGetText() {
        WebElement webElement = webDriver.findElement(alertUpdate);
        return webDriverWaitElement(webElement).getText();
    }

    public SettingPage closeWeb() {
        webDriver.close();
        return this;
    }

    public SettingPage clickButtonSaveChanges() {
        WebElement webElement = webDriver.findElement(buttonSaveChanges);
        webDriverWaitElement(webElement).click();
        return this;
    }

    public SettingPage clickEditDetails() {
        WebElement webElement = webDriver.findElement(editDetailsWithWindowMaximize);
        webDriverWaitElement(webElement).click();
        return this;
    }

    public SettingPage sendKeyRealName(String name) {
        WebElement webElement = webDriver.findElement(fieldRealName);
        webElement.clear();
        webElement.sendKeys(name);
        return this;
    }

    public WebElement webDriverWaitElement(WebElement webElement) {
        return (new WebDriverWait(webDriver, 15)).
                until(ExpectedConditions.visibilityOf(webElement));
    }

}
