package test;

import core.Annotation;
import org.junit.Test;
import page.ErrorTextOrderPage;

import static org.junit.Assert.assertEquals;


public class NegativeOrderSamokatTest extends Annotation {
    @Test
    public void comparisonErrorTextFirstName() {
        ErrorTextOrderPage errorName = new ErrorTextOrderPage();
        errorName.openFormOrder();
        assertEquals("Некорректная подсказка об ошибке", "Введите корректное имя", errorName.getErrorTextName());
    }

    @Test
    public void comparisonErrorTextLastName() {
        ErrorTextOrderPage errorLastName = new ErrorTextOrderPage();
        errorLastName.openFormOrder();
        assertEquals("Некорректная подсказка об ошибке", "Введите корректную фамилию", errorLastName.getErrorTextLastName());
    }

    @Test
    public void comparisonErrorTextAddress() {
        ErrorTextOrderPage errorAddress = new ErrorTextOrderPage();
        errorAddress.openFormOrder();
        assertEquals("Некорректная подсказка об ошибке", "Введите корректный адрес", errorAddress.getErrorAddress());
    }

    @Test
    public void comparisonErrorTextStationMetro() {
        ErrorTextOrderPage errorStation = new ErrorTextOrderPage();
        errorStation.openFormOrder();
        assertEquals("Некорректная подсказка об ошибке", "Выберите станцию", errorStation.getErrorStationMetro());
    }

    @Test
    public void comparisonErrorTextPhoneNumber() {
        ErrorTextOrderPage errorNumberPhone = new ErrorTextOrderPage();
        errorNumberPhone.openFormOrder();
        assertEquals("Некорректная подсказка об ошибке", "Введите корректный номер", errorNumberPhone.getErrorPhoneNumber());
    }
}
