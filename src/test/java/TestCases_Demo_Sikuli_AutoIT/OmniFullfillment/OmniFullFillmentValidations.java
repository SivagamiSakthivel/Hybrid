package TestCases_Demo_Sikuli_AutoIT.OmniFullfillment;

import PageObjects.OmniFullfillmentPage;
import com.jacob.com.LibraryLoader;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;


public class OmniFullFillmentValidations {


    OmniFullfillmentPage OFS = new OmniFullfillmentPage();


    @Test
    public void TC_01_ValidateHomeScreen() throws FindFailed, InterruptedException, IOException,Exception {
        try {
            String jacobDllVersionToUse;
            if (System.getProperty("sun.arch.data.model").contains("32")) {
                jacobDllVersionToUse = "jacob-1.18-x86.dll";
            } else {
                jacobDllVersionToUse = "jacob-1.18-x64.dll";
            }

            File file = new File("src\\main\\resources\\Lib", jacobDllVersionToUse);
            System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());
            OFS.waitScreen();
            OFS.LaunchApplication();
            OFS.Validate();

        } catch (FindFailed ex) {
            throw new FindFailed(ex.getMessage());
        }
//        catch (IOException e) {
//           // e.printStackTrace();
//            throw new IOException(e.getMessage());
//        }
        finally {
            OFS.CloseApp();
            OFS.CloseApp_AutoIT();
        }
    }
}





