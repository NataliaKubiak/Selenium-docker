package org.portfolio.pages.flightreservation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.portfolio.pages.BasePage;

public class FlightSearchPage extends BasePage {

    @FindBy(id = "passengers")
    private WebElement passengersSelect;
    @FindBy(id = "search-flights")
    private WebElement searchFlightsButton;

    public FlightSearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        return this.wait.until(ExpectedConditions.visibilityOf(this.passengersSelect)).isDisplayed();
    }

    public void selectPassengers(String numOfPassengers) {
        Select passengers = new Select(this.passengersSelect);
        passengers.selectByValue(numOfPassengers);
    }

    public void searchFlights() {
        this.searchFlightsButton.click();
    }
}
