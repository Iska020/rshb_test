package ru.rshb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.rshb.utils.ConfProperties;

import java.time.Duration;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriverPath"));
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 5 сек
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        BasePage.setDriver(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}