package graduation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SettingPage {
    private By editDetails = By.xpath("(//a[@href='/options/edit-details/'])[1]");
    private By fieldRealName = By.xpath("(//input[@class='form-control'])[2]");
    private By buttonSaveChanges = By.xpath("//button[@type='submit']");
    private By alertUpdate = By.xpath("//p[text()='Личные данные обновлены.']");

    private WebDriver webDriver;

    public SettingPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String alertGetText(){
        WebElement webElement = webDriver.findElement(alertUpdate);
       return webElement.getText();
    }

    public SettingPage closeWeb() {
        webDriver.close();
        return this;
    }

    public SettingPage clickButtonSaveChanges() {
        WebElement webElement = webDriver.findElement(buttonSaveChanges);
        webElement.click();
        return this;
    }

    public SettingPage clickEditDetails() {
        WebElement webElement = webDriver.findElement(editDetails);
        webElement.click();
        return this;
    }

    public SettingPage sendKeyRealName(String name) {
        WebElement webElement = webDriver.findElement(fieldRealName);
        webElement.clear();
        webElement.sendKeys(name);
        return this;
    }

}
