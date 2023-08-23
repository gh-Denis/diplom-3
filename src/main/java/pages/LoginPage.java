package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private final By emailField = By.xpath(".//input[@type='text']");
    private final By passwordField = By.xpath(".//input[@type='password']");
    private final By signInButton = By.xpath(".//button[text()='Войти']");
    private final By signInHeader = By.xpath(".//h2[text()='Вход']");
    private final By signUpButton = By.xpath(".//a[text()='Зарегистрироваться']");
    private final By restorePasswordButton = By.xpath(".//a[text()='Восстановить пароль']");

    private final WebDriver driver;

    public LoginPage(WebDriver webDriver) {
        driver = webDriver;
    }

    @Step("waitForLoadSignInButton")
    public void waitForLoadSignInButton() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(signInButton));
    }

    @Step("waitForLoadSignUpButton")
    public void waitForLoadSignUpButton() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(signUpButton));
    }

    @Step("setEmail")
    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("setPassword")
    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("clickSignInButton")
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    @Step("clickSignUpButton")
    public void clickSignUpButton() {
        driver.findElement(signUpButton).click();
    }

    @Step("clickRestoreButton")
    public void clickRestoreButton() {
        driver.findElement(restorePasswordButton).click();
    }

    @Step("signInHeaderText")
    public String signInHeaderText() {
        return driver.findElement(signInHeader).getText();
    }

    @Step("login")
    public void login(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickSignInButton();
    }
}