package HomeWork_6.Lenta;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseTest {

    static WebDriver webDriver;
    private static String URL = "https://lenta.com/";

    @BeforeAll
    static void setApp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterAll
    static void setDown() {
        webDriver.quit();
    }
    @BeforeEach
    void setUp() {
        webDriver.manage().deleteAllCookies();
        webDriver.get(URL);
    }
    public WebDriver getWebDriver() {return this.webDriver;}
}

