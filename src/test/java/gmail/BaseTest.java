package gmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by ekaterinabut on 12/1/15.
 */
public class BaseTest {
    public static WebDriver driver;

    public static void init(){
        System.setProperty("webdriver.chrome.driver", "/Users/ekaterinabut/EpamTraining/chromedriver");
        driver=new ChromeDriver();
    }

    public static void close(){
        driver.quit();
    }
}
