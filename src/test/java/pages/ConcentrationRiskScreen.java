package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.AbstractPageObject;

import java.util.*;


public class ConcentrationRiskScreen extends AbstractPageObject {
    /* Filter */
    public static final String ANALYSIS_DATE_PICKER = "//*[@id=\"analysisDate\"]";
    public static final String REFERENECE_DATE_PICKER = "//*[@id=\"referenceDate\"]";
    public static final String SECTOR_SELECT_INPUT = "/html/body/app-root/app-main/div/div[1]/div/app-concentration-risk/app-concentration-risk-filter/div/div/div/div[3]/div/span/p-multiselect";
    public static final String PORTFOLIO_SELECT_INPUT = "/html/body/app-root/app-main/div/div[1]/div/app-concentration-risk/app-concentration-risk-filter/div/div/div/div[4]/div/span/p-multiselect";
    public static final String INSTRUMENT_SELECT_INPUT = "/html/body/app-root/app-main/div/div[1]/div/app-concentration-risk/app-concentration-risk-filter/div/div/div/div[5]/div/span/p-multiselect";
    public static final String EMETTEUR_SELECT_INPUT = "/html/body/app-root/app-main/div/div[1]/div/app-concentration-risk/app-concentration-risk-filter/div/div/div/div[6]/div/span/p-autocomplete/span/input";
    public static final String SEARCH_BUTTON = "/html/body/app-root/app-main/div/div[1]/div/app-concentration-risk/app-concentration-risk-filter/div/div/div/div[7]/button[2]";

    /* indicator */

    public static final String ACTION_CONCENTRATION_VALUE ="/html/body/app-root/app-main/div/div[1]/div/app-concentration-risk/div[1]/div[1]/div/div[1]/div[1]/app-indicator-card/div/div/div[1]/div[1]";
    public static final String OBLIGATION_CONCENTRATION_VALUE = "/html/body/app-root/app-main/div/div[1]/div/app-concentration-risk/div[1]/div[1]/div/div[1]/div[2]/app-indicator-card/div/div/div[1]/div[1]";
    public static final String MONITAIRE_CONCENTRATION_VALUE = "/html/body/app-root/app-main/div/div[1]/div/app-concentration-risk/div[1]/div[1]/div/div[2]/div[1]/app-indicator-card/div/div/div[1]/div[1]";
    public static final String DEPOTS_CONCENTRATION_VALUE = "/html/body/app-root/app-main/div/div[1]/div/app-concentration-risk/div[1]/div[1]/div/div[2]/div[2]/app-indicator-card/div/div/div[1]/div[1]";

    /* indicator variation */

