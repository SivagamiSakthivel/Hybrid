package TestCases_Demo_Sikuli_AutoIT.OmniFullfillment;

import PageObjects.OmniFullfillmentPage;
import autoitx4java.AutoItX;
import org.sikuli.script.*;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class AbstractTest {

    private static OmniFullfillmentPage omniFullfillmentPage;
    Screen screen=new Screen();
    AutoItX x = new AutoItX();
    Pattern imageProjectscreen = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\ItemInquiry\\Images\\Projectmyscreen.png");
    Pattern imageprojectmyscreenmax = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\ItemInquiry\\Images\\Projectmyscreenmax.png");
    Pattern imageOmniFullfillmentIcon = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\Repository\\OmniFullfillment\\OmniFullfillmentLogo.png");
    Pattern imagebackArrow = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\Repository\\backButton.png");


    public static OmniFullfillmentPage omniFulfillmentPageInstance()
    {
        if(omniFullfillmentPage == null)
            omniFullfillmentPage = new OmniFullfillmentPage();
        return omniFullfillmentPage;
    }

    @BeforeSuite(alwaysRun = true)
    public void InitBeforeSuite()
    {
    }

    //Reusable Methods

    public void waitScreen() throws FindFailed {
        screen.wait(imageProjectscreen, 10);
    }

    /*Method to Launch the application
     */
    public void LaunchApplication(Pattern iconToBeLaunched) throws FindFailed {
        screen.click(imageProjectscreen);
        screen.doubleClick(imageprojectmyscreenmax);
        ScreenImage file = screen.capture(screen.getBounds());
        screen.click(iconToBeLaunched);
    }

    /*
    Method to click an object(image)
     */
    public void click(Pattern imgToClick) throws FindFailed
    {
        Match val = screen.exists(imgToClick);
        Assert.assertTrue(val.isValid());
        screen.click(imgToClick);
    }

    /*
    Click Element using AutoIT
     */
    public void clickUsingAutoIT()
    {
        x.winWaitActive("Project My Screen App");
        x.mouseClick("left", 819, 617, 1, 1);
        x.mouseUp("left");
    }

    /*Method to verify image presence in screen
    **Input: Image to be verified
     */
    public void VerifyImagePresence(Pattern img) throws Exception
    {
        Match val = screen.exists(img);
        assert val.isValid();
        if (val.isValid()) {
            System.out.println(val);
            System.out.println(img.getFilename()+"Image present");
        }
        else {
            System.out.println("Image not loaded");
            throw new Exception("Image not loaded");
        }
    }


    /*Sikuli Functions*/
    public void CloseApp() throws FindFailed, InterruptedException {

        screen.click(imagebackArrow);
        screen.mouseDown(Button.LEFT);
        Thread.sleep(5000);
        //screen.aSwipeDown();

    }
    /* Close App With Auto It Script  **/
    public void CloseApp_AutoIT() throws IOException {

        x.winWaitActive("Project My Screen App");
        x.mouseClick("left", 753, 228, 1, 1);
        x.mouseUp("left");


    }
}
