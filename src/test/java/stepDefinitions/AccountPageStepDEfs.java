package stepDefinitions;

import io.cucumber.java.en.*;
import pages.accountsPage;
import pages.loginPage;
import qaFactory.driverFactory;

import java.util.List;
import java.util.Map;

public class AccountPageStepDEfs {
    private loginPage LoginPage = new loginPage(driverFactory.getDriver());
    private accountsPage AccountsPage;
    @Given("user has already logged into application")
    public void user_has_already_logged_into_application(io.cucumber.datatable.DataTable credTable) {
        List<Map<String, String>> credList = credTable.asMaps();
        String userName = credList.get(0).get("username");
        String password = credList.get(0).get("password");

        driverFactory.getDriver()
                .get("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/");
        //LoginPage.navigateToSignInPage();
        LoginPage.doLogin(userName,password);
        //AccountsPage = LoginPage.doLogin(userName, password);

    }

    @Given("user is on Accounts page")
    public void user_is_on_accounts_page() {
        AccountsPage.navigateToAccountsPage();
        }

    @When("user gets the title of the page")
    public void user_gets_the_title_of_the_page() {

       AccountsPage.getAccountOptionsCount();
        AccountsPage.accountsPageOptionList();
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String string) {
        AccountsPage.getAccountPageTitle();
    }


}
