package gmail;

import com.epam.auto.patterns.decorator.CustomWebDriver;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by ekaterinabut on 12/6/15.
 */
public class BaseTest {

    protected CustomWebDriver customDriver;
    @Before
    public void setUp() {
        WebDriver driver = new FirefoxDriver();
        customDriver = new CustomWebDriver(driver);
    }

    @After
    public void tearDown(){
        customDriver.quit();
    }
}
