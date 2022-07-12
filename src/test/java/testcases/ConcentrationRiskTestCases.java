package testcases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.ConcentrationRiskScreen;
import pages.LoginScreen;
import pages.Menu;
import testdata.DataFromGoogleSheet;
import utilities.BaseFile;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.*;
import java.util.stream.Collectors;

public class ConcentrationRiskTestCases extends BaseFile {




    Menu menu ;
    LoginScreen loginScreen;
    ConcentrationRiskScreen concentrationRiskScreen;
    DataFromGoogleSheet dataFromgoogle = new DataFromGoogleSheet();

    List<List<Object>> data =  dataFromgoogle.DataFromGoogleSheet(dataFromgoogle.AnalysisDaterange);
    List<List<Object>> data2 = dataFromgoogle.DataFromGoogleSheet(dataFromgoogle.ReferenceDaterange);
    List<List<Object>> data3 = dataFromgoogle.DataFromGoogleSheet(dataFromgoogle.Sectorrange);
    List<List<Object>> data4 = dataFromgoogle.DataFromGoogleSheet(dataFromgoogle.Portfoliorrange);
    List<List<Object>> data5 = dataFromgoogle.DataFromGoogleSheet(dataFromgoogle.Instrumentrange);
    List<List<Object>> data6 = dataFromgoogle.DataFromGoogleSheet(dataFromgoogle.Emetteurrange);
    List<List<Object>> data7 = dataFromgoogle.DataFromGoogleSheet(dataFromgoogle.Concentrationrange);
    List<List<Object>> data8 = dataFromgoogle.DataFromGoogleSheet(dataFromgoogle.VariationConcentrationrange);
    List<List<Object>> data9 = dataFromgoogle.DataFromGoogleSheet(dataFromgoogle.ConcentrationSurLesActifsrange);
    List<List<Object>> data10 = dataFromgoogle.DataFromGoogleSheet(dataFromgoogle.ConcentrationSurLesPassifsrange);
    List<List<Object>> data11 = dataFromgoogle.DataFromGoogleSheet(dataFromgoogle.ChartSectorrangeForAsset);

    List<List<Object>> data12 = dataFromgoogle.DataFromGoogleSheet(dataFromgoogle.ConcentrationSurLesActifsGrouprange);

    List<List<Object>> data13 = dataFromgoogle.DataFromGoogleSheet(dataFromgoogle.ConcentrationSurLesPassifsGrouprange);

    List<List<Object>> data14 = dataFromgoogle.DataFromGoogleSheet(dataFromgoogle.ChartSectorrangeForLiability);

    List<List<Object>> data15 = dataFromgoogle.DataFromGoogleSheet(dataFromgoogle.ChartRateWeightrangeForAsset);


    List<List<Object>> data16 = dataFromgoogle.DataFromGoogleSheet(dataFromgoogle.ChartRateWeightrangeForLiability);





    public ConcentrationRiskTestCases() throws GeneralSecurityException, IOException {
    }


