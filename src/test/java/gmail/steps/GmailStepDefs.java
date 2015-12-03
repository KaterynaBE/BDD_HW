package gmail.steps;

import com.epam.auto.patterns.staticfactorymethod.Email;
import com.epam.auto.patterns.staticfactorymethod.EmailStaticFactory;
import com.epam.auto.ui.services.EmailManager;
import com.epam.auto.ui.services.SentMailManager;
import com.epam.auto.ui.services.SignManager;
import com.epam.auto.utils.StringUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gmail.BaseTest;
import org.junit.Assert;


/**
 * Created by ekaterinabut on 12/1/15.
 */
public class GmailStepDefs extends BaseTest {

    private final String USERNAME1 = "testtasktask";
    private final String PASSWORD1 = "testtasktaskpwd";
    private final String USERNAME2 = "testtasktask2@gmail.com";
    private final String EMAIL_TITLE = "Email title ";
    private final String MESSAGE = "Some awesome text ";

    public EmailManager emailMng;
    public SignManager signMng;
    public SentMailManager sentMailMng;
//    private SignInPage signinPage;

    @Given("^I (?:open|navigate to) main page$")
    public void iOpenMainPage() throws Throwable {
        driver.get("http://www.gmail.com");
    }

    @Given("^I log in as \"([^\"]*)\" with password \"([^\"]*)\"$")
    public void iLogInAsUser(String user1, String pwd1) throws Throwable {
        signMng = new SignManager(driver);
        signMng.signInGmail(USERNAME1, PASSWORD1);
//        signinPage = new SignInPage(driver);
//        signinPage.signIn("testtasktask", "testtasktaskpwd");
// ? - can't find 2nd element (password field by id). Same w/o using page, just element-by-element steps
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
                sentMailMng.getSentMailListText().contains(EMAIL_TITLE));
    }
}