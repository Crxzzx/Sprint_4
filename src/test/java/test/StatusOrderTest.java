package test;

import core.Annotation;
import org.junit.Test;
import page.StatusOrderPage;

import static org.junit.Assert.assertTrue;

public class StatusOrderTest extends Annotation {
    @Test
    public void compareStatusOrder() {
        StatusOrderPage statusOrderPage = new StatusOrderPage();
        assertTrue("Заказ с таким номером уже существует", statusOrderPage.statusOrderSamokat("12321"));
    }
}
