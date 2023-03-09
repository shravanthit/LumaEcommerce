package appHooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import Utils.configReader;
import qaFactory.driverFactory;
import io.cucumber.java.Before;

import java.util.Properties;

public class appHooks {
    private driverFactory driverFactory;
    private WebDriver driver;
    private configReader configReader;
    Properties prop;

    @Before(order = 0)
    public void getProperty(){
        configReader = new configReader();
      prop =  configReader.init_prop();

    }
    @Before(order = 1)
    public void launchBrowser(){
        String browserName = prop.getProperty("browser");
        driverFactory =new driverFactory();
        driver = driverFactory.init_driver(browserName);
    }
    @After(order = 0)
    public void quitBrowser(){
        driver.quit();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            String screenshotName = scenario.getName().replaceAll("","_");
            byte[] sourcepath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcepath,"image/png",screenshotName);
        }
    }
}
