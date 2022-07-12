package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.AbstractPageObject;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Menu extends AbstractPageObject {

    public static final String OPEN_MENU_BUTTON = "//a[@class='sidebar-pin']/img";
    public static final String RISKMANAGEMENET_MENU = "//a[ @href='/riskManagement/risk-aggregations']";
    public static final String CONCENTRATIONRISK_SUBMENU = "/html/body/app-root/app-main/div/app-top-bar-menu/div/div/app-menu/div/div[2]/ul/li[3]/ul/li[3]/a";

    @FindBy(how = How.XPATH , using = RISKMANAGEMENET_MENU)
    WebElement RiskManagementMenu;

    @FindBy(how = How.XPATH , using = CONCENTRATIONRISK_SUBMENU)
    WebElement ConcentrationRiskSubMenu;

    @FindBy(how = How.XPATH , using = OPEN_MENU_BUTTON)
    WebElement OpenMenuButton;

    public void clickRiskManagementMenu() throws InterruptedException {

        Thread.sleep(1000);
    RiskManagementMenu.click();
    }

    public void clickConcentrationRiskSubMenu() throws InterruptedException {
        Thread.sleep(1000);
        ConcentrationRiskSubMenu.click();
    }

    public void clickOpenMenuButton() {
        OpenMenuButton.click();
    }

    public void enterConcentrationRiskScreen() throws InterruptedException {
        Actions act = new Actions(getDriver());
        Thread.sleep(5000);
        /*act.moveToElement(getDriver().findElement(By.xpath("//app-menu"))).perform();
        Thread.sleep(4000);*/
        RiskManagementMenu.click();
        Thread.sleep(5000);
       /* act.moveToElement(getDriver().findElement(By.xpath("//app-menu"))).perform();
        Thread.sleep(4000);*/
        ConcentrationRiskSubMenu.click();
    }





}
