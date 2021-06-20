package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import selenium.improvement.ProjectFieldDecorator;

import java.util.concurrent.TimeUnit;

public abstract class BasePage {

    protected WebDriver driver;
    protected static final String BASE_URL = "https://books-pwakit.appspot.com";
    protected WebDriverWait waiter;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        waiter = new WebDriverWait(driver,3);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        PageFactory.initElements(new ProjectFieldDecorator(new DefaultElementLocatorFactory(driver)), this);
    }

    @BeforeTest
    public void setupTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown() {
        if (driver != null) driver.quit();
    }

}
