package graduation;

import graduation.pages.HomePage;
import graduation.pages.ProfilePage;
import graduation.pages.ThemePage;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;
import graduation.settings.SettingWebDriver;

public class StepsTestAddSurvey {
    private String nameVoting;
    private int numberDays;
    private int allowedAnswerOptions;
    private String answerQFirst;
    private String answerQSecond;
    private String alert;
    private HomePage homePage = new HomePage(SettingWebDriver.setUp());
    private ThemePage themePage = new ThemePage(homePage.getWebDriver());
    private ProfilePage profilePage = new ProfilePage(homePage.getWebDriver());

    @Дано("^у пользователя есть наименование вопроса голосования \"(.*)\"$")
    public void nameVotingTheme(String nameVot) {
        this.nameVoting = nameVot;
    }

    @Дано("^у пользователя есть длительность голосования в днях (\\d+)$")
    public void numbersDaysVoting(int numbersD) {
        this.numberDays = numbersD;
    }

    @Дано("^у пользователя есть число разрешенных вариантов (\\d+)$")
    public void allowedAnswerOptions(int numbersAnswers) {
        this.allowedAnswerOptions = numbersAnswers;
    }

    @Дано("^у пользователя есть первый возможный вариант ответ \"(.*)\"$")
    public void allowedAnswerOptionsFirst(String answerF) {
        this.answerQFirst = answerF;
    }

    @Дано("^у пользователя есть второй возможный вариант ответ \"(.*)\"$")
    public void allowedAnswerOptionsSecond(String answerS) {
        this.answerQSecond = answerS;
    }

    @Когда("^пользователь заполняет форму и отправляет сообщение с голосованием$")
    public void sendingAVotingMessage()  {
        homePage.authorization(profilePage.getLogin(), profilePage.getPassword());
        homePage.creatNewTheme("NameTheme1", "BodyTheme1");
        themePage.clickButtonAddSurvey();
        themePage.writeVoit(nameVoting, answerQFirst, answerQSecond, numberDays, allowedAnswerOptions);
        themePage.clickButtonSendMessageWithVoting();
    }

    @Тогда("^пользователь видит сообщение \"(.*)\"$")
    public void viewAlertSuccess(String alert) {
        this.alert = alert;
        Assert.assertEquals("Голосование было опубликовано.", this.alert);
        Assert.assertEquals(true, themePage.buttonSaveChangeThemeNameIsDisplayed());
        themePage.closeWeb();
    }
}
