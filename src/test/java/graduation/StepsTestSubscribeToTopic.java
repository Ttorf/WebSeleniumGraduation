package graduation;

import graduation.pages.HomePage;
import graduation.pages.ProfilePage;
import graduation.pages.ThemePage;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;
import graduation.settings.SettingWebDriver;

public class StepsTestSubscribeToTopic {
    private HomePage homePage = new HomePage(SettingWebDriver.setUp());
    private ThemePage themePage = new ThemePage(homePage.getWebDriver());
    private ProfilePage profilePage = new ProfilePage(homePage.getWebDriver());
    private String status;

    @Когда("^пользователь подписывается на топик$")
    public void subscribe()  {
        homePage.authorization(profilePage.getLogin(), profilePage.getPassword());
        homePage.creatNewTheme("NameTheme1", "BodyTheme1");
        themePage.clickDropDownMenu();
        themePage.clickAstivSubscribeStatus();
    }

    @Тогда("^пользователь видит \"(.*)\"$")
    public void getStatus(String statusNow) {
        this.status = statusNow;
        Assert.assertEquals(status, themePage.dropDownMenuStatusGetText());
        themePage.closeWeb();
    }

}
