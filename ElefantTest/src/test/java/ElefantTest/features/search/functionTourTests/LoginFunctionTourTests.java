package ElefantTest.features.search.functionTourTests;

import ElefantTest.steps.serenity.LoginSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class LoginFunctionTourTests {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public LoginSteps loginSteps;

    @Test
    public void loginWithEmptyEmail() {
        loginSteps.isLoginPage();
        loginSteps.loginSteps("","mire");
        loginSteps.shouldEmailBeRead();
        loginSteps.shouldErrorEmailBeDisplayed("Introdu o adresa de email!");
    }

    @Test
    public void loginWithEmailWithLength1() {
        loginSteps.isLoginPage();
        loginSteps.loginSteps("b","secret");
        loginSteps.shouldEmailBeRead();
        loginSteps.shouldErrorEmailBeDisplayed("Introdu o adresa de email valida!");
    }

    @Test
    public void loginWithInvalidEmail() {
        loginSteps.isLoginPage();
        loginSteps.loginSteps("bocsa_mirela@ya","secret");
        loginSteps.shouldShowInvalidEmailOrPass("Email-ul si/sau parola introduse sunt gresite.");
    }

    @Test
    public void loginWithEmptyPassword() {
        loginSteps.isLoginPage();
        loginSteps.loginSteps("bocsa_mirela@yahoo.com","");
        loginSteps.shouldPasswordBeRead();
        loginSteps.shouldErrorPAssBeDisplayed("Introdu o parola!");
    }

    @Test
    public void loginWithPasswordWithLength1() {
        loginSteps.isLoginPage();
        loginSteps.loginSteps("bocsa_mirela@yahoo.com","s");
        loginSteps.shouldShowInvalidEmailOrPass("email-ul si/sau parola introduse sunt gresite.");
    }

    @Test
    public void loginWithInvalidAccount() {
        loginSteps.isLoginPage();
        loginSteps.loginSteps("mirela.bocsa@x2mobile.net","sdsd");
        loginSteps.shouldShowInvalidEmailOrPass("Email-ul si/sau parola introduse sunt gresite.");
    }

    @Test
    public void loginWithValidAccount() {
        loginSteps.isLoginPage();
        loginSteps.loginSteps("mirela.bocsa@x2mobile.net","123ABC");
        loginSteps.shouldBeLogged("Mirela");
    }

} 