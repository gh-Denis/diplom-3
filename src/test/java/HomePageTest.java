import cfg.Browser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

import static org.junit.Assert.assertEquals;

public class HomePageTest {

    HomePage objHomePage;
    private WebDriver driver;

    @Before
    public void setUp() {
        Browser objBrowser = Browser.CHROME;
        driver = objBrowser.getDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        objHomePage = new HomePage(driver);
    }

    @Test
    public void shouldOpenBunSection() {
        objHomePage.waitForLoadElement(objHomePage.bunSection);
        objHomePage.waitForLoadElement(objHomePage.bunSelected);
        assertEquals("Булки", driver.findElement(objHomePage.bunSelected).getText());
    }

    @Test
    public void shouldOpenSauceSection() {
        objHomePage.waitForLoadElement(objHomePage.sauceSection);
        objHomePage.clickSauceSection();
        objHomePage.waitForLoadElement(objHomePage.sauceSelected);
        assertEquals("Соусы", driver.findElement(objHomePage.sauceSelected).getText());
    }

    @Test
    public void shouldOpenFillingSection() {
        objHomePage.waitForLoadElement(objHomePage.fillingSection);
        objHomePage.clickFillingSection();
        objHomePage.waitForLoadElement(objHomePage.fillingSelected);
        assertEquals("Начинки", driver.findElement(objHomePage.fillingSelected).getText());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}