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
import java.util.Locale;

public class Search {
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
        driver.findElement(By.id("search_query_top")).click();
        driver.findElement(By.id("search_query_top")).sendKeys("Dress");
        driver.findElement(By.name("submit_search")).click();
        List<WebElement> dressList = driver.findElements(By.xpath("//div[@id=\"center_column\"]//div[@class=\"product-container\"]//a[@class=\"product-name\"]"));
        Assertions.assertTrue(dressList.size() != 0);
        for   (WebElement webElement : dressList) {
            if (webElement.getText().contains("Dress")){
                return;
            }
        }
    }
}