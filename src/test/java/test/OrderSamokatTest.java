package test;

import core.Annotation;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import page.OrderStep1Page;
import page.OrderStep2Page;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertTrue;

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
                {1, "Костян", "Скелетонов", "ул.Пушкина д. 10", 5, "89278813987", 1, "сутки", "grey", "Подгоните плизз заряженный"},
                {2, "Лёха", "Рыбаловов", "ул.Великий Рыбак д. 5", 4, "89278813922", 1, "двое суток", "black", "Карась оказался не свежий,буду заказывать на yandex.market"},
        };
    }

    @Test
    public void fillingFormOrder() {
        OrderStep1Page orderStep1Page = new OrderStep1Page();
        orderStep1Page.createOrderSamokatStep1(buttonOrder, nameForm, lastNameForm, adressForm, stationMetroForm, phoneNumberForm);
        OrderStep2Page orderStep2Page = new OrderStep2Page();
        orderStep2Page.orderSamokat2step(dateCalendar, rentalPeriod, colorSamokat, commentCourier);
        MatcherAssert.assertThat("Модальное окно,об успешном создании заказа не отобразилось" , orderStep2Page.getStatusOrder() , containsString("Заказ оформлен"));
    }
}

