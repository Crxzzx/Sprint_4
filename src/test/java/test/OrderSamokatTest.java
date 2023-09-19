package test;

import core.Annotation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import page.OrderStep1Page;
import page.OrderStep2Page;

@RunWith(Parameterized.class)
public class OrderSamokatTest extends Annotation {
    private final int buttonOrder;
    private final String nameForm;
    private final String lastNameForm;
    private final String adressForm;
    private final int stationMetroForm;
    private final String phoneNumberForm;
    private final int dateCalendar;
    private final String rentalPeriod;
    private final String colorSamokat;
    private final String commentCourier;

    public OrderSamokatTest(int buttonOrder, String nameForm, String lastNameForm, String adressForm, int stationMetroForm, String phoneNumberForm, int dateCalendar, String rentalPeriod, String colorSamokat, String commentCourier) {
        this.buttonOrder = buttonOrder;
        this.nameForm = nameForm;
        this.lastNameForm = lastNameForm;
        this.adressForm = adressForm;
        this.stationMetroForm = stationMetroForm;
        this.phoneNumberForm = phoneNumberForm;
        this.dateCalendar = dateCalendar;
        this.rentalPeriod = rentalPeriod;
        this.colorSamokat = colorSamokat;
        this.commentCourier = commentCourier;

    }

    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
                {1, "Костян", "Скелетонов", "ул.Пушкина д. 10", 5, "89278813987", 3, "сутки", "grey", "Подгоните плизз заряженный"},
                {2, "Лёха", "Рыбаловов", "ул.Великий Рыбак д. 5", 4, "89278813922", 2, "двое суток", "black", "Карась оказался не свежий,буду заказывать на yandex.market"},
        };
    }

    @Test
    public void fillingFormOrder() {
        OrderStep1Page test1 = new OrderStep1Page();
        test1.createOrderSamokatStep1(buttonOrder, nameForm, lastNameForm, adressForm, stationMetroForm, phoneNumberForm);
        OrderStep2Page test2 = new OrderStep2Page();
        test2.orderSamokat2step(dateCalendar, rentalPeriod, colorSamokat, commentCourier);
    }
}

