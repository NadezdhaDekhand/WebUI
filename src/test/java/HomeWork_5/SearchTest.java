package HomeWork_5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SearchTest {
    private static WebDriver driver;
    private static final String MAIN_PAGE_URL = "http://automationpractice.com";

    @BeforeAll
    public static void setAdd() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterAll
    public static void setDown() {
        driver.quit();
    }

    @Test
    public void searchDressTest() {
        driver.get(MAIN_PAGE_URL);
        final String text = "Dress";
        driver.findElement(By.id("search_query_top")).click();
        driver.findElement(By.id("search_query_top")).sendKeys("Dress");
        driver.findElement(By.name("submit_search")).click();
        WebElement result = driver.findElement(By.cssSelector("#center_column > h1 > span.heading-counter"));
        result.getText();
        assertEquals(result.getText(),"7 results have been found.");
        System.out.println(result.getText());
        }
    }


