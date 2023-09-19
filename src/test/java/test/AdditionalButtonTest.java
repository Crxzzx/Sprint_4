package test;

import core.Annotation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import page.AdditionalTaskMainPage;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AdditionalButtonTest extends Annotation {
    private final int selectButton;
    private final String urlService;

    public AdditionalButtonTest(int selectButton, String urlService) {
        this.selectButton = selectButton;
        this.urlService = urlService;
    }

    @Parameterized.Parameters
    public static Object[][] getUrlLogo() {
        return new Object[][]{
                {2, "https://qa-scooter.praktikum-services.ru/"},
                {1, "https://ya.ru/"},
        };
    }

    @Test
    public void comparisonUrlAfterClickLogo() {
        AdditionalTaskMainPage urlLogo = new AdditionalTaskMainPage();
        assertEquals("Url неверный", urlService, urlLogo.clickButtonService(selectButton));
    }
}
