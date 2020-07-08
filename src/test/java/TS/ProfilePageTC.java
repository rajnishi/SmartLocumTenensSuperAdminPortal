package TS;

import BasePage.BaseTest;
import BasePage.ReadFromPropFile;
import ExtentReport.ExtentTestManager;
import PO.ProfilePagePO;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfilePageTC extends BaseTest {
    public ProfilePageTC(){}

    public ProfilePageTC(WebDriver passDriver){driver = passDriver;}

    @Test
    public void verifyProfilePageSLT() throws InterruptedException {
        //******************************"Pre-condition : Login Require******************//
        SuperAdminLoginTC SupAdLoginObj = new SuperAdminLoginTC(driver);
        SupAdLoginObj.verifySuperAdminLoginSLT();

        //********************Reading data from Read From Prop File****************************//
        ProfilePagePO profilePOObj = new ProfilePagePO(driver);
        ReadFromPropFile readFromPropFilePPObj = new ReadFromPropFile("SuperAdminConfig.properties");

        //**********************************Profile and EditPage************************************//
        ExtentTestManager.getTest().getTest().setName("SMT-002: Verify Profile Page");
        // 1. Click dropdown arrow  on profile user
        Assert.assertTrue(profilePOObj.clickOnLinkBtn(profilePOObj.DropDown_xpath), "Unable to click on dropdown");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Click on Sign In button ", "User able to click on sign in button");

        //2. Click ""Edit profile"" button
        Assert.assertTrue(profilePOObj.clickOnLinkBtn(profilePOObj.EditProfile_xpath), "Unable to click on edit profile tab");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Click on edit profile tab ", "User able to click on edit profile tab ");

       ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,3000)");

        //5.Enter address
        Assert.assertTrue(profilePOObj.enterTextInInputBtn(profilePOObj.HAdd_xpath, readFromPropFilePPObj.getAddress()), "Unable to enter address");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Enter address ", "User able to enter address ");

        Assert.assertTrue(profilePOObj.enterTextInInputBtn(profilePOObj.HCity_xpath, readFromPropFilePPObj.getCity()), "Unable to enter city");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Enter city", "User able to enter city ");

        //6.Select state from drop down
        Assert.assertTrue(profilePOObj.selectFromDropDownBtn(profilePOObj.HState_xpath, profilePOObj.HState1_xpath), "Unable to select state");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Please select state from dropdown ", "User able to select state from dropdown option ");

        Assert.assertTrue(profilePOObj.enterTextInInputBtn(profilePOObj.Zip_xpath, readFromPropFilePPObj.getZip()), "Unable to enter zip");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Enter zip ", "User able to enter zip");

        Assert.assertTrue(profilePOObj.clickOnLinkBtn(profilePOObj.Billingchkbox_xpath), "Unable to click on billing contact");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Click on billing contact same as above checkbox", "User able to click on billing contact same as above checkbox");

        Assert.assertTrue(profilePOObj.clickOnLinkBtn(profilePOObj.Save_xpath), "Unable to save profile");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Click on save profile ", "User able to save profile successfully");

        //7. User should be able to edit profile AND should display message of saved profile successfully
        Thread.sleep(2300);
        String expectedMessage = "Your profile has been saved.";
        Assert.assertEquals(profilePOObj.findText(profilePOObj.ToastMessage_xpath), expectedMessage);
        ExtentTestManager.getTest().log(LogStatus.PASS, "Capture the successful message of profile saved", "User is able to save profile successfully");
        System.out.println("Message : " + profilePOObj.findText(profilePOObj.ToastMessage_xpath));

    }
}
