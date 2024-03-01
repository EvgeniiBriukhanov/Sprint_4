package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static Constants.AboutRent.*;


public class ForWhomScooterPage {

    private WebDriver driver;


    public ForWhomScooterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setText(String text, By input) {
        driver.findElement(input).isDisplayed();
        driver.findElement(input).sendKeys(text);
    }

    public void setMetroStation(String metroStation, By fieldMetroName, By listMetroStation) {
        driver.findElement(fieldMetroName).isDisplayed();
        driver.findElement(fieldMetroName).click();
        driver.findElement(fieldMetroName).sendKeys(metroStation);
        driver.findElements(listMetroStation).get(0).click();
    }

    public void clickButton(By button) {
        driver.findElement(button).isDisplayed();
        driver.findElement(button).click();
    }

    public void waitLoadingPage(By expectedPage) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(expectedPage));
    }

}
