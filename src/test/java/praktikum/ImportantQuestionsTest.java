package praktikum;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.pages.MainPage;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static praktikum.EnvConfig.EXPLICIT_WAIT;

@RunWith(Parameterized.class)

public class ImportantQuestionsTest {

    // Переменные для ID кнопок
    private static final String BUTTON_ID_1 = "accordion__heading-0";
    private static final String BUTTON_ID_2 = "accordion__heading-1";
    private static final String BUTTON_ID_3 = "accordion__heading-2";
    private static final String BUTTON_ID_4 = "accordion__heading-3";
    private static final String BUTTON_ID_5 = "accordion__heading-4";
    private static final String BUTTON_ID_6 = "accordion__heading-5";
    private static final String BUTTON_ID_7 = "accordion__heading-6";
    private static final String BUTTON_ID_8 = "accordion__heading-7";


    // Переменные для ID текстов
    private static final String ANSWER_TEXT_1 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private static final String ANSWER_TEXT_2 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    private static final String ANSWER_TEXT_3 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    private static final String ANSWER_TEXT_4 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    private static final String ANSWER_TEXT_5 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    private static final String ANSWER_TEXT_6 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    private static final String ANSWER_TEXT_7 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    private static final String ANSWER_TEXT_8 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";


    @Parameterized.Parameter(0)
    public String buttonId;

    @Parameterized.Parameter(1)
    public String expectedAnswerText;

    @ClassRule
    public static DriverRule driverRule = new DriverRule();

    @Parameterized.Parameters(name = "{index}: Проверка кнопки с ID {0} текста {1}")
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {BUTTON_ID_1, ANSWER_TEXT_1},
                {BUTTON_ID_2, ANSWER_TEXT_2},
                {BUTTON_ID_3, ANSWER_TEXT_3},
                {BUTTON_ID_4, ANSWER_TEXT_4},
                {BUTTON_ID_5, ANSWER_TEXT_5},
                {BUTTON_ID_6, ANSWER_TEXT_6},
                {BUTTON_ID_7, ANSWER_TEXT_7},
                {BUTTON_ID_8, ANSWER_TEXT_8},
        });
    }


    @Test
    public void questionsAbout() throws Exception {
        WebDriver driver = driverRule.getDriver();
        var mainMage = new MainPage(driver);
        mainMage.open();
        // Создание локаторов для кнопки и текста
        By questionButton = By.id(buttonId);
        By answerText = By.id(buttonId.replace("heading", "panel")); // заменяем `heading` на `panel` для текста
        // Скроллим страницу до нужного элемента
        mainMage.scrollForElement(questionButton);
        // Нажимаем на нужный элемент
        mainMage.clickOnQuestion(questionButton);
        // Добавили явное ожидание
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOfElementLocated(answerText));
        // Сравниваем текст ответа на часто задаваемые вопросы с ожидаемым результатом
        String actualText = driver.findElement(answerText).getText();
        assertEquals("Текст ответа не совпадает для кнопки с ID " + buttonId, expectedAnswerText, actualText);

    }
}
