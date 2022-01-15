package io.automatenow.utils;

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
    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    /**
     * Use this method to save failed test screenshots as a PNG file.
     *
     * @param iTestResult
     */
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        String methodName = iTestResult.getName();
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("./failed_tests/" + methodName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.error("Test '" + methodName + "' has failed and a screenshot was taken.");
    }

    /**
     * Uncomment this method if you wish to save failed test screenshots in a Word document
     *
     * @param iTestResult
     */
//    @Override
//    public void onTestFailure(ITestResult iTestResult) {
//        String failedTest = iTestResult.getName();
//        String screenshotsPath = "./failed_tests/screenshots.docx";
//
//        // Take screenshot
//        TakesScreenshot screenshot = (TakesScreenshot) driver;
//        File file = screenshot.getScreenshotAs(OutputType.FILE);
//
//        try {
//            // Set output directory if not already set
//            Path outputDirectory = Path.of("./failed_tests/");
//            if (!Files.exists(outputDirectory)) {
//                assertTrue(new File(String.valueOf(outputDirectory)).mkdirs(), "Unable to create output directory");
//            }
//
//            // Check if screenshots file already exists
//            XWPFDocument document;
//            Path screenshotsDocumentPath = Path.of(screenshotsPath);
//            if (!Files.exists(screenshotsDocumentPath)) {
//                // Create a blank document
//                document = new XWPFDocument();
//            } else {
//                // Open existing document
//                document = new XWPFDocument(Files.newInputStream(Paths.get(screenshotsPath)));
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
//            FileOutputStream fos = new FileOutputStream(screenshotsPath);
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
//        log.error("Test '" + failedTest + "' has failed and a screenshot was taken.");
//    }

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
