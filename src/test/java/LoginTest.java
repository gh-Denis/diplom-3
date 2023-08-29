import cfg.Browser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.RestorePassPage;
import pages.SignUpPage;

import static org.junit.Assert.assertEquals;

public class LoginTest {

    HomePage objHomePage;
    LoginPage objLoginPage;
    private WebDriver driver;

    @Before
    public void setUp() {
        Browser objBrowser = Browser.CHROME;
        driver = objBrowser.getDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        objHomePage = new HomePage(driver);
        objLoginPage = new LoginPage(driver);
    }

    @Test
    public void shouldLoginViaSignInButton() {
        objHomePage.clickSignInButton();
        objLoginPage.waitForLoadSignInButton();
        objLoginPage.login("spbden86@yandex.ru", "Stell@RBurgeR");
        objHomePage.waitOrderButtonVisibility();
        assertEquals("Оформить заказ", objHomePage.orderButtonText());
    }

    @Test
    public void shouldLoginViaPersonalAccount() {
        objHomePage.clickPersonalAccount();
        objLoginPage.waitForLoadSignInButton();
        objLoginPage.login("spbden86@yandex.ru", "Stell@RBurgeR");
        objHomePage.waitOrderButtonVisibility();
        assertEquals("Оформить заказ", objHomePage.orderButtonText());
    }

    @Test
    public void shouldLoginViaSignUpForm() {
        objHomePage.clickSignInButton();
        objLoginPage.waitForLoadSignInButton();
        objLoginPage.clickSignUpButton();
        SignUpPage objSignUp = new SignUpPage(driver);
        objSignUp.waitSignInButtonVisibility();
        objSignUp.clickSignInButton();
        objLoginPage.waitForLoadSignInButton();
        objLoginPage.login("spbden86@yandex.ru", "Stell@RBurgeR");
        objHomePage.waitOrderButtonVisibility();
        assertEquals("Оформить заказ", objHomePage.orderButtonText());
    }

    @Test
    public void shouldLoginViaRestorePassword() {
        objHomePage.clickSignInButton();
        objLoginPage.waitForLoadSignInButton();
        objLoginPage.clickRestoreButton();
        RestorePassPage objRestorePass = new RestorePassPage(driver);
        objRestorePass.waitSignInButtonVisibility();
        objRestorePass.clickSignInButton();
        objLoginPage.waitForLoadSignInButton();
        objLoginPage.login("spbden86@yandex.ru", "Stell@RBurgeR");
        objHomePage.waitOrderButtonVisibility();
        assertEquals("Оформить заказ", objHomePage.orderButtonText());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}