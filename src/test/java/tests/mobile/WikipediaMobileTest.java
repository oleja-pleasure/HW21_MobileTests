package tests.mobile;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class WikipediaMobileTest extends MobileTestBase {

    @Test
    @Tag("mobile")
    void wikiGetStarted() {
        step("Проверка 1 вкладки get started", () ->
        $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("The Free Encyclopedia …in over 300 languages")));
        step("Переход на следующую вкладку", () ->
        $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());
        step("Проверка 2 вкладки get started", () ->
        $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("New ways to explore")));
        step("Переход на следующую вкладку", () ->
        $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());
        step("Проверка 3 вкладки get started", () ->
        $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("Reading lists with sync")));
        step("Переход на следующую вкладку", () ->
        $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());
        step("Проверка 4 вкладки get started", () ->
        $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("Send anonymous data")));
    }
}
