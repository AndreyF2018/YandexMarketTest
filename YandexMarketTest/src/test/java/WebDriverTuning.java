import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class WebDriverTuning
{
    protected WebDriver driver;

    @BeforeTest
    public void start()
    {
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
        driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.get("https://market.yandex.ru/");
    }

    @AfterTest
    public void finish()
    {
        driver.quit();
    }
}
