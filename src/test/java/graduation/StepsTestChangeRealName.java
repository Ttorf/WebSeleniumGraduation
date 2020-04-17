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
    public void openSettingPage() throws InterruptedException {
        homePage.authorization(profilePage.getLogin(), profilePage.getPassword());
        homePage.clickUserAvatar();
        Thread.sleep(1000);
        homePage.openSetting();
        Thread.sleep(1000);
    }

    @Когда("^пользователь меняет реальное имя$")
    public void changeRealName() throws InterruptedException {
        settingPage.clickEditDetails();
        Thread.sleep(1000);
        settingPage.sendKeyRealName(name);
        settingPage.clickButtonSaveChanges();
        Thread.sleep(1000);
    }


    @Тогда("^пользователь видит всплывающее сообщение \"(.*)\"$")
    public void getStatus(String alert) throws InterruptedException {
        this.alertSuccess = alert;
        Assert.assertEquals(alertSuccess,settingPage.alertGetText());
        Thread.sleep(1000);
        settingPage.closeWeb();
    }
}
