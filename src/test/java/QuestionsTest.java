import Constants.Constant;
import Constants.ExpectedTexts;
import Pages.ScooterHomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class QuestionsTest {

    private WebDriver driver;

    @Before
    public void actionBefore() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get(Constant.URL_HOME_PAGE);
    }

    @After
    public void actionAfter() {
        driver.quit();
    }

    @Test
    public void TheImportantQuestionsTest() {
        ScooterHomePage scooterHomePage = new ScooterHomePage(driver);
        scooterHomePage.waitStartHomePage();
        scooterHomePage.confirmCookie();
        scooterHomePage.scrollAcrossThePage();

        scooterHomePage.openingTabsAndCheckingText(0, ExpectedTexts.TEXT_HEADING_0, ExpectedTexts.TEXT_PANEL_0);
        scooterHomePage.openingTabsAndCheckingText(1, ExpectedTexts.TEXT_HEADING_1, ExpectedTexts.TEXT_PANEL_1);
        scooterHomePage.openingTabsAndCheckingText(2, ExpectedTexts.TEXT_HEADING_2, ExpectedTexts.TEXT_PANEL_2);
        scooterHomePage.openingTabsAndCheckingText(3, ExpectedTexts.TEXT_HEADING_3, ExpectedTexts.TEXT_PANEL_3);
        scooterHomePage.openingTabsAndCheckingText(4, ExpectedTexts.TEXT_HEADING_4, ExpectedTexts.TEXT_PANEL_4);
        scooterHomePage.openingTabsAndCheckingText(5, ExpectedTexts.TEXT_HEADING_5, ExpectedTexts.TEXT_PANEL_5);
        scooterHomePage.openingTabsAndCheckingText(6, ExpectedTexts.TEXT_HEADING_6, ExpectedTexts.TEXT_PANEL_6);
        scooterHomePage.openingTabsAndCheckingText(7, ExpectedTexts.TEXT_HEADING_7, ExpectedTexts.TEXT_PANEL_7);
    }

}