package graduation;

import graduation.pages.HomePage;
import graduation.pages.ProfilePage;
import graduation.pages.ThemePage;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;
import graduation.settings.SettingWebDriver;

public class StepsTestChooseAnswer {
    String alert;
    HomePage homePage = new HomePage(SettingWebDriver.setUp());
    ThemePage themePage = new ThemePage(homePage.getWebDriver());
    ProfilePage profilePage = new ProfilePage(homePage.getWebDriver());


    @Когда("^пользователь выбрал первый ответ")
    public void chooseAnswer() throws InterruptedException {
        homePage.authorization(profilePage.getLogin(), profilePage.getPassword());
        homePage.creatNewTheme("NameTheme1", "BodyTheme1");
        themePage.clickButtonAddSurvey();
        Thread.sleep(1000);
        themePage.writeVoit("Голосование", "answerQFirst", "answerQSecond", 2, 2);
        Thread.sleep(1000);
        themePage.clickButtonSendMessageWithVoting();
        Thread.sleep(1000);
        themePage.clickRandomCheckBox();
    }

    @Когда("^пользователь сохранил результат")
    public void saveResult() throws InterruptedException {
        Thread.sleep(1000);
        themePage.clickButtonSaveYourAnswer();
    }

    @Тогда("^пользователь видит сообщение об удачном голосовании \"(.*)\"$")
    public void viewAlert(String alert) throws InterruptedException {
        this.alert = alert;
        Thread.sleep(1000);
        Assert.assertEquals(true, themePage.alertSuccessMessage());
        themePage.closeWeb();
    }
}
