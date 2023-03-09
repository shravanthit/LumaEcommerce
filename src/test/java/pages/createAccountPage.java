package pages;

import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.FindBy;


public class createAccountPage {

    @FindBy(xpath = ("//a[contains(text(),'Create an Account')]/@href"))
    public WebElement createAccount;

    @FindBy(id = "firstname")
    public WebElement firstNameText;
    @FindBy(id = "lastname")
    public WebElement lastnameText;

    @FindBy(id = "email_address")
    public WebElement emailAddress;
    @FindBy(id = "password")
    public WebElement registrationPwd;

    @FindBy(id = "password-confirmation")
    public WebElement registrationPwdConfirmation;

    @FindBy(xpath = ("//button[@class='action submit primary']"))
    WebElement createAccountBtn;

}
