package PO;

import BasePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PostJobPO extends BasePage {
    public PostJobPO(WebDriver driver) {
        super(driver);
    }
    ///////////////Locators for ProfilePage//////////
    public By DropDown_xpath = By.xpath("//a[@role= 'button']");
    public By PostJob_xpath = By.xpath("//a[text()= 'Post a Job']");
    public By JobTitle_xpath = By.xpath("//input[@name ='title']");
    public By JobDesc_xpath = By.xpath("//textarea[@name ='description']");
    public By City_xpath = By.xpath("//input[@name ='city']");
    public By HState_xpath = By.xpath("//mat-select[@name='locationId']");
    public By HState1_xpath = By.xpath("//span[contains((text()), ' Arizona ')]");

    public By AddSpecialty_xpath = By.xpath("//a[contains((text()), 'Add specialty/subspecialty')]");
    public By Specialty_xpath = By.xpath("//mat-select[@name = 'specialityId']");
    public By SpecialtyTxt_xpath = By.xpath("//span[contains(text(), ' Anesthesiology ')]");

    public By Subspecialty_xpath = By.xpath("//mat-select[@name = 'subSpecialityId']");
    public By SubspecialtyTxt_xpath = By.xpath("//span[contains(text(), ' Addiction Medicine ')]");

    public By AddSkills_xpath = By.xpath("//a[contains((text()), ' Add Skills ')]");
    public By SkillsChkList_xpath = By.xpath("//div[@id='divSkillsCheckboxlist']");
    public By SkillsChkList1_xpath = By.xpath("//span[text()= 'Acupuncture for pain management']");
    public By SkillsChkList2_xpath = By.xpath("//span[text() = ' Mechanical ventilation']");
    public By SkillsChkList3Add_xpath = By.xpath("(//span[text() = ' Add '])[2]");
    public By AddBtn_xpath = By.xpath("//span[text()= ' Add ']");

    public By BEBC_xpath = By.xpath("(//mat-radio-group[@role= 'radiogroup'])[1]//mat-radio-button[@id='mat-radio-5']");

    //Job Listing Dates
    public By StartDtOpenCal_xpath = By.xpath("(//button[@aria-label= 'Open calendar'])[1]");
    public By StartMonYrDt_xpath = By.xpath("//button[@aria-label= 'Choose month and year']");
    public By StartYr_xpath = By.xpath("//td[@aria-label= '2020']");
    public By StartMonth_xpath = By.xpath("//div[contains(text(),' JULY ')]");
    public By StartDay_xpath = By.xpath("//td[@aria-label = 'July 1, 2020']");

    public By NoEndDate_xpath = By.xpath("//mat-checkbox[@name = 'IsEndDate']");

    public By EndDtOpenCal_xpath = By.xpath("(//button[@aria-label= 'Open calendar'])[2]");
    public By EndDtMonYrDt_xpath = By.xpath("//button[@aria-label= 'Choose month and year']");
    public By EndDtYr_xpath = By.xpath("//td[@aria-label='2020']");

    public By EndDtMonth_xpath = By.xpath("//div[contains(text(),' JULY ')]");
    public By EndDayDt_xpath = By.xpath("//td[@aria-label = 'July 30, 2020']");

    //Job Dates
    public By Start1DtOpenCal_xpath = By.xpath("(//button[@aria-label= 'Open calendar'])[3]");
    public By Start1MonYrDt_xpath = By.xpath("//button[@aria-label= 'Choose month and year']");
    public By Start1Yr_xpath = By.xpath("//td[@aria-label= '2020']");
    public By Start1Month_xpath = By.xpath("//div[contains(text(),' JULY ')]");
    public By Start1Day_xpath = By.xpath("//td[@aria-label = 'July 9, 2020']");

    public By NoEndDate1_xpath = By.xpath("//mat-checkbox[@name = 'IsEndDate']");

    public By EndDtOpenCal1_xpath = By.xpath("(//button[@aria-label= 'Open calendar'])[4]");
    public By EndDtMonYrDt1_xpath = By.xpath("//button[@aria-label= 'Choose month and year']");
    public By EndDtyr1_xpath = By.xpath("//td[@aria-label='2020']");
    public By EndDtMonth1_xpath = By.xpath("//div[contains(text(),' JULY ')]");
    public By EndDayDt1_xpath = By.xpath("//td[@aria-label = 'July 30, 2020']");

    public By AddDts_xpath = By.xpath("//span[text()=' Add Dates ']");

    public By RateType_xpath = By.xpath("//mat-select[@name= 'payFrequencyId']");
    public By Hourly_xpath = By.xpath("//span[text()=' Hourly ']");

    public By PayRate_xpath = By.xpath("//input[@name ='mopayRate']");

    public By StateLicReq_xpath = By.xpath("//mat-select[@name= 'stateLicenceIds']");
    public By StateSelection_xpath = By.xpath("//span[text()=' Alaska ']");
    public By StateSelection1_xpath = By.xpath("//span[text()=' California ']");

    public By WillLicPosi_xpath = By.xpath("(//mat-radio-group[@role= 'radiogroup'])[2]//mat-radio-button[@id='mat-radio-7']");
    public By FacilityCover_xpath = By.xpath("(//mat-radio-group[@role= 'radiogroup'])[3]//mat-radio-button[@id='mat-radio-9']"); //input[@id = 'mat-radio-21-input']");

    public By JobSetting_xpath = By.xpath("//mat-select[@name= 'jobSettingId']");
    public By JobSettDropDwn_xpath = By.xpath("//span[text()=' Hospital ']");

    public By EstCredTime_xpath = By.xpath("//input[@name ='estimatedCredentialTime']");


    public By Submit_xpath = By.xpath("//span[text()=' Submit ']");
    public By ToastMessage_xpath = By.xpath("//div[@aria-label = 'This job posting has been successfully created.']");




}
