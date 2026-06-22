package api_utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {

    public static ExtentReports extent;

    public static ExtentReports getReportInstance() {

        if (extent == null) {

            String timeStamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss"));

            String reportPath = System.getProperty("user.dir")
                    + "/Reports/API_Test_Report_" + timeStamp + ".html";

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter(reportPath);

            sparkReporter.config().setReportName("API Automation Report");
            sparkReporter.config().setDocumentTitle("Rest Assured Execution Report");
            sparkReporter.config().setTheme(Theme.DARK);

            extent = new ExtentReports();

            extent.attachReporter(sparkReporter);

            extent.setSystemInfo("Tester", "Abdul Azeez");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Framework", "Rest Assured + TestNG");
            extent.setSystemInfo("Execution Time", timeStamp);
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        }

        return extent;
    }
}