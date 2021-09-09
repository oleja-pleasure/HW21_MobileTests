package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Mobile implements WebDriverProvider {

        @Override
        public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
            desiredCapabilities.setCapability("platformName","Android");
            desiredCapabilities.setCapability("deviceName","DEVICE_NUMBER");
            desiredCapabilities.setCapability("version", "8.1");
            desiredCapabilities.setCapability("locale", "en");
            desiredCapabilities.setCapability("language", "en");
            desiredCapabilities.setCapability("appPackage", "org.wikipedia.alpha");
            desiredCapabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
            desiredCapabilities.setCapability("app", getAbsolutePath("src/test/resources/app-alpha-universal-release.apk"));

            AndroidDriver androidDriver = null;
            try {
                androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return androidDriver;


        }
    private String getAbsolutePath(String filePath) {
        File file = new File(filePath);
        assertTrue(file.exists(), filePath + " not found");

        return file.getAbsolutePath();
    }
    }

