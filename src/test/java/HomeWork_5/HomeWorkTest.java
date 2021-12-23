package HomeWork_5;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Link;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;
@Epic("1")
public class HomeWorkTest {
    private static WebDriver driver;
    private static String MAIN_PAGE_URL = "http://automationpractice.com";

    @BeforeAll
    static void setAdd() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterAll
    static void setDown() {
        driver.quit();

    }

    @Test
    @Description("Добавление товара в корзину")
    @Link("http://automationpractice.com")
    public void testAddToCard() {
        driver.get(MAIN_PAGE_URL);
        driver.findElement(By.xpath("//img[@alt='Faded Short Sleeve T-shirts']")).click();
        driver.findElement(By.xpath("//select [@id=\"group_1\"]//option[3]")).click();
        driver.findElement(By.xpath("//div//li/a[@id=\"color_14\"]")).click();
        driver.findElement(By.xpath("//p[@id=\"add_to_cart\"]/button/span")).click();
        String attributeValue = driver.findElement(By.xpath("//div[@class=\"button-container\"]/a"))
                .getAttribute("title");
        assertEquals(attributeValue, "Proceed to checkout");
        System.out.println(attributeValue);
    }

    @Test
    @Description("Удалить товар из корзины")
    @Link("http://automationpractice.com")
    public void testRemoveFromTheCard() {
        driver.get(MAIN_PAGE_URL);
        driver.findElement(By.xpath("//img[@alt='Faded Short Sleeve T-shirts']")).click();
        driver.findElement(By.xpath("//select [@id=\"group_1\"]//option[3]")).click();
        driver.findElement(By.xpath("//div//li/a[@id=\"color_14\"]")).click();
        driver.findElement(By.xpath("//p[@id=\"add_to_cart\"]/button/span")).click();
        driver.findElement(By.xpath("//div[@id='layer_cart']/div/div/span")).click();
        driver.findElement(By.cssSelector(".logo")).click();

        WebElement element = driver.findElement(By.xpath("//a[@href=\'http://automationpractice.com/index.php?controller=order\']"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();

        driver.findElement(By.cssSelector(".ajax_cart_block_remove_link")).click();
        driver.findElement(By.xpath("//a[@href=\'http://automationpractice.com/index.php?controller=order\']")).click();
        WebElement result = driver.findElement(By.xpath("//div[@id=\"center_column\"]/p[text()='Your shopping cart is empty.']"));
        result.getText();
        assertEquals(result.getText(), "Your shopping cart is empty.");
        System.out.println(result.getText());

    }

    @Test
    @Description("Поиск товара")
    @Link("http://automationpractice.com")
    public void testSearchDress() {
        driver.get(MAIN_PAGE_URL);

        driver.findElement(By.id("search_query_top")).click();
        driver.findElement(By.id("search_query_top")).sendKeys("Dress");
        driver.findElement(By.name("submit_search")).click();
        WebElement result = driver.findElement(By.cssSelector("#center_column > h1 > span.heading-counter"));
        result.getText();
        assertEquals(result.getText(), "7 results have been found.");
        System.out.println(result.getText());
    }
}

