import cfg.Browser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.PersonalAccountPage;

import static org.junit.Assert.assertEquals;

public class PersonalAccountTest {

    private WebDriver driver;
    private HomePage objHomePage;
    private LoginPage objLoginPage;

    @Before
    public void setUp() {
        Browser objBrowser = Browser.CHROME;
        driver = objBrowser.getDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        objHomePage = new HomePage(driver);
        objHomePage.clickSignInButton();
        objLoginPage = new LoginPage(driver);
        objLoginPage.login("spbden86@yandex.ru", "Stell@RBurgeR");
    }

    @Test
    public void shouldOpenPersonalAccount() {
        objHomePage.clickPersonalAccount();
        PersonalAccountPage obgAccountPage = new PersonalAccountPage(driver);
        obgAccountPage.waitForLoadProfile();
        assertEquals("Профиль", obgAccountPage.profileText());
    }

    @Test
    public void shouldOpenConstructorByButton() {
        objHomePage.clickPersonalAccount();
        PersonalAccountPage obgAccountPage = new PersonalAccountPage(driver);
        obgAccountPage.waitForLoadProfile();
        obgAccountPage.clickConstructor();
        objHomePage.waitConstructorActiveVisibility();
        assertEquals("Соберите бургер", objHomePage.constructorHeaderText());
    }

    @Test
    public void shouldOpenConstructorByLogo() {
        objHomePage.clickPersonalAccount();
        PersonalAccountPage obgAccountPage = new PersonalAccountPage(driver);
        obgAccountPage.waitForLoadProfile();
        obgAccountPage.clickLogo();
        objHomePage.waitConstructorActiveVisibility();
        assertEquals("Соберите бургер", objHomePage.constructorHeaderText());
    }

    @Test
    public void shouldExit() {
        objHomePage.clickPersonalAccount();
        PersonalAccountPage obgAccountPage = new PersonalAccountPage(driver);
        obgAccountPage.waitForLoadProfile();
        obgAccountPage.clickExitButton();
        objLoginPage.waitForLoadSignInButton();
        assertEquals("Вход", objLoginPage.signInHeaderText());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}