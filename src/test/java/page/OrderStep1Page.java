package page;

import core.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderStep1Page extends Driver {
    //Кнопка "Заказать" в заголовке сайта
    private By orderHeader = By.xpath(".//button[contains(@class , 'Button_Button')]");
    //Блок "Road map" в футере сайта
    private By blockFooter = By.xpath(".//div[contains(@class , 'Home_ThirdPart')]");
    //Кнопка "Заказать" в футере сайта
    private By buttonFooter = By.xpath(".//div[contains(@class , 'Home_FinishButton')]/button[text() = 'Заказать']");
    //Поле ввода "Имя" пользователя в первом шаге бронирования
    private By inputNameForm = By.xpath(".//input[@placeholder = '* Имя']");
    //Поле ввода "Фамилия" пользователя в первом шаге бронирования
    private By inputLastNameForm = By.xpath(".//input[@placeholder = '* Фамилия']");
    //Поле ввода "Адрес:куда доставить" в первом шаге бронирования
    private By inputAddressForm = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    //Поле "Станция метро" в первом шаге бронирования
    private By inputStationForm = By.xpath(".//input[@placeholder = '* Станция метро']");
    //Выпадающий список станций метро в первом шаге бронирования
    private By listStationMetro = By.className("select-search__row");
    //Поле ввода "Телефон:на него позвонить курьер" в первом шаге бронирования
    private By inputNumberPhoneForm = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    //Кнопка "Далее" в первом шаге бронирования
    private By buttonNextForm = By.xpath(".//div[contains(@class , 'Order_NextButton')]/button[text() = 'Далее']");
    //Элемент шапки сайта на главной странице
    private By headerPage = By.xpath(".//div[contains(@class , 'Header_Header')]");
    private By cookie = By.xpath(".//button[contains(@class , 'App_Cookie') and (text() = 'да все привыкли')]");

    public void clickButtonOrder(int button) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(headerPage));
        if (button == 1) {
            driver.findElement(orderHeader).click();
        } else {
            new WebDriverWait(driver, 3)
                    .until(ExpectedConditions.visibilityOfElementLocated(blockFooter));
            WebElement element = driver.findElement(buttonFooter);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            driver.findElement(buttonFooter).click();
        }
    }

    public void setInputNameForm(String name) {
        driver.findElement(inputNameForm).sendKeys(name);
    }

    public void setInputLastNameForm(String lastName) {
        driver.findElement(inputLastNameForm).sendKeys(lastName);
    }

    public void setInputAddressForm(String address) {
        driver.findElement(inputAddressForm).sendKeys(address);
    }

    public void setInputStationForm(int station) {
        driver.findElement(inputStationForm).click();
        WebElement stationMetro1 = driver.findElements(listStationMetro).get(station);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(listStationMetro));
        stationMetro1.click();
    }

    public void setInputNumberPhoneForm(String number) {
        driver.findElement(inputNumberPhoneForm).sendKeys(number);
        driver.findElement(buttonNextForm).click();
    }

    public void createOrderSamokatStep1(int button, String name, String lastName, String adress, int station, String number) {
        clickButtonOrder(button);
        setInputNameForm(name);
        setInputLastNameForm(lastName);
        setInputAddressForm(adress);
        setInputStationForm(station);
        setInputNumberPhoneForm(number);
    }

    public void clickOnButtonCookie() {
        driver.findElement(cookie).click();
    }
}
