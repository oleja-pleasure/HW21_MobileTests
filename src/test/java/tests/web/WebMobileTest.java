package tests.web;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class WebMobileTest extends WebTestBase {
    @Test
    @Tag("web")
    void wikiTest(){
        step("Открытие главной страницы", () ->
                open("https://en.m.wikipedia.org/"));
        step("Клик по полю поиска", () ->
                $("#searchInput").click());
        step("Поиск статьи по Appium", () ->
                $("[method=\"get\"]>[name=\"search\"]").val("Appium").pressEnter());
        step("Проверка открытой страницы", () ->
                $("#section_0").shouldHave(text("Appium")));
    }
}
