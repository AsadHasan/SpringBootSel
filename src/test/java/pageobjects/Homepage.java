package pageobjects;

import helpers.PageHelper;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import static org.hamcrest.core.Is.is;

/**
 * Created by Asad.Hasan on 24/03/2017.
 */

public class Homepage extends LoadableComponent{

   private WebDriver driver;
   private PageHelper pageHelper;

    @FindBy(css = "a.reg-link") private WebElement pricing;

    public Homepage(WebDriver drv){
        driver=drv;
        PageFactory.initElements(driver,this);
        pageHelper=new PageHelper(driver);
    }

    @Override
    protected void load(){
        driver.get("https://www.browserstack.com/");
        pageHelper.maximise();
    }

    @Override
    protected void isLoaded() throws Error{
        String title = pageHelper.pageTitle();
        Assert.assertThat("Not on the right page.", title.contains("Cross Browser Testing Tool."),is(true));
    }

    public PricingPage checkPricing(){
        pageHelper.click(pricing);
        pricing.click();
        return new PricingPage(driver);
    }
}
