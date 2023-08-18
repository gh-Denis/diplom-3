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
        assertEquals("Профиль", driver.findElement(obgAccountPage.profile).getText());
    }

    @Test
    public void shouldOpenConstructorByButton() {
        objHomePage.clickPersonalAccount();
        PersonalAccountPage obgAccountPage = new PersonalAccountPage(driver);
        obgAccountPage.waitForLoadProfile();
        obgAccountPage.clickConstructor();
        objHomePage.waitForLoadElement(objHomePage.constructorActive);
        assertEquals("Соберите бургер", driver.findElement(objHomePage.constructorHeader).getText());
    }

    @Test
    public void shouldOpenConstructorByLogo() {
        objHomePage.clickPersonalAccount();
        PersonalAccountPage obgAccountPage = new PersonalAccountPage(driver);
        obgAccountPage.waitForLoadProfile();
        obgAccountPage.clickLogo();
        objHomePage.waitForLoadElement(objHomePage.constructorActive);
        assertEquals("Соберите бургер", driver.findElement(objHomePage.constructorHeader).getText());
    }

    @Test
    public void shouldExit() {
        objHomePage.clickPersonalAccount();
        PersonalAccountPage obgAccountPage = new PersonalAccountPage(driver);
        obgAccountPage.waitForLoadProfile();
        obgAccountPage.clickExitButton();
        objLoginPage.waitForLoadSignInButton();
        assertEquals("Вход", driver.findElement(objLoginPage.signInHeader).getText());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}