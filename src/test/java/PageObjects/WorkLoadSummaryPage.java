package PageObjects;


import autoitx4java.AutoItX;
import org.sikuli.script.*;

import java.io.IOException;

public class WorkLoadSummaryPage  {

    Screen screen = new Screen();

    Pattern imageProjectscreen = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\ItemInquiry\\Images\\Projectmyscreen.png");
    Pattern imageprojectmyscreenmax = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\ItemInquiry\\Images\\Projectmyscreenmax.png");
    Pattern imageOmniFullfillmentIcon = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\Repository\\OmniFullfillment\\OmniFullfillmentLogo.png");
    Pattern imagebackArrow = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\Repository\\backButton.png");

    Pattern imageAwaitingPick = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\Repository\\OmniFullfillment\\WorkLoadSummary\\AwaitingPick.png");
    Pattern imagePacked = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\Repository\\OmniFullfillment\\WorkLoadSummary\\Packed.png");
    Pattern imagePackInProgress = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\Repository\\OmniFullfillment\\WorkLoadSummary\\PackInProgress.png");
    Pattern imagePickCompleted = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\Repository\\OmniFullfillment\\WorkLoadSummary\\PickCompleted.png");
    Pattern imagePickInProgress = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\Repository\\OmniFullfillment\\WorkLoadSummary\\PickInProgress.png");
    Pattern imageReadyForCustomerPickup = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\Repository\\OmniFullfillment\\WorkLoadSummary\\ReadyForCustomerPickup.png");
    Pattern imageShipped = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\Repository\\OmniFullfillment\\WorkLoadSummary\\Shipped.png");
    Pattern imageworkloadSummary = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\Repository\\OmniFullfillment\\HomePage\\workloadSummary.png");
    public void waitScreen() throws FindFailed {
        screen.wait(imageProjectscreen, 10);

        // System.out.println("Saved screen as "+file);

    }

    public void LaunchApplication() throws FindFailed {
       screen.click(imageProjectscreen);
        screen.doubleClick(imageprojectmyscreenmax);
        ScreenImage file = screen.capture(screen.getBounds());
       screen.click(imageOmniFullfillmentIcon);
    }

    /*
    **Method to Validate contents displayed in OmniFullfillment -workload Summary
    **
     */

    public void ValidateWorkLoad_Details() throws Exception
    {
        Thread.sleep(10000);
        screen.click(imageworkloadSummary);
        Thread.sleep(10000);
        VerifyImagePresence(imageAwaitingPick);
        VerifyImagePresence(imagePacked);
        VerifyImagePresence(imagePackInProgress);
        VerifyImagePresence(imagePickCompleted);
        VerifyImagePresence(imagePickInProgress);
        VerifyImagePresence(imageReadyForCustomerPickup);
        VerifyImagePresence(imageShipped);

    }


    /*Method to verify image presence in screen
    **Input: Image to be verified
     */
    public void VerifyImagePresence(Pattern img) throws Exception
    {
        Match val = screen.exists(img);
        //assert val.isValid();
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
        AutoItX x = new AutoItX();
        x.winWaitActive("Project My Screen App");
        x.mouseClick("left", 753, 228, 1, 1);
        x.mouseUp("left");


    }
}
