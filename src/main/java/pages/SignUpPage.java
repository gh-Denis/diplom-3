package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {

    private final By textField = By.xpath(".//input[@type='text']");
    private final By passwordField = By.xpath(".//input[@type='password']");
    private final By signUpButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By signInButton = By.xpath(".//a[text()='Войти']");
    private final By passwordError = By.xpath(".//p[text()='Некорректный пароль']");

    private final WebDriver driver;

    public SignUpPage(WebDriver webDriver) {
        driver = webDriver;
    }

    @Step("waitForLoadElement")
    public void waitForLoadElement(By element) {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    @Step("setName")
    public void setName(String username) {
        driver.findElements(textField).get(0).sendKeys(username);
    }

    @Step("setEmail")
    public void setEmail(String email) {
        driver.findElements(textField).get(1).sendKeys(email);
    }

    @Step("setPassword")
    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("clickSignUpButton")
    public void clickSignUpButton() {
        driver.findElement(signUpButton).click();
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

    @Step("waitSignUpButtonVisibility")
    public void waitSignUpButtonVisibility() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(signUpButton));
    }

    @Step("waitPasswordErrorVisibility")
    public void waitPasswordErrorVisibility() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(passwordError));
    }

    @Step("passwordErrorText")
    public String passwordErrorText() {
        return driver.findElement(passwordError).getText();
    }

    @Step("signUp")
    public void signUp(String username, String email, String password) {
        setName(username);
        setEmail(email);
        setPassword(password);
        clickSignUpButton();
    }
}