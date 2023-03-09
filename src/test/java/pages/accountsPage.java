package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class accountsPage {

    private WebDriver driver;
    private By dropDownAccIcon = By.xpath("//span[@class=\"customer-name active\"]");

    private By accountOptionList = By.xpath("//div[@class=\"customer-menu\"]//li");

    private By myAccountText = By.xpath("//span[contains(text(),'My Account')]");

    public accountsPage(WebDriver driver) {
        this.driver = driver;
    }


    public void navigateToAccountsPage() {
        driver.findElement(dropDownAccIcon).click();


    }

    public int getAccountOptionsCount() {
        return driver.findElements(accountOptionList).size() - 3;
    }

    public List<String> accountsPageOptionList() {

        List<String> accountList = new ArrayList<>();
        List<WebElement> accountsHeaderList = driver.findElements(accountOptionList);

        for (WebElement e : accountsHeaderList) {
            String text = e.getText();
            System.out.println(text);
            if (e.getText().contains("My Account"))
                e.click();

        }

        //accountList.add(text);
        return accountList;
    }


    public void getAccountPageTitle() {
        driver.findElement(myAccountText).getText();
        String accountText = driver.findElement(myAccountText).getText();
        System.out.println("text is: " + accountText);
    }


}

