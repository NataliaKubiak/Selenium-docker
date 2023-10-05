package org.portfolio.pages.flightreservation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.portfolio.pages.BasePage;

public class RegistrationConfirmationPage extends BasePage {

    @FindBy(id = "go-to-flights-search")
    private WebElement goToFlightsSearchButton;
    @FindBy(css = "#registration-confirmation-section p b")
    private WebElement name;

    public RegistrationConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        return this.wait.until(ExpectedConditions.visibilityOf(this.goToFlightsSearchButton)).isDisplayed();
    }

    public void goToFlightsSearch() {
        this.goToFlightsSearchButton.click();
    }

    public String getFirstName() {
        return this.name.getText();
    }
}
