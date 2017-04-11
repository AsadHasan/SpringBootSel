package pageobjects;

import helpers.PageHelper;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import utility.Log;

import static org.hamcrest.core.Is.is;

/**
 * Created by Asad.Hasan on 24/03/2017.
 */

public class PricingPage extends LoadableComponent{

    private WebDriver driver;
    private PageHelper pageHelper;

    private final String cssLive="div.live-plan li[data-option-array-index='1']";
    @FindBy(css =cssLive) private WebElement livePlanOption;
    @FindBy(css = "div.live-plan .chosen-container") private WebElement livePlanMenu;

    private final String cssAutomate="div.automate-plan li[data-option-array-index='2']";
    @FindBy(css =cssAutomate) private WebElement automatePlanOption;
    @FindBy(css = "div.automate-plan .chosen-container") private WebElement automatePlanMenu;

    private final String cssAutomatePro="div.automate-pro-plan li[data-option-array-index='2']";
    @FindBy(css =cssAutomatePro) private WebElement automateProPlanOption;
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

    @Override
    protected void load(){
        Log.info("Loading pricing page");
        driver.get("https://www.browserstack.com/pricing");
        pageHelper.maximise();
    }

    @Override
    protected void isLoaded() throws Error{
        String title = pageHelper.pageTitle();
        Assert.assertThat("Not on the right page.", title.contains("BrowserStack Plans and Pricing"),is(true));
    }

    public PricingPage selectLivePlan(){
        pageHelper.click(livePlanMenu);
        return this;
    }

    public PricingPage selectLiveOption(){
        pageHelper.click(livePlanOption);
        return this;
    }

    public PricingPage selectAutomatePlan(){
        pageHelper.click(automatePlanMenu);
        return this;
    }

    public PricingPage selectAutomateOption(){
        pageHelper.click(automatePlanOption);
        return this;
    }

    public PricingPage selectAutomateProPlan(){
        pageHelper.click(automateProPlanMenu);
        return this;
    }

    public PricingPage selectAutomateProOption(){
        pageHelper.click(automateProPlanOption);
        return this;
    }

    public String getLivePrice(){
        return pageHelper.getText(livePrice);
    }

    public String getAutomatePrice(){
        return pageHelper.getText(automatePrice);
    }

    public String getAutomateProPrice(){
        return pageHelper.getText(automateProPrice);
    }
}
