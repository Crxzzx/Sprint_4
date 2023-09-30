package test;

import core.Annotation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import page.AccordionPage;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CheckTextAccordionTest extends Annotation {
    private final int numberAccordion;
    private final String textAccordionQuestion;
    private final String textAccordionAnswer;

    public CheckTextAccordionTest(int numberAccordion, String textAccordionQuestion, String textAccordionAnswer) {
        this.numberAccordion = numberAccordion;
        this.textAccordionQuestion = textAccordionQuestion;
        this.textAccordionAnswer = textAccordionAnswer;
    }

    @Parameterized.Parameters
    public static Object[][] getTextAccordion() {
        return new Object[][]{
                {0, "Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, "Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, "Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Test
    public void checkHeader() {
        AccordionPage accordionPage = new AccordionPage();
        assertEquals("Текст заголовка вопроса некорректный", textAccordionQuestion, accordionPage.checkElementAccordion(numberAccordion));
    }

    @Test
    public void checkParagraf() {
        AccordionPage accordionPage = new AccordionPage();
        assertEquals("Текст ответа на вопрос некорректный", textAccordionAnswer, accordionPage.getTextAfterClickButton(numberAccordion));
    }
}

