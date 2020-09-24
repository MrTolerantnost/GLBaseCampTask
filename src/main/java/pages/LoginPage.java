package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Constants;


import java.time.Duration;
import java.util.List;

import static org.awaitility.Awaitility.await;

public class LoginPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class.getName());
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//h2[@class='ui teal image header']")
    public WebElement title;

    @FindBy(xpath = "//div[@class='field'][1]")
    public WebElement emailField;

    @FindBy(xpath = "//div[@class='field'][2]")
    public WebElement passwordField;

    @FindBy(xpath = "//div[@class='ui fluid large teal submit button']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@class='ui error message']")
    public WebElement errorMessageField;

    @FindBy(xpath = "//ul[@class='list']")
    public List<WebElement> errorMessageList;




    @Step("Open app with link")
    public void open() {
        driver.get(BASE_URL);
        await().atMost(Duration.ofSeconds(Constants.AW_WAIT_TIME)).until(() -> loginButton.isDisplayed());
    }

    @Step("Click Login Button")
    public void loginButtonClick() {
        loginButton.click();
    }

    @Step("Fill in E-mail field")
    public void fillInEmailField() {
        emailField.sendKeys("test@test.com");
    }

    @Step("Fill in Password field")
    public void fillInPasswordField() {
        passwordField.sendKeys("pass1234");
    }
    @Step
    public int getValidationListSize() {
        return errorMessageList.size();
    }


}
