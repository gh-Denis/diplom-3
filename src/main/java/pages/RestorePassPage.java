package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RestorePassPage {

    public final By signInButton = By.xpath(".//a[text()='Войти']");
    private final WebDriver driver;

    public RestorePassPage(WebDriver webDriver) {
        driver = webDriver;
    }

    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    public void waitForLoadElement(By element) {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}