package test;

import PageObject.HomePage;
import PageObject.OrderPageForWho;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickOrderButtons {

    private WebDriver driver;

    @Test
    public void clickUpOrderButton() {
//        driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage objHomePage = new HomePage(driver);
        objHomePage.waitLoadingPage();
        objHomePage.clickUpOrderButton();
        OrderPageForWho objOrderPageForWho = new OrderPageForWho(driver);
        boolean isLoadPage = objOrderPageForWho.isLoadPage();
        Assert.assertTrue("не открывается форма заказа по нажатию верхней кнопки", isLoadPage);
    }

    @Test
    public void clickDownOrderButton() {
//        driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage objHomePage = new HomePage(driver);
        objHomePage.waitLoadingPage();
        OrderPageForWho objOrderPageForWho = new OrderPageForWho(driver);
        boolean isLoadPage = objOrderPageForWho.isLoadPage();
        Assert.assertTrue("не открывается форма заказа по нажатию нижней кнопки", isLoadPage);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
