package HomeWork_6.Lenta;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v94.log.Log;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.time.Duration;
import java.util.List;

@Epic("2")
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
    @AfterEach
    public void CheckBrowser(){

   List<LogEntry> allLogRows = getWebDriver().manage().logs().get(LogType.BROWSER).getAll();

   if (!allLogRows.isEmpty()) {
       if (allLogRows.size() >0) {
           allLogRows.forEach(logEntry -> {
               System.out.println(logEntry.getMessage());
           });
   }
       Assertions.fail();
   }
    }

    public WebDriver getWebDriver() {return this.webDriver;}
}

