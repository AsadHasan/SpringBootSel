package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Asad.Hasan on 28/03/2017.
 */
public class PageHelper {

    private WebDriver driver;
    private WebDriverWait wait;

    public PageHelper(WebDriver drv){
        driver=drv;
    }

    public WebDriverWait wait(int timeout){
        wait=new WebDriverWait(driver,timeout);
        return wait;
    }

    public String pageTitle(){
        return driver.getTitle();
    }

    public void maximise(){
        driver.manage().window().maximize();
    }
}
