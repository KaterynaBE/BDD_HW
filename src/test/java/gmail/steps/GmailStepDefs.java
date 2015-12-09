package gmail.steps;

//import com.epam.auto.patterns.decorator.CustomWebDriver;
import com.epam.auto.patterns.staticfactorymethod.Email;
import com.epam.auto.patterns.staticfactorymethod.EmailStaticFactory;
import com.epam.auto.ui.services.DraftsManager;
import com.epam.auto.ui.services.EmailManager;
import com.epam.auto.ui.services.SentMailManager;
import com.epam.auto.ui.services.SignManager;
import com.epam.auto.utils.StringUtils;
import cucumber.api.java.Before;
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

    // protected CustomWebDriver customDriver;
    WebDriver driver = new FirefoxDriver();

    private final String USERNAME1 = "testtasktask";
    private final String PASSWORD1 = "testtasktaskpwd";
    private final String USERNAME2 = "testtasktask2@gmail.com";
    private final String EMAIL_TITLE = "Email title ";
    private final String MESSAGE = "Some awesome text ";
    private final String EMPTY_DRAFTS_MESSAGE = "You don't have any saved drafts.";

    public EmailManager emailMng;
    public SignManager signMng;
    public SentMailManager sentMailMng;
    public DraftsManager draftsMng;

    @Before
    public void initManagers() {
        emailMng = new EmailManager(driver);
        signMng = new SignManager(driver);
        draftsMng = new DraftsManager(driver);
        sentMailMng = new SentMailManager(driver);
    }

    @Given("^I (?:open|navigate to) main page$")
    public void iOpenMainPage() throws Throwable {
        driver.get("http://www.gmail.com");
    }

    @Given("^I log in as \"([^\"]*)\" with password \"([^\"]*)\"$")
    public void iLogInAsUser(String user1, String pwd1) throws Throwable {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        signMng.signInGmail(USERNAME1, PASSWORD1);
    }

    @Given("^I sent email to \"([^\"]*)\" with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iSentEmail(String addressee, String subject, String emailBody) throws Throwable {

        String emailTitle = EMAIL_TITLE + StringUtils.getRandomString(6);
        Email email = EmailStaticFactory.createDefaultEmail(USERNAME2, emailTitle, MESSAGE
                + StringUtils.getRandomString(7));

        emailMng.sendEmail(email);
    }

    @Given("^I create email to sent to \"([^\"]*)\" with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iCreateEmail(String addressee, String subject, String emailBody) throws Throwable {

        String emailTitle = EMAIL_TITLE + StringUtils.getRandomString(6);
        Email email = EmailStaticFactory.createDefaultEmail(USERNAME2, emailTitle, MESSAGE
                + StringUtils.getRandomString(7));

        emailMng.createEmailClosePopup(email);
    }

    @Given("^I go to Drafts folder$")
    public void iGoToDraftFolder() throws Throwable {
        draftsMng.navigateToDraftsFolder();
    }


    @When("^I go to Sent Mail folder$")
    public void iGoToSentMailFolder() throws Throwable {
        sentMailMng.navigateToSendFolder();
    }

    @When("^I sent email from Drafts folder$")
         public void I_sent_email() throws Throwable {
         draftsMng.openAndSendDraft();
    }

    @Then("^email sent is on Send folder$")
    public void emailSentIsOnSentMailFolder() throws Throwable {
        Assert.assertTrue("Verification Failed: email is not on Sent Mail folder.",
//                sentMailMng.getSentMailListText().contains(EMAIL_TITLE));
// have difficulties wih list text element identification, looking at the page source instead
                driver.getPageSource().contains(EMAIL_TITLE));
    }

    @Then("^Draft folder is empty$")
    public void draftFolderIsEmpty() throws Throwable {
        //Assert.assertTrue("Verification Failed: textTo add", draftsMng.getDraftsListText().contains(EMAIL_TITLE));
        Assert.assertTrue("Verification Failed: Draft folder is not empty",
                driver.getPageSource().contains(EMPTY_DRAFTS_MESSAGE));
    }
}