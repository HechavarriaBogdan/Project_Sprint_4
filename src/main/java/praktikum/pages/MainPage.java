package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.EnvConfig;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class MainPage {
    private final WebDriver driver;

    // Локатор кнопки "Go" в хедере
    private final By goButton = By.cssSelector(".Header_Button__28dPO");
    // Локатор инпута "Введите номер заказа"
    private final By orderField = By.className("Input_Input__1iN_Z");
    // Локатор кнопки "Статус заказа"
    private final By statusButton = By.className("Header_Link__1TAG7");



    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод открывает Web страницу
    public void open() {
        driver.get(EnvConfig.BASE_URL);
    }
    // Метод нажимает на кнопку "GO" в хедере
    public StatusPage clickOnGo() {
        driver.findElement(goButton).click();

        return new StatusPage(driver);
    }
    // Метод вводит невалидный номер заказа в инпут "Введите номер заказа"
    public void enterOrderId(String orderNumber) {
        driver.findElement(orderField).sendKeys(orderNumber);
    }
    // Метод нажимает на кнопку "Статус заказа"
    public void clickOnStatus() {
        driver.findElement(statusButton).click();
    }

    // Метод скроллит экран до нужного локатора
    public void scrollForElement (By locator) {
        WebElement scrollElement = driver.findElement(locator);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", scrollElement);
    }

    // Метод кликает на стрелку с часто задаваемым вопросом
    public void clickOnQuestion(By locator) {
        driver.findElement(locator).click();
    }


}
