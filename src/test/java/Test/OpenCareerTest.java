package Test;

import AbstractComponents.AbstractComponent;
import TestComponents.BasePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.AppsPool;
import pageObjects.GlowGlobant;
import pageObjects.OpenPositions;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class OpenCareerTest extends BasePage {

    public static WebDriver driver;

    WebDriver iniDriver;
    static ExtentReports extent;

    @BeforeTest
    public static void Initialize()
    {
        System.out.println("BeforeTest TestNG annotation");
    }

    @Test
    public void aOpenPosition() throws IOException {
//        ExtentTest test = extent.createTest("Open Positions");

        driver = initializeDriver();

//        BasePage bp = new BasePage();
//        bp.initializeDriver();

        pageObjects.CitrixLogin landingPage = new pageObjects.CitrixLogin(driver);

        String getGoogleConfirmation = landingPage.getConfirmationGooglePage();
        Assert.assertTrue(getGoogleConfirmation.toLowerCase().contains("acceder"));

        AbstractComponent callM = new AbstractComponent(driver);

//        String loginEmail = callM.callData("email");

        landingPage.inputEmailAddressGoogle(callM.callVariables("email"));

        landingPage.clickOnSiguienteButton();

        landingPage.insertPasswordGoogle(callM.callVariables("password"));

        landingPage.seePassword();

        landingPage.googleNextbutton();

//        test.fail("Result do not match"); // This is useful to force the test case to fail on the report

//        extent.flush();

    }

    @Test
    public static void bPortalAppsPool_GoGlow() throws InterruptedException {

        AppsPool goApps = new AppsPool(driver);

//        Thread.sleep(30000);

        goApps.clickGlowIcon();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
        }

        goApps.signInWithGoogle();

        goApps.selectGoogleAccountForGlow();

    }

    @Test
    public static void cGlowGlobantStaffing() throws InterruptedException {

        GlowGlobant glowGlobantObject = new GlowGlobant(driver);

        glowGlobantObject.setSidebarMenuButton();

//        glowGlobantObject.staffingButtonSideBar();
        glowGlobantObject.setStaffingButtonOpens();
        glowGlobantObject.staffingOpenCareerSideBar();

    }

    @Test
    public static void dOpenPositions() throws InterruptedException {

        OpenPositions openPositionsPage = new OpenPositions(driver);

        openPositionsPage.openPositionsObject();

        openPositionsPage.searchForPositionObject("Test");

        openPositionsPage.choosePositionOnList("Test Automation Engineer");

        openPositionsPage.applyFilterObject();

        openPositionsPage.getTAEProjects("These are the Open TAE Positions:");

    }
    @AfterTest(enabled = false) // Enabled is used to exclude any specific scenario because it has a bug related
    public static void closeInstance()
    {
        driver.close();
    }

    @Test(groups={"Smoke"})
    public static void quitInstance()
    {
        driver.quit();
    }

    public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) OpenCareerTest.driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "//Reports//" + testCaseName + ".png");
        FileUtils.copyFile(source, file);
        return System.getProperty("user.dir") + "//Reports//" + testCaseName + ".png";
    }
}
