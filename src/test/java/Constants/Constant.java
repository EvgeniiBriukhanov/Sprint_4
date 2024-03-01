package Constants;

import org.openqa.selenium.By;

public class Constant {
    public static final String URL_HOME_PAGE = "https://qa-scooter.praktikum-services.ru/";
    public static final By COOKIE_CONFIRM_BUTTON = By.id("rcc-confirm-button");
    public static final By FIRST_ORDER_BUTTON = By.xpath(".//div[@class = 'Header_Nav__AGCXC']/button[@class = 'Button_Button__ra12g']");
    public static final By SECOND_ORDER_BUTTON = By.xpath(".//div[@class = 'Home_FinishButton__1_cWm']/button[text()='Заказать']");
    public static final By QUESTIONS_ABOUT_IMPORTANT_HEADER = By.xpath(".//div[@class='Home_FourPart__1uthg']/div[@class='Home_SubHeader__zwi_E']");
    public static final By QUESTIONS_LIST = By.xpath(".//div[@data-accordion-component='AccordionItem']");

}
