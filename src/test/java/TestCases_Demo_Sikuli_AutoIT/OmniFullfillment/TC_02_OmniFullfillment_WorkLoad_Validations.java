package TestCases_Demo_Sikuli_AutoIT.OmniFullfillment;
import PageObjects.OmniFullfillmentPage;
import PageObjects.WorkLoadSummaryPage;
import com.jacob.com.LibraryLoader;
import org.junit.*;
import org.sikuli.script.FindFailed;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
public class TC_02_OmniFullfillment_WorkLoad_Validations {

    WorkLoadSummaryPage WLS=new WorkLoadSummaryPage();

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
    public void Validate_WorkLoadSummary() throws Exception
    {
        try
        {
            WLS.waitScreen();
            WLS.LaunchApplication();
            WLS.ValidateWorkLoad_Details();
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
@AfterTest
    public void closeApp() throws Exception
    {
        WLS.CloseApp();
        WLS.CloseApp_AutoIT();
    }

}
