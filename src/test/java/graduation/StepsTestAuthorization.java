package graduation;

import graduation.pages.HomePage;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;
import graduation.settings.SettingWebDriver;

public class StepsTestAuthorization {
    private String login;
    private String pass;
    private String message;

    private HomePage homePage = new HomePage(SettingWebDriver.setUp());

    @Дано("^пользователь имеет логин \"(.*)\"$")
    public void giveLogin(String string) {
        this.login = string;
    }

    @Дано("^пользователь имеет пароль \"(.*)\"$")
    public void givePass(String string) {
        this.pass = string;
    }

    @Когда("^пользователь авторизуется$")
    public void authorize()  {
        homePage.authorization(login, pass);
    }

    @Тогда("^пользователь получает сообщение \"(.*)\"$")
    public void getAlert(String string) {
        this.message = string;
        String excepted = homePage.getAlert();
        Assert.assertEquals(excepted, message);
        homePage.closeWeb();
    }

    @Тогда("^пользователь получит доступ к сайту$")
    public void getAccess() {
        Assert.assertEquals(true, homePage.newThemeIsDisplayed());
        homePage.closeWeb();
    }
}

