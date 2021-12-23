package HomeWork_6.MyStore;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
@Epic("2")
public abstract class BasePageTest {
    static WebDriver webDriver;
    private static String URL = "http://automationpractice.com";
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

    public WebDriver getWebDriver() {return  this.webDriver;}
}


