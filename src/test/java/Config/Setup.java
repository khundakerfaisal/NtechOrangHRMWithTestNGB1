package Config;

import UtilsFile.UtilsPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;


import java.time.Duration;

public class Setup {
    public WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeClass(groups = "smoke")
    public void StartBrowser(){
        extent= UtilsPage.getInstance();
        test=extent.createTest("Start Browser");

//        ChromeOptions options = new ChromeOptions();
//        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
//        driver = new ChromeDriver(options);

        driver=new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        test.pass("Browser open successfully");
    }

    @AfterClass(groups = "smoke")
    public void CloseBrowser(){
        driver.quit();
        extent.flush();
    }
}
