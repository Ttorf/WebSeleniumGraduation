package graduation;

import graduation.pages.HomePage;
import graduation.pages.ProfilePage;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;
import settings.SettingWebDriver;

public class StepsTestOpenProfile {
    HomePage homePage = new HomePage(SettingWebDriver.setUp());
    ProfilePage profilePage = new ProfilePage(homePage.getWebDriver());
    String name;

    @Когда("^пользователь открывает профиль$")
    public void subscribe() throws InterruptedException {
        homePage.authorization(profilePage.getLogin(), profilePage.getPassword());
        homePage.clickUserAvatar();
        Thread.sleep(1000);
        homePage.clickOpenProfile();
        Thread.sleep(1000);
    }

    @Тогда("^пользователь видит свой ник \"(.*)\"$")
    public void getStatus(String nickName) throws InterruptedException {
        this.name = nickName;
        Assert.assertEquals(name, profilePage.getNickNameProfile());
        profilePage.closeWeb();
    }
}
