package TestComponents;

import AbstractComponents.AbstractComponent;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.OpenPositions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BasePage{

    static WebDriver driver;
    public static WebDriver initializeDriver() throws IOException {

        AbstractComponent globalProperties = new AbstractComponent(driver);

        String browserName = globalProperties.callBrowser("browser");

        System.out.println("Checking what has this variable " + browserName);

        if(browserName.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        }
        else if (browserName.equalsIgnoreCase("edge"))
        {
            EdgeDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        }
        else if (browserName.equalsIgnoreCase("firefox"))
        {
            FirefoxDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
//        Cookie cookies = new Cookie("key", "value");
//        driver.manage().addCookie(cookies);

        String url = globalProperties.callVariables("url");
        driver.get(url);

        return driver;
    }
}