    @BeforeMethod()
    public void start() throws GeneralSecurityException, IOException, InterruptedException {
        loadConfig();
        startApp();
        loginScreen = new LoginScreen();
        loginScreen.loginForTest();
        menu = new Menu();
        menu.enterConcentrationRiskScreen();

    }
    @Test(priority = 2)
    public void Filtre1 () throws InterruptedException, GeneralSecurityException, IOException {

        concentrationRiskScreen = new ConcentrationRiskScreen();
        Thread.sleep(9000);
        concentrationRiskScreen.enteranalysisdate(String.valueOf(data.get(0).get(0)));
        Thread.sleep(9000);
        concentrationRiskScreen.enterreferencedate(String.valueOf(data2.get(0).get(0)));
        Thread.sleep(9000);
        concentrationRiskScreen.chooseInstrument(String.valueOf(data5.get(0).get(0)),String.valueOf(data5.get(1).get(0)),String.valueOf(data5.get(2).get(0)),String.valueOf(data5.get(3).get(0)),String.valueOf(data5.get(4).get(0)));
        Thread.sleep(2000);
        concentrationRiskScreen.chooseSector(String.valueOf(data3.get(0).get(0)),String.valueOf(data3.get(1).get(0)),String.valueOf(data3.get(2).get(0)),String.valueOf(data3.get(3).get(0)));
        Thread.sleep(2000);
        concentrationRiskScreen.choosePortfolio(String.valueOf(String.valueOf(data4.get(2).get(0))),String.valueOf(String.valueOf(data4.get(0).get(0))));
        Thread.sleep(2000);
        concentrationRiskScreen.chooseEmetteur(String.valueOf(data6.get(1).get(0)));
        Thread.sleep(2000);
        concentrationRiskScreen.clickSearchButton();
        Thread.sleep(5000);



        /* Concentration Par Action */
        Assert.assertEquals(concentrationRiskScreen.getElementValue(concentrationRiskScreen.ActionConcentrationValue),String.valueOf(data7.get(1).get(1)));
        Thread.sleep(1000);
        Assert.assertEquals(concentrationRiskScreen.getElementValue(concentrationRiskScreen.ActionConcentrationVariationValue),String.valueOf(data8.get(1).get(1)));
        Thread.sleep(1000);
        Assert.assertEquals(concentrationRiskScreen.getElementColor(concentrationRiskScreen.ActionConcentrationVariationValue),"#ffc102");
        Thread.sleep(1000);
        Assert.assertTrue((concentrationRiskScreen.getElementCssClass(concentrationRiskScreen.ArrowVariationActionConcentration)).contains("variation-stable"));
        Thread.sleep(1000);
        Assert.assertTrue(concentrationRiskScreen.elementIsDisplayed(concentrationRiskScreen.SparkLineActionConcentration));

        /* Concentration Par Obligation */
        Assert.assertEquals(concentrationRiskScreen.getElementValue(concentrationRiskScreen.ObligationConcentrationValue),String.valueOf(data7.get(1).get(2)));
        Thread.sleep(2000);
        Assert.assertEquals(concentrationRiskScreen.getElementValue(concentrationRiskScreen.ObligationConcentrationVariationValue),String.valueOf(data8.get(1).get(2)));
        Thread.sleep(2000);
        Assert.assertEquals(concentrationRiskScreen.getElementColor(concentrationRiskScreen.ObligationConcentrationVariationValue),"#ffc102");
        Thread.sleep(2000);
        Assert.assertTrue((concentrationRiskScreen.getElementCssClass(concentrationRiskScreen.ArrowVariationObligationConcentration)).contains("variation-stable"));
        Thread.sleep(2000);
        Assert.assertTrue(concentrationRiskScreen.elementIsDisplayed(concentrationRiskScreen.SparkLineObligationConcentration));




        /* Concentration Marché Monitaire */
        Assert.assertEquals(concentrationRiskScreen.getElementValue(concentrationRiskScreen.MonitaireConcentrationValue),String.valueOf(data7.get(1).get(3)));
        Thread.sleep(2000);
        Assert.assertEquals(concentrationRiskScreen.getElementValue(concentrationRiskScreen.MonitaireConcentrationVariationValue),String.valueOf(data8.get(1).get(3)));
        Thread.sleep(2000);
        Assert.assertEquals(concentrationRiskScreen.getElementColor(concentrationRiskScreen.MonitaireConcentrationVariationValue),"#ffc102");
        Thread.sleep(2000);
        Assert.assertTrue((concentrationRiskScreen.getElementCssClass(concentrationRiskScreen.ArrowVariationMonitaireConcentration)).contains("variation-stable"));
        Thread.sleep(2000);
        Assert.assertTrue(concentrationRiskScreen.elementIsDisplayed(concentrationRiskScreen.SparkLineMonitaireConcentration));



        /* Concentration Des Depôts */
        Assert.assertEquals(concentrationRiskScreen.getElementValue(concentrationRiskScreen.DepotsConcentrationValue),String.valueOf(data7.get(1).get(4)));
        Thread.sleep(1000);
        Assert.assertEquals(concentrationRiskScreen.getElementValue(concentrationRiskScreen.DepotsConcentrationVariationValue),String.valueOf(data8.get(1).get(4)));
        Thread.sleep(1000);
        Assert.assertEquals(concentrationRiskScreen.getElementColor(concentrationRiskScreen.DepotsConcentrationVariationValue),"#ffc102");
        Thread.sleep(1000);
        Assert.assertTrue((concentrationRiskScreen.getElementCssClass(concentrationRiskScreen.ArrowVariationDepotsConcentration)).contains("variation-stable"));
        Thread.sleep(1000);
        Assert.assertTrue(concentrationRiskScreen.elementIsDisplayed(concentrationRiskScreen.SparkLineDepotsConcentration));
        Thread.sleep(1000);
        /* Indice HHI /*

         */

        /* Tableaux Actif*/
        if (data9 != null ){
            Thread.sleep(1000);
            List<String> newdata9 = data9.stream().flatMap(List::stream).map(object -> Objects.toString(object, null)).collect(Collectors.toList());
            Collections.sort(newdata9);
            List<String> DataFromTableActifSorted = concentrationRiskScreen.verifyTableActifConcentrationValues();
            Collections.sort(DataFromTableActifSorted);
            Assert.assertEquals(DataFromTableActifSorted,newdata9);
            Thread.sleep(2000);
            Assert.assertEquals(Integer.parseInt(concentrationRiskScreen.getElementValue(concentrationRiskScreen.numberOfGroupCounterpartyForActifTable).replace(" Counterparts","")),data9.size()); }
        else {
            //log
            //Assert.assertEquals( concentrationRiskScreen.verifyTableActifConcentrationValues(), null);
            Assert.assertEquals(Integer.parseInt(concentrationRiskScreen.getElementValue(concentrationRiskScreen.numberOfGroupCounterpartyForActifTable).replace(" Counterparts","")),0); }

        // Group SWITCH
        concentrationRiskScreen.chooseGroupOrCounterpartyActif("Group");

        if ( data12 != null ) {
            List<String> newdata12 = data12.stream().flatMap(List::stream).map(object -> Objects.toString(object, null)).collect(Collectors.toList());
            Collections.sort(newdata12);
            List<String> DataFromTableActifSortedG = concentrationRiskScreen.verifyTableActifConcentrationValues();
            Collections.sort(DataFromTableActifSortedG);
            Assert.assertEquals(DataFromTableActifSortedG,newdata12);
            Thread.sleep(2000);
            Assert.assertEquals(Integer.parseInt(concentrationRiskScreen.getElementValue(concentrationRiskScreen.numberOfGroupCounterpartyForPassifTable).replace(" Counterparts","")),data10.size());
            Thread.sleep(2000); }
        else {
            //log hne w akhw
            // Assert.assertEquals( concentrationRiskScreen.verifyTableActifConcentrationValues() , []);
            Assert.assertEquals(Integer.parseInt(concentrationRiskScreen.getElementValue(concentrationRiskScreen.numberOfGroupCounterpartyForActifTable).replace(" Counterparts","")),0); }



        /* Tableaux Passif*/
        if (data10 != null) {
            Thread.sleep(1000);
            List<String> newdata10 = data10.stream().flatMap(List::stream).map(object -> Objects.toString(object, null)).collect(Collectors.toList());
            Collections.sort(newdata10);
            List<String> DataFromTablePassifSorted = concentrationRiskScreen.verifyTablePassifConcentrationValues();
            Collections.sort(DataFromTablePassifSorted);
            Assert.assertEquals(DataFromTablePassifSorted,newdata10);
            Thread.sleep(2000);
            Assert.assertEquals(Integer.parseInt(concentrationRiskScreen.getElementValue(concentrationRiskScreen.numberOfGroupCounterpartyForPassifTable).replace(" Counterparts","")),data10.size()); }
        else {
            //log
            //Assert.assertEquals( concentrationRiskScreen.verifyTablePassifConcentrationValues() , null);
            Assert.assertEquals(Integer.parseInt(concentrationRiskScreen.getElementValue(concentrationRiskScreen.numberOfGroupCounterpartyForPassifTable).replace(" Counterparts","")),0); }


        // Group SWITCH
        concentrationRiskScreen.chooseGroupOrCounterpartyPassif("Group");
        if (data13 != null) {
            List<String> newdata13 = data13.stream().flatMap(List::stream).map(object -> Objects.toString(object, null)).collect(Collectors.toList());
            System.out.println(newdata13);
            Collections.sort(newdata13);
            List<String> DataFromTablePassifSortedG = concentrationRiskScreen.verifyTablePassifConcentrationValues();
            Collections.sort(DataFromTablePassifSortedG);
            Assert.assertEquals(DataFromTablePassifSortedG,newdata13);
            Thread.sleep(2000);
            Assert.assertEquals(Integer.parseInt(concentrationRiskScreen.getElementValue(concentrationRiskScreen.numberOfGroupCounterpartyForPassifTable).replace(" Counterparts","")),data10.size());
            Thread.sleep(2000);  }
        else {
            //log
            //Assert.assertEquals( concentrationRiskScreen.verifyTablePassifConcentrationValues() , null);
            Assert.assertEquals(Integer.parseInt(concentrationRiskScreen.getElementValue(concentrationRiskScreen.numberOfGroupCounterpartyForPassifTable).replace(" Counterparts","")),0); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        //chart des secteur [comparaison données googlesheet avec chart ]
        List<String> newdata3 = data3.stream().flatMap(List::stream).map(object -> Objects.toString(object, null)).collect(Collectors.toList());
        List<String> ChartLabel = concentrationRiskScreen.VerifyIndustriesDistributionChartElements();
        List<String > newChartLabel = new ArrayList<>();
        List<String > newValuesOfChat = new ArrayList<>();
        for (String text : ChartLabel){
            int i =  text.indexOf("Rate");
            String newtext = text.substring(2,i);
            newChartLabel.add(newtext); }
        Collections.sort(newChartLabel);
        Collections.sort(newdata3);
        Assert.assertEquals(newChartLabel,newdata3);
        /// chart des secteurs [comapraison des valeus de la chart avec les secteurs qui sont entré au début]
        for (String text : ChartLabel){
            int i =  text.indexOf("Rate");
            String text1 = text.replace("Rate","");
            String text2 = text1.substring(2,text1.length());
            newValuesOfChat.add(text2); }
        List<String> newdata11 = data11.stream().flatMap(List::stream).map(object -> Objects.toString(object, null)).collect(Collectors.toList());
        Collections.sort(newdata11);
        Collections.sort(newValuesOfChat);
        Assert.assertEquals(newValuesOfChat,newdata11);
        //chart des secteur [comparaison données chart avec legend ]
        List<String> chartlegend = concentrationRiskScreen.VerifyIndustriesDistributionChartlegend();
        Collections.sort(chartlegend);
        Assert.assertEquals(newChartLabel,chartlegend);
        newChartLabel.clear();
        newValuesOfChat.clear();
        //// switch to the other chart
        List<String> newdata15 = data15.stream().flatMap(List::stream).map(object -> Objects.toString(object, null)).collect(Collectors.toList());
        List<String> ChartLabelRateWeight = concentrationRiskScreen.VerifyRateWeightChartElements();
        List<String > newChartLabelRateWeight = new ArrayList<>();
        for (String text : ChartLabelRateWeight){
            int i =  text.indexOf("y: ");
            int j =  text.indexOf(", z");
            String newtext = text.substring(i-3,j-1);
            String newtext1 = newtext.replace(", y: "," : ").concat("%");;
            newChartLabelRateWeight.add(newtext1); }
        Collections.sort(newdata15);
        Collections.sort(newChartLabelRateWeight);
        Assert.assertEquals(newChartLabelRateWeight,newdata15);
        ChartLabelRateWeight.clear();
        newChartLabelRateWeight.clear();

        Thread.sleep(4000);
        concentrationRiskScreen.chooseAssetOrLiabilityFromsectorChart("Liability");
        Thread.sleep(4000);

        List<String> ChartLabelLiability = concentrationRiskScreen.VerifyIndustriesDistributionChartElements();
        for (String text : ChartLabel){
            int i =  text.indexOf("Rate");
            String newtext = text.substring(2,i);
            newChartLabel.add(newtext); }
        Collections.sort(newChartLabel);
        Collections.sort(newdata3);
        Assert.assertEquals(newChartLabel,newdata3);
        /// chart des secteurs [comapraison des valeus de la chart avec les secteurs qui sont entré au début]
        for (String text : ChartLabel){
            int i =  text.indexOf("Rate");
            String text1 = text.replace("Rate","");
            String text2 = text1.substring(2,text1.length());
            newValuesOfChat.add(text2); }
        List<String> newdata14 = data14.stream().flatMap(List::stream).map(object -> Objects.toString(object, null)).collect(Collectors.toList());
        Collections.sort(newdata14);
        Collections.sort(newValuesOfChat);
        Assert.assertEquals(newValuesOfChat,newdata11);
        //chart des secteur [comparaison données chart avec legend ]
        List<String> chartlegendLiability = concentrationRiskScreen.VerifyIndustriesDistributionChartlegend();
        Collections.sort(chartlegendLiability);
        Assert.assertEquals(newChartLabel,chartlegendLiability);

        Thread.sleep(4000);
        ChartLabelRateWeight = concentrationRiskScreen.VerifyRateWeightChartElements();
        List<String> newdata16 = data16.stream().flatMap(List::stream).map(object -> Objects.toString(object, null)).collect(Collectors.toList());
        System.out.println(ChartLabelRateWeight);
        for (String text : ChartLabelRateWeight){
            int i =  text.indexOf("y: ");
            int j =  text.indexOf(", z");
            String newtext = text.substring(i-3,j);
            String newtext1 = newtext.replace(", y: "," : ").concat("%");
            newChartLabelRateWeight.add(newtext1); }
        Collections.sort(newdata16);
        Collections.sort(newChartLabelRateWeight);
        System.out.println(newChartLabelRateWeight);
        Assert.assertEquals(newChartLabelRateWeight,newdata16);







    }




    @Test(priority = 1)
    public void test(){
        System.out.println("test");
    }





    @AfterMethod()
    public void clean(){
        cleanup();
    }


}
