package BasePage;

import BasePage.ReadFromPropFile;
import ExtentReport.ExtentManager;
import ExtentReport.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BaseTest{
    public WebDriver driver;
    public BaseTest(){}


    @Parameters({"browserName"})
    @BeforeClass(alwaysRun = true)
//public void beforeClass(@Optional("chrome") String browserName, @Optional("C:\\Program Files\\drivers\\chromedriver_win32 (1)\\chromedriver.exe") String localDriverPath) {
    public void beforeClass(@Optional("chrome") String browserName) {
        getLocalDriver(browserName);
        this.driver.manage().timeouts().implicitlyWait(90L, TimeUnit.SECONDS);
        this.driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();
        this.driver.manage().deleteAllCookies();

    }

    @Parameters({"browserName"})
    @BeforeMethod(alwaysRun = true)

    public void beforeMethod(@Optional("chrome") String browserName, Method method) {
       ReadFromPropFile readFromPropFileObj = new ReadFromPropFile("SuperAdminConfig.properties");

        ExtentTestManager.startTest("Method Name: " + method.getName());
// ExtentTestManager.getTest().log(LogStatus.INFO, "Open Browser and navigate to " + this.driver.getCurrentUrl(), "Browser Name: " + browserName);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("TEST STARTED # " + method.getAnnotation(Test.class).description());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        driver.get(readFromPropFileObj.getUrl());
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result, Method method) throws Exception {
        String fileName;
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        String testSRes;
        Date endDateTime;
        String testDescription;
        String dateEndInString;
        if (result.getStatus() == 2) {
            endDateTime = new Date();
            DateFormat shortDf = DateFormat.getDateTimeInstance(3, 3);
            testDescription = shortDf.format(endDateTime).replace("/", "_");
            testDescription = testDescription.replace(" ", "_");
            testDescription = testDescription.replace(":", "_");
            dateEndInString = "SC_error__" + testDescription;
            fileName = System.getProperty("user.dir") + "\\Reports\\failure_screenshots\\" + dateEndInString + ".png";
            takeSnapShot(this.driver, fileName);
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Error Screenshort" + ExtentTestManager.getTest().addScreenCapture("failure_screenshots\\" + dateEndInString + ".png"));
            ExtentTestManager.getTest().log(LogStatus.FAIL, result.getThrowable().getMessage());
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Test Failed");
            testSRes = "FAIL";
        } else if (result.getStatus() == 3) {
            ExtentTestManager.getTest().log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
            testSRes = "SKIP";
        } else {
            ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
            testSRes = "PASS";
        }

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("TEST COMPLETED # [ " + testSRes + " ] " + method.getAnnotation(Test.class).description());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        ExtentManager.getReporter().endTest(ExtentTestManager.getTest());
        ExtentManager.getReporter().flush();
        ExtentTestManager.getTest().log(LogStatus.INFO, "Browser Closed");
        Thread.sleep(2000);
    }

    @AfterClass(alwaysRun = true)
    public void terminateReport() throws IOException {
        this.driver.quit();
    }

   /* @AfterSuite
    public void afterSuite() throws IOException {
        WriteExcel writeExcel = new WriteExcel();
//writeExcel.writeData();

    }*/


    //private void getLocalDriver(String browserName, String driverPath) {
    private void getLocalDriver(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().version("83").setup();
//System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\drivers\\chromedriver_79.16\\chromedriver.exe");
            driver=new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
//System.setProperty("webdriver.gecko.driver", driverPath);
            WebDriverManager.firefoxdriver().setup();
            this.driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("ie")) {
            this.driver = new InternetExplorerDriver();
        }
    }

    public static void takeSnapShot(WebDriver driver, String fileWithPath) throws Exception {
        TakesScreenshot scrShot = (TakesScreenshot) driver;
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(fileWithPath);
        FileUtils.copyFile(SrcFile, DestFile);
    }
}
