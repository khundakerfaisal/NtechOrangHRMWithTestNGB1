package TestRunner;

import Config.Setup;
import Pages.LoginPage;
import UtilsFile.LoginCsvData;
import UtilsFile.UtilsPage;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginWithCsv extends Setup {
    @Test(dataProvider = "loginCsvDataSet",dataProviderClass = LoginCsvData.class)
    public void doLoginWithJson(String username,String password) throws InterruptedException, IOException, ParseException {
        LoginPage loginPage = new LoginPage(driver);
//        String username = UtilsPage.getUser().get("UserName").toString();
//        String password = UtilsPage.getUser().get("Password").toString();
        loginPage.login(username, password);
        Thread.sleep(4000);
    }
}
