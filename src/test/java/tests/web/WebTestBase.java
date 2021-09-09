package tests.web;

import com.codeborne.selenide.Configuration;
import config.Credentials;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.Attach.getSessionId;

public class WebTestBase {
    @BeforeAll
    public static void setup() {
        String login = Credentials.credentials.login();
        String password = Credentials.credentials.password();
        String server = Credentials.credentials.server();
        Configuration.remote = String.format("https://%s:%s@%s/wd/hub", login, password, server);
        addListener("AllureSelenide", new AllureSelenide());
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    public void afterEach() {
        String sessionId = getSessionId();
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        closeWebDriver();
        Attach.attachVideoSelenoid(sessionId);
    }
}
