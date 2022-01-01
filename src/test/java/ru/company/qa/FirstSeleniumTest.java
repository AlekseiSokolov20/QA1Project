package ru.company.qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {
    WebDriver driver;
    //before - подготовка к тесту setUp

    @BeforeMethod
    public void setUp(){
        // System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver.exe");
        // инициализация драйвера браузера Chrome
        driver = new ChromeDriver();
        // driver = new FirefoxDriver();
        // открытие страницы
        driver.get("https://www.google.com/");
    }

    //test
    @Test
    public void openGoogleTest(){
        System.out.println("site opened!!!");
    }

    //after - tearDown
    @AfterMethod
    public void tearDown(){
        // закрытие браузера
        driver.quit();
    }
}



