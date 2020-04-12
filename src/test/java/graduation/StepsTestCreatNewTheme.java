package graduation;

import graduation.pages.HomePage;
import graduation.pages.ThemePage;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;
import settings.SettingWebDriver;

public class StepsTestCreatNewTheme {
    String nameTheme;
    String bodyTheme;
    HomePage homePage = new HomePage(SettingWebDriver.setUp());
    ThemePage themePage = new ThemePage(homePage.getWebDriver());

    @Дано("^у пользователя есть название темы \"(.*)\"$")
    public void nameTheme(String stringName) {
        this.nameTheme = stringName;

    }

    @Дано("^у пользователя есть тело темы \"(.*)\"$")
    public void nameBody(String stringBody) {
        this.bodyTheme = stringBody;

    }

    @Когда("^пользователь заполняет и создаёт тему$")
    public void writeAll() throws InterruptedException {
        homePage.authorization(themePage.getLogin(), themePage.getPassword());
        Thread.sleep(4000);
        homePage.clickNewTheme();
        Thread.sleep(3000);
        homePage.writeNewTheme(nameTheme, bodyTheme);
        homePage.clickCreatTheme();
    }

    @Тогда("^пользователь переходит на страницу созданной темы$")
    public void getNameThemeOnNewPage() throws InterruptedException {
      themePage = new  ThemePage(homePage.getWebDriver());
        Thread.sleep(6000);
        Assert.assertEquals(bodyTheme, themePage.bodyTheme());
        themePage.closeWeb();
    }

}