package test;

import core.Annotation;
import org.junit.Test;
import page.NotFoundOrderSamokatPage;

import static org.junit.Assert.assertTrue;

public class StatusOrderTest extends Annotation {
    @Test
    public void compareStatusOrder() {
        NotFoundOrderSamokatPage statusSamokat = new NotFoundOrderSamokatPage();
        assertTrue("Заказ с таким номером уже существует", statusSamokat.statusOrderSamokat());
    }
}
