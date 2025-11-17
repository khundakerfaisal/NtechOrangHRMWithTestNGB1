package TestRunner;

import Config.Setup;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class LoginTestRunner extends Setup {

    @Test(priority = 1, description = "Valid credential")
    public void doLoginWithValidCred() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        String username=System.getProperty("username");
        String password=System.getProperty("password");
        loginPage.login(username,password);
//        loginPage.login("Admin", "admin123"); //Login
        Thread.sleep(2000);

        //Assertion
//        WebElement MatchText = driver.findElement(By.xpath("//span/h6[text()='Dashboard']"));
//        String TextActual = MatchText.getText();
//        String TextExpected = "Dashboard";
//        Assert.assertEquals(TextActual.trim(), TextExpected);
//        Thread.sleep(2000);


    }


}
