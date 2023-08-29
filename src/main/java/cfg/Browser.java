package cfg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public enum Browser {
    CHROME("chrome"), YANDEX("yandex");
    private final String browser;

    Browser(String browserName) {
        this.browser = browserName;
    }

    public WebDriver getDriver() {
        switch (this) {
            case CHROME:
                return new ChromeDriver();
            case YANDEX: {
                ChromeOptions options = new ChromeOptions();
                System.setProperty("webdriver.chrome.driver", "C:\\Portable\\yandexdriver-win64\\yandexdriver.exe");
                options.setBinary("C:\\Users\\DEN\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
                return new ChromeDriver(options);
            }
            default:
                break;
        }
        return null;
    }
}