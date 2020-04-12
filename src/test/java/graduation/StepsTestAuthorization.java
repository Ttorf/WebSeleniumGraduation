package graduation;

import graduation.pages.HomePage;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import settings.SettingWebDriver;

public class StepsTestAuthorization {
    WebDriver webDriver;
    String login;
    String pass;
    String message;

    HomePage homePage = new HomePage(SettingWebDriver.setUp());

    @Дано("^пользователь имеет логин \"(.*)\"$")
    public void giveLogin(String string) throws InterruptedException {
        this.login = string;
    }

    @Дано("^пользователь имеет пароль \"(.*)\"$")
    public void givePass(String string) throws InterruptedException {
        this.pass = string;
    }

    @Когда("^пользователь авторизуется$")
    public void autoriz() throws InterruptedException {
        homePage.authorization(login, pass);
        Thread.sleep(1000);
    }

    @Тогда("^пользователь получает сообщение \"(.*)\"$")
    public void getAlert(String string) throws InterruptedException {
        this.message = string;
        String excected = homePage.getAlert();
        Assert.assertEquals(excected, message);
        Thread.sleep(2000);
        homePage.closeWeb();
    }

    @Тогда("^пользователь получит доступ к сайту$")
    public void getAccess() throws InterruptedException {
        Assert.assertEquals(true, homePage.newThemeIsDisplayed());
        homePage.closeWeb();
    }
}
