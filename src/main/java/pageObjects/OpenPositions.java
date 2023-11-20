package pageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class OpenPositions extends AbstractComponent {

    WebDriver driver;

    public OpenPositions(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Positions']")
    WebElement filterPositionsWindowLocator;

    @FindBy(xpath = "//input[@placeholder='Search for Position...']")
    WebElement searchForPositionLocator;

    @FindBy(xpath = "//li[@class='ng-star-inserted']")
    List<WebElement> options;

    @FindBy(xpath = "//button[@class='apply-btn']")
    WebElement applyFilterButton;

//    @FindBy(xpath = "//span[@class = 'text-no-wrap'] //label[@class = 'label-bold mat-tooltip-trigger']")
    @FindBy(xpath = "//span[@class='text-no-wrap']/label[contains(@class,'label-bold')]")
    List<WebElement> tAEPositions;
    By searchBy = By.xpath("//input[@placeholder='Search for Position...']");

//    public void goTo()
//    {
//        driver.get("https://go.globant.com");
//    }
    public void openPositionsObject() throws InterruptedException {
        filterPositionsWindowLocator.click();
//        Thread.sleep(2000);

    }

    public void searchForPositionObject(String filter)
    {
        waitForElementToAppear(searchBy);
        searchForPositionLocator.sendKeys(filter);
    }

    public void choosePositionOnList(String positionL)
    {
//        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

        for (WebElement option : options)
        {
            System.out.println(option.getText());

            if(option.getText().equalsIgnoreCase(positionL))
            {
                option.click();
                System.out.println("  --------  ");
//                break;
            }
        }
    }

    public void applyFilterObject()
    {

        applyFilterButton.click();
    }

    public void getTAEProjects(String txt) throws InterruptedException {

        System.out.println(txt);

        Thread.sleep(5000);

        for (WebElement tAEPosition : tAEPositions)

        {
            System.out.println("- " + tAEPosition.getText());
        }

    }
}
