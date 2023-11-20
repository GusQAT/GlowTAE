package AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class AbstractComponent
{
    public WebDriver driver;

    public AbstractComponent(WebDriver driver)
    {
        this.driver = driver;
    }

    public void waitForElementToAppear(By findBy)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(240));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public String callBrowser(String callPreferredBrowser) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//Resources//GlobalData.properties");
        prop.load(fis);
        String browserName;
        browserName = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty(callPreferredBrowser);
//        browserName = System.getProperty("browser") != null ? System.getProperty("browser") :prop.getProperty(callDataV);
        System.out.println("CallData Method I " + browserName);
        System.out.println("CallData Method II " + callPreferredBrowser);
//        return prop.getProperty(callDataV);
        return browserName;
    }

    public String callVariables(String callProperties) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//Resources//GlobalData.properties");
        prop.load(fis);
//        String browserName;
//        browserName = System.getProperty("browser") != null ? System.getProperty("browser") :prop.getProperty(callDataV);
//        System.out.println("CallData Method I " + browserNameMav);
//        System.out.println("CallData Method II " + callDataV);
//        return prop.getProperty(callDataV);
        return prop.getProperty(callProperties);
    }


}


