package TestCases_Demo_Sikuli_AutoIT.OmniFullfillment;

import PageObjects.OmniFullfillmentSearchPage;
import PageObjects.WorkLoadSummaryPage;
import com.jacob.com.LibraryLoader;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class TC_03_OmniFullfillment_SearchPage_Validations{

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
    }

    @Test
    public void Validate_SearchPage() throws Exception
    {
        try
        {
            search.waitTillPageLoad();
            search.LaunchOmniFullfillment();
            search.Validate_SearchPage_Contents();
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    @AfterTest
    public void closeApp() throws Exception
    {
        search.CloseOmniFullfillment();
    }
}
