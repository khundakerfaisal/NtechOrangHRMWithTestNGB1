package UtilsFile;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.util.Random;

import static Config.Setup.test;

public class UtilsPage {

    public static ExtentReports extent;

    public static void saveEmployee(String username, String password, String confirmPassword) throws IOException, ParseException {
        String filePath = "src/test/resources/employee.json";
        JSONParser parser = new JSONParser();
        JSONArray addedArray = (JSONArray) parser.parse(new FileReader(filePath));
        JSONObject addedObject = new JSONObject();
        addedObject.put("UserName", username);
        addedObject.put("Password", password);
        addedObject.put("ConfirmPassword", confirmPassword);
        addedArray.add(addedObject);
        FileWriter writer = new FileWriter(filePath);
        writer.write(addedArray.toJSONString());
        writer.flush();
        writer.close();

    }

    public static JSONObject getUser() throws IOException, ParseException {
        String filePath = "src/test/resources/employee.json";
        JSONParser parser = new JSONParser();
        JSONArray lastAddedArray = (JSONArray) parser.parse(new FileReader(filePath));
        JSONObject lastObject = (JSONObject) lastAddedArray.get(lastAddedArray.size() - 1);
        return lastObject;
    }

    public static void scrollBy(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 60)");
    }

    public static ExtentReports getInstance() {
        if (extent == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("reports/ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

        }
        return extent;
    }

    public static void getScreenShot(WebDriver driver,String message,ExtentTest node) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);

        String screenshotDir = "reports/screenshots/";
        new File(screenshotDir).mkdirs();

        String fileName = "screenshot_" + generateNumber() + ".jpg";
        String fullScreenshotPath = screenshotDir + fileName;

        File destFile=new File(fullScreenshotPath);
        FileUtils.copyFile(srcFile,destFile);

        String relativePath = "screenshots/" + fileName;
        node.pass(message, MediaEntityBuilder.createScreenCaptureFromPath(relativePath).build());
    }

    public static String generateNumber() {
        Random random = new Random();
        return String.valueOf(random.nextInt(9999) + 1111);
    }

}
