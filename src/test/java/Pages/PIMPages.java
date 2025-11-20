package Pages;

import UtilsFile.UtilsPage;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;
import java.io.IOException;
import java.util.List;

import static Config.Setup.test;

public class PIMPages {
    WebDriver driver;
    ExtentTest node;



    @FindBy(className = "oxd-main-menu-item-wrapper")
    List<WebElement> pimMenu;

    @FindBy(className = "oxd-button")
    List<WebElement> addButton;

    @FindBy(name = "firstName")
    WebElement inputFirstName;
    @FindBy(name = "middleName")
    WebElement inputMiddleName;
    @FindBy(name = "lastName")
    WebElement inputLastName;

    @FindBy(className = "oxd-switch-input")
    List<WebElement> switchButton;

    @FindBy(className = "oxd-input")
    List<WebElement> inputUserName;
    @FindBy(className = "oxd-input")
    List<WebElement> inputPassword;
    @FindBy(className = "oxd-input")
    List<WebElement> inputConfirmPassword;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;


    public PIMPages(WebDriver driver,ExtentTest node) {
        this.driver = driver;
        this.node = node;
        PageFactory.initElements(driver, this);
    }

    public void inputPIMInfo(String firstName, String middleName, String lastName, String userName, String password, String confirmPassword) throws InterruptedException, IOException {
        pimMenu.get(1).click();
        node.info("PIM Menu click Successfully");
        node.pass("PIM Menu work as expected ");
        Thread.sleep(2000);
        addButton.get(2).click();
        Thread.sleep(3000);
        inputFirstName.sendKeys(firstName);
        Thread.sleep(1000);
        inputMiddleName.sendKeys(middleName);
        Thread.sleep(1000);
        inputLastName.sendKeys(lastName);
        Thread.sleep(1000);
        switchButton.get(0).click();
        Thread.sleep(1000);

        inputUserName.get(5).sendKeys(userName);
        Thread.sleep(1000);
        UtilsPage.scrollBy(driver);
        inputPassword.get(6).sendKeys(password);
        UtilsPage.getScreenShot(driver,"Password found as expected",node);
        Thread.sleep(1000);
        inputConfirmPassword.get(7).sendKeys(confirmPassword);
        Thread.sleep(1000);

        submitButton.click();
        UtilsPage.getScreenShot(driver,"User Submit Successfully",node);
        Thread.sleep(1000);

    }
}
