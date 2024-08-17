package praktikum;

import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.pages.MainPage;
import praktikum.pages.OrderPageFirst;
import praktikum.pages.OrderPageSecond;

public class OrderScooterTest {
    @Rule
    public DriverRule factory = new DriverRule();

    @Test
    public void orderScooter() throws Exception {
        WebDriver driver = factory.getDriver();
        var mainPage = new MainPage(driver);
        var orderPageFirst = new OrderPageFirst(driver);
        var orderPageSecond = new OrderPageSecond(driver);
        mainPage.open();
        mainPage.headerOrderClick();
        orderPageFirst.addName();
        orderPageFirst.addSurname();
        orderPageFirst.addAddress();
        orderPageFirst.clickMetro();
        orderPageFirst.addPhoneNumber();
        orderPageFirst.clickNextButton();
        orderPageSecond.setDateToBring();
        orderPageSecond.setRentalPeriod();
        orderPageSecond.setSelectColor();
        orderPageSecond.addComment();
        orderPageSecond.clickFinalButton();
        orderPageSecond.confirmOrder();
        orderPageSecond.checkOrderModal();
    }
}
