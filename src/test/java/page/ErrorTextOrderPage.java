package page;

import core.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ErrorTextOrderPage extends Driver {
    //Кнопка "Заказать" в хедере сайта
    private By orderButtonHeader = By.xpath(".//button[contains(@class , 'Button_Button')]");
    //Кнопка "Далее" в первом шаге бронирования
    private By buttonNext = By.xpath("//div[contains(@class , 'Order_NextButton')]/button[text() = 'Далее']");
    //Подсказка об ошибке в поле "Имя" в первом шаге бронирования
    private By errorFirstName = By.xpath(".//div[text() = 'Введите корректное имя']");
    //Подсказка об ошибке в поле "Фамилия" в первом шаге бронирования
    private By errorLastName = By.xpath(".//div[text() = 'Введите корректную фамилию']");
    //Поле ввода "Адрес: куда привезти заказ в первом шаге бронирования
    private By addressForm = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    //Подсказка об ошибке в поле "Адрес: куда привезти заказ" в первом шаге бронирования
    private By errorAddress = By.xpath(".//div[text() = 'Введите корректный адрес']");
    //Подсказка об ошибке в поле "Станция метро" в первом шаге бронирования
    private By errorStationMetro = By.xpath(".//div[text() = 'Выберите станцию']");
    //Подсказка об ошибке в поле "Телефон: на него позвонит курьер" в первом шаге бронирования
    private By errorNumberPhone = By.xpath(".//div[text() = 'Введите корректный номер']");

    public void openFormOrder() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(orderButtonHeader));
        driver.findElement(orderButtonHeader).click();
        driver.findElement(buttonNext).click();
    }

    public String getErrorTextName() {
        return driver.findElement(errorFirstName).getText();
    }

    public String getErrorTextLastName() {
        return driver.findElement(errorLastName).getText();
    }

    public String getErrorAddress() {
        driver.findElement(addressForm).sendKeys("d");
        return driver.findElement(errorAddress).getText();
    }

    public String getErrorStationMetro() {
        return driver.findElement(errorStationMetro).getText();
    }

    public String getErrorPhoneNumber() {
        return driver.findElement(errorNumberPhone).getText();
    }
}

