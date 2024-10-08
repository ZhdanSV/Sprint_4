package test;

import PageObject.HomePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


@RunWith(Parameterized.class)
public class QuestionListTest {

    private WebDriver driver;
    private final int number;
    private final String expectedText;

    public QuestionListTest(int number, String expectedText) {
        this.number = number;
        this.expectedText = expectedText;
    }

    @Parameterized.Parameters
    public static Object[][] getTextData() {
        return new Object[][] {
                {1, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {2, "Пока что у нас так: один заказ — один самокат. Если хотите" +
                        " покататься с друзьями, можете просто сделать несколько" +
                        " заказов — один за другим."},
                {3, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая " +
                        "в течение дня. Отсчёт времени аренды начинается с момента," +
                        " когда вы оплатите заказ курьеру. Если мы привезли самокат " +
                        "8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {4, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {5, "Пока что нет! Но если что-то срочное — всегда можно позвонить" +
                        " в поддержку по красивому номеру 1010."},
                {6, "Самокат приезжает к вам с полной зарядкой. Этого хватает на " +
                        "восемь суток — даже если будете кататься без передышек и во сне." +
                        " Зарядка не понадобится."},
                {7, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки " +
                        "тоже не попросим. Все же свои."},
                {8, "Да, обязательно. Всем самокатов! И Москве, и Московской области."}

        };
    }


    @Test //проверяем текст под нажатым вопросом
    public void checkResponseText() {
//        driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage objHomePage = new HomePage(driver);
        objHomePage.waitLoadingPage();
        objHomePage.clickQuestionInAccordingList(number);
        String actualText = objHomePage.getTextOfResponseListOption(number);
        Assert.assertEquals(actualText + " Не совпадает текст в "+number+" пункте", expectedText, actualText);
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
