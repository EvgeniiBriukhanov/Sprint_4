package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static Constants.AboutRent.COLOR_SCOOTER_BLACK_CHECKBOX;
import static Constants.AboutRent.COLOR_SCOOTER_GREY_CHECKBOX;


public class AboutRentPage {

    private WebDriver driver;


    public AboutRentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setText(String text, By input) {
        driver.findElement(input).isDisplayed();
        driver.findElement(input).sendKeys(text);
    }

    public void clickButton(By button) {
        driver.findElement(button).isDisplayed();
        driver.findElement(button).click();
    }

    public void waitLoadingPage(By expectedPage) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(expectedPage));
    }

    public void selectRentalDate(By rentalDateField, String rentalDate) {
        String date = ".//div[@aria-label='Choose " + rentalDate + "']";
        driver.findElement(rentalDateField).isDisplayed();
        driver.findElement(rentalDateField).click();
        driver.findElement(By.xpath(date)).click();
    }

    public void setRentalPeriod(String numberOfRentalDays, By fieldRentalPeriod, By listRentalPeriod) {
        WebElement rentalPeriod = driver.findElement(fieldRentalPeriod);
        rentalPeriod.isDisplayed();
        rentalPeriod.click();
        List<WebElement> elements = driver.findElements(listRentalPeriod);
        WebElement selectedPeriod = elements.stream().filter(a -> a
                .getText().equals(numberOfRentalDays)).findFirst().get();
        selectedPeriod.click();

    }

    public void setAndCheckColourCheckBox(String color, By fieldColorScooter) {
        WebElement scooterColor = driver.findElement(fieldColorScooter);
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

}