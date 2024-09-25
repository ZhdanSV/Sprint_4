package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;
import java.util.List;


public class HomePage {

    private final WebDriver driver;

    // Верхняя кнопка "заказать"
    private final By upOrderButton = By.xpath(".//button[@class='Button_Button__ra12g']");
    // Нижняя кнопка "Заказать"
    private final By downOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // Список вопросов о важном
    private final By accordingListQuestion = By.className("accordion__button");
    // Список ответов на вопросы о важном
    private final By accordingListResponse = By.xpath(".//div[@class='accordion__panel']/p");

    //конструктор класса
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getQuetionList() {
        return driver.findElements(accordingListQuestion);
    }

    //клик по верхней кнопке "заказать"
    public void clickUpOrderButton() {
        driver.findElement(upOrderButton).click();
    }

    //клик по нижней кнопке "заказать"
    public void clickDownOrderButton() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(downOrderButton));
        driver.findElement(downOrderButton).click();
    }

    //клик по пункту с вопросом
    public void clickQuestionInAccordingList(int questionNum) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(accordingListQuestion));
        List<WebElement> element = getQuetionList();
        element.get(questionNum-1).click();
    }

    //получение текста из пункта списка ответов
    public String getTextOfResponseListOption(int responseNum) {
        List<WebElement> textElements = driver.findElements(accordingListResponse);
        return textElements.get(responseNum-1).getText();
    }

    public void waitLoadingPage() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(driver.findElement(upOrderButton)));
    }
}
