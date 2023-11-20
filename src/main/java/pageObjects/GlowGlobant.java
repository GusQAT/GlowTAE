package pageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

public class GlowGlobant extends AbstractComponent {

    WebDriver driver;
    public GlowGlobant (WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//span[contains(text(),'Staffing')]")
    WebElement staffingButtonLocator;
    @FindBy(xpath="//span[contains(text(),'Open Career')]")
    WebElement staffingOpenCareer;
    @FindBy(css="button.hamburger")
    WebElement sidebarMenuButton;
    @FindBy(id="menu-3")
    WebElement staffingButtonOpens;

    By staffingBy = By.xpath("//span[contains(text(),'Staffing')]");
    By openCareerBy = By.xpath("//span[contains(text(),'Open Career')]");

    By staffingMainButton = By.xpath("button.hamburger");
    public void setSidebarMenuButton()
    {
        String classAttribute = sidebarMenuButton.getAttribute("class");
        if (!classAttribute.contains("open")) {
            sidebarMenuButton.click();
        }
    }

    public void setStaffingButtonOpens()
    {
        String classAttribute = staffingButtonOpens.getAttribute("class");
        if (!classAttribute.contains("option-open")) {
            staffingButtonOpens.click();
        }
    }
//    public void staffingButtonSideBar() throws InterruptedException {
//
//
////        waitForElementToAppear(staffingBy);
//        staffingButtonLocator.click();
//        Thread.sleep(3000);
//
//
//    }

    public void staffingOpenCareerSideBar() throws InterruptedException {

        waitForElementToAppear(openCareerBy);
        staffingOpenCareer.click();
        Thread.sleep(13000);
    }

}
