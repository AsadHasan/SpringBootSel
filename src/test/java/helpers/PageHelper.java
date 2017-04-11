package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.Log;

/**
 * Created by Asad.Hasan on 28/03/2017.
 */
public class PageHelper {

    private WebDriver driver;
    private WebDriverWait wait;

    public PageHelper(WebDriver drv){
        driver=drv;
        wait=new WebDriverWait(driver,15);
    }

    public String pageTitle(){
        Log.info("Fetching page title");
        return driver.getTitle();
    }

    public void maximise(){
        Log.info("Maximising browser window");
        driver.manage().window().maximize();
    }

    public void click(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Log.info("Element found, clicking element");
        element.click();
    }

    public String getText(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        Log.info("Element found, fetching element text");
        return element.getText();
    }
}
