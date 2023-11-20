package pageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CitrixLogin extends AbstractComponent {

    WebDriver driver;

    public CitrixLogin(WebDriver driver) // Constructor Method
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //WebElement SignInGoogle = driver.findElement(By.xpath("//div[@class='google-text']"));

    @FindBy(xpath = "//span[text()='Siguiente']")
    WebElement locatorClickonSiguienteButton;

    @FindBy(xpath = "//*[text()='Acceder']")
    WebElement confirmationGooglePage;

    @FindBy(xpath = "//input[@name='identifier']")
    WebElement inputEmailAddress;

    @FindBy(xpath = "//a[@class='storeapp-details-link']//img[@alt='Glow']")
    WebElement openGlowFromCitrix;

    @FindBy(xpath = "//input[@type='password']")
    WebElement insertPassword;

    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement seeCitrixPassword;

    @FindBy(xpath = "//span[text()='Siguiente']")
    WebElement nextButton;

    By insertPasswordBy = By.xpath("//input[@type='password']");

    public void clickOnSiguienteButton()
    {
        locatorClickonSiguienteButton.click();
    }
    public String getConfirmationGooglePage()
    {
        return confirmationGooglePage.getText();
    }
    public void inputEmailAddressGoogle(String emailAddress)
    {
        inputEmailAddress.sendKeys(emailAddress);
    }
    public void openGlowFromCitrixButton ()
    {
        openGlowFromCitrix.click();
    }
    public void insertPasswordGoogle(String insertPasswordGoogle)
    {
        waitForElementToAppear(insertPasswordBy);
        insertPassword.sendKeys(insertPasswordGoogle);
    }

    public void seePassword()
    {
        seeCitrixPassword.click();
    }

    public void googleNextbutton()
    {
        nextButton.click();
    }

}
