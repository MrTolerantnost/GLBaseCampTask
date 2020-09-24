package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public static final String BASE_URL = "https://semantic-ui.com/examples/login.html";


    protected WebDriver driver;
    protected WebDriverWait wait;


    public LoginPage loginPage;


    public void init(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);

        loginPage = new LoginPage(driver);

    }


    @Step("Element {} is displayed")
    public boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }
}

