package graduation;

import graduation.pages.HomePage;
import graduation.pages.ProfilePage;
import graduation.pages.SettingPage;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;
import graduation.settings.SettingWebDriver;

public class StepsTestChangeRealName {
    private HomePage homePage = new HomePage(SettingWebDriver.setUp());
    private ProfilePage profilePage = new ProfilePage(homePage.getWebDriver());
    private SettingPage settingPage = new SettingPage(homePage.getWebDriver());
    private String alertSuccess;
    private String name;

    @Дано("^пользователь имеет имя \"(.*)\"$")
    public void realName(String nameReal) {
        this.name = nameReal;
    }

    @Когда("^пользователь открывает форму настроек$")
    public void openSettingPage()  {
        homePage.authorization(profilePage.getLogin(), profilePage.getPassword());
        homePage.clickUserAvatar();
        homePage.openSetting();
    }

    @Когда("^пользователь меняет реальное имя$")
    public void changeRealName()  {
        settingPage.clickEditDetails();
        settingPage.sendKeyRealName(name);
        settingPage.clickButtonSaveChanges();
    }


    @Тогда("^пользователь видит всплывающее сообщение \"(.*)\"$")
    public void getStatus(String alert)  {
        this.alertSuccess = alert;
        Assert.assertEquals(alertSuccess,settingPage.alertGetText());
        settingPage.closeWeb();
    }
}
