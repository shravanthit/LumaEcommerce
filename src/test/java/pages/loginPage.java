package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import qaFactory.driverFactory;

public class loginPage {

    private WebDriver driver;

    public loginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By getTitle = By.xpath("//p[contains(text(),'This is a demo store. No orders will be fulfilled.')]");
    private By signLink = //By.linkText("Sign In ");
            By.xpath("//a[contains(text(),'Sign In')][1]");
    private By email = By.id("email");

    private By password = By.id("pass");

    private By signInBtn = By.id("send2");

    private By defaultWelcomeMsg = By.xpath("//span[contains(text(),'Default welcome msg!')][1]");
    private By welcomeUserName = By.xpath("//span[contains(text(),'Welcome, ss ttt!')][1]");

    private By womenCategory = By.xpath("//span[contains(text(),'Women')]");


    public void launchHomePage() {
        driverFactory.getDriver().get("https://magento.softwaretestingboard.com/");
        //wait(2);
        // driver.findElement(signLink).click();

    }

    /*public String getPageTitle() {
        return driver.getTitle();

    }*/

    public void navigateToSignInPage() {
        driver.findElement(signLink).click();
        driver.findElement(getTitle).isDisplayed();
        // String text = driver.getTitle();
        //System.out.print("text displayed as",+text);
    }

    public void enterUsername(String username) {
        // driver.findElement(email).isDisplayed();
        driver.findElement(email).sendKeys(username);

    }

    public void enterPassword(String pwd) {

        driver.findElement(password).sendKeys(pwd);
    }

    public void clickSignIn() {
        driver.findElement(signInBtn).click();
    }

    public boolean verifyLogin() throws InterruptedException {
        driver.manage().window().maximize();
        Thread.sleep(2);
        driver.findElement(womenCategory);
        return driver.findElement(womenCategory).isDisplayed();
       // driver.findElement(welcomeUserName);
        //return driver.findElement(welcomeUserName).isDisplayed();
    }
    public accountsPage doLogin(String un, String pwd) {
        System.out.println("login with: " + un + " and " + pwd);
        driver.findElement(email).sendKeys(un);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signInBtn).click();
        return new accountsPage(driver);
    }
}
