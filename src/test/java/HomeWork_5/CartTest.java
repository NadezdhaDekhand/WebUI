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
import org.openqa.selenium.interactions.Actions;



import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;


public class CartTest {
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
    public void addToCardTest() {
        driver.get(MAIN_PAGE_URL);
        driver.findElement(By.xpath("//img[@alt='Faded Short Sleeve T-shirts']")).click();
        driver.findElement(By.xpath("//select [@id=\"group_1\"]//option[3]")).click();
        driver.findElement(By.xpath("//div//li/a[@id=\"color_14\"]")).click();
        driver.findElement(By.xpath("//p[@id=\"add_to_cart\"]/button/span")).click();
        String attributeValue = driver.findElement(By.xpath("//div[@class=\"button-container\"]/a"))
                .getAttribute("title");
        assertEquals(attributeValue,"Proceed to checkout");
        System.out.println(attributeValue);
    }
    @Test
    public void removeFromTheCardTest(){
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
        assertEquals(result.getText(),"Your shopping cart is empty.");
        System.out.println(result.getText());

    }



}