    public static final String ACTION_CONCENTRATION_VARIATION_VALUE ="/html/body/app-root/app-main/div/div[1]/div/app-concentration-risk/div[1]/div[1]/div/div[1]/div[1]/app-indicator-card/div/div/div[1]/div[2]";
    public static final String OBLIGATION_CONCENTRATION_VARIATION_VALUE = "/html/body/app-root/app-main/div/div[1]/div/app-concentration-risk/div[1]/div[1]/div/div[1]/div[2]/app-indicator-card/div/div/div[1]/div[2]";
    public static final String MONITAIRE_CONCENTRATION_VARIATION_VALUE = "/html/body/app-root/app-main/div/div[1]/div/app-concentration-risk/div[1]/div[1]/div/div[2]/div[1]/app-indicator-card/div/div/div[1]/div[2]";
    public static final String DEPOTS_CONCENTRATION_VARIATION_VALUE = "/html/body/app-root/app-main/div/div[1]/div/app-concentration-risk/div[1]/div[1]/div/div[2]/div[2]/app-indicator-card/div/div/div[1]/div[2]";
    public static final String ARROW_VARIATION_ACTION_CONCENTRATION = "/html/body/app-root/app-main/div/div[1]/div/app-concentration-risk/div[1]/div[1]/div/div[1]/div[1]/app-indicator-card/div/div/div[1]/i";
    public static final String ARROW_VARIATION_OBLIGATION_CONCENTRATION = "/html/body/app-root/app-main/div/div[1]/div/app-concentration-risk/div[1]/div[1]/div/div[1]/div[2]/app-indicator-card/div/div/div[1]/i";
    public static final String ARROW_VARIATION_MONITAIRE_CONCENTRATION = "/html/body/app-root/app-main/div/div[1]/div/app-concentration-risk/div[1]/div[1]/div/div[2]/div[1]/app-indicator-card/div/div/div[1]/i";
    public static final String ARROW_VARIATION_DEPOTS_CONCENTRATION = "/html/body/app-root/app-main/div/div[1]/div/app-concentration-risk/div[1]/div[1]/div/div[2]/div[2]/app-indicator-card/div/div/div[1]/i";
    public static final String SPARK_LINE_ACTION_CONCENTRATION = "/html/body/app-root/app-main/div/div[1]/div/app-concentration-risk/div[1]/div[1]/div/div[1]/div[1]/app-indicator-card/div/highcharts-chart";
    public static final String SPARK_LINE_OBLIGATION_CONCENTRATION = "/html/body/app-root/app-main/div/div[1]/div/app-concentration-risk/div[1]/div[1]/div/div[1]/div[2]/app-indicator-card/div/highcharts-chart";
    public static final String SPARK_LINE_MONITAIRE_CONCENTRATION = "/html/body/app-root/app-main/div/div[1]/div/app-concentration-risk/div[1]/div[1]/div/div[2]/div[1]/app-indicator-card/div/highcharts-chart";
    public static final String SPARK_LINE_DEPOTS_CONCENTRATION = "/html/body/app-root/app-main/div/div[1]/div/app-concentration-risk/div[1]/div[1]/div/div[2]/div[2]/app-indicator-card/div/highcharts-chart";
    public static final String HHI_INDEX = "//*[@id=\"gauge\"]";



    /* Tables*/
    public static final String TABLE_ACTIF_CONCENTRATION ="/html/body/app-root/app-main/div/div[1]/div/app-concentration-risk/div[2]/div[1]/div/app-concentration-table/p-table";
    public static final String TABLE_PASSIF_CONCENTRATION = "/html/body/app-root/app-main/div/div[1]/div/app-concentration-risk/div[2]/div[2]/div/app-concentration-table/p-table";
    public static final String ACTIF_TABLE_DROPDOWN ="/html/body/app-root/app-main/div/div[1]/div/app-concentration-risk/div[2]/div[1]/div/div/p-dropdown";
    public static final String PASSIF_TABLE_DROPDOWN="/html/body/app-root/app-main/div/div[1]/div/app-concentration-risk/div[2]/div[2]/div/div/p-dropdown";

    public static final String ACTIF_TABLE_DROPDOWN_UL ="//*[@id=\"pr_id_1_list\"]";

    public static final String NUMBER_OF_GROUP_COUNTERPARTY_FOR_ACTIFTABLE = "/html/body/app-root/app-main/div/div[1]/div/app-concentration-risk/div[2]/div[1]/div/app-concentration-table/div/h6";

    public static final String NUMBER_OF_GROUP_COUNTERPARTY_FOR_PASSIFTABLE = "/html/body/app-root/app-main/div/div[1]/div/app-concentration-risk/div[2]/div[2]/div/app-concentration-table/div/h6";

    @FindBy(how = How.XPATH ,using = ANALYSIS_DATE_PICKER)
    public WebElement AnalysisDatePicker;

    @FindBy(how = How.XPATH , using = REFERENECE_DATE_PICKER)
    public WebElement ReferenceDatePicker;

    @FindBy(how = How.XPATH , using = SECTOR_SELECT_INPUT)
    public WebElement SectorSelectInput;

    @FindBy(how = How.XPATH , using = PORTFOLIO_SELECT_INPUT)
    public WebElement PortfolioSelectInput;

    @FindBy(how = How.XPATH , using = INSTRUMENT_SELECT_INPUT)
    public WebElement InstrumentSelectInput;

    @FindBy(how = How.XPATH , using = EMETTEUR_SELECT_INPUT)
    public WebElement EmetteurSelectInput;

    @FindBy(how = How.XPATH , using = SEARCH_BUTTON)
    public WebElement SearchButton ;

    @FindBy(how = How.XPATH , using = ACTION_CONCENTRATION_VALUE)
    public WebElement ActionConcentrationValue ;

