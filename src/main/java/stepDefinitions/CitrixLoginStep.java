package stepDefinitions;

import AbstractComponents.AbstractComponent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.io.IOException;
import static TestComponents.BasePage.initializeDriver;

public class CitrixLoginStep{

    WebDriver driver;
    pageObjects.CitrixLogin landingPage;

    @Given("go to Citrix page")
    public void goToCitrixPage() throws IOException
    {
        driver = initializeDriver();
    }

    @Given("{String} welcome text is displayed on Citrix page")
    public void landedOnCitrixPage(String element)
    {
        landingPage = new pageObjects.CitrixLogin(driver);

        String getGoogleConfirmation = landingPage.getConfirmationGooglePage();
        Assert.assertTrue(getGoogleConfirmation.toLowerCase().contains(element));
    }

    @When("^I add (.+) and (.+)$") // Regular Expression    //    ^ is called caret symbol
    public void addUsernameAndPassword(String username, String password)
    {
        AbstractComponent callM = new AbstractComponent(driver);

//        String loginEmail = callM.callData("email");

        landingPage.inputEmailAddressGoogle(username);

        landingPage.clickOnSiguienteButton();

        landingPage.insertPasswordGoogle(password);
    }

    @Then("Show password on the screen")
    public void showPasswordOnTheScreen()
    {
        landingPage.seePassword();
    }

    @And("Click on Google Next button")
    public void clickOnGoogleNextButton()
    {
        landingPage.googleNextbutton();
    }

}
