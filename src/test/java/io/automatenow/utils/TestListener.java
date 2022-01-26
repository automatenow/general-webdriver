package io.automatenow.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import io.automatenow.pages.BasePage;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static org.testng.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Marco A. Cruz
 */
public class TestListener extends BasePage implements ITestListener {
    private ExtentReports extent = new ExtentReports();
    private ExtentSparkReporter reporter = new ExtentSparkReporter("ExtentReport.html");

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    /**
     * This method contains three different options for saving screenshots of failed tests. Please uncomment the code
     * for the options that you wish to use.
     *
     * @param iTestResult
     */
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        String screenshotsDir = "./failed_tests/";
        String screenshotsPathWordDoc = screenshotsDir + "screenshots.docx";
        String failedTest = iTestResult.getName();

        log.error("Test '" + failedTest + "' has failed and a screenshot was taken.");

        /*
        OPTION 1:
        Save screenshot as PNG file
         */
        takeScreenshot(failedTest);

        /*
        OPTION 2:
        Save screenshot as PNG file and add it to an Extent Report
         */
//        takeScreenshot(failedTest);
//
//        // Sets Dashboard as the primary view of the report
//        reporter.viewConfigurer().viewOrder().as(new ViewName[]{ViewName.DASHBOARD, ViewName.TEST}).apply();
//        extent.attachReporter(reporter);
//        extent.createTest(failedTest)
//                // Allows for setting a test category
////                .assignCategory("Smoke")
//                .addScreenCaptureFromPath(screenshotsDir + failedTest + ".png")
//                // Offers another form of displaying the screenshot
////                .fail(MediaEntityBuilder.createScreenCaptureFromPath(screenshotsDir + failedTest + ".png").build())
//                // Prints the stacktrace
//                .log(Status.FAIL, iTestResult.getThrowable());
//        //  Write the test information to the reporter
//        extent.flush();

        /*
        OPTION 3:
        Save screenshot to MS Word document
         */
        // Take screenshot
//        TakesScreenshot screenshot = (TakesScreenshot) driver;
//        File file = screenshot.getScreenshotAs(OutputType.FILE);
//
//        try {
//            // Set output directory if not already set
//            Path outputDirectory = Path.of(screenshotsDir);
//            if (!Files.exists(outputDirectory)) {
//                assertTrue(new File(String.valueOf(outputDirectory)).mkdirs(), "Unable to create output directory");
//            }
//
//            // Check if screenshots file already exists
//            XWPFDocument document;
//            Path screenshotsDocumentPath = Path.of(screenshotsPathWordDoc);
//            if (!Files.exists(screenshotsDocumentPath)) {
//                // Create a blank document
//                document = new XWPFDocument();
//            } else {
//                // Open existing document
//                document = new XWPFDocument(Files.newInputStream(Paths.get(screenshotsPathWordDoc)));
//            }
//
//            // Add a paragraph to the document
//            XWPFParagraph paragraph = document.createParagraph();
//
//            // Add name of failed test
//            XWPFRun run = paragraph.createRun();
//            if (Files.exists(screenshotsDocumentPath)) {
//                run.addCarriageReturn();
//                run.addCarriageReturn();
//            }
//            run.setText("Test name: " + failedTest);
//            run.addCarriageReturn();
//            run.addCarriageReturn();
//
//            // Create image file input stream
//            File image = new File(String.valueOf(file));
//            FileInputStream imageData = new FileInputStream(image);
//
//            // Set image type and get image name
//            int imageType = XWPFDocument.PICTURE_TYPE_JPEG;
//            String imageFileName = image.getName();
//
//            // Set image width/height
//            int imageWidth = 500;
//            int imageHeight = 250;
//
//            // Set document name and destination
//            FileOutputStream fos = new FileOutputStream(screenshotsPathWordDoc);
//
//            // Add screenshot to document
//            run.addPicture(imageData, imageType, imageFileName, Units.toEMU(imageWidth), Units.toEMU(imageHeight));
//            document.write(fos);
//
//            // Cleanup
//            fos.close();
//            document.close();
//        } catch (IOException | InvalidFormatException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
