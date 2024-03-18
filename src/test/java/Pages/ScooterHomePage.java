package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ScooterHomePage {
    private static final By HOME_PAGE_HEADER = By.className("Home_Header__iJKdX");
    private static final By COOKIE_CONFIRM_BUTTON = By.id("rcc-confirm-button");
    private static final By FIRST_ORDER_BUTTON = By.xpath(".//div[@class = 'Header_Nav__AGCXC']/button[@class = 'Button_Button__ra12g']");
    private static final By SECOND_ORDER_BUTTON = By.xpath(".//div[@class = 'Home_FinishButton__1_cWm']/button[text()='Заказать']");
    private static final By QUESTIONS_ABOUT_IMPORTANT_HEADER = By.xpath(".//div[@class='Home_FourPart__1uthg']/div[@class='Home_SubHeader__zwi_E']");
    private static final By QUESTIONS_LIST = By.xpath(".//div[@data-accordion-component='AccordionItem']");
    private final WebDriver driver;

    private static final String elementAnswer = "accordion__panel-";

    public ScooterHomePage(WebDriver driver) {
        this.driver = driver;
    }

    private void clickButton(By button) {
        driver.findElement(button).isDisplayed();
        driver.findElement(button).click();
    }

    public void confirmCookie() {
        clickButton(COOKIE_CONFIRM_BUTTON);
    }

    public void clickFirstOrderButton() {
        clickButton(FIRST_ORDER_BUTTON);
    }

    public void clickSecondOrderButton() {
        WebElement questionsHeader = driver.findElement(SECOND_ORDER_BUTTON);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", questionsHeader);
        clickButton(SECOND_ORDER_BUTTON);
    }

    public void waitStartHomePage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(HOME_PAGE_HEADER));
    }

    public void scrollAcrossThePage() {
        // Прокрути страницу до вопросов
        WebElement questionsHeader = driver.findElement(QUESTIONS_ABOUT_IMPORTANT_HEADER);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", questionsHeader);
    }

    public void checkingHeadingText(int numberSize, String expectedTextQuestion) {
        List<WebElement> elements = driver.findElements(QUESTIONS_LIST);
        Assert.assertEquals(elements.get(numberSize).getText(), expectedTextQuestion);
    }

    public void checkingPanelText(int numberSize, String expectedTextAnswer) {
        List<WebElement> elements = driver.findElements(QUESTIONS_LIST);
        elements.get(numberSize).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(elementAnswer + numberSize)));
        Assert.assertEquals(driver.findElement(By.id(elementAnswer + numberSize)).getText(), expectedTextAnswer);
    }
}