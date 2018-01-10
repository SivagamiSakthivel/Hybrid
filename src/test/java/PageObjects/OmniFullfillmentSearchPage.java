package PageObjects;

import TestCases_Demo_Sikuli_AutoIT.OmniFullfillment.AbstractTest;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.testng.Assert;

public class OmniFullfillmentSearchPage extends AbstractTest
{
    AbstractTest base=new AbstractTest();

    Pattern imageOmniFullfillmentIcon = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\Repository\\OmniFullfillment\\OmniFullfillmentLogo.png");
    Pattern imageDetailsIcon = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\Repository\\OmniFullfillment\\SearchPage\\DetailsIcon.png");
    Pattern imagePrinterSettings = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\Repository\\OmniFullfillment\\SearchPage\\PrinterSettings.png");
    Pattern imageVersionNumber = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\Repository\\OmniFullfillment\\SearchPage\\VersionNumber.png");
    Pattern imageReportIssue = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\Repository\\OmniFullfillment\\SearchPage\\ReportIssue.png");
    Pattern imageStartDiagnostics = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\Repository\\OmniFullfillment\\SearchPage\\StartDiagnostics.png");


    public void waitTillPageLoad() throws FindFailed
    {
        try
        {
            base.waitScreen();
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    public void LaunchOmniFullfillment() throws Exception
    {
        try{

        base.LaunchApplication(imageOmniFullfillmentIcon);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public void CloseOmniFullfillment() throws Exception
    {
        try
        {
       base.CloseApp();
       base.CloseApp_AutoIT();
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

    }
    public void Validate_SearchPage_Contents() throws FindFailed,Exception
    {
        try
        {
        Thread.sleep(10000);
        base.clickUsingAutoIT();
        base.VerifyImagePresence(imagePrinterSettings);
        base.VerifyImagePresence(imageVersionNumber);
        base.VerifyImagePresence(imageReportIssue);
        base.VerifyImagePresence(imageStartDiagnostics);
        }
//        catch (Exception ex)
//        {
//            System.out.println(ex.getMessage());
//            throw new Exception("xxxxxx");
//        }
        catch (FindFailed findFailed)
        {
            System.out.println(findFailed.getMessage());
            throw new Exception("xxxxxx");
        }
    }
}
