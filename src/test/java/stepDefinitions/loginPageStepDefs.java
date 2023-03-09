package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.loginPage;
import qaFactory.driverFactory;

public class loginPageStepDefs {

    private loginPage loginPage = new loginPage(driverFactory.getDriver());

    @Given("the user is on signIn page")
    public void user_is_on_login_page() {
        loginPage.launchHomePage();
        loginPage.navigateToSignInPage();
    }

    @When("the user enters username {string}")
    public void user_enters_username(String username) {
        loginPage.enterUsername(username);
    }

    @When("the user enters password {string}")
    public void user_enters_password(String password) {
        loginPage.enterPassword(password);
    }

    @When("user clicks on Login button")
    public void user_clicks_on_login_button() {
        loginPage.clickSignIn();
    }

    @Then("user is succesfully loggedIn")
    public void succesfully_loggedIn() throws InterruptedException {
        Assert.assertTrue(loginPage.verifyLogin());

    }
}










/*

   /* @Given("the user is on signIn page")
    public void navigateToSignInPage() throws InterruptedException {
        loginPage.launchHomePage();
        loginPage.getPageTitle();
        loginPage.navigateToSignInPage();

    }

    @Given("the user is on signIn page")
    public void the_user_is_on_sign_in_page() throws InterruptedException {
        loginPage.launchHomePage();
        loginPage.getPageTitle();
        loginPage.navigateToSignInPage();
        throw new io.cucumber.java.PendingException();
    }


    @When("enter valid (.*) and (.*) and clicked on signin")
    public void enterCredentials(String e , String p){
        loginPage.enterDetails(e, p);

    }

    @Then("The user is succesfully loggedIn")
    public void verifySuccessfulLogIn(){
        loginPage.verifyLogin();

    }*/

/*
    @Given("the user is on signIn page")
    public void the_user_is_on_sign_in_page() throws InterruptedException {
        loginPage.launchHomePage();
        loginPage.getPageTitle();
        loginPage.navigateToSignInPage();
        wait();
        throw new io.cucumber.java.PendingException();
    }
    @When("enter valid {string} and \"\"Shrav@123\"\" and clicked on signin")
    public void enter_valid_and_shrav_and_clicked_on_signin(String e, String p) {
        loginPage.enterDetails(e, p);
        throw new io.cucumber.java.PendingException();
    }
    @Then("The user is succesfully loggedIn")
    public void the_user_is_succesfully_logged_in() {
        loginPage.verifyLogin();
        throw new io.cucumber.java.PendingException();
    }

}
*/
