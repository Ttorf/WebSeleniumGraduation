package graduation;

import graduation.pages.HomePage;
import graduation.pages.ProfilePage;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;
import graduation.settings.SettingWebDriver;

public class StepsTestOpenProfile {
    private HomePage homePage = new HomePage(SettingWebDriver.setUp());
    private ProfilePage profilePage = new ProfilePage(homePage.getWebDriver());
    private String name;

    @Когда("^пользователь открывает профиль$")
    public void subscribe()  {
        homePage.authorization(profilePage.getLogin(), profilePage.getPassword());
        homePage.clickUserAvatar();
        homePage.clickOpenProfile();
    }

    @Тогда("^пользователь видит свой ник \"(.*)\"$")
    public void getStatus(String nickName) {
        this.name = nickName;
        Assert.assertEquals(name, profilePage.getNickNameProfile());
        profilePage.closeWeb();
    }
}
