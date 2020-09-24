package test;

import com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import utils.Constants;

import java.time.Duration;

import static org.awaitility.Awaitility.await;

public class LoginPageTests extends BaseTests {


    @Test
    public void isPageDisplayed () {
        basePage.loginPage.open();
        Assert.assertTrue((basePage.isElementDisplayed(basePage.loginPage.loginButton)));
    }

    @Test
    public void isTitleDisplayed() {
        basePage.loginPage.open();
        Assert.assertTrue(basePage.isElementDisplayed(basePage.loginPage.title));
    }

    @Test
    public void isErrorsMessageFieldDisplayed(){
        basePage.loginPage.open();
        basePage.loginPage.loginButtonClick();
        await().atMost(Duration.ofSeconds(Constants.AW_WAIT_TIME)).until(()->basePage.loginPage.errorMessageField.isDisplayed());
        Assert.assertTrue((basePage.isElementDisplayed( basePage.loginPage.errorMessageField)));
    }

    @Test
    public void fullValidationErrorListSize () {
        basePage.loginPage.open();
        basePage.loginPage.loginButtonClick();
        await().atMost(Duration.ofSeconds(Constants.AW_WAIT_TIME)).until(()->basePage.loginPage.errorMessageField.isDisplayed());
        Assert.assertEquals(4,basePage.loginPage.getValidationListSize());

    }

    @Test
    public void validCredentialsWhenLogin() {
        basePage.loginPage.open();
        basePage.loginPage.fillInEmailField();
        basePage.loginPage.fillInPasswordField();
        basePage.loginPage.loginButtonClick();
        await().atMost(Duration.ofSeconds(Constants.AW_WAIT_TIME)).until(() -> basePage.loginPage.emailField.getAttribute("value").equals("E-mail address"));
        Assert.assertFalse((basePage.isElementDisplayed( basePage.loginPage.errorMessageField)));
    }





}
