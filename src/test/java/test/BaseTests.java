package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.BasePage;

import java.util.concurrent.TimeUnit;

public class BaseTests {

    protected BasePage basePage;
    private WebDriver driver;


    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();


        ChromeOptions options = new ChromeOptions();

//        options.addArguments("--no-sandbox");
//        options.addArguments("--headless");
//        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        basePage = new BasePage();
        basePage.init(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
