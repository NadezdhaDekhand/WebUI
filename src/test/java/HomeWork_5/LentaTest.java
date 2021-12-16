package HomeWork_5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;

public  class LentaTest {
    private static WebDriver driver;

    @BeforeAll
    static void setAdd() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterAll
    static void setDown() {
        driver.quit();

    }
    @Test
    public  void testCooke(){
        driver.get("https://lenta.com/");
        driver.findElement(By.xpath("//a[@class=\"header__catalog\"]")).click();
        driver.findElement(By.cssSelector(" div.catalog-groups-grid.catalog-groups-grid--small-paddings > a:nth-child(2)"));
        driver.findElement(By.xpath("//div[@class=\"header__logo-container\"]/a"));
        System.out.println(driver.manage().getCookies());
    }
    @Test
    public void testSearch(){
        driver.get("https://lenta.com/");
        final String text = "лук";
        driver.findElement(By.xpath("//div[@class=\"catalog-search__field-block\"]/input")).sendKeys(text + "\n");
        List<WebElement> itemList = driver.findElements(By.xpath("//div[@class=\"sku-in-search-results__title-block\"]/a"));
        Assert.assertTrue(itemList.size() != 0);
        for (int i = 0; i < itemList.size(); i++) {
            Assert.assertTrue(itemList.get(i).getText().toLowerCase().contains(text));
            System.out.println(itemList.get(i).getText());
        }
    }
}
