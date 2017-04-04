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
  
    private final String cssLive="div.live-plan li[data-option-array-index='1']";
    @FindBy(css =cssLive) private WebElement livePlanOption;
    @FindBy(css = "div.live-plan .chosen-container") private WebElement livePlanMenu;

    private final String cssAutomate="div.live-plan li[data-option-array-index='2']";
    @FindBy(css =cssLive) private WebElement automatePlanOption;
    @FindBy(css = "div.automate-plan .chosen-container") private WebElement automatePlanMenu;

    private final String cssAutomatePro="div.live-plan li[data-option-array-index='2']";
    @FindBy(css =cssLive) private WebElement automateProPlanOption;
    @FindBy(css = "div.automate-pro-plan .chosen-container") private WebElement automateProPlanMenu;

    private final String cssLivePrice="div.live-plan-section div.plan-price-section span";
    @FindBy(css = cssLivePrice) private WebElement livePrice;

    private final String cssAutomatePrice="div.automate-plan-section div.plan-price-section span";
    @FindBy(css = cssAutomatePrice) private WebElement automatePrice;

    private final String cssAutomateProPrice="div.automate-pro-plan-section div.plan-price-section span";
    @FindBy(css = cssAutomateProPrice) private WebElement automateProPrice;

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

    public PricingPage selectAutomatePlan(){
        pageHelper.wait(15)
                .until(ExpectedConditions
                        .elementToBeClickable(automatePlanMenu));
        automatePlanMenu.click();
        return this;
    }

    public PricingPage selectAutomateOption(){
        pageHelper.wait(15)
                .until(ExpectedConditions.elementToBeClickable(automatePlanOption));
        automatePlanOption.click();
        return this;
    }

    public PricingPage selectAutomateProPlan(){
        pageHelper.wait(15)
                .until(ExpectedConditions
                        .elementToBeClickable(automateProPlanMenu));
        automateProPlanMenu.click();
        return this;
    }

    public PricingPage selectAutomateProOption(){
        pageHelper.wait(15)
                .until(ExpectedConditions.elementToBeClickable(automateProPlanOption));
        automateProPlanOption.click();
        return this;
    }


}
