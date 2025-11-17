package TestRunner;

import Config.Setup;
import Pages.LoginPage;
import UtilsFile.UtilsPage;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginWithJson extends Setup {
    @Test(priority = 1, description = "Login With Last User ifo")
    public void doLoginWithJson() throws InterruptedException, IOException, ParseException {
        LoginPage loginPage = new LoginPage(driver);
        String username = UtilsPage.getUser().get("UserName").toString();
        String password = UtilsPage.getUser().get("Password").toString();
        loginPage.login(username, password);
        Thread.sleep(4000);
    }
}
