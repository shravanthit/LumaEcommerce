package qaFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class driverFactory {

    public WebDriver driver;

    public static ThreadLocal<WebDriver>tlDriver = new ThreadLocal<>();

    /**
     * ths method is used to intialize the threadlocal driver on basis of given browser
     * @param browser
     * @return this will return tldriver.
     */
    public WebDriver init_driver(String browser){
        if(browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());
        }

        else if(browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver());

        } else if (browser.equals("safari")) {
            tlDriver.set((new SafariDriver()));
        }
        else{
            System.out.println("Please Pass the correct browser value:" +browser);
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();

    }

    /**
     * this is used to get the driver with ThreadLocal
     * @return
     */
    public static synchronized WebDriver getDriver(){
        return tlDriver.get();
    }
}

