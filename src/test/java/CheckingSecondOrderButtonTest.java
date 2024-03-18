import Constants.Constant;
import Pages.ForWhomScooterPage;
import Pages.ScooterHomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class CheckingSecondOrderButtonTest {

    private WebDriver driver;

    public WebDriver getWebDriver(boolean useFirefox) {
        if (useFirefox) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
            return new FirefoxDriver(options);
        } else {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
            return new ChromeDriver(options);
        }
    }

    @Before
    public void actionBefore() {
        driver = getWebDriver(false);
        driver.get(Constant.URL_HOME_PAGE);
    }

    @After
    public void actionAfter() {
        driver.quit();
    }

    @Test
    public void checkingSecondOrderButtonTest() {
        ScooterHomePage scooterHomePage = new ScooterHomePage(driver);
        scooterHomePage.waitStartHomePage();
        scooterHomePage.confirmCookie();

        ForWhomScooterPage forWhomScooterPage = new ForWhomScooterPage(driver);

        scooterHomePage.clickSecondOrderButton();
        forWhomScooterPage.waitForWhomScooterPageLoading();
        forWhomScooterPage.isHeaderDisplayed();
    }
}