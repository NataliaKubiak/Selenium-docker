package org.portfolio.pages.flightreservation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.portfolio.pages.BasePage;

public class RegistrationPage extends BasePage {

    @FindBy(id = "firstName")
    private WebElement firstNameInput;
    @FindBy(id = "lastName")
    private WebElement lastNameInput;
    @FindBy(id = "email")
    private WebElement emailInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "street")
    private WebElement streetInput;
    @FindBy(id = "city")
    private WebElement cityInput;
    @FindBy(id = "zip")
    private WebElement zipInput;
    @FindBy(id = "register-btn")
    private WebElement registerButton;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        return this.wait.until(ExpectedConditions.visibilityOf(this.firstNameInput)).isDisplayed();
    }

    public void goTo(String url) {
        this.driver.get(url);
    }

    public void enterUserDetails(String firstName, String lastName) {
        this.firstNameInput.sendKeys(firstName);
        this.lastNameInput.sendKeys(lastName);
    }

    public void enterUserCredentials(String email, String password) {
        this.emailInput.sendKeys(email);
        this.passwordInput.sendKeys(password);
    }

    public void enterAddress(String street, String city, String zip) {
        this.streetInput.sendKeys(street);
        this.cityInput.sendKeys(city);
        this.zipInput.sendKeys(zip);
    }

    public void register() {
        registerButton.click();
    }
}