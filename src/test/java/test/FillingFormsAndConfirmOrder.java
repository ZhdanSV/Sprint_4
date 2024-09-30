package test;

import PageObject.HomePage;
import PageObject.OrderPageAboutRent;
import PageObject.OrderPageConfirmation;
import PageObject.OrderPageForWho;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Parameterized.class)
public class FillingFormsAndConfirmOrder {
    private WebDriver driver;
    private final String name;
    private final String surname;
    private final String address;
    private final int metroStation;
    private final String phoneNumber;
    private final String deliveryDate;
    private final int rentalPeriodDropDownOptions;
    private final String color;
    private final String commentField;
    private final String expectedText = "Заказ оформлен";

    public FillingFormsAndConfirmOrder(String name,
                                       String surname,
                                       String address,
                                       int metroStation,
                                       String phoneNumber,
                                       String deliveryDate,
                                       int rentalPeriodDropDownOptions,
                                       String color,
                                       String commentField) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.deliveryDate = deliveryDate;
        this.rentalPeriodDropDownOptions = rentalPeriodDropDownOptions;
        this.color = color;
        this.commentField = commentField;
    }

    @Parameterized.Parameters
    public static Object[][] personalInfoData() {
        return new Object[][] {
                {"Сергей", "Сергеев", "Энергетиков 18", 1, "89466541122", "Choose четверг, 19-е сентября 2024 г.", 2, "black", "смит вампир"},
                {"Брэд", "Пит", "Тверская 10", 5, "+79995554422", "Choose суббота, 28-е сентября 2024 г.", 6, "grey", "не звонить"}
        };
    }



    @Test
    public void fillingFormAndClickNext() {
//        driver = new FirefoxDriver();
        driver = new ChromeDriver();
        // Открыли главную страницу
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage objHomePage = new HomePage(driver);
        // Кликнули по кнопке заказать
        objHomePage.clickUpOrderButton();
        OrderPageForWho objOrderPageForWho = new OrderPageForWho(driver);
        objOrderPageForWho.waitLoadingPage();
        //заполнили форму
        objOrderPageForWho.fillingPersonalInfo(name, surname, address, metroStation, phoneNumber);
        objOrderPageForWho.clickNextButton();
        OrderPageAboutRent objAboutRent = new OrderPageAboutRent(driver);
        objAboutRent.waitLoadingPage();
        // проверили что переход выполнен
        Assert.assertTrue("не открывается форма с информацией об аренде", objAboutRent.isLoadPage());
        //заполнили поля
        objAboutRent.fillingAboutRentPage(deliveryDate, rentalPeriodDropDownOptions, color, commentField);
        //клик по кнопке заказать
        objAboutRent.clickOrderButtonAtRentPage();
        //проверили что переход выполнен
        OrderPageConfirmation objOrderPageConfirmation = new OrderPageConfirmation(driver);
        objOrderPageConfirmation.waitLoadingPage();
        Assert.assertTrue("не открывается поп-ап с подтверждением", objOrderPageConfirmation.isLoadPage());
        objOrderPageConfirmation.clickYesButton();
        //проверили открылось ли окно Заказ оформлен
        String actualText = objOrderPageConfirmation.getActualText();
        Assert.assertEquals("не открылось окно Заказ оформлен", expectedText, actualText );
    }


    @After
    public void tearDown() {
        driver.quit();
    }

}
