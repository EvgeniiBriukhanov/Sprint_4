package Constants;

import org.openqa.selenium.By;

public class AboutRent {
    public static final By ABOUT_RENT_HEADER = By.className("Order_Header__BZXOb");
    public static final By RENTAL_DATE_INPUT = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    public static final By RENTAL_PERIOD_DROPDOWN = By.className("Dropdown-placeholder");
    public static final By RENTAL_PERIOD_LIST = By.className("Dropdown-option");
    public static final By COLOR_SCOOTER = By.className("Order_Title__3EKne");
    public static final By COLOR_SCOOTER_BLACK_CHECKBOX = By.id("black");
    public static final By COLOR_SCOOTER_GREY_CHECKBOX = By.id("grey");
    public static final By COMMENT_FOR_THE_COURIER_INPUT = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    public static final By ORDER_BUTTON = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[text()='Заказать']");
    public static final By PLACE_AN_ORDER_HEADER = By.className("Order_ModalHeader__3FDaJ");
    public static final By YES_IN_MODAL_BUTTON = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[text()='Да']");
    public static final By ORDER_IS_PROCESSED_HEADER = By.className("Order_ModalHeader__3FDaJ");
    public static final By GET_STATUS_BUTTON = By.xpath(".//button[text()='Посмотреть статус']");
}
