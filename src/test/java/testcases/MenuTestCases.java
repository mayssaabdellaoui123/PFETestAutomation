package testcases;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginScreen;
import pages.Menu;
import utilities.BaseFile;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class MenuTestCases extends BaseFile {


    Menu menu ;
    Loginstepcase loginstepcase = new Loginstepcase();
    LoginScreen loginScreen;

    @BeforeSuite()
    public void start() throws GeneralSecurityException, IOException {
        loadConfig();
        startApp();
        loginScreen = new LoginScreen();
        loginScreen.loginForTest();
    }

   @Test
    public void MenuTestCase1 () throws InterruptedException {

     menu = new Menu();
     menu.clickRiskManagementMenu();
     menu.clickConcentrationRiskSubMenu();

     Thread.sleep(1000);
     Assert.assertEquals(menu.getPageURL(),"http://staging.alm.vneuron.com/riskManagement/concentrationRisk");
       }



    @AfterSuite()
    public void clean(){
        cleanup();
    }
}
