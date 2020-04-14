package graduation;

import graduation.pages.HomePage;
import graduation.pages.ProfilePage;
import graduation.pages.ThemePage;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;
import settings.SettingWebDriver;

public class StepsTestSubscribeToTopic {
    HomePage homePage = new HomePage(SettingWebDriver.setUp());
    ThemePage themePage = new ThemePage(homePage.getWebDriver());
    ProfilePage profilePage = new ProfilePage(homePage.getWebDriver());
    String status;

    @Когда("^пользователь подписывается на топик$")
    public void subscribe() throws InterruptedException {
        homePage.authorization(profilePage.getLogin(), profilePage.getPassword());
        homePage.creatNewTheme("NameTheme1", "BodyTheme1");
        Thread.sleep(1000);
        themePage.clickDropDownMenu();
        Thread.sleep(1000);
        themePage.clickAstivSubscribeStatus();


    }

    @Тогда("^пользователь видит \"(.*)\"$")
    public void getStatus(String statusNow) {
        this.status = statusNow;
        Assert.assertEquals(status, themePage.dropDownMenuStatusGetText());
        themePage.closeWeb();
    }

}
