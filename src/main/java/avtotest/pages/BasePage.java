package avtotest.pages;

import avtotest.steps.BaseSteps;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

public class BasePage {
    public WebDriver driver = BaseSteps.getDriver();

    public BasePage() {
        PageFactory.initElements(driver, this);
    }

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) BaseSteps.getDriver()).executeScript("arguments[0].scrollIntoView();", element);
        ((JavascriptExecutor) BaseSteps.getDriver()).executeScript("scrollBy(0, -250)");
    }

    public void scrollToAndClickElement(WebElement element) throws Exception {
        for (int i = 0; i < 3; i++) {
            try {
                scrollToElement(element);
                element.click();
                return;
            } catch (Exception e) {
                if (i >= 3)
                    throw new Exception("Невозможно найти элемент");
                continue;
            }
        }
    }

    public void compareElements(WebElement element, String expect) throws Exception {
        for (int i = 0; i < 3; i++) {
            try {
                scrollToElement(element);
                System.out.println(element.getText());
                if(!expect.equalsIgnoreCase(element.getText()))
                    continue;
                break;
            } catch (Exception e) {
                if (i >= 3) {
                    throw new Exception("Невозможно найти элемент");
                }
                continue;
            }
        }
        assertTrue("Исходного текста нет ", expect.equalsIgnoreCase(element.getText()));
        System.out.println("Исходный текст есть: " + expect);

    }
}
