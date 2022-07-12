package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public abstract class AbstractPageObject extends BaseFile {

    public static WebDriver driver;

    /**
     * AjaxElementLocator is a lazy load concept in Page Factory pattern to identify WebElements only when they are used
     */
    protected AbstractPageObject() {
        driver = getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,Integer.parseInt( props.getProperty("timeout")) ), this);
    }

    public String getPageURL(){
        return driver.getCurrentUrl();
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

}

