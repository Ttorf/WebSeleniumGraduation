package graduation;

import graduation.pages.HomePage;
import graduation.pages.ProfilePage;
import graduation.pages.ThemePage;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;
import graduation.settings.SettingWebDriver;

public class StepsTestCreatResponse {
    private String bodyResponseTheme;
    private HomePage homePage = new HomePage(SettingWebDriver.setUp());
    private ThemePage themePage = new ThemePage(homePage.getWebDriver());
    private ProfilePage profilePage = new ProfilePage(homePage.getWebDriver());

    @Дано("^у пользователя есть тело ответа для темы \"(.*)\"$")
    public void nameBodyResponse(String stringBody) {
        this.bodyResponseTheme = stringBody;
    }

    @Когда("^пользователь отправляет ответ$")
    public void sendRespons() throws InterruptedException {
        homePage.authorization(profilePage.getLogin(), profilePage.getPassword());
        homePage.creatNewTheme("NameTheme1", "BodyTheme1");
        themePage.clickButtonReply();
        themePage.sendKeyRespons(bodyResponseTheme);
        themePage.clickButtonSendResponse();

    }

    @Тогда("^пользователь видит свой ответ в данной теме обсуждения$")
    public void getNewRespons() {
        Assert.assertTrue(themePage.getMyLastRespons(bodyResponseTheme));
        themePage.closeWeb();
    }

}

