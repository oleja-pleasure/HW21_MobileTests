import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class WikipediaTest extends TestBase {

    @Test
    void searchAppium() {
        $(MobileBy.AccessibilityId("Search Wikipedia")).click();
        $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).setValue("appium");
        //$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(text("Appium"));
        $(MobileBy.id("org.wikipedia.alpha:id/page_list_item_title")).click();
        $(MobileBy.id("org.wikipedia.alpha:id/view_page_title_text")).shouldHave(text("Appium"));
    }
}
