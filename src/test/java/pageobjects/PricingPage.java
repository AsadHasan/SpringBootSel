package pageobjects;

import helpers.PageHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Asad.Hasan on 24/03/2017.
 */

public class PricingPage {

    private WebDriver driver;
    private PageHelper pageHelper;
    //2 parallel tests (Up to 5 users)
    //2 parallel tests (Up to 5 users)
    private final String cssLive="div.live-plan li[data-option-array-index='3']";
   @FindBy(css =cssLive) private WebElement livePlanOption;
   @FindBy(css = "div.live-plan .chosen-container") private WebElement livePlanMenu;

    public PricingPage(WebDriver drv){
        driver=drv;
        pageHelper=new PageHelper(driver);
        PageFactory.initElements(driver,this);
    }

    public PricingPage selectLivePlan(){

        pageHelper.wait(15)
                .until(ExpectedConditions
                .elementToBeClickable(livePlanMenu));
        livePlanMenu.click();
        return this;
    }

    public PricingPage selectLiveOption(){
        pageHelper.wait(15)
                .until(ExpectedConditions.elementToBeClickable(livePlanOption));
        livePlanOption.click();
        return this;
    }
}
