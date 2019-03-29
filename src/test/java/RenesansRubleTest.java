import avtotest.steps.BaseSteps;
import avtotest.steps.CalculatorSteps;
import avtotest.steps.MainSteps;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class RenesansRubleTest extends BaseSteps {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Рубли", "2000000", "6 месяцев", "30000","6.25%","65 132,87","150 000","2 215 132,87"},
                {"Доллары США", "50000", "9 месяцев", "1000","0.75%","301,42","8 000","58 301,42"}
        });
    }

    @Parameterized.Parameter
    public String currency;

    @Parameterized.Parameter(1)
    public String sum;

    @Parameterized.Parameter(2)
    public String period;

    @Parameterized.Parameter(3)
    public String monthlyReplenishment;

    @Parameterized.Parameter(4)
    public String rate;

    @Parameterized.Parameter(5)
    public String accruedForPeriod;

    @Parameterized.Parameter(6)
    public String replenishmentForPeriod;

    @Parameterized.Parameter(7)
    public String resultForPeriod;

    @Test
    @DisplayName("Делаем расчет вклада")
    public void testMethod() throws Exception {


        MainSteps mainSteps = new MainSteps();
        CalculatorSteps calculatorSteps = new CalculatorSteps();

        mainSteps.clickButtonCalculator();
        calculatorSteps.checkExpectTitle("Рассчитайте доходность по вкладу");
        calculatorSteps.choseCurrency(currency);
        calculatorSteps.choseInBank(currency);

        calculatorSteps.choseSum(sum);
        calculatorSteps.period(period);
        calculatorSteps.choseMonthlyReplenishment(monthlyReplenishment);
        calculatorSteps.сapitalizaionCheckedOrNot();
        calculatorSteps.partialWithdrawalCheckedOrNo(currency);
        calculatorSteps.checkRate(rate);
        calculatorSteps.checkAccruedForPeriod(accruedForPeriod);
        calculatorSteps.checkReplenishmentForPeriod(replenishmentForPeriod);
        calculatorSteps.checkResultForPeriod(resultForPeriod);


    }
}
