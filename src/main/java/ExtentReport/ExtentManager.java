package ExtentReport;


import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;

public class ExtentManager {
    static ExtentReports extent;
    static final String configFilePath = System.getProperty("user.dir") + "/src/main/resources/config.xml";

    public ExtentManager() {
    }

    public static synchronized ExtentReports getReporter() {
        if (extent == null) {
            extent = new ExtentReports("Reports/TestReports.html", true);
            extent.addSystemInfo("Browser Name", "Chrome");
            extent.addSystemInfo("Smart Locum Tenens", "QA Enviroment");
            extent.addSystemInfo("Author", "Rajani");
            extent.loadConfig(new File(configFilePath));
        }
        return extent;
    }
}
