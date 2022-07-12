package testdata;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class DataFromGoogleSheet {

    public String AnalysisDaterange = "AnalysisDate!A1:A11";
    public String ReferenceDaterange = "ReferenceDate!A1:A16";
    public String Sectorrange = "Sector!A1:A16";
    public String Portfoliorrange = "Portfolio!A1:A7";
    public String Instrumentrange = "Instrument!A1:A7";
    public String Emetteurrange = "Emetteur!A1:A7";
    public String Loginrange = "login!A2:C6";
    public String Concentrationrange = "ConcentrationValues!A1:E7";
    public String VariationConcentrationrange = "VariationConcentration!A1:E5";
    public String ConcentrationSurLesActifsrange = "ConcentrationSurLesActifs!A2:D6";
    public String ConcentrationSurLesPassifsrange = "ConcentrationSurLesPassifs!A2:D6";

    public String ConcentrationSurLesActifsGrouprange = "ConcentrationSurLesActifs!A8:D13";

    public String ConcentrationSurLesPassifsGrouprange = "ConcentrationSurLesPassifs!A8:D13";


    public String ChartSectorrangeForAsset = "SectorChart!A1:A4";

    public String ChartSectorrangeForLiability = "SectorChart!C1:C4";

    public String ChartRateWeightrangeForAsset = "RateWeightChart!A1:A2";

    public String ChartRateWeightrangeForLiability = "RateWeightChart!C1:C2";



    public List<List<Object>> DataFromGoogleSheet(String range) throws GeneralSecurityException, IOException {
        GoogleSheetAPI sheetAPI = new GoogleSheetAPI();
        List<List<Object>> values = sheetAPI.getData(range);
        return  values;
    }


}
