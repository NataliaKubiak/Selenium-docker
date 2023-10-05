package org.portfolio.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setDriver() throws MalformedURLException {
        if(Boolean.getBoolean("selenium.grid.enabled")) {
            this.driver = getRemoteDriver();
        } else {
            this.driver = getLocalDriver();
        }
    }

    //if the System Property Variable selenium.grid.enabled = true we will use this driver
    private WebDriver getRemoteDriver() throws MalformedURLException {
        Capabilities capabilities;

        if(System.getProperty("browser").equalsIgnoreCase("chrome")) {
            capabilities = new ChromeOptions();
        } else {
            capabilities = new FirefoxOptions();
        }

        return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
    }

    //if the System Property Variable selenium.grid.enabled = false we will use this driver
    private WebDriver getLocalDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }
}
