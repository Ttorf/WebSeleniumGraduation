package graduation;

import graduation.pages.HomePage;
import graduation.pages.ThemePage;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;
import settings.SettingWebDriver;

public class StepsTestAddSurvey {
    String nameVoting;
    int numberDays;
    int allowedAnswerOptions;
    String answerQFirst;
    String answerQSecond;
    String alert;
    HomePage homePage = new HomePage(SettingWebDriver.setUp());
    ThemePage themePage = new ThemePage(homePage.getWebDriver());

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
    public void sendingAVotingMessage() throws InterruptedException {
        homePage.authorization(themePage.getLogin(), themePage.getPassword());
        Thread.sleep(3000);
        homePage.clickNewTheme();
        Thread.sleep(3000);
        homePage.writeNewTheme("nameTheme1", "bodyTheme1");
        homePage.clickCreatTheme();
        Thread.sleep(2000);
        themePage.clickButtonAddSurvey();
        Thread.sleep(2000);
        themePage.sendKeyFieldQuestion(nameVoting);
        themePage.sendKeyfiledAvailableOptions1(answerQFirst);
        themePage.sendKeyfiledAvailableOptions2(answerQSecond);
        themePage.sendKeyfieldNumberDaysVoit(String.valueOf(numberDays));
        themePage.sendKeyfieldNumberOfOptions(String.valueOf(allowedAnswerOptions));
        Thread.sleep(2000);
        themePage.clickButtonSendMessageWithVoting();

    }

    @Тогда("^пользователь видит сообщение \"(.*)\"$")
    public void viewOwnVoting(String alert) throws InterruptedException {
        this.alert = alert;
        Thread.sleep(2000);
        Assert.assertEquals(true, themePage.buttonSaveChangeThemeNameIsDisplayed());
        themePage.closeWeb();
    }
}
