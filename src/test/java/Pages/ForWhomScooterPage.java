package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ForWhomScooterPage {
    private static final By WHO_IS_THE_SCOOTER_FOR_HEADER = By.className("Order_Header__BZXOb");
    private static final By FIRST_NAME_INPUT = By.xpath("//input[@placeholder='* Имя']");
    private static final By LAST_NAME_INPUT = By.xpath(".//input[@placeholder='* Фамилия']");
    private static final By ADDRESS_INPUT = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private static final By NAME_METRO_INPUT = By.xpath(".//input[@placeholder='* Станция метро']");
    private static final By PHONE_NUMBER_INPUT = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private static final By LIST_METRO_STATION = By.xpath("//*[@class='select-search__select']");
    private static final By NEXT_BUTTON = By.xpath(".//button[text()='Далее']");

    private WebDriver driver;


    public ForWhomScooterPage(WebDriver driver) {
        this.driver = driver;
    }

    private void setText(String text, By input) {
        driver.findElement(input).isDisplayed();
        driver.findElement(input).sendKeys(text);
    }

    public void setFirstName(String text) {
        setText(text, FIRST_NAME_INPUT);
    }

    public void setLastName(String text) {
        setText(text, LAST_NAME_INPUT);
    }

    public void setAddress(String text) {
        setText(text, ADDRESS_INPUT);
    }

    public void setPhoneNumber(String text) {
        setText(text, PHONE_NUMBER_INPUT);
    }

    private Boolean isTextSetted(String expectedText, By input) {
        return driver.findElement(input).getAttribute("value").equals(expectedText);
    }

    public Boolean isFirstNameSetted(String expectedText) {
        return isTextSetted(expectedText, FIRST_NAME_INPUT);
    }

    public Boolean isLastNameSetted(String expectedText) {
        return isTextSetted(expectedText, LAST_NAME_INPUT);
    }

    public Boolean isAddressSetted(String expectedText) {
        return isTextSetted(expectedText, ADDRESS_INPUT);
    }

    public Boolean isPhoneNumberSetted(String expectedText) {
        return isTextSetted(expectedText, PHONE_NUMBER_INPUT);
    }

    public Boolean isMetroStationSetted(String expectedText) {
        return isTextSetted(expectedText, NAME_METRO_INPUT);
    }

    public void setMetroStation(String metroStation) {
        driver.findElement(NAME_METRO_INPUT).isDisplayed();
        driver.findElement(NAME_METRO_INPUT).click();
        driver.findElement(NAME_METRO_INPUT).sendKeys(metroStation);
        driver.findElements(LIST_METRO_STATION).get(0).click();
    }

    public void clickNextButton() {
        driver.findElement(NEXT_BUTTON).isDisplayed();
        driver.findElement(NEXT_BUTTON).click();
    }

    public void waitForWhomScooterPageLoading() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(WHO_IS_THE_SCOOTER_FOR_HEADER));
    }

    public Boolean isHeaderDisplayed() {
        return driver.findElement(WHO_IS_THE_SCOOTER_FOR_HEADER).isDisplayed();
    }

}
