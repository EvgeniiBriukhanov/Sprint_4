package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static Constants.Constant.*;

public class ScooterHomePage {
    private final WebDriver driver;

    private static final String elementAnswer = "accordion__panel-";

    public ScooterHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void confirmCookie() {
        driver.findElement(COOKIE_CONFIRM_BUTTON).isDisplayed();
        driver.findElement(COOKIE_CONFIRM_BUTTON).click();
    }

    public void waitStartHomePage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Home_Header__iJKdX")));
    }

    public void scrollAcrossThePage(By scrollElement) {
        // Прокрути страницу до вопросов
        WebElement questionsHeader = driver.findElement(scrollElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", questionsHeader);
    }

    public void openingTabsAndCheckingText(int numberSize, String expectedTextQuestion, String expectedTextAnswer, By questionsList) {
        List<WebElement> elements = driver.findElements(questionsList);
        Assert.assertEquals(elements.get(numberSize).getText(), expectedTextQuestion);
        elements.get(numberSize).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(elementAnswer + numberSize)));
        Assert.assertEquals(driver.findElement(By.id(elementAnswer + numberSize)).getText(), expectedTextAnswer);
    }

    public void clickOrderButton(By button) {
        driver.findElement(button).isDisplayed();
        driver.findElement(button).click();
    }

    public void checkingOrderButtons(By firstButton, By secondButton, String urlStartPage, By expectedPageOnButtonClick) {
        clickOrderButton(firstButton);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(expectedPageOnButtonClick));
        driver.get(urlStartPage);
        waitStartHomePage();
        scrollAcrossThePage(secondButton);
        clickOrderButton(secondButton);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(expectedPageOnButtonClick));
    }

}