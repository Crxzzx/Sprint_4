package test;

import core.Annotation;
import org.junit.Test;
import page.OrderStep1Page;

import static org.junit.Assert.assertEquals;


public class NegativeOrderSamokatTest extends Annotation {
    @Test
    public void comparisonErrorTextFirstName() {
        OrderStep1Page orderStep1Page = new OrderStep1Page();
        orderStep1Page.openFormOrder();
        assertEquals("Некорректная подсказка об ошибке", "Введите корректное имя", orderStep1Page.getErrorTextName());
    }

    @Test
    public void comparisonErrorTextLastName() {
        OrderStep1Page orderStep1Page = new OrderStep1Page();
        orderStep1Page.openFormOrder();
        assertEquals("Некорректная подсказка об ошибке", "Введите корректную фамилию", orderStep1Page.getErrorTextLastName());
    }

    @Test
    public void comparisonErrorTextAddress() {
        OrderStep1Page orderStep1Page = new OrderStep1Page();
        orderStep1Page.openFormOrder();
        assertEquals("Некорректная подсказка об ошибке", "Введите корректный адрес", orderStep1Page.getErrorAddress("d"));
    }

    @Test
    public void comparisonErrorTextStationMetro() {
        OrderStep1Page orderStep1Page = new OrderStep1Page();
        orderStep1Page.openFormOrder();
        assertEquals("Некорректная подсказка об ошибке", "Выберите станцию", orderStep1Page.getErrorStationMetro());
    }

    @Test
    public void comparisonErrorTextPhoneNumber() {
        OrderStep1Page orderStep1Page = new OrderStep1Page();
        orderStep1Page.openFormOrder();
        assertEquals("Некорректная подсказка об ошибке", "Введите корректный номер", orderStep1Page.getErrorPhoneNumber());
    }
}
