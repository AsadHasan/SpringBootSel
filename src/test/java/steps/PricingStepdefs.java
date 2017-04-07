package steps;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java8.En;
import driverfactory.Browser;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import pageobjects.Homepage;
import pageobjects.PricingPage;

import static org.hamcrest.core.Is.is;

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
                case "2 parallel tests (Up to 5 users)":
                    pricingPage.selectLiveOption();
                    break;
                case "4 parallel tests (Up to 10 users)":
                    pricingPage.selectAutomateOption();
                    break;
                case "5 parallel tests (Up to 5 users)":
                    pricingPage.selectAutomateProOption();
                    break;
            }
        });
        Then("^correct \"([^\"]*)\" is returned$", (String arg0) -> {
            switch (arg0){
                case "29":
                    Assert.assertThat("Live price is wrong",pricingPage.getLivePrice(),is(arg0));
                    break;
                case "299":
                    Assert.assertThat("Automate price is wrong",pricingPage.getAutomatePrice(),is(arg0));
                    break;
                case "499":
                    Assert.assertThat("AutomatePro price is wrong",pricingPage.getAutomateProPrice(),is(arg0));
                    break;
            }
        });
    }
}
