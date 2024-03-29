import Constants.Constant;
import Pages.AboutRentPage;
import Pages.ForWhomScooterPage;
import Pages.ScooterHomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class ScooterOrderTest {

    private WebDriver driver;

    private final String firstName;
    private final String lastName;
    private final String address;
    private final String metroStation;
    private final String phoneNumber;
    private final String dateForRent;
    private final String numberOfRentalDays;
    private final String colorScooter;
    private final String messageCourier;


    public ScooterOrderTest(String firstName, String lostName, String address, String metroStation, String phoneNumber, String dateForRent, String numberOfRentalDays, String colorScooter, String messageCourier) {
        this.firstName = firstName;
        this.lastName = lostName;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.dateForRent = dateForRent;
        this.numberOfRentalDays = numberOfRentalDays;
        this.colorScooter = colorScooter;
        this.messageCourier = messageCourier;
    }

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

    @Parameterized.Parameters
    public static Object[][] getUserData() {
        return new Object[][]{
                {"Иван", "Морозов", "Третья плита слева от стены", "Воробьёвы горы", "+79992042000", "понедельник, 26-е февраля 2024 г.", "двое суток", "чёрный жемчуг", "Тест-Тестович"},
                {"Петро", "Непьющий", "На дне бутылке", "Марьина роща", "+79999379992", "пятница, 8-е марта 2024 г.", "пятеро суток", "черный жемчуг и серая безысходность", "Привет!"},
        };
    }

    @Test
    public void orderScooterTest() {
        ScooterHomePage scooterHomePage = new ScooterHomePage(driver);
        scooterHomePage.waitStartHomePage();
        scooterHomePage.confirmCookie();

        scooterHomePage.clickFirstOrderButton();
        ForWhomScooterPage forWhomScooterPage = new ForWhomScooterPage(driver);
        forWhomScooterPage.waitForWhomScooterPageLoading();
        forWhomScooterPage.isHeaderDisplayed();

        forWhomScooterPage.setFirstName(firstName);
        forWhomScooterPage.isFirstNameSetted(firstName);
        forWhomScooterPage.setLastName(lastName);
        forWhomScooterPage.isLastNameSetted(lastName);
        forWhomScooterPage.setAddress(address);
        forWhomScooterPage.isAddressSetted(address);
        forWhomScooterPage.setPhoneNumber(phoneNumber);
        forWhomScooterPage.isPhoneNumberSetted(phoneNumber);
        forWhomScooterPage.setMetroStation(metroStation);
        forWhomScooterPage.isMetroStationSetted(metroStation);

        forWhomScooterPage.clickNextButton();

        AboutRentPage aboutRentPage = new AboutRentPage(driver);
        aboutRentPage.waitAboutRentPage();
        aboutRentPage.selectRentalDate(dateForRent);
        aboutRentPage.setRentalPeriod(numberOfRentalDays);
        aboutRentPage.isSettedRentalPeriod(numberOfRentalDays);
        aboutRentPage.setAndCheckColourCheckBox(colorScooter);
        aboutRentPage.setComment(messageCourier);
        aboutRentPage.isCommentSetted(messageCourier);

        aboutRentPage.clickOrderButton();
        aboutRentPage.waitOrderModal();

        aboutRentPage.clickYesButton();
        aboutRentPage.waitOrderIsProcessedModal();
        assertTrue(aboutRentPage.isOrderCreated());
        assertTrue(aboutRentPage.isStatusButtonDisplayed());
    }
}