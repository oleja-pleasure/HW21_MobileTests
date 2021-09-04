package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.Credentials;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    String bs_login = Credentials.credentials.bs_login();
    String bs_password = Credentials.credentials.bs_password();

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        // Set your access credentials
        desiredCapabilities.setCapability("browserstack.user", bs_login);
        desiredCapabilities.setCapability("browserstack.key", bs_password);

        // Set URL of the application under test
        desiredCapabilities.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");

        // Specify device and os_version for testing
        desiredCapabilities.setCapability("device", "Google Pixel 3");
        desiredCapabilities.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        desiredCapabilities.setCapability("project", "First Java Project");
        desiredCapabilities.setCapability("build", "Java Android");
        desiredCapabilities.setCapability("name", "first_test");


        AndroidDriver androidDriver = null;
        try {
            androidDriver = new AndroidDriver(new URL(Credentials.credentials.bs_server()), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return androidDriver;
    }
}
