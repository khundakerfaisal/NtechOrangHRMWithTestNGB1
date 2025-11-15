package TestRunner;

import Config.Setup;
import Pages.LoginPage;
import Pages.PIMPages;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PIMTestRunner extends Setup {
    @Test(priority = 1, description = "Valid credential")
    public void doLoginWithValidCred() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123"); //Login
        Thread.sleep(2000);
        //Assertion
//        WebElement MatchText = driver.findElement(By.xpath("//span/h6[text()='Dashboard']"));
//        String TextActual = MatchText.getText();
//        String TextExpected = "Dashboard";
//        Assert.assertEquals(TextActual.trim(), TextExpected);
//        Thread.sleep(2000);

    }

    @Test(priority = 2, description = "Valid credential")
    public void enterPimInfo() throws InterruptedException {
        PIMPages pimPages=new PIMPages(driver);
        Faker faker=new Faker();
        String firstName=faker.name().firstName();
        String middleName=faker.name().nameWithMiddle();
        String lastName=faker.name().lastName();
        String userName=faker.name().lastName();
        String password="Aa@123456";
        String confirmPassword="Aa@123456";

        pimPages.inputPIMInfo(firstName,middleName,lastName,userName,password,confirmPassword);
        Thread.sleep(2000);
    }

}
