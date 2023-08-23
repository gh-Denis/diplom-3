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
        objHomePage.waitBunSectionVisibility();
        objHomePage.waitBunSelected();
        assertEquals("Булки", objHomePage.bunSelectedText());
    }

    @Test
    public void shouldOpenSauceSection() {
        objHomePage.waitSauceSectionVisibility();
        objHomePage.clickSauceSection();
        objHomePage.waitSauceSelected();
        assertEquals("Соусы", objHomePage.sauceSelectedText());
    }

    @Test
    public void shouldOpenFillingSection() {
        objHomePage.waitFillingSectionVisibility();
        objHomePage.clickFillingSection();
        objHomePage.waitFillingSelected();
        assertEquals("Начинки", objHomePage.fillingSelectedText());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}