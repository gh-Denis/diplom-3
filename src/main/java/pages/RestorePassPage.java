package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RestorePassPage {

    private final By signInButton = By.xpath(".//a[text()='Войти']");

    private final WebDriver driver;

    public RestorePassPage(WebDriver webDriver) {
        driver = webDriver;
    }

    @Step("clickSignInButton")
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    @Step("waitSignInButtonVisibility")
    public void waitSignInButtonVisibility() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(signInButton));
    }
}