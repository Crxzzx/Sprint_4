package core;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import page.OrderStep1Page;

public abstract class Annotation extends Driver {
    @Before
    public void settings() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox","--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru");
        OrderStep1Page closeCookie = new OrderStep1Page();
        closeCookie.clickOnButtonCookie();
    }

    @After
    public void quitBrowser() {
        driver.quit();
    }
}

