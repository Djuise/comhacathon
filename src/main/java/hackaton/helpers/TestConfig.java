package hackaton.helpers;

import hackaton.runner.SeleniumConfiguration;
import hackaton.runner.annotations.AfterTest;
import hackaton.runner.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class TestConfig extends SeleniumConfiguration {
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-ssl-errors=yes", "--ignore-certificate-errors", "--no-sandbox", "--headless", "--window-size=1920,1080");
        driver.set(new ChromeDriver(options));
        driver.get().get("https://apparel-uk.local:9002/ucstorefront/en/");
        driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown() {
        driver.get().quit();
    }

    @Override
    protected void finalize() throws Throwable {
        driver.get().close();
        super.finalize();
    }
}
