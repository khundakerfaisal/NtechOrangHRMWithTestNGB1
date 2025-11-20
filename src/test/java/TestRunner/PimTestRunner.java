package TestRunner;

import Config.Setup;
import Pages.LoginPage;
import Pages.PIMPages;
import UtilsFile.UtilsPage;
import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;


public class PimTestRunner extends Setup {
    public  ExtentTest node;
    @Test(priority = 1,groups = "smoke", description = "Valid credential")
    public void doLoginWithValidCred() throws InterruptedException {
        test=extent.createTest("Login with CLI");
        node =test.createNode("Login Screen found successfully");
        LoginPage loginPage = new LoginPage(driver);
        String username=System.getProperty("username");
        String password=System.getProperty("password");
        loginPage.login(username,password);
        Thread.sleep(2000);

    }

    @Test(priority = 2,groups = "smoke", description = "Enter employee info")
    public void enterPimInfo() throws InterruptedException, IOException, ParseException {
        node=test.createNode("Employee info found as expected");
        PIMPages pimPages=new PIMPages(driver,node);
        Faker faker=new Faker();
        String firstName=faker.name().firstName();
        String middleName=faker.name().nameWithMiddle();
        String lastName=faker.name().lastName();
        String username=faker.name().lastName();
        String password="Aa@123456";
        String confirmPassword="Aa@123456";

        pimPages.inputPIMInfo(firstName,middleName,lastName,username,password,confirmPassword);
        UtilsPage.saveEmployee(username,password,confirmPassword);
        Thread.sleep(2000);
    }

}
