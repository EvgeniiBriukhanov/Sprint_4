package Constants;

import org.openqa.selenium.By;

public class ForWhomScooter {

    public static final By WHO_IS_THE_SCOOTER_FOR_HEADER = By.className("Order_Header__BZXOb");
    public static final By FIRST_NAME_INPUT = By.xpath("//input[@placeholder='* Имя']");
    public static final By LAST_NAME_INPUT = By.xpath(".//input[@placeholder='* Фамилия']");
    public static final By ADDRESS_INPUT = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    public static final By NAME_METRO_INPUT = By.xpath(".//input[@placeholder='* Станция метро']");
    public static final By PHONE_NUMBER_INPUT = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    public static final By LIST_METRO_STATION = By.xpath("//*[@class='select-search__select']");
    public static final By NEXT_BUTTON = By.xpath(".//button[text()='Далее']");

}
