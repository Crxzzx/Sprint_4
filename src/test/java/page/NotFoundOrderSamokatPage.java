package page;

import core.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotFoundOrderSamokatPage extends Driver {
    //Заголовок на главной странице
    private By headerService = By.xpath(".//div[contains(@class , 'Header_Header')]");
    //Кнопка "Статус заказа" на главной странице
    private By buttonStatus = By.xpath(".//button[contains(@class , 'Header_Link') and (text() = 'Статус заказа')]");
    //Поле ввода "Введите номер заказа" на глвной странице
    private By inputNumberOrder = By.xpath(".//input[@placeholder = 'Введите номер заказа']");
    //Кнопка "Go!" после нажатия на кнопку "Статус заказа" на главной странице
    private By buttonGo = By.xpath(".//button[contains(@class , 'Button_Button') and (text() = 'Go!')]");
    //Статус заказа ,на странице статуса заказа
    private By notFoundOrderStatus = By.xpath(".//img[@alt = 'Not found']");

    public void clickButtonStatus() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(headerService));
        driver.findElement(buttonStatus).click();
    }

    public void setInputNumberOrder() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(inputNumberOrder));
        driver.findElement(inputNumberOrder).sendKeys("3123123");
    }

    public void clickButtonGo() {
        driver.findElement(buttonGo).click();
    }

    public boolean getStatusOrder() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(headerService));
        return driver.findElement(notFoundOrderStatus).isDisplayed();
    }

    public boolean statusOrderSamokat() {
        clickButtonStatus();
        setInputNumberOrder();
        clickButtonGo();
        return getStatusOrder();
    }
}
