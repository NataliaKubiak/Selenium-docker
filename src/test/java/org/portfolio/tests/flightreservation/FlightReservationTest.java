package org.portfolio.tests.flightreservation;

import org.portfolio.pages.flightreservation.*;
import org.portfolio.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FlightReservationTest extends BaseTest {

    private String nomOfPassengers;
    private String expectedPrice;

    @BeforeTest
    @Parameters({"nomOfPassengers", "expectedPrice"})
    public void setParameters(String nomOfPassengers, String expectedPrice) {
        this.nomOfPassengers = nomOfPassengers;
        this.expectedPrice = expectedPrice;
    }

    @Test
    public void userRegistrationTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.goTo("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/reservation-app/index.html");
        Assert.assertTrue(registrationPage.isAt());

        registrationPage.enterUserDetails("selenium", "docker");
        registrationPage.enterUserDetails("selenium@docker.com", "docker");
        registrationPage.enterAddress("123 non main St", "Atlanta", "30001");
        registrationPage.register();
    }

    @Test(dependsOnMethods = "userRegistrationTest")
    public void registrationConformationTest() {
        RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
        Assert.assertTrue(registrationConfirmationPage.isAt());

        registrationConfirmationPage.setGoToFlightsSearch();
    }

    @Test(dependsOnMethods = "registrationConformationTest")
    public void flightSearchTest() {
        FlightSearchPage flightSearchPage = new FlightSearchPage(driver);
        Assert.assertTrue(flightSearchPage.isAt());

        flightSearchPage.selectPassengers(nomOfPassengers);
        flightSearchPage.searchFlights();
    }

    @Test(dependsOnMethods = "flightSearchTest")
    public void flightsSelectionTest() {
        SelectFlightsPage selectFlightsPage = new SelectFlightsPage(driver);
        Assert.assertTrue(selectFlightsPage.isAt());

        selectFlightsPage.selectFlights();
        selectFlightsPage.confirmFlights();
    }

    @Test(dependsOnMethods = "flightsSelectionTest")
    public void flightReservationConfirmationTest() {
        FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver);
        Assert.assertTrue(flightConfirmationPage.isAt());

        Assert.assertEquals(flightConfirmationPage.getPrice(), expectedPrice);
    }
}
