package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class OrderPageForWho {

    private final WebDriver driver;

    //поля ввода
    private final By nameField = By.xpath(".//input[@placeholder='* Имя']");
    private final By surnameField = By.xpath(".//input[@wfd-id='id2']");
    private final By addressField = By.xpath(".//input[@wfd-id='id3']");
    private final By metroStationField = By.xpath(".//input[@wfd-id='id4']");
    private final By metroStationOptions = By.xpath(".//div[@class='select-search__select']");
    private final By phoneNumberField = By.xpath(".//input[@wfd-id='id5']");

    // кнопка "далее"
    private final By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //конструктор класса
    public OrderPageForWho(WebDriver driver) {
        this.driver = driver;
    }

    //ввод Имени
    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    //ввод фамилии
    public void enterSurname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    //ввод адреса
    public void enterAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    //ввод станции метро
    public void enterMetroStation(int metro) {
        driver.findElement(metroStationField).click();
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOf(driver.findElement(metroStationOptions)));
        driver.findElement(By.xpath(".//button[@class='Order_SelectOption__82bhS select-search__option' " +
                "and @value='"+metro+"']")).click();

    }

    //ввод номера телефона
    public void enterPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    //нажатие кнопки далее
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public void waitLoadingPage() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(driver.findElement(nextButton)));
    }

    public void fillingPersonalInfo(String name,
                                    String surname,
                                    String address,
                                    int metro,
                                    String phoneNumber) {
        enterName(name);
        enterSurname(surname);
        enterAddress(address);
        enterMetroStation(metro);
        enterPhoneNumber(phoneNumber);
    }
}
