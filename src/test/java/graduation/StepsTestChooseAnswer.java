package graduation;

import graduation.pages.HomePage;
import graduation.pages.ThemePage;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;
import settings.SettingWebDriver;

public class StepsTestChooseAnswer {
    String alert;
    HomePage homePage = new HomePage(SettingWebDriver.setUp());
    ThemePage themePage = new ThemePage(homePage.getWebDriver());

    // Когда пользователь выбрал первый ответ и сохранил результат
    //    Тогда пользователь видит сообщение "Ваш голос был сохранен"
    @Когда("^пользователь выбрал первый ответ и сохранил результат")
    public void name() throws InterruptedException {
        homePage.authorization(themePage.getLogin(), themePage.getPassword());
        Thread.sleep(3000);
        homePage.clickNewTheme();
        Thread.sleep(3000);
        homePage.writeNewTheme("nameTheme1", "bodyTheme1");
        homePage.clickCreatTheme();
        Thread.sleep(2000);
        //клик на чекбокс
        // клик на сохранить ваш голос;

    }

    @Тогда("^пользователь видит сообщение об удачном голосовании \"(.*)\"$")
    public void viewAlert(String alert) throws InterruptedException {
        this.alert = alert;
        Thread.sleep(2000);
        Assert.assertEquals(true, themePage.alertSuccessMessage());
        themePage.closeWeb();
    }
}
