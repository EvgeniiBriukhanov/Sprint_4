import Constants.Constant;
import Constants.ExpectedTexts;
import Pages.AboutRentPage;
import Pages.ScooterHomePage;
import Pages.ForWhomScooterPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static Constants.AboutRent.*;
import static Constants.Constant.*;
import static Constants.ForWhomScooter.*;
import static org.junit.Assert.*;

//checking the text in the important questions section
//Выпадающий список в разделе «Вопросы о важном». Тебе нужно проверить: когда нажимаешь на стрелочку, открывается соответствующий текст.
@RunWith(Parameterized.class)
public class TestScripts {

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


    public TestScripts(String firstName, String lostName, String address, String metroStation, String phoneNumber, String dateForRent, String numberOfRentalDays, String colorScooter, String messageCourier) {
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

    @Before
    public void actionBefore() {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get(Constant.URL_HOME_PAGE);
    }

    @After
    public void actionAfter() {
        driver.quit();
    }

    @Test
    public void checkingTheTextInTheImportantQuestionsSection() {
        ScooterHomePage scooterHomePage = new ScooterHomePage(driver);
        scooterHomePage.waitStartHomePage();
        scooterHomePage.confirmCookie();
        scooterHomePage.scrollAcrossThePage(QUESTIONS_ABOUT_IMPORTANT_HEADER);

        scooterHomePage.openingTabsAndCheckingText(0, ExpectedTexts.TEXT_HEADING_0, ExpectedTexts.TEXT_PANEL_0, QUESTIONS_LIST);
        scooterHomePage.openingTabsAndCheckingText(1, ExpectedTexts.TEXT_HEADING_1, ExpectedTexts.TEXT_PANEL_1, QUESTIONS_LIST);
        scooterHomePage.openingTabsAndCheckingText(2, ExpectedTexts.TEXT_HEADING_2, ExpectedTexts.TEXT_PANEL_2, QUESTIONS_LIST);
        scooterHomePage.openingTabsAndCheckingText(3, ExpectedTexts.TEXT_HEADING_3, ExpectedTexts.TEXT_PANEL_3, QUESTIONS_LIST);
        scooterHomePage.openingTabsAndCheckingText(4, ExpectedTexts.TEXT_HEADING_4, ExpectedTexts.TEXT_PANEL_4, QUESTIONS_LIST);
        scooterHomePage.openingTabsAndCheckingText(5, ExpectedTexts.TEXT_HEADING_5, ExpectedTexts.TEXT_PANEL_5, QUESTIONS_LIST);
        scooterHomePage.openingTabsAndCheckingText(6, ExpectedTexts.TEXT_HEADING_6, ExpectedTexts.TEXT_PANEL_6, QUESTIONS_LIST);
        scooterHomePage.openingTabsAndCheckingText(7, ExpectedTexts.TEXT_HEADING_7, ExpectedTexts.TEXT_PANEL_7, QUESTIONS_LIST);
    }

    @Parameterized.Parameters
    public static Object[][] getUserData() {
        return new Object[][]{
                 {"Иван", "Морозов", "Третья плита слева от стены", "Воробьёвы горы", "+79992042000", "понедельник, 26-е февраля 2024 г.", "двое суток", "чёрный жемчуг", "Тест-Тестович"},
                {"Петро", "Непьющий", "На дне бутылке", "Марьина роща", "+79999379992", "пятница, 8-е марта 2024 г.", "пятеро суток", "черный жемчуг и серая безысходность", "Привет!"},
        };
    }


    @Test
    public void checkingOrderButtonAndOrderScooter() {
        ScooterHomePage scooterHomePage = new ScooterHomePage(driver);
        scooterHomePage.waitStartHomePage();
        scooterHomePage.confirmCookie();

        scooterHomePage.checkingOrderButtons(FIRST_ORDER_BUTTON, SECOND_ORDER_BUTTON, URL_HOME_PAGE, WHO_IS_THE_SCOOTER_FOR_HEADER);

        ForWhomScooterPage forWhomScooterPage = new ForWhomScooterPage(driver);
        forWhomScooterPage.setText(firstName, FIRST_NAME_INPUT);
        forWhomScooterPage.setText(lastName, LAST_NAME_INPUT);
        forWhomScooterPage.setText(address, ADDRESS_INPUT);
        forWhomScooterPage.setText(phoneNumber, PHONE_NUMBER_INPUT);
        forWhomScooterPage.setMetroStation(metroStation, NAME_METRO_INPUT, LIST_METRO_STATION);
        assertEquals(firstName, driver.findElement(FIRST_NAME_INPUT).getAttribute("value"));
        assertEquals(lastName, driver.findElement(LAST_NAME_INPUT).getAttribute("value"));
        assertEquals(address, driver.findElement(ADDRESS_INPUT).getAttribute("value"));
        assertEquals(phoneNumber, driver.findElement(PHONE_NUMBER_INPUT).getAttribute("value"));
        assertEquals(metroStation, driver.findElement(NAME_METRO_INPUT).getAttribute("value"));

        forWhomScooterPage.clickButton(NEXT_BUTTON);

        forWhomScooterPage.waitLoadingPage(ABOUT_RENT_HEADER);
        AboutRentPage aboutRentPage = new AboutRentPage(driver);
        aboutRentPage.selectRentalDate(RENTAL_DATE_INPUT, dateForRent);
        assertNotNull(driver.findElement(RENTAL_DATE_INPUT).getAttribute("value"));

        aboutRentPage.setRentalPeriod(numberOfRentalDays, RENTAL_PERIOD_DROPDOWN, RENTAL_PERIOD_LIST);
        assertEquals(numberOfRentalDays, driver.findElement(RENTAL_PERIOD_DROPDOWN).getText());

        aboutRentPage.setAndCheckColourCheckBox(colorScooter, COLOR_SCOOTER);

        aboutRentPage.setText(messageCourier, COMMENT_FOR_THE_COURIER_INPUT);
        assertEquals(messageCourier, driver.findElement(COMMENT_FOR_THE_COURIER_INPUT).getAttribute("value"));

        aboutRentPage.clickButton(ORDER_BUTTON);
        aboutRentPage.waitLoadingPage(PLACE_AN_ORDER_HEADER);

        aboutRentPage.clickButton(YES_IN_MODAL_BUTTON);
        aboutRentPage.waitLoadingPage(ORDER_IS_PROCESSED_HEADER);
        assertEquals("Заказ оформлен", driver.findElement(ORDER_IS_PROCESSED_HEADER).getText());
        assertTrue(driver.findElement(GET_STATUS_BUTTON).isDisplayed());
    }
}