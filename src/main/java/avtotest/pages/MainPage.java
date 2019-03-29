package avtotest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    @FindBy(xpath = "//a[@style ='background-image: url(/upload/iblock/350/calculator.svg)']")
    WebElement calculator;

    public void selectCalculator()throws Exception{
        scrollToAndClickElement(calculator);
    }
}
