package avtotest.steps;

import avtotest.pages.MainPage;
import io.qameta.allure.Step;

public class MainSteps{
    MainPage mainPage = new MainPage();
    @Step("Нажимаем калькулятор для вклада")
    public void clickButtonCalculator()throws Exception{
        mainPage.selectCalculator();
    }

}
