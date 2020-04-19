package graduation;

import graduation.pages.HomePage;
import graduation.pages.ProfilePage;
import graduation.pages.ThemePage;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;
import graduation.settings.SettingWebDriver;

public class StepsTestChooseAnswer {
    private String alert;
    private HomePage homePage = new HomePage(SettingWebDriver.setUp());
    private ThemePage themePage = new ThemePage(homePage.getWebDriver());
    private ProfilePage profilePage = new ProfilePage(homePage.getWebDriver());


    @Когда("^пользователь выбрал первый ответ")
    public void chooseAnswer()  {
        homePage.authorization(profilePage.getLogin(), profilePage.getPassword());
        homePage.creatNewTheme("NameTheme1", "BodyTheme1");
        themePage.clickButtonAddSurvey();
        themePage.writeVoit("Голосование", "answerQFirst", "answerQSecond", 2, 2);
        themePage.clickButtonSendMessageWithVoting();
        themePage.clickRandomCheckBox();
    }

    @Когда("^пользователь сохранил результат")
    public void saveResult()  {
        themePage.clickButtonSaveYourAnswer();
    }

    @Тогда("^пользователь видит сообщение об удачном голосовании \"(.*)\"$")
    public void viewAlert(String alert)  {
        this.alert = alert;
        Assert.assertEquals(this.alert,themePage.alertSuccessMessage().getText());
        themePage.closeWeb();
    }
}
