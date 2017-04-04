package driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.springframework.context.annotation.Bean;

/**
 * Created by Asad.Hasan on 24/03/2017.
 */

public class Browser {

    @Bean
    public WebDriver getChrome(){
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/drivers/chromedriver.exe");
        return new ChromeDriver();
    }

    @Bean
    public WebDriver getPhantom(){
        System.setProperty("phantomjs.binary.path",
                "src/test/resources/drivers/phantomjs.exe");
        return new PhantomJSDriver();
    }

    @Bean
    public WebDriver getHtmlUnit(){
        return new HtmlUnitDriver();
    }

}
