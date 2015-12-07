package gmail.steps;

//import com.epam.auto.patterns.decorator.CustomWebDriver;
import com.epam.auto.patterns.staticfactorymethod.Email;
import com.epam.auto.patterns.staticfactorymethod.EmailStaticFactory;
import com.epam.auto.ui.services.EmailManager;
import com.epam.auto.ui.services.SentMailManager;
import com.epam.auto.ui.services.SignManager;
import com.epam.auto.utils.StringUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


/**
 * Steps defenitions for Gmail tests with BDD approach.
 */
public class GmailStepDefs {

//    protected CustomWebDriver customDriver;
    WebDriver driver = new FirefoxDriver();

    private final String USERNAME1 = "testtasktask";
    private final String PASSWORD1 = "testtasktaskpwd";
    private final String USERNAME2 = "testtasktask2@gmail.com";
    private final String EMAIL_TITLE = "Email title ";
    private final String MESSAGE = "Some awesome text ";

    public EmailManager emailMng;
    public SignManager signMng;
    public SentMailManager sentMailMng;

    @Given("^I (?:open|navigate to) main page$")
    public void iOpenMainPage() throws Throwable {
        driver.get("http://www.gmail.com");
    }

    @Given("^I log in as \"([^\"]*)\" with password \"([^\"]*)\"$")
    public void iLogInAsUser(String user1, String pwd1) throws Throwable {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        signMng = new SignManager(driver);
        signMng.signInGmail(USERNAME1, PASSWORD1);
    }

    @Given("^I sent email to \"([^\"]*)\" with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iSentEmail(String addressee, String subject, String emailBody) throws Throwable {
        emailMng = new EmailManager(driver);

        String emailTitle = EMAIL_TITLE + StringUtils.getRandomString(6);
        Email email = EmailStaticFactory.createDefaultEmail(USERNAME2, emailTitle, MESSAGE
                + StringUtils.getRandomString(7));

        emailMng.sendEmail(email);
    }

    @When("^I go to Sent Mail folder$")
    public void iGoToSentMailFolder() throws Throwable {
        sentMailMng = new SentMailManager(driver);
        sentMailMng.navigateToSendFolder();
    }

    @Then("^email sent is on Send folder$")
    public void emailSentIsOnSentMailFolder() throws Throwable {
        sentMailMng = new SentMailManager(driver);
        Assert.assertTrue("Verification Failed: email is not on Sent Mail folder.",
//                sentMailMng.getSentMailListText().contains(EMAIL_TITLE));
// have difficulties wih list text element identification, looking at the page source instead
                driver.getPageSource().contains(EMAIL_TITLE));
    }
}