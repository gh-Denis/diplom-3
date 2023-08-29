package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private final By constructorActive = By.xpath(".//a[@class='AppHeader_header__link__3D_hX AppHeader_header__link_active__1IkJo']/p[text()='Конструктор']");
    private final By constructorHeader = By.xpath(".//h1[text()='Соберите бургер']");
    private final By personalAccount = By.xpath(".//p[text()='Личный Кабинет']");
    private final By signInButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By orderButton = By.xpath(".//button[text()='Оформить заказ']");
    private final By bunSection = By.xpath(".//div[@style='display: flex;']");
    private final By sauceSection = By.xpath(".//div[@style='display: flex;']/div/span[text()='Соусы']");
    private final By fillingSection = By.xpath(".//div[@style='display: flex;']/div/span[text()='Начинки']");
    private final By bunSelected = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']");
    private final By sauceSelected = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']");
    private final By fillingSelected = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']");

    private final WebDriver driver;

    public HomePage(WebDriver webDriver) {
        driver = webDriver;
    }

    @Step("clickSignInButton")
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    @Step("clickPersonalAccount")
    public void clickPersonalAccount() {
        driver.findElement(personalAccount).click();
    }

    @Step("waitBunSectionVisibility")
    public void waitBunSectionVisibility() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(bunSection));
    }

    @Step("waitBunSelected")
    public void waitBunSelected() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(bunSelected));
    }

    @Step("waitSauceSectionVisibility")
    public void waitSauceSectionVisibility() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(sauceSection));
    }

    @Step("waitSauceSelected")
    public void waitSauceSelected() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(sauceSelected));
    }

    @Step("waitFillingSectionVisibility")
    public void waitFillingSectionVisibility() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(fillingSection));
    }

    @Step("waitFillingSelected")
    public void waitFillingSelected() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(fillingSelected));
    }

    @Step("waitOrderButtonVisibility")
    public void waitOrderButtonVisibility() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(orderButton));
    }

    @Step("waitConstructorActiveVisibility")
    public void waitConstructorActiveVisibility() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(constructorActive));
    }

    @Step("bunSelectedText")
    public String bunSelectedText() {
        return driver.findElement(bunSelected).getText();
    }

    @Step("sauceSelectedText")
    public String sauceSelectedText() {
        return driver.findElement(sauceSelected).getText();
    }

    @Step("fillingSelectedText")
    public String fillingSelectedText() {
        return driver.findElement(fillingSelected).getText();
    }

    @Step("orderButtonText")
    public String orderButtonText() {
        return driver.findElement(orderButton).getText();
    }

    @Step("constructorHeaderText")
    public String constructorHeaderText() {
        return driver.findElement(constructorHeader).getText();
    }

    @Step("clickSauceSection")
    public void clickSauceSection() {
        driver.findElement(sauceSection).click();
    }

    @Step("clickFillingSection")
    public void clickFillingSection() {
        driver.findElement(fillingSection).click();
    }
}