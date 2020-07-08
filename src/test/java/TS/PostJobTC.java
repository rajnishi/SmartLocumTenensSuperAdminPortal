package TS;

import BasePage.BaseTest;
import BasePage.ReadFromPropFile;
import ExtentReport.ExtentTestManager;
import PO.PostJobPO;
import PO.ProfilePagePO;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostJobTC extends BaseTest {
    @Test
    public void verifyPostJobTCSLT() throws InterruptedException {
        //******************************"Pre-condition : Login Require******************//
        SuperAdminLoginTC SupAdLoginObj = new SuperAdminLoginTC(driver);
        SupAdLoginObj.verifySuperAdminLoginSLT();

        //********************Reading data from Read From Prop File****************************//
        PostJobPO postJobPOObj = new PostJobPO(driver);
        ReadFromPropFile readFromPropFilePPObj = new ReadFromPropFile("PostJobConfig.properties");

        //**********************************Profile and EditPage************************************//
        ExtentTestManager.getTest().getTest().setName("SMT-002: Verify Post Job Page");

        // 1. Click dropdown arrow on Jobs
        Assert.assertTrue(postJobPOObj.clickOnLinkBtn(postJobPOObj.DropDown_xpath), "Unable to click on dropdown");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Click on Sign In button ", "User able to click on sign in button");

        // 2. Click dropdown arrow on post a Job
        Assert.assertTrue(postJobPOObj.clickOnLinkBtn(postJobPOObj.PostJob_xpath), "Unable to click on post a job tab");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Click on post a job dropdown ", "User able to click on post a job dropdown button");

        //3. Enter Job title
        Assert.assertTrue(postJobPOObj.enterTextInInputBtn(postJobPOObj.JobTitle_xpath, readFromPropFilePPObj.getTitle()), "Unable to enter on job title");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Enter job title ", "User able to enter job title ");


        //3. Enter Job description
        Assert.assertTrue(postJobPOObj.enterTextInInputBtn(postJobPOObj.JobDesc_xpath, readFromPropFilePPObj.getJobDesc()), "Unable to enter on job description");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Enter job description ", "User able to enter job description ");

        //4. Enter city
        Assert.assertTrue(postJobPOObj.enterTextInInputBtn(postJobPOObj.City_xpath, readFromPropFilePPObj.getCity1()), "Unable to enter city");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Enter city ", "User able to enter city ");

        //11.Select State
        Assert.assertTrue(postJobPOObj.selectFromDropDownBtn(postJobPOObj.HState_xpath, postJobPOObj.HState1_xpath),"Unable to select state");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Select state ", "User should able to select state");


        //3. Click on add Specialty/Subspecialty
        Assert.assertTrue(postJobPOObj.clickOnLinkBtn(postJobPOObj.AddSpecialty_xpath), "Unable to click on Add specialty/subspecialty");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Click on Add specialty/subspecialty ", "User able to click on Add specialty/subspecialty");

        //4. Click on dropdown to select Specialty option
        Thread.sleep(2000);
        Assert.assertTrue(postJobPOObj.selectFromDropDownBtn(postJobPOObj.Specialty_xpath, postJobPOObj.SpecialtyTxt_xpath), "Unable to click on drop down button of Specialty");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Click on drop down button and select Specialty option ", "User able to click drop down button and able to select from Specialty option");

        //5. Click on dropdown to select Subspecialty option
        Assert.assertTrue(postJobPOObj.selectFromDropDownBtn(postJobPOObj.Subspecialty_xpath, postJobPOObj.SubspecialtyTxt_xpath), "Unable to click on drop down button of SubSpecialty");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Click on drop down button and select option SubSpecialty ", "User able to click drop down button and able to select the option from SubSpecialty");

        //3. Click on add Skills btn
        Assert.assertTrue(postJobPOObj.clickOnLinkBtn(postJobPOObj.AddSkills_xpath), "Unable to click on Add Skills");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Click on Add Skills ", "User able to click on Add Skills");

        //11.Select skills

        Assert.assertTrue(postJobPOObj.clickOnLinkBtn(postJobPOObj.SkillsChkList_xpath), "Unable to select checklist skills");
        ExtentTestManager.getTest().log(LogStatus.PASS, "click on checklist skills", "User able to click on checklist skills");

        Assert.assertTrue(postJobPOObj.clickOnLinkBtn(postJobPOObj.SkillsChkList1_xpath), "Unable to select skills1");
        ExtentTestManager.getTest().log(LogStatus.PASS, "click on checklist skills1", "User able to click on checklist skills1");

        Assert.assertTrue(postJobPOObj.clickOnLinkBtn(postJobPOObj.SkillsChkList2_xpath), "Unable to select skills2");
        ExtentTestManager.getTest().log(LogStatus.PASS, "click on checklist skills1", "User able to click on checklist skills2");

        Assert.assertTrue(postJobPOObj.clickOnLinkBtn(postJobPOObj.SkillsChkList3Add_xpath), "Unable to click on add skills button");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Click on add skills button ", "User able to click on add skills button");

        Assert.assertTrue(postJobPOObj.clickOnLinkBtn(postJobPOObj.AddBtn_xpath), "Unable to click on add button");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Click on add button ", "User able to click on add button");
        Thread.sleep(3000);

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");

        //10.Select option Yes for Board Eligible/Board Cerified
        Assert.assertTrue(postJobPOObj.clickOnLinkBtn(postJobPOObj.BEBC_xpath), "Unable to click on Board eligibility/board certification");
        ExtentTestManager.getTest().log(LogStatus.PASS, "click on Board eligibility/board certification", "User able to click on Board eligibility/board certification ");

        //Job Listing Dates

        //Assert.assertTrue(postJobPOObj.clickOnLinkBtn(postJobPOObj.StartDtOpenCal_xpath), "Unable to click on Start Date calender");
        //ExtentTestManager.getTest().log(LogStatus.PASS, "click on to open the Start Date calender ", "User able to open the Start Date calender");

        //Thread.sleep(2000);
        //Assert.assertTrue(postJobPOObj.clickOnLinkBtn(postJobPOObj.StartMonYrDt_xpath), "Unable to select year & month");
        //ExtentTestManager.getTest().log(LogStatus.PASS, "Select the year & month ", "User able to select year & month");

        //Assert.assertTrue(postJobPOObj.clickOnLinkBtn(postJobPOObj.StartYr_xpath), "Unable to select year");
        //ExtentTestManager.getTest().log(LogStatus.PASS, "Select the year ", "User able to select year");

        //Assert.assertTrue(postJobPOObj.clickOnLinkBtn(postJobPOObj.StartMonth_xpath), "Unable to select month");
        // ExtentTestManager.getTest().log(LogStatus.PASS, "click on to select month ", "User able to select month");

        // Assert.assertTrue(postJobPOObj.clickOnLinkBtn(postJobPOObj.StartDay_xpath), "Unable to select Day");
        // ExtentTestManager.getTest().log(LogStatus.PASS, "click on to select day ", "User able to select day");*//*


        //11.Select End Date
         Assert.assertTrue(postJobPOObj.clickOnLinkBtn(postJobPOObj.EndDtOpenCal_xpath), "Unable to click on End Date calender");
        ExtentTestManager.getTest().log(LogStatus.PASS, "click on to open the End Date calender ", "User able to open the End Date calender");


        // Assert.assertTrue(postJobPOObj.clickOnLinkBtn(postJobPOObj.EndDtMonYrDt_xpath), "Unable to select year & month");
        //ExtentTestManager.getTest().log(LogStatus.PASS, "Select the year & month ", "User able to select year & month");

        // Assert.assertTrue(postJobPOObj.clickOnLinkBtn(postJobPOObj.EndDtYr_xpath), "Unable to select year");
        // ExtentTestManager.getTest().log(LogStatus.PASS, "click on to select year", "User able to select year");

        // Assert.assertTrue(postJobPOObj.clickOnLinkBtn(postJobPOObj.EndDtMonth_xpath), "Unable to select month");
        // ExtentTestManager.getTest().log(LogStatus.PASS, "click on to select month ", "User able to select month");


        Assert.assertTrue(postJobPOObj.clickOnLinkBtn(postJobPOObj.EndDayDt_xpath), "Unable to select Day");
        ExtentTestManager.getTest().log(LogStatus.PASS, "click on to select day ", "User able to select day");

        //Job Dates
        Assert.assertTrue(postJobPOObj.clickOnLinkBtn(postJobPOObj.Start1DtOpenCal_xpath), "Unable to click on Start Date calender");
        ExtentTestManager.getTest().log(LogStatus.PASS, "click on to open the Start Date calender ", "User able to open the Start Date calender");

        //Thread.sleep(2000);
        //Assert.assertTrue(postJobPOObj.clickOnLinkBtn(postJobPOObj.Start1MonYrDt_xpath), "Unable to select year & month");
        //ExtentTestManager.getTest().log(LogStatus.PASS, "Select the year & month ", "User able to select year & month");

        //Assert.assertTrue(postJobPOObj.clickOnLinkBtn(postJobPOObj.Start1Yr_xpath), "Unable to select year");
        //ExtentTestManager.getTest().log(LogStatus.PASS, "Select the year ", "User able to select year");

        //Assert.assertTrue(postJobPOObj.clickOnLinkBtn(postJobPOObj.Start1Month_xpath), "Unable to select month");
        //ExtentTestManager.getTest().log(LogStatus.PASS, "click on to select month ", "User able to select month");

        Assert.assertTrue(postJobPOObj.clickOnLinkBtn(postJobPOObj.Start1Day_xpath), "Unable to select Day");
        ExtentTestManager.getTest().log(LogStatus.PASS, "click on to select day ", "User able to select day");

        //11.Select End Date
        Assert.assertTrue(postJobPOObj.clickOnLinkBtn(postJobPOObj.EndDtOpenCal1_xpath), "Unable to click on End Date calender");
        ExtentTestManager.getTest().log(LogStatus.PASS, "click on to open the End Date calender ", "User able to open the End Date calender");

        // Assert.assertTrue(postJobPOObj.clickOnLinkBtn(postJobPOObj.EndDtMonYrDt1_xpath), "Unable to select year & month");
        //ExtentTestManager.getTest().log(LogStatus.PASS, "Select the year & month ", "User able to select year & month");

        //Assert.assertTrue(postJobPOObj.clickOnLinkBtn(postJobPOObj.EndDtyr1_xpath), "Unable to select year");
        // ExtentTestManager.getTest().log(LogStatus.PASS, "click on to select year", "User able to select year");

        //Assert.assertTrue(postJobPOObj.clickOnLinkBtn(postJobPOObj.EndDtMonth1_xpath), "Unable to select month");
        //  ExtentTestManager.getTest().log(LogStatus.PASS, "click on to select month ", "User able to select month");

        Assert.assertTrue(postJobPOObj.clickOnLinkBtn(postJobPOObj.EndDayDt1_xpath), "Unable to select Day");
        ExtentTestManager.getTest().log(LogStatus.PASS, "click on to select day ", "User able to select day");

        //CLick on Add Dates
        Assert.assertTrue(postJobPOObj.clickOnLinkBtn(postJobPOObj.AddDts_xpath), "Unable to click on add dates button");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Click on add dates button ", "User able to click on add dates button");

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
        //11.Select rate type
        Assert.assertTrue(postJobPOObj.selectFromDropDownBtn(postJobPOObj.RateType_xpath, postJobPOObj.Hourly_xpath),"Unable to select rate type");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Select rate type ", "User should able to select rate type");

        //StateRe
        Assert.assertTrue(postJobPOObj.enterTextInInputBtn(postJobPOObj.PayRate_xpath, readFromPropFilePPObj.getPayRate()), "Unable to enter pay type");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Enter pay rate amount ", "User able to enter the pay rate");

        Thread.sleep(2000);
        Assert.assertTrue(postJobPOObj.selectDropDown(postJobPOObj.StateLicReq_xpath, postJobPOObj.StateSelection_xpath, postJobPOObj.StateSelection1_xpath), "Unable to click on drop down button of state license requirements");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Click on drop down button and select state license requirements option ", "User able to click drop down button and able to select from state license requirements option");

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)");

        //Willing to License for Position*
        Assert.assertTrue(postJobPOObj.clickOnLinkBtn(postJobPOObj.WillLicPosi_xpath), "Unable to select willing to license for position ");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Select willing to license for position as Yes", "User able to select willing to license for position");

        //Facility to Cover Travel*
        Assert.assertTrue(postJobPOObj.clickOnLinkBtn(postJobPOObj.FacilityCover_xpath), "Unable to select Facility to Cover Travel* ");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Select Facility to Cover Travel*", "User able to select Facility to Cover Travel*");
        //Job Setting*
        Assert.assertTrue(postJobPOObj.selectFromDropDownBtn(postJobPOObj.JobSetting_xpath, postJobPOObj.JobSettDropDwn_xpath), "Unable to click on drop down button of job setting");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Click on drop down button and select job setting option ", "User able to click drop down button and able to select from job setting option");

        //Estimated Credentialing Time*
        //StateRe
        Assert.assertTrue(postJobPOObj.enterTextInInputBtn(postJobPOObj.EstCredTime_xpath, readFromPropFilePPObj.getPayRate()), "Unable to enter Estimated Credentialing Time");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Enter Estimated Credentialing Time ", "User able to enter Estimated Credentialing Time");


        Assert.assertTrue(postJobPOObj.clickOnLinkBtn(postJobPOObj.Submit_xpath), "Unable to click on submit button");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Click on submit button ", "User able to click on submit button");

        String expectedMessage = "This job posting has been successfully created.";
        Assert.assertEquals(postJobPOObj.findText(postJobPOObj.ToastMessage_xpath), expectedMessage);
        ExtentTestManager.getTest().log(LogStatus.PASS, "Capture the successful message of posting a job successfully", "User is able to post a new job successfully");
        System.out.println("Message : " + postJobPOObj.findText(postJobPOObj.ToastMessage_xpath));
    }
}
