package graduation;

import graduation.pages.HomePage;
import graduation.pages.ProfilePage;
import graduation.pages.ThemePage;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;
import graduation.settings.SettingWebDriver;

public class StepsTestCreatNewTheme {
    private String nameTheme;
    private String bodyTheme;
    private HomePage homePage = new HomePage(SettingWebDriver.setUp());
    private ThemePage themePage = new ThemePage(homePage.getWebDriver());
    private ProfilePage profilePage = new ProfilePage(homePage.getWebDriver());

    @Дано("^у пользователя есть название темы \"(.*)\"$")
    public void nameTheme(String stringName) {
        this.nameTheme = stringName;
    }

    @Дано("^у пользователя есть тело темы \"(.*)\"$")
    public void nameBody(String stringBody) {
        this.bodyTheme = stringBody;
    }

    @Когда("^пользователь заполняет и создаёт тему$")
    public void writeAll()  {
        homePage.authorization(profilePage.getLogin(), profilePage.getPassword());

        homePage.clickNewTheme();
        homePage.writeNewTheme(nameTheme, bodyTheme);
        homePage.clickCreatTheme();
    }

    @Тогда("^пользователь переходит на страницу созданной темы$")
    public void getNameThemeOnNewPage() {
        Assert.assertEquals(bodyTheme, themePage.bodyTheme());
        themePage.closeWeb();
    }

}
