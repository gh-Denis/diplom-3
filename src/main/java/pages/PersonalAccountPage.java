package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAccountPage {
    private final By constructor = By.xpath(".//p[text()='Конструктор']");
    private final By logo = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");
    private final By profile = By.xpath(".//a[text()='Профиль']");
    private final By exitButton = By.xpath(".//button[text()='Выход']");

    private final WebDriver driver;

    public PersonalAccountPage(WebDriver webDriver) {
        driver = webDriver;
    }

    @Step("waitForLoadProfile")
    public void waitForLoadProfile() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(profile));
    }

    @Step("profileText")
    public String profileText() {
        return driver.findElement(profile).getText();
    }

    @Step("clickConstructor")
    public void clickConstructor() {
        driver.findElement(constructor).click();
    }

    @Step("clickLogo")
    public void clickLogo() {
        driver.findElement(logo).click();
    }

    @Step("clickExitButton")
    public void clickExitButton() {
        driver.findElement(exitButton).click();
    }
}