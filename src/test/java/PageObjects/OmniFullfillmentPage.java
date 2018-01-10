package PageObjects;


import autoitx4java.AutoItX;
import org.sikuli.script.*;

import java.io.IOException;

public class OmniFullfillmentPage {

    Screen screen = new Screen();
    boolean imgPresent;

    //Add image path


    Pattern imageProjectscreen = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\ItemInquiry\\Images\\Projectmyscreen.png");
    Pattern imageOmniFullfillmentIcon = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\Repository\\OmniFullfillment\\OmniFullfillmentLogo.png");
    Pattern imageprojectmyscreenmax = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\ItemInquiry\\Images\\Projectmyscreenmax.png");
    Pattern imageUPC = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\Repository\\mBarcode.png");
    Pattern imagezero = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\Repository\\mZero.png");
    Pattern imagebackArrow = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\Repository\\backButton.png");

    //HomePage
    Pattern imageAssignLocation= new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\Repository\\OmniFullfillment\\HomePage\\assignLocation.png");
    Pattern imagecontainersReady = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\Repository\\OmniFullfillment\\HomePage\\containersReady.png");
    Pattern imagecustomPicking = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\Repository\\OmniFullfillment\\HomePage\\customPicking.png");
    Pattern imagepacking = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\Repository\\OmniFullfillment\\HomePage\\packing.png");
    Pattern imagemanageLocations = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\Repository\\OmniFullfillment\\HomePage\\manageLocations.png");
    Pattern imageshipmentsReady = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\Repository\\OmniFullfillment\\HomePage\\shipmentsReady.png");
    Pattern imagestartPicking = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\Repository\\OmniFullfillment\\HomePage\\startPicking.png");
    Pattern imagetrouble = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\Repository\\OmniFullfillment\\HomePage\\trouble.png");
    Pattern imageworkloadSummary = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\Repository\\OmniFullfillment\\HomePage\\workloadSummary.png");
    Pattern imagescreenWait = new Pattern(System.getProperty("user.dir") + "\\src\\main\\java\\Repository\\OmniFullfillment\\HomePage\\screenWait.png");

    public void waitScreen() throws FindFailed {
//        screen.wait(imageProjectscreen, 10);

        AutoItX x = new AutoItX();
        x.winWaitActive("Project My Screen App");


    }

    public void LaunchApplication() throws FindFailed {
        // Click on the image
//        screen.click(imageProjectscreen);
        screen.click(imageProjectscreen);
        screen.doubleClick(imageprojectmyscreenmax);
        ScreenImage file = screen.capture(screen.getBounds());
//        String sample = "LaunchApp";
//        System.out.println("Saved screen as " + file.save("C:\\GUI_POC\\Winium-master\\WiniumDemo\\src\\main\\java\\ItemInquiry\\Images", sample));

        screen.click(imageOmniFullfillmentIcon);

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

    //Validate Home page contents
    public void Validate() throws FindFailed,Exception
    {
    try
    {
    screen.wait(imagescreenWait, 10);
    Thread.sleep(10000);
        VerifyImagePresence(imageAssignLocation);
        VerifyImagePresence(imagecontainersReady);
        VerifyImagePresence(imagecustomPicking);
        VerifyImagePresence(imagepacking);
        VerifyImagePresence(imagemanageLocations);
        VerifyImagePresence(imageshipmentsReady);
        VerifyImagePresence(imagestartPicking);
        VerifyImagePresence(imagetrouble);
        VerifyImagePresence(imageworkloadSummary);


    }
    catch (FindFailed ex) {
        System.out.println(ex.getMessage());
    } catch (InterruptedException e) {
        e.printStackTrace();
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
        // Runtime.getRuntime().exec("D:\\POC_AutoIt\\closeApplicationNew.exe");

        AutoItX x = new AutoItX();
        x.winWaitActive("Project My Screen App");
        x.mouseClick("left", 753, 228, 1, 1);
        x.mouseUp("left");


//        MouseClick("left",756,231,1)
//        MouseUp("left")

    }
}