    @FindBy(how = How.XPATH , using = OBLIGATION_CONCENTRATION_VALUE)
    public WebElement ObligationConcentrationValue ;

    @FindBy(how = How.XPATH , using = MONITAIRE_CONCENTRATION_VALUE)
    public WebElement MonitaireConcentrationValue ;

    @FindBy(how = How.XPATH , using = DEPOTS_CONCENTRATION_VALUE)
    public WebElement DepotsConcentrationValue ;

    @FindBy(how = How.XPATH , using = ACTION_CONCENTRATION_VARIATION_VALUE)
    public WebElement ActionConcentrationVariationValue ;

    @FindBy(how = How.XPATH , using = OBLIGATION_CONCENTRATION_VARIATION_VALUE)
    public WebElement ObligationConcentrationVariationValue ;

    @FindBy(how = How.XPATH , using = MONITAIRE_CONCENTRATION_VARIATION_VALUE)
    public WebElement MonitaireConcentrationVariationValue ;

    @FindBy(how = How.XPATH , using = DEPOTS_CONCENTRATION_VARIATION_VALUE)
    public  WebElement DepotsConcentrationVariationValue ;

    @FindBy(how = How.XPATH , using = ARROW_VARIATION_ACTION_CONCENTRATION)
    public  WebElement ArrowVariationActionConcentration ;

    @FindBy(how = How.XPATH , using = ARROW_VARIATION_OBLIGATION_CONCENTRATION)
    public  WebElement ArrowVariationObligationConcentration ;

    @FindBy(how = How.XPATH , using = ARROW_VARIATION_MONITAIRE_CONCENTRATION)
    public  WebElement ArrowVariationMonitaireConcentration ;

    @FindBy(how = How.XPATH , using = ARROW_VARIATION_DEPOTS_CONCENTRATION)
    public  WebElement ArrowVariationDepotsConcentration ;

    @FindBy(how = How.XPATH , using = SPARK_LINE_ACTION_CONCENTRATION)
    public  WebElement SparkLineActionConcentration ;

    @FindBy(how = How.XPATH , using = SPARK_LINE_OBLIGATION_CONCENTRATION)
    public  WebElement SparkLineObligationConcentration ;

    @FindBy(how = How.XPATH , using = SPARK_LINE_MONITAIRE_CONCENTRATION)
    public  WebElement SparkLineMonitaireConcentration ;

    @FindBy(how = How.XPATH , using = SPARK_LINE_DEPOTS_CONCENTRATION)
    public  WebElement SparkLineDepotsConcentration ;

    @FindBy(how = How.XPATH , using = HHI_INDEX)
    public  WebElement HHIIndex ;

    @FindBy(how = How.XPATH , using = TABLE_ACTIF_CONCENTRATION)
    public  WebElement TableActifConcentration ;

    @FindBy(how = How.XPATH , using = TABLE_PASSIF_CONCENTRATION)
    public  WebElement TablePassifConcentration ;

    @FindBy(how = How.XPATH , using = ACTIF_TABLE_DROPDOWN)
    public  WebElement ActifTableDropDown ;

    @FindBy(how = How.XPATH , using = PASSIF_TABLE_DROPDOWN)
    public  WebElement PassifTableDropDown ;

    @FindBy(how = How.XPATH , using = NUMBER_OF_GROUP_COUNTERPARTY_FOR_ACTIFTABLE)
    public  WebElement numberOfGroupCounterpartyForActifTable ;

    @FindBy(how = How.XPATH , using = NUMBER_OF_GROUP_COUNTERPARTY_FOR_PASSIFTABLE)
    public  WebElement numberOfGroupCounterpartyForPassifTable ;






    public void enteranalysisdate(String date) throws InterruptedException {
        Thread.sleep(1000);
        AnalysisDatePicker.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        //Thread.sleep(3000);
        AnalysisDatePicker.sendKeys(date);
        AnalysisDatePicker.click();
    }
    public void enterreferencedate(String date) throws InterruptedException {
        Thread.sleep(1000);
        ReferenceDatePicker.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        //Thread.sleep(3000);
        ReferenceDatePicker.sendKeys(date);
        ReferenceDatePicker.click();
    }



