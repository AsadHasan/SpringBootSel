package steps;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java8.En;
import driverfactory.Browser;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import pageobjects.Homepage;
import pageobjects.PricingPage;

/**
 * Created by Asad.Hasan on 24/03/2017.
 */
@ContextConfiguration(classes = Browser.class)
public class PricingStepdefs implements En {

//    @Autowired private WebDriver driver;
    private WebDriver driver;
    private Homepage homepage;
    private PricingPage pricingPage;
    @Autowired private ApplicationContext appContext;

    @Before("@chrome")
    public void chrome(){
        driver=(WebDriver)appContext.getBean("getChrome");
        pricingPage=new PricingPage(driver);
    }

    @Before("@phantom")
    public void phantom(){
        driver=(WebDriver)appContext.getBean("getPhantom");
        pricingPage=new PricingPage(driver);
    }

    @Before("@edge")
    public void edge(){
        driver=(WebDriver)appContext.getBean("getEdge");
        pricingPage=new PricingPage(driver);
    }

    @Before("@htmlunit")
    public void htmlunit(){
        driver=(WebDriver)appContext.getBean("getHtmlUnit");
        pricingPage=new PricingPage(driver);
    }

    public PricingStepdefs() {
        Given("^I am on the pricing page$", () -> {
            pricingPage.get();
        });
        Given("^I select \"([^\"]*)\"$", (String arg0) -> {
            switch (arg0){
                case "Live":
                    pricingPage.selectLivePlan();
                    break;
                case "Automate":
                    pricingPage.selectAutomatePlan();
                    break;
                case "Automate Pro":
                    pricingPage.selectAutomateProPlan();
                    break;
            }
        });
        When("^I choose \"([^\"]*)\"$", (String arg0) -> {
            switch (arg0){
                case "Live":
                    pricingPage.selectLiveOption();
                    break;
                case "Automate":
                    pricingPage.selectAutomateOption();
                    break;
                case "Automate Pro":
                    pricingPage.selectAutomateProOption();
                    break;
            }
        });
        Then("^correct \"([^\"]*)\" is returned$", (String arg0) -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });
    }
}
