package gmail.steps;

import com.epam.auto.patterns.decorator.CustomWebDriver;
import com.epam.auto.patterns.staticfactorymethod.Email;
import com.epam.auto.patterns.staticfactorymethod.EmailStaticFactory;
import com.epam.auto.ui.services.DraftsManager;
import com.epam.auto.ui.services.EmailManager;
import com.epam.auto.ui.services.SentMailManager;
import com.epam.auto.ui.services.SignManager;
import com.epam.auto.utils.StringUtils;
import cucumber.api.java.Before;
import cucumber.api.java.After;
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
    protected static CustomWebDriver customDriver;

    private final String EMAIL_TITLE = "Email title ";
    private final String MESSAGE = "Some awesome text ";
    private final String EMPTY_DRAFTS_MESSAGE = "You don't have any saved drafts.";

    public EmailManager emailMng;
    public SignManager signMng;
    public SentMailManager sentMailMng;
    public DraftsManager draftsMng;

    @Before
    public static void setUp() {
        WebDriver driver = new FirefoxDriver();
        customDriver = new CustomWebDriver(driver);
        driver.manage().window().maximize();
    }

    @Before
    public void initManagers() {
        emailMng = new EmailManager(customDriver);
        signMng = new SignManager(customDriver);
        draftsMng = new DraftsManager(customDriver);
        sentMailMng = new SentMailManager(customDriver);
    }

    @Given("^I (?:open|navigate to) main page$")
    public void openMainPage() throws Throwable {
        customDriver.get("http://www.gmail.com");
    }

    @Given("^I log in as \"([^\"]*)\" with password \"([^\"]*)\"$")
    public void logIn(String user, String password) throws Throwable {
        customDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        signMng.signInGmail(user, password);
    }

    @Given("^I create email to sent to \"([^\"]*)\" with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void createEmail(String addressee, String Title, String body) throws Throwable {

        String emailTitle = StringUtils.getRandomString(6);
        Email email = EmailStaticFactory.createDefaultEmail(addressee, emailTitle, StringUtils.getRandomString(7));

        emailMng.createEmailClosePopup(email);
    }

    @Given("^I go to Drafts folder$")
    public void navigateToDraftFolder() throws Throwable {
        draftsMng.navigateToDraftsFolder();
    }

    @When("^I sent email to \"([^\"]*)\" with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void sentEmail(String addressee, String subject, String emailBody) throws Throwable {

        String emailTitle = StringUtils.getRandomString(6);
        Email email = EmailStaticFactory.createDefaultEmail(addressee, emailTitle, StringUtils.getRandomString(7));

        emailMng.sendEmail(email);
    }

    @When("^I go to Sent Mail folder$")
    public void navigateToSendFolder() throws Throwable {
        sentMailMng.navigateToSendFolder();
    }

    @When("^I sent email from Drafts folder$")
         public void sentEmail() throws Throwable {
         draftsMng.openAndSendDraft();
    }

    @Then("^email sent is on Send folder$")
    public void ensureThatEmailWasSent() throws Throwable {
        Assert.assertTrue("Email is not on Sent Mail folder.",
//                sentMailMng.getSentMailListText().contains(EMAIL_TITLE));
// have difficulties wih list text element identification, looking at the page source instead
                customDriver.getPageSource().contains(EMAIL_TITLE));
    }

    @Then("^Draft folder is empty$")
    public void ensureThatDraftsAreEmpty() throws Throwable {
        //OR -> Assert.assertTrue("Verification Failed: textTo add", draftsMng.getDraftsListText().contains(EMAIL_TITLE));
        Assert.assertTrue("Draft folder is not empty",
                customDriver.getPageSource().contains(EMPTY_DRAFTS_MESSAGE));
    }

    @After
    public static void tearDown(){
        customDriver.quit();
    }
}