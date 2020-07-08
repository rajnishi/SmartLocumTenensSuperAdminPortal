package PO;

import BasePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuperAdminLoginPO extends BasePage {
    public SuperAdminLoginPO(WebDriver driver) {
        super(driver);
    }

    ///////////////Locators for SuperAdmin LoginPage//////////
    public By SignIN_xpath = By.xpath("//span[text() = 'Sign In']");
    public By LoginEmail_xpath = By.xpath("//input[@name= 'email']");
    public By LoginPwd_xpath = By.xpath("//input[@name= 'password']");
    public By LoginRemMe_xpath = By.xpath("//mat-checkbox[@name = 'rememberMe']");
    public By LoginSignIn_xpath = By.xpath("//button[@type='submit']");
    public By Textverify_xpath = By.xpath("//h1[text() = 'Welcome Micheal']");
    public By InvalidPass_xpath = By.xpath("//div[contains(text(), 'Invalid password')]"); //better to use contains rather then word

    public By Logo_xpath = By.xpath("//img[@src= 'assets/images/logo-dark.svg']");
    public By ContactInfo_xpath = By.xpath("//a[text()= 'info@smartlocumtenens.com']");


}
