package ru.company.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class SearchProductTests {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.navigate().to("http://automationpractice.com");
        // развёртывание окна до максимальной ширины экрана
        driver.manage().window().maximize();
        // ожидание открытия окна
        //  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // WebDriverWait wait = new WebDriverWait(driver, 30);
    }

    @Test
    public void searchProductTest(){
        // найти поле ввода для поиска
        // нажать поисковое поле
        driver.findElement(By.cssSelector("#search_query_top")).click();
        // ввести данные для поиска
        driver.findElement(By.id("search_query_top")).sendKeys("summer dresses" + Keys.ENTER);
        // найти элемент интерфейса подтверждающий открытие страницы каталога
        String text = driver.findElement(By.className("lighter")).getText();
        Assert.assertEquals(text.toLowerCase(Locale.ROOT), "\"summer dresses\"");
    }

    @Test
    public void searchInContainerMenuTest(){
        //перейти на первый элемент из списка меню "menu content"

        WebElement ul = driver.findElement(By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']"));
        ul.findElement(By.xpath(".//a[@title=\"Women\"]")).click();

        WebElement el = driver.findElement(By.xpath("//ul[@class=\"tree dynamized\"]"));
        el.findElement(By.xpath(".//*[contains(text(),'Tops')]")).click();
    }


    @AfterMethod(enabled = false)
    public void tearDown(){
        driver.quit();
        // driver.close();
    }
}



