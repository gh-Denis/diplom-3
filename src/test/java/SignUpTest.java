import cfg.Browser;
import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUpPage;

import static org.junit.Assert.assertEquals;

public class SignUpTest {

    private WebDriver driver;
    private String name;
    private String email;
    private String password;
    private LoginPage objLoginPage;

    @Before
    public void setUp() {
        Browser objBrowser = Browser.CHROME;
        driver = objBrowser.getDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        HomePage objHomePage = new HomePage(driver);
        objHomePage.clickSignInButton();
        objLoginPage = new LoginPage(driver);
        objLoginPage.waitForLoadSignUpButton();
        objLoginPage.clickSignUpButton();
        Faker faker = new Faker();
        name = faker.name().username();
        email = faker.internet().emailAddress();
        password = faker.internet().password();
    }

    @Test
    public void shouldSignUp() {
        SignUpPage objSignUpPage = new SignUpPage(driver);
        objSignUpPage.waitSignUpButtonVisibility();
        objSignUpPage.signUp(name, email, password);
        objLoginPage.waitForLoadSignInButton();
        assertEquals("Вход", objLoginPage.signInHeaderText());
    }

    @Test
    public void shouldNotSignUp() {
        SignUpPage objSignUpPage = new SignUpPage(driver);
        objSignUpPage.waitSignUpButtonVisibility();
        objSignUpPage.signUp(name, email, "test");
        objSignUpPage.waitPasswordErrorVisibility();
        assertEquals("Некорректный пароль", objSignUpPage.passwordErrorText());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}