package test;

import PageObject.HomePage;
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
        boolean isLoadPage = driver.findElement(By.className("Order_Header__BZXOb")).isDisplayed();
        Assert.assertTrue("не открывается форма заказа по нажатию верхней кнопки", isLoadPage);
        driver.quit();
    }

    @Test
    public void clickDownOrderButton() {
//        driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage objHomePage = new HomePage(driver);
        objHomePage.waitLoadingPage();
        objHomePage.clickDownOrderButton();
        boolean isLoadPage = driver.findElement(By.className("Order_Header__BZXOb")).isDisplayed();
        Assert.assertTrue("не открывается форма заказа по нажатию нижней кнопки", isLoadPage);
        driver.quit();
    }

}
