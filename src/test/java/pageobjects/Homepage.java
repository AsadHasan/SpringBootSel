package pageobjects;

import helpers.PageHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Asad.Hasan on 24/03/2017.
 */

public class Homepage {

   private WebDriver driver;
   private WebDriverWait wait;
   private PageHelper pageHelper;

    @FindBy(css = "a.reg-link") private WebElement pricing;

    public Homepage(WebDriver drv){
        driver=drv;
        PageFactory.initElements(driver,this);
        pageHelper=new PageHelper(driver);
    }

    public PricingPage checkPricing(){
        pageHelper.wait(15)
                .until(ExpectedConditions.elementToBeClickable(pricing));
        pricing.click();
        return new PricingPage(driver);
    }
}
