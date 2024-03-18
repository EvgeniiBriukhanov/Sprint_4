import Constants.Constant;
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

import static Constants.ExpectedTexts.*;

@RunWith(Parameterized.class)
public class QuestionsTest {

    private WebDriver driver;

    private final int numberQuestion;
    private final String textHeading;
    private final String textPanel;

    public QuestionsTest(int numberQuestion, String textHeading, String textPanel) {
        this.numberQuestion = numberQuestion;
        this.textHeading = textHeading;
        this.textPanel = textPanel;
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
                {0, TEXT_HEADING_0, TEXT_PANEL_0},
                {1, TEXT_HEADING_1, TEXT_PANEL_1},
                {2, TEXT_HEADING_2, TEXT_PANEL_2},
                {3, TEXT_HEADING_3, TEXT_PANEL_3},
                {4, TEXT_HEADING_4, TEXT_PANEL_4},
                {5, TEXT_HEADING_5, TEXT_PANEL_5},
                {6, TEXT_HEADING_6, TEXT_PANEL_6},
                {7, TEXT_HEADING_7, TEXT_PANEL_7},
        };
    }

    @Test
    public void TheImportantQuestionsTest() {
        ScooterHomePage scooterHomePage = new ScooterHomePage(driver);
        scooterHomePage.waitStartHomePage();
        scooterHomePage.confirmCookie();
        scooterHomePage.scrollAcrossThePage();

        scooterHomePage.checkingHeadingText(numberQuestion, textHeading);
        scooterHomePage.checkingPanelText(numberQuestion, textPanel);
    }

}