package TS;

import BasePage.BaseTest;
import BasePage.ReadFromPropFile;
import ExtentReport.ExtentTestManager;
import PO.SuperAdminLoginPO;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SuperAdminLoginTC extends BaseTest {
    public SuperAdminLoginTC(){}
    public SuperAdminLoginTC(WebDriver passDriver) {driver = passDriver;
    }

    @Test
    public void verifySuperAdminLoginSLT(){
        //********************Reading data from Read From Prop File****************************//
        ReadFromPropFile readFromPropFileObj = new ReadFromPropFile("SuperAdminConfig.properties");
        SuperAdminLoginPO SupAdLoginObj = new SuperAdminLoginPO(driver);

        //************************Login Page*****************************//

        ExtentTestManager.getTest().getTest().setName("SMT-001: Verify Super Admin Login");

        //1. Click on Sign In tab to login
         Assert.assertTrue(SupAdLoginObj.clickOnLinkBtn(SupAdLoginObj.SignIN_xpath), "Once url is open unable to click on Sign In");
         ExtentTestManager.getTest().log(LogStatus.PASS, "Once Url is open click on Sign In ", "User should able to click on sign in button");

        //2. Enter valid email address
        Assert.assertTrue(SupAdLoginObj.enterTextInInputBtn(SupAdLoginObj.LoginEmail_xpath, readFromPropFileObj.getEmail()), "Unable to enter email");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Enter email ID ", "User should able to enter emaild ID");

        //3. Enter valid password
        Assert.assertTrue(SupAdLoginObj.enterTextInInputBtn(SupAdLoginObj.LoginPwd_xpath, readFromPropFileObj.getPwd()), "Unable to enter password");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Enter password ", "User should able to enter password");

        //4. Click on to 'Remember Me' button for next login optinal
        Assert.assertTrue(SupAdLoginObj.clickOnLinkBtn(SupAdLoginObj.LoginRemMe_xpath), "Unable to click on Remember Me");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Click on remember me button ", "User should able to click on remember me button");

        //5. Click on 'Sign In' button
        Assert.assertTrue(SupAdLoginObj.clickOnLinkBtn(SupAdLoginObj.LoginSignIn_xpath), "Unable to click on Sign In");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Click on Sign In button to login ", "User should able to click on sign in button to login");

        //6. Verify if user is redirected to home page by verifying the text 'Healthcare Professional'
        // String expectedName = "Welcome Dev Raj";
        String expectedName = "Welcome Micheal";
        Assert.assertEquals(SupAdLoginObj.findText(SupAdLoginObj.Textverify_xpath), expectedName);
        ExtentTestManager.getTest().log(LogStatus.PASS, "Click on user logged in text to verify ", "User is redirected to home page and able to capture the text 'Welcome Micheal'");
        System.out.println("Title is: " + SupAdLoginObj.findText(SupAdLoginObj.Textverify_xpath));

    }


}
