package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPageConfirmation {
    private WebDriver driver;

    // кнопка "да"
    private final By yesButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");

    //заголовок
    private final By header = By.className("Order_ModalHeader__3FDaJ");

    //конструктор класса
    public OrderPageConfirmation(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLoadPage() {
        return driver.findElement(header).isDisplayed();
    }

    public void waitLoadingPage() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(driver.findElement(header)));
    }

    public String getActualText() {
        return driver.findElement(header).getText();
    }

    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }
}
