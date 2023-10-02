package org.portfolio.pages.vendorportal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.portfolio.pages.BasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DashboardPage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(DashboardPage.class);
    @FindBy(id = "monthly-earning")
    private WebElement monthlyEarningElement;
    @FindBy(id = "annual-earning")
    private WebElement annualEarningElement;
    @FindBy(id = "profit-margin")
    private WebElement profitMarginElement;
    @FindBy(id = "available-inventory")
    private WebElement availableInventoryElement;
    @FindBy(css = "#dataTable_filter input")
    private WebElement searchInput;
    @FindBy(id = "dataTable_info")
    private WebElement searchResultCountElement;
    @FindBy(css = "#userDropdown img")
    private WebElement userProfilePictureElement;
    @FindBy(linkText = "Logout")
    private WebElement logoutLink;
    @FindBy(css = "#logoutModal a")
    private WebElement modalLogoutButton;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        return this.wait.until(ExpectedConditions.visibilityOf(this.annualEarningElement)).isDisplayed();
    }

    public String getAnnualEarning() {
        return this.annualEarningElement.getText();
    }

    public String getMonthlyEarning() {
        return this.monthlyEarningElement.getText();
    }

    public String getProfitMargin() {
        return this.profitMarginElement.getText();
    }

    public String getAvailableInventory() {
        return this.availableInventoryElement.getText();
    }

    public void searchOrderHistoryBy(String keyword) {
        this.searchInput.sendKeys(keyword);
    }

    public int getSearchResultsCount() {
        String resultsText = this.searchResultCountElement.getText();
        String[] arr = resultsText.split(" ");

        int count = Integer.parseInt(arr[5]);
        log.info("Results count: {}", count);
        return count;
    }

    public void logout() {
        this.userProfilePictureElement.click();
        this.logoutLink.click();
        this.modalLogoutButton.click();
    }
}
