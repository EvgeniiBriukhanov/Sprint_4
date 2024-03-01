package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertNotNull;


public class AboutRentPage {

    private WebDriver driver;

    private static final By ABOUT_RENT_HEADER = By.className("Order_Header__BZXOb");
    private static final By RENTAL_DATE_INPUT = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private static final By RENTAL_PERIOD_DROPDOWN = By.className("Dropdown-placeholder");
    private static final By RENTAL_PERIOD_LIST = By.className("Dropdown-option");
    private static final By COLOR_SCOOTER = By.className("Order_Title__3EKne");
    private static final By COLOR_SCOOTER_BLACK_CHECKBOX = By.id("black");
    private static final By COLOR_SCOOTER_GREY_CHECKBOX = By.id("grey");
    private static final By COMMENT_FOR_THE_COURIER_INPUT = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private static final By ORDER_BUTTON = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[text()='Заказать']");
    private static final By PLACE_AN_ORDER_HEADER = By.className("Order_ModalHeader__3FDaJ");
    private static final By YES_IN_MODAL_BUTTON = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[text()='Да']");
    private static final By ORDER_IS_PROCESSED_HEADER = By.className("Order_ModalHeader__3FDaJ");
    private static final By GET_STATUS_BUTTON = By.xpath(".//button[text()='Посмотреть статус']");

    public AboutRentPage(WebDriver driver) {
        this.driver = driver;
    }

    private void clickButton(By button) {
        driver.findElement(button).isDisplayed();
        driver.findElement(button).click();
    }

    private void waitLoadingPage(By expectedPage) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(expectedPage));
    }

    public void setComment(String text) {
        driver.findElement(COMMENT_FOR_THE_COURIER_INPUT).isDisplayed();
        driver.findElement(COMMENT_FOR_THE_COURIER_INPUT).sendKeys(text);
    }

    public Boolean isCommentSetted(String messageCourier) {
        return driver.findElement(COMMENT_FOR_THE_COURIER_INPUT).getAttribute("value").equals(messageCourier);
    }

    public void waitOrderModal() {
        waitLoadingPage(PLACE_AN_ORDER_HEADER);
    }

    public void waitOrderIsProcessedModal() {
        waitLoadingPage(ORDER_IS_PROCESSED_HEADER);
    }

    public void waitAboutRentPage() {
        waitLoadingPage(ABOUT_RENT_HEADER);
    }

    public void selectRentalDate(String rentalDate) {
        String date = ".//div[@aria-label='Choose " + rentalDate + "']";
        driver.findElement(RENTAL_DATE_INPUT).isDisplayed();
        driver.findElement(RENTAL_DATE_INPUT).click();
        driver.findElement(By.xpath(date)).click();
        assertNotNull(driver.findElement(RENTAL_DATE_INPUT).getAttribute("value"));
    }

    public void setRentalPeriod(String numberOfRentalDays) {
        WebElement rentalPeriod = driver.findElement(RENTAL_PERIOD_DROPDOWN);
        rentalPeriod.isDisplayed();
        rentalPeriod.click();
        List<WebElement> elements = driver.findElements(RENTAL_PERIOD_LIST);
        WebElement selectedPeriod = elements.stream().filter(a -> a
                .getText().equals(numberOfRentalDays)).findFirst().get();
        selectedPeriod.click();
    }

    public Boolean isSettedRentalPeriod(String numberOfRentalDays) {
        return driver.findElement(RENTAL_PERIOD_DROPDOWN).getText().equals(numberOfRentalDays);
    }

    public void clickOrderButton() {
        clickButton(ORDER_BUTTON);
    }

    public void clickYesButton() {
        clickButton(YES_IN_MODAL_BUTTON);
    }

    public void setAndCheckColourCheckBox(String color) {
        WebElement scooterColor = driver.findElement(COLOR_SCOOTER);
        scooterColor.isDisplayed();
        switch (color) {
            case "чёрный жемчуг":
                driver.findElement(COLOR_SCOOTER_BLACK_CHECKBOX).isDisplayed();
                driver.findElement(COLOR_SCOOTER_BLACK_CHECKBOX).click();
                driver.findElement(COLOR_SCOOTER_BLACK_CHECKBOX).isSelected();
                break;
            case "серая безысходность":
                driver.findElement(COLOR_SCOOTER_GREY_CHECKBOX).isDisplayed();
                driver.findElement(COLOR_SCOOTER_GREY_CHECKBOX).click();
                driver.findElement(COLOR_SCOOTER_GREY_CHECKBOX).isSelected();
                break;
            case "черный жемчуг и серая безысходность":
                driver.findElement(COLOR_SCOOTER_BLACK_CHECKBOX).isDisplayed();
                driver.findElement(COLOR_SCOOTER_BLACK_CHECKBOX).click();
                driver.findElement(COLOR_SCOOTER_BLACK_CHECKBOX).isSelected();
                driver.findElement(COLOR_SCOOTER_GREY_CHECKBOX).isDisplayed();
                driver.findElement(COLOR_SCOOTER_GREY_CHECKBOX).click();
                driver.findElement(COLOR_SCOOTER_GREY_CHECKBOX).isSelected();
                break;
        }

    }

    public Boolean isOrderCreated() {
        return driver.findElement(ORDER_IS_PROCESSED_HEADER).getText().equals("Заказ оформлен");
    }

    public Boolean isStatusButtonDisplayed() {
        return driver.findElement(GET_STATUS_BUTTON).isDisplayed();
    }
}