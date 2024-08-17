package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;

public class OrderPageSecond {
    private final WebDriver driver;

    public OrderPageSecond(WebDriver driver) {
        this.driver = driver;
    }

    // Локатор для инпута "Когда привезти самокат"
    private final By inputDateToBring = By.cssSelector("[placeholder='* Когда привезти самокат']");
    // Шаблон локатора для выбора даты в календаре
    private final String datepickerDay = "react-datepicker__day--0";
    // Локатор для инпута выбора срока аренды
    private final By inputRentalPeriod = By.className("Dropdown-root");
    // Локатор для выбора срока аренды из дропдауна
    private final By dropdownOption = By.xpath("//*[@class='Dropdown-menu']//*[text()='сутки']");
    // Локатор для выбора цвета самоката
    private final By selectColor = By.id("black");
    // Локатор для инпута с комментарием
    private final By inputComment = By.cssSelector("[placeholder='Комментарий для курьера']");
    // Локатор для кнопки "Заказать"
    private final By orderFinalButton = By.xpath("//*[@class='Order_Buttons__1xGrp']//*[text()='Заказать']");
    // Локатор для кнопки "Да", которая подтверждает оформление заказа
    private final By confirmOrder = By.xpath("//*[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");

    // Метод устанавливает дату в инпуте "Когда привести самокат"
    public void setDateToBring () {
        WebElement inputElement = driver.findElement(inputDateToBring);
        inputElement.click();
        LocalDate today = LocalDate.now();
        int dayOfMonth = today.getDayOfMonth();
        String day = String.format("%02d", dayOfMonth);
        driver.findElement(By.className(datepickerDay + day)).click();
        System.out.println("Date = " + day);
    }

    // Метод устанавливает срок аренды
    public void setRentalPeriod () {
        driver.findElement(inputRentalPeriod).click();
        driver.findElement(dropdownOption).click();
    }
    // Метод выбирает цвет самоката
    public void setSelectColor () {
        driver.findElement(selectColor).click();
    }

    // Метод заполняет поле ввода комментария
    public void addComment () {
        WebElement inputElement = driver.findElement(inputComment);
        inputElement.click();
        inputElement.clear();
        String comment = "Тестовый комментарий";
        inputElement.sendKeys(comment);
    }
    // Метод нажимает на кнопку "Заказать"
    public void clickFinalButton () {
        driver.findElement(orderFinalButton).click();
    }
    // Метод подтверждает оформление заказа
    public void confirmOrder() {
        driver.findElement(confirmOrder).click();
    }
}
