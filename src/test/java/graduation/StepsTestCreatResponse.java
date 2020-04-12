package graduation;

import graduation.pages.HomePage;
import graduation.pages.ThemePage;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;
import settings.SettingWebDriver;

public class StepsTestCreatResponse {
    String bodyResponseTheme;
    HomePage homePage = new HomePage(SettingWebDriver.setUp());
    ThemePage themePage = new ThemePage(homePage.getWebDriver());


    @Дано("^у пользователя есть тело ответа для темы \"(.*)\"$")
    public void nameBodyResponse(String stringBody) {
        this.bodyResponseTheme = stringBody;

    }

    @Когда("^пользователь отправляет ответ$")
    public void sendRespons() throws InterruptedException {
        String nameTheme = "Name Theme";
        String bodyTheme = "Body new Theme";
        homePage.authorization(themePage.getLogin(), themePage.getPassword());
        Thread.sleep(4000);
        homePage.clickNewTheme();
        Thread.sleep(3000);
        homePage.writeNewTheme(nameTheme, bodyTheme);
        homePage.clickCreatTheme();
        Thread.sleep(4000);
        themePage.clickButtonReply();
        Thread.sleep(4000);
        themePage.sendKeyRespons(bodyResponseTheme);
        Thread.sleep(4000);
        themePage.clickButtonSendResponse();
        Thread.sleep(2000);
    }

    @Тогда("^пользователь видит свой ответ в данной теме обсуждения$")
    public void getNewRespons() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertEquals(bodyResponseTheme, themePage.getMyLastRespons());
        themePage.closeWeb();
    }

}

