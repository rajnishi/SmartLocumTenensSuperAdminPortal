package PO;

import BasePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePagePO extends BasePage {
    public ProfilePagePO(WebDriver driver) {     super(driver);    }
    ///////////////Locators for ProfilePage//////////
    public By DropDown_xpath = By.xpath("//span[@class = 'name']");
    public By EditProfile_xpath = By.xpath("//a[contains(text(), ' Edit Profile ')]");
    public By HAdd_xpath = By.xpath("//input[@name ='address1']");
    public By HCity_xpath = By.xpath("//input[@name ='city']");
    public By HState_xpath = By.xpath("//mat-select[@name='stateId']");
    public By HState1_xpath = By.xpath("//span[contains((text()), ' Delaware ')]");
    public By Zip_xpath = By.xpath("//input[@name= 'zipCode']");
    public By Billingchkbox_xpath = By.xpath("//mat-checkbox[@id= 'mat-checkbox-3']");
    public By Save_xpath = By.xpath("//span[text()=' Save Profile ']");
    public By ToastMessage_xpath = By.xpath("//div[@aria-label = 'Your profile has been saved.']");

}
