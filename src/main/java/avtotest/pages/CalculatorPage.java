package avtotest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class CalculatorPage extends BasePage {

    @FindBy(xpath = "//h2[text()='Рассчитайте доходность по вкладу']")
    public WebElement title;

    @FindBy(xpath = "//span[text()='Рубли']/ancestor::span")
    public WebElement ruble;

    @FindBy(xpath = "//span[text()='Доллары США']/ancestor::span")
    public WebElement dollar;

    @FindBy(xpath = "//input[@name='deposit_b_n']/following-sibling::div")
    public WebElement checkBoxInBank;

    @FindBy(xpath = "//input[@name='deposit_b_n']//..")
    public WebElement boxInBankCheckedOrNot;

    @FindBy(xpath = "//input[@name='amount']")
    public WebElement sumOfContribution;


    @FindBy(xpath = "//div[@class='jq-selectbox__select']")
    public WebElement period;

    @FindBy(xpath = "//div[@class='jq-selectbox__dropdown']/ul/li")
    public WebElement selectPeriod;

    @FindBy(xpath = "//input[@name='replenish']")
    public WebElement monthlyReplenishment;

    @FindBy(xpath = "//input[@name='capitalization']//..")
    public WebElement boxСapitalizaionCheckedOrNot;

    @FindBy(xpath = "//input[@name='partial_out']//..")
    public WebElement boxPartialWithdrawalCheckedOrNot;


    @FindBy(xpath = "//span[@class='js-calc-rate']")
    public WebElement depositRate;

    @FindBy(xpath = "//span[@class='js-calc-earned']")
    public WebElement accrued;

    @FindBy(xpath = "//span[@class='js-calc-replenish']")
    public WebElement replenishment;

    @FindBy(xpath = "//span[@class='js-calc-result']")
    public WebElement result;

    public void checkTitle(String expect) throws Exception {
        compareElements(title, expect);
    }
    public void selectCalculatorCurrency(String menuItem) throws Exception{
        if("Рубли".equalsIgnoreCase(menuItem)){
            scrollToAndClickElement(ruble);
            System.out.println("Рубли");
        }else if ("Доллары США".equalsIgnoreCase(menuItem)){
            scrollToAndClickElement(dollar);
            System.out.println("Доллары США");
        }else {
            System.out.println("Валюта не найдена");
        }
    }
    public void selectInBankCheckedOrNot()throws Exception{
        scrollToAndClickElement(boxInBankCheckedOrNot);
    }




    public void selectSumOfContribution(String value) throws Exception {
        scrollToAndClickElement(sumOfContribution);
        sumOfContribution.sendKeys(value);
    }

    public void selectPeriod(String expectPeriod) throws Exception {
        for (int i = 0; i < 10; i++) {
            try {
                scrollToAndClickElement(period);
                WebElement el = driver.findElement(
                        By.xpath("//div[@class='jq-selectbox__dropdown']/ul/li[text()=\"" +expectPeriod+"\"]"));
                el.click();

                break;
            } catch (Exception e) {
                if (i >= 9) {
                    throw new Exception("Период не найден");
                }
                continue;
            }
        }
    }
    public void selectСapitalizaionCheckedOrNot()throws Exception{
        scrollToAndClickElement(boxСapitalizaionCheckedOrNot);
    }
    public void selectPartialWithdrawalCheckedOrNot()throws Exception{
        scrollToAndClickElement(boxPartialWithdrawalCheckedOrNot);
    }

    public void selectMonthlyReplenishment(String value) throws Exception {
        scrollToAndClickElement(monthlyReplenishment);
        monthlyReplenishment.sendKeys(value);
    }


    public void checkDepositRate(String expect) throws Exception {
        compareElements(depositRate, expect);
    }

    public void checkAccrued(String expect) throws Exception {
        compareElements(accrued, expect);
    }

    public void checkReplenishment(String expect) throws Exception {
        compareElements(replenishment, expect);
    }

    public void checkResult(String expect) throws Exception {
        compareElements(result, expect);
    }
}
