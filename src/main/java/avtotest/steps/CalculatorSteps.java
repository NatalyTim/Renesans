package avtotest.steps;

import avtotest.pages.CalculatorPage;
import io.qameta.allure.Step;

public class CalculatorSteps{

    CalculatorPage calculatorPage = new CalculatorPage();

  @Step("Проверяем наличие заголовка")
    public void checkExpectTitle(String expect) throws Exception {
        calculatorPage.checkTitle(expect);
    }
    @Step("Выбираем валюту")
    public void choseCurrency(String currency) throws Exception {
        calculatorPage.selectCalculatorCurrency(currency);
    }
    @Step("Открытие вклада в банке или на сайте")
    public void choseInBank(String currency) throws Exception {
        if(!"Доллары США".equalsIgnoreCase(currency))
            calculatorPage.selectInBankCheckedOrNot();
    }

    @Step("Выбираем сумму вклада")
    public void choseSum(String depositAmount) throws Exception {
        calculatorPage.selectSumOfContribution(depositAmount);
    }
    @Step("Выбираем срок вклада")
    public void period(String expectPeriod) throws Exception {
        calculatorPage.selectPeriod(expectPeriod);
    }

    @Step("Ежемесячное пополнение")
    public void choseMonthlyReplenishment(String replenishment) throws Exception {
        calculatorPage.selectMonthlyReplenishment(replenishment);
    }
    @Step("Ежемесячная капитализация")
    public void сapitalizaionCheckedOrNot() throws Exception {
        calculatorPage.selectСapitalizaionCheckedOrNot();
    }
    @Step("Частичное снятие")
    public void partialWithdrawalCheckedOrNo(String currency) throws Exception {
        if(!"Доллары США".equalsIgnoreCase(currency))
            calculatorPage.selectPartialWithdrawalCheckedOrNot();
    }

    @Step("Проверяем ставку вклада")
    public void checkRate(String expect) throws Exception {
        calculatorPage.checkDepositRate(expect);
    }

    @Step("Проверяем сколько начислено за период")
    public void checkAccruedForPeriod(String expect) throws Exception {
        calculatorPage.checkAccrued(expect);
    }

    @Step("Проверяем пополнение за период")
    public void checkReplenishmentForPeriod(String expect) throws Exception {
        calculatorPage.checkReplenishment(expect);
    }

    @Step("Проверяем сколько подлежит к снятию")
    public void checkResultForPeriod(String expect) throws Exception {
        calculatorPage.checkResult(expect);
    }
}