    public void chooseSector(String... options) throws InterruptedException {
        Thread.sleep(1000);
        SectorSelectInput.click();
        Thread.sleep(1000);
        for(String option : options) {
            driver.findElement(By.xpath("//li[@aria-label=\"" +option+ "\"]")).click();
        }
        Thread.sleep(2000);
        SectorSelectInput.click();
    }

    public void choosePortfolio(String... options) throws InterruptedException {
        Thread.sleep(1000);
        PortfolioSelectInput.click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//p-multiselect[@inputid='portfolio']//p-multiselectitem/li[@aria-label='G']")).click();
        for(String option : options) {
            driver.findElement(By.xpath("//p-multiselect[@inputid='portfolio']//p-multiselectitem/li[@aria-label='" +option+ "']")).click();
        }
        Thread.sleep(2000);
        PortfolioSelectInput.click();
    }

    public void chooseInstrument(String... options) throws InterruptedException {
        Thread.sleep(9000);
        Thread.sleep(9000);
        Thread.sleep(9000);
        Thread.sleep(9000);

        InstrumentSelectInput.click();
        Thread.sleep(1000);
        for(String option : options) {
           // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@aria-label=\"" +option+ "\"]")));
            driver.findElement(By.xpath("//li[@aria-label=\"" +option+ "\"]")).click();
        }
        Thread.sleep(2000);
        InstrumentSelectInput.click();
    }

    public void chooseEmetteur(String... options) throws InterruptedException {
        Thread.sleep(1000);
        EmetteurSelectInput.sendKeys(options);
       /* Thread.sleep(1000);
        for(String option : options) {
            driver.findElement(By.xpath("//li[@aria-label=\"" +option+ "\"]")).click();
        }
        Thread.sleep(2000); */
    }

    public void clickSearchButton() throws InterruptedException {
        Thread.sleep(1000);
        SearchButton.click();
    }


    public String getElementValue (WebElement variable) throws InterruptedException {
        Thread.sleep(2000);
        return variable.getText();
    }


    public String getElementColor(WebElement variable){
        String s = variable.getCssValue("color");
        String c = Color.fromString(s).asHex();
        return c;
    }

    public String getElementCssClass (WebElement variable){

        return variable.getAttribute("class");
    }

    public Boolean elementIsDisplayed (WebElement variable){



        return variable.isDisplayed();
    }

    public String verify_HHI_Index(){
       return HHIIndex.getAttribute("color");

    }

    public List<String> verifyTableActifConcentrationValues(){
        List<WebElement> allRows = TableActifConcentration.findElements(By.tagName("tr"));
        //And iterate over them, getting the cells
        List<String> dataTable = new ArrayList<>();
        for (WebElement row : allRows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            //Print the contents of each cell
            for (WebElement cell : cells) {
                dataTable.add(cell.getText());
            }

    }

         return dataTable;
    }

    public List<String> verifyTablePassifConcentrationValues(){
        List<WebElement> allRows = TablePassifConcentration.findElements(By.tagName("tr"));

        //And iterate over them, getting the cells
        List<String> dataTable = new ArrayList<>();
        for (WebElement row : allRows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            //Print the contents of each cell

            for (WebElement cell : cells) {


                dataTable.add(cell.getText());

            }

        }

        return dataTable;
    }

