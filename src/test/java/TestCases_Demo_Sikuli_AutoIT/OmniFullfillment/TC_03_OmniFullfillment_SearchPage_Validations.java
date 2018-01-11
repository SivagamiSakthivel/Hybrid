package TestCases_Demo_Sikuli_AutoIT.OmniFullfillment;

import ExtendReport.ExtendReportManager;
import PageObjects.OmniFullfillmentSearchPage;
import PageObjects.WorkLoadSummaryPage;
import com.jacob.com.LibraryLoader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class TC_03_OmniFullfillment_SearchPage_Validations extends ExtendReportManager{

    OmniFullfillmentSearchPage search=new OmniFullfillmentSearchPage();

    @BeforeTest
    public void Initialise()
    {
        String jacobDllVersionToUse;
        if (System.getProperty("sun.arch.data.model").contains("32")) {
            jacobDllVersionToUse = "jacob-1.18-x86.dll";
        } else {
            jacobDllVersionToUse = "jacob-1.18-x64.dll";
        }

        File file = new File("src\\main\\resources\\Lib", jacobDllVersionToUse);
        System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());

        extent=new ExtentReports("D://MyExtendReport.html",true);
        extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
        logger=extent.startTest(("Validate Serach Page of OmniFullfillment"));
       // logger=extent.startTest((this.getClass().getSimpleName()+"::"+method.getName()),method.getName());
    }

    @Test
    public void Validate_SearchPage() throws Exception
    {
        try
        {
            search.waitTillPageLoad();
            search.LaunchOmniFullfillment();
            search.Validate_SearchPage_Contents();
            logger.log(LogStatus.PASS,"Test Case Passed");
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            logger.log(LogStatus.FAIL,"Test Case Failed");
        }
    }
    @AfterTest
    public void closeApp() throws Exception
    {
        search.CloseOmniFullfillment();
    }
}
