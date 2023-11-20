package pageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppsPool extends AbstractComponent {

    WebDriver driver;
    public AppsPool(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//img[@src='/logon/images/glow-logo.png']")
    WebElement glowIcon;

    @FindBy(xpath = "//div[@class='google-text']")
    WebElement signInWithGoogleLocator;

    @FindBy(xpath = "//div[@class='WBW9sf']")
    WebElement selectGoogleAccount;

    @FindBy(xpath = "//div[@class='google-oauth-login']//button[contains(@class, 'btn-google') and contains(@class, 'oauth') and contains(@class, 'center-block')]")
    WebElement selectGoogleAccountSpinner;

    By glowIconBy = By.xpath("//img[@src='/logon/images/glow-logo.png']");
    By signInBy = By.xpath("//div[@class='google-text']");
    By selectGoogleBy = By.xpath("//div[@class='WBW9sf']");
    By spiner = By.xpath("//div[@class='google-oauth-login']//button[contains(@class, 'btn-google') and contains(@class, 'oauth') and contains(@class, 'center-block')]");

    public void clickGlowIcon() throws InterruptedException {

        waitForElementToAppear(glowIconBy);
        glowIcon.click();

//        Thread.sleep(15000);
    }
    public void signInWithGoogle() throws InterruptedException {

        waitForElementToAppear(signInBy);
        signInWithGoogleLocator.click();

        Thread.sleep(5000);
    }
    public void selectGoogleAccountForGlow() throws InterruptedException {

        waitForElementToAppear(selectGoogleBy);
        selectGoogleAccount.click();
//        Thread.sleep(8000);
//        waitForElementToAppear(spiner);
//        selectGoogleAccountSpinner.click();
        }
    }