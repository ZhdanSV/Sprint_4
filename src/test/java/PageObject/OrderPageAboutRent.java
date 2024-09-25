package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OrderPageAboutRent {
    private final WebDriver driver;

    //поля ввода
    private final By deliveryDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By rentalPeriodDropDown = By.className("Dropdown-placeholder");
    private final By rentalPeriodDropDownOptions = By.className("Dropdown-option");
    private final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    //кнопка "заказать"
    private final By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //кнопка "назад"
    private final By backButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i']");


    //конструктор класса
    public OrderPageAboutRent(WebDriver driver) {
        this.driver = driver;
    }
    //ввод даты доставки
    public void enterDeliveryDate(String date) {
        driver.findElement(deliveryDate).click();
        driver.findElement(By.xpath(".//div[@aria-label='"+date+"']")).click();
    }
    //ввод срока аренды
    public void enterRentalPeriod(int days) {
        driver.findElement(rentalPeriodDropDown).click();
        List<WebElement> element = driver.findElements(rentalPeriodDropDownOptions);
        element.get(days-1).click();
    }
    //ввод цвета
    public void enterColor(String color) {
        driver.findElement(By.id(color)).click();
    }
    //ввод комментария
    public void enterComment(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }
    //нажатие кнопки "заказать"
    public void clickOrderButtonAtRentPage() {
        driver.findElement(orderButton).click();
    }

    public void fillingAboutRentPage(String date,
                                     int days,
                                     String color,
                                     String comment) {
        enterDeliveryDate(date);
        enterRentalPeriod(days);
        enterColor(color);
        enterComment(comment);

    }

    public void waitLoadingPage() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(driver.findElement(orderButton)));
    }


}
