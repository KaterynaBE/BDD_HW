package gmail;

import cucumber.api.CucumberOptions;
// import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

/**
 * Created by ekaterinabut on 12/1/15.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        plugin = {
                "pretty", "json:target/Cucumber.json",
                "html:target/cucumber-html-report"
        }
)
public class gmailTest {
    @BeforeClass
//    @Before ? gives an error on runner
    public static void initSelenium(){
        BaseTest.init();
    }

    @AfterClass
    public static void closeSelenium(){
        BaseTest.close();
    }
}
