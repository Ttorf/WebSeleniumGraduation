package graduation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {
    private final String login = "Torf";
    private final String password = "654321ss";
    private By nickNameProfile = By.tagName("h1");

    private WebDriver webDriver;

    public ProfilePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getNickNameProfile() {
        WebElement webElement = webDriver.findElement(nickNameProfile);
        return webElement.getText();
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public ProfilePage closeWeb() {
        webDriver.close();
        return this;
    }
}
