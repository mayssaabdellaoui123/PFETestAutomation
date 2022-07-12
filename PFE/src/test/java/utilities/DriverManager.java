package utilities;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();


    public WebDriver initDriver(String browser) {

        // init driver of selected browser
        WebDriver webdriver = DriverFactory.valueOf(browser.toUpperCase()).createDriver();
        driver.set(webdriver);
        return getDriver();
    }


    public static WebDriver getDriver() {
        return driver.get();
    }


    public static void quit() {
        DriverManager.driver.get().quit();
        driver.remove();
    }

}
