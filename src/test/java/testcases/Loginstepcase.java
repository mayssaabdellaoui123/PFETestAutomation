package testcases;

import com.sun.xml.internal.stream.events.AttributeImpl;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginScreen;
import pages.Menu;
import testdata.DataFromGoogleSheet;
import utilities.BaseFile;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Loginstepcase extends BaseFile {

    DataFromGoogleSheet dataFromgoogle = new DataFromGoogleSheet();
    LoginScreen loginScreen;
    Menu menu ;

    @BeforeMethod()
    public void start() throws GeneralSecurityException, IOException {
        loadConfig();
        startApp();
    }


    public void login(String login,String password) throws IOException, GeneralSecurityException {
        loginScreen = new LoginScreen();
        Assert.assertTrue(loginScreen.checkForgetPasswordMessageIsDisplayed());
        Assert.assertTrue(loginScreen.checkLoginPhotoIsDisplayed());
        Assert.assertTrue(loginScreen.checkContactSupportMessageIsDisplayed());
        loginScreen.enterEmailFeild(login);
        loginScreen.enterpasswordFeild(password);
        loginScreen.clickLoginBtn();
    }





   @Test()
   @Description("Login sucessfully")
   public void LoginTestCase1 () throws IOException, GeneralSecurityException {
        List<List<Object>> data = dataFromgoogle.DataFromGoogleSheet(dataFromgoogle.Loginrange);


       login(String.valueOf(data.get(0).get(0)),String.valueOf(data.get(0).get(1)));
        getDriver().manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        String TextAlert = loginScreen.checkAlertIsDisplayed();
        Assert.assertEquals(TextAlert,"Success\n" +
                "You have logged in sucessfully");
        Assert.assertNotEquals( loginScreen.getPageURL() , "http://staging.alm.vneuron.com/dashboard" );
    }

    @Test()
    @Description("Invalid credentials when login ")
    public void LoginTestCase2 () throws IOException, GeneralSecurityException {
        List<List<Object>> data = dataFromgoogle.DataFromGoogleSheet(dataFromgoogle.Loginrange);
        System.out.println(String.valueOf(data.get(4).get(0)) instanceof Object);


        login(String.valueOf(data.get(1).get(0)),String.valueOf(data.get(1).get(1)));
       getDriver().manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
       String TextAlert = loginScreen.checkAlertIsDisplayed();
       Assert.assertEquals(TextAlert,"Error\n" +
               "Invalid user credentials");
        Assert.assertEquals( loginScreen.getPageURL(), "http://staging.alm.vneuron.com/login" );

    }

    @Test()
    @Description("Invalid credentials when login ")
    public void LoginTestCase3 () throws IOException, GeneralSecurityException {
        List<List<Object>> data = dataFromgoogle.DataFromGoogleSheet(dataFromgoogle.Loginrange);
        login(String.valueOf(data.get(2).get(0)),String.valueOf(data.get(2).get(1)));
        getDriver().manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        String TextAlert = loginScreen.checkAlertIsDisplayed();
        Assert.assertEquals(TextAlert,"Error\n" +
                "Invalid user credentials");
        Assert.assertEquals( loginScreen.getPageURL(), "http://staging.alm.vneuron.com/login" );

    }

     @Test()
     @Description("Invalid credentials when login ")
    public void LoginTestCase4 () throws IOException, GeneralSecurityException {
         List<List<Object>> data = dataFromgoogle.DataFromGoogleSheet(dataFromgoogle.Loginrange);
        login(String.valueOf(data.get(3).get(0)),String.valueOf(data.get(3).get(1)));
        getDriver().manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        /* a vérifier */
        //String TextAlert = loginScreen.checkAlertIsDisplayed();
        //Assert.assertEquals(TextAlert,"Error\n" +
        //       "Invalid user credentials");
        //Assert.assertTrue(loginScreen.checkErrrorMessageIsDisplayed());
      Assert.assertEquals( loginScreen.getPageURL(), "http://staging.alm.vneuron.com/login" );

    }

    @Test()
    @Description("Invalid credentials when login ")
    public void LoginTestCase5 () throws IOException, GeneralSecurityException {
        List<List<Object>> data = dataFromgoogle.DataFromGoogleSheet(dataFromgoogle.Loginrange);
        login(String.valueOf(data.get(4).get(0)),String.valueOf(data.get(4 ).get(1)));
        getDriver().manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        String TextAlert = loginScreen.checkAlertIsDisplayed();
        Assert.assertEquals(TextAlert,"Error\n" +
                "Invalid user credentials");
        /* à vérifier */
       /* System.out.println(loginScreen.checkErrrorMessageIsDisplayed());
        Assert.assertTrue(loginScreen.checkErrrorMessageIsDisplayed()); */
      Assert.assertEquals( loginScreen.getPageURL(), "http://staging.alm.vneuron.com/login" );

    }

    @AfterMethod()
    public void clean(){
        cleanup();
    }

}
