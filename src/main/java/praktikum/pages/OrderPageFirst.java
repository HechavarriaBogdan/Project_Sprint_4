package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPageFirst {
    private final WebDriver driver;

    public OrderPageFirst(WebDriver driver) {
        this.driver = driver;
    }

    // Локатор для инпута "Имя"
    private final By inputName = By.cssSelector("[placeholder='* Имя']");
    // Локатор для инпута "Фамилия"
    private final By inputSurname = By.cssSelector("[placeholder='* Фамилия']");
    // Локатор для инпута "Адрес"
    private final By inputAddress = By.cssSelector("[placeholder='* Адрес: куда привезти заказ']");
    // Локатор для инпута "Станция метро"
    private final By inputMetro = By.className("select-search__input");
    // Локатор для инпута с выбором Станции метро
    private final By metroStation = By.cssSelector("[data-index='1']");
    // Локатор инпута ввода номера телефона
    private final By inputPhoneNumber = By.cssSelector("[placeholder='* Телефон: на него позвонит курьер']");
    // Локатор для кнопки "Далее"
    private final By nextButton = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");

    // Метод нажимает на поле ввода имени, зачищает его и вводит Имя
    public void addName() {
        WebElement inputElement = driver.findElement(inputName);
        inputElement.click();
        inputElement.clear();
        String name = "Джон";
        inputElement.sendKeys(name);
    }

    // Метод нажимает на поле ввода фамилии, зачищает его и вводит Фамилию
    public void addSurname() {
        WebElement inputElement = driver.findElement(inputSurname);
        inputElement.click();
        inputElement.clear();
        String surname = "Доу";
        inputElement.sendKeys(surname);
    }

    // Метод нажимает на поле ввода адреса, зачищает его и вводит Адрес
    public void addAddress() {
        WebElement inputElement = driver.findElement(inputAddress);
        inputElement.click();
        inputElement.clear();
        String address = "г.Москва, ул.Ленина 50";
        inputElement.sendKeys(address);
    }

    // Метод нажимает на поле ввода "Станция метро" и выбирает станцию
    public void clickMetro() {
        driver.findElement(inputMetro).click();
        driver.findElement(metroStation).click();
    }

    // Метод заполняет поле ввода номера телефона
    public void addPhoneNumber() {
        WebElement inputElement = driver.findElement(inputPhoneNumber);
        inputElement.click();
        inputElement.clear();
        String phoneNumber = "+79028574588";
        inputElement.sendKeys(phoneNumber);
    }

    // Метод нажимает на кнопку "Далее"
    public void clickNextButton () {
        driver.findElement(nextButton).click();
    }

}
