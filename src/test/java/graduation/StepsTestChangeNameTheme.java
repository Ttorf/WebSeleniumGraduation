package graduation;

import graduation.pages.HomePage;
import graduation.pages.ProfilePage;
import graduation.pages.ThemePage;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;
import settings.SettingWebDriver;

public class StepsTestChangeNameTheme {
    String newNameTheme;
    HomePage homePage = new HomePage(SettingWebDriver.setUp());
    ThemePage themePage = new ThemePage(homePage.getWebDriver());
    ProfilePage profilePage = new ProfilePage(homePage.getWebDriver());
    @Дано("^у пользователя есть новое наименование темы обсуждения \"(.*)\"$")
    public void newNameTheme(String nameTheme) {
        this.newNameTheme = nameTheme;

    }

    @Когда("^пользователь  изменяет название темы$")
    public void changeNameTheme() throws InterruptedException {
        homePage.authorization(profilePage.getLogin(), profilePage.getPassword());
        homePage.creatNewTheme("NameTheme1","BodyTheme1");
        themePage.clickButtonChangeNameTheme();
        Thread.sleep(2000);

    }

    @Тогда("^пользователь видит форму для изменения темы$")
    public void getFormChangeNameTheme() {
        Assert.assertEquals(true, themePage.buttonSaveChangeThemeNameIsDisplayed());
    }

    @Когда("^пользователь вводит новое название темы и сохраняет изменения$")
    public void inputNameThemeAndSave() throws InterruptedException {
        themePage.sendKeyFieldNameTheme(newNameTheme);
        Thread.sleep(2000);
        themePage.clickButtonSaveChangeThemeName();
        Thread.sleep(2000);
    }

    @Тогда("^пользователь видит новое наименование темы$")
    public void getNetNameTheme() {
        Assert.assertEquals(newNameTheme, themePage.getNameTheme());
        themePage.closeWeb();
    }
}