    public void chooseGroupOrCounterpartyActif(String option) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,450)", "");
        Thread.sleep(2000);
        ActifTableDropDown.click();
        Thread.sleep(3000);
        //ActifTableDropdownUl.click();
        //Thread.sleep(2000);
        List<WebElement> options = getDriver().findElements(By.xpath("//ul//p-dropdownitem//li"));
        for (WebElement op : options){
            WebElement categSpan = op.findElement(By.tagName("span"));
            String categText = categSpan.getText().trim();
            if (option.equalsIgnoreCase(categText)) {
                op.click();
                Thread.sleep(5000);
            }
        }



    }


    public void chooseGroupOrCounterpartyPassif(String option) throws InterruptedException {
        /*JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,450)", "");*/
        PassifTableDropDown.click();
        Thread.sleep(3000);
        //ActifTableDropdownUl.click();
        //Thread.sleep(2000);
        List<WebElement> options = getDriver().findElements(By.xpath("//ul//p-dropdownitem//li"));
        for (WebElement op : options) {
            WebElement categSpan = op.findElement(By.tagName("span"));
            String categText = categSpan.getText().trim();
            if (option.equalsIgnoreCase(categText)) {
                op.click();
                Thread.sleep(5000);
            }
        }



    }

    public List<String> VerifyIndustriesDistributionChartElements () throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        //js.executeScript("window.scrollBy(0.350)", "");
        //js.executeScript("arguments[0].scrollIntoView();", variable);
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(9000);
        List<WebElement> ElementOfTheChart = getDriver().findElements(By.xpath("//highcharts-chart[@role='region' and @aria-label='Industries distribution by rate index. Highcharts interactive chart.']/*[name()='div' and @class='highcharts-container ']/*[name()='svg']/*[name()='g' and @class='highcharts-series-group']/*[name()='g']/*[name()='path']"));
        Actions act = new Actions(getDriver());
        List<WebElement> list = new ArrayList<>();
        List<String> LabelOfElementsofTheChart = new ArrayList<>();

        list.addAll(ElementOfTheChart);
        //list.addAll(ElementOfTheChart);
        for (WebElement e : list){
            Thread.sleep(4000);
            act.moveToElement(e).perform();
            Thread.sleep(500);

           String text = getDriver().findElement(By.xpath("//highcharts-chart[@role='region' and @aria-label='Industries distribution by rate index. Highcharts interactive chart.']/*[name()='div' and @class='highcharts-container ']/*[name()='svg']/*[name()='g' and @style='cursor:default;white-space:nowrap;pointer-events:none;']//*[name()='text']")).getText();
           LabelOfElementsofTheChart.add(text);
        }

        return LabelOfElementsofTheChart;

    }

    public List<String> VerifyRateWeightChartElements () throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,30);

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(4000);

        List<WebElement> ElementOfTheChart = getDriver().findElements(By.xpath("//highcharts-chart[@role='region' and @aria-label='Rate Weight. Highcharts interactive chart.']/*[name()='div' and @class='highcharts-container ']/*[name()='svg']/*[name()='g' and @class='highcharts-series-group']/*[name()='g']/*[name()='path']"));
        Actions act = new Actions(getDriver());
        List<String> LabelOfElementsofTheChart = new ArrayList<>();
        for (WebElement e : ElementOfTheChart){
            Thread.sleep(4000);
            act.moveToElement(e).perform();
            Thread.sleep(4000);
            String text = e.getAttribute("aria-label");
            LabelOfElementsofTheChart.add(text);
        }

        return LabelOfElementsofTheChart;

    }



    public List<String> VerifyIndustriesDistributionChartlegend () throws InterruptedException {
        List<String> Elements = new ArrayList<>();
        List<String> ElementsColor = new ArrayList<>();
        //JavascriptExecutor js = (JavascriptExecutor) getDriver();
        //js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(5000);
        List<WebElement> ElementOfTheChart = getDriver().findElements(By.xpath("//highcharts-chart[@role='region' and @aria-label='Industries distribution by rate index. Highcharts interactive chart.']/*[name()='div' and @class='highcharts-container ']/*[name()='div' and @class='highcharts-a11y-proxy-container-after']/*[name()='div' and @class='highcharts-a11y-proxy-group highcharts-a11y-proxy-group-legend']/ul/li/button"));
        for (WebElement e : ElementOfTheChart){
            Elements.add((e.getAttribute("aria-label")).replace("Show ",""));

        }


        return Elements;


    }

    public void chooseAssetOrLiabilityFromsectorChart(String option) throws InterruptedException {

        Thread.sleep(2000);
        List<WebElement> options = getDriver().findElements(By.xpath("//app-concentration-industries-chart/div/div/p-tabmenu/div/ul/li/a"));
        for (WebElement op : options) {
            WebElement categSpan = op.findElement(By.tagName("span"));
            String categText = categSpan.getText().trim();
            if (option.equalsIgnoreCase(categText)) {
                op.click();
                Thread.sleep(5000);
            }
        } }









}
