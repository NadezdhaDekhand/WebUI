package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

public class RemoveFromTheCart {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("http://automationpractice.com");
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
        driver.quit();
            }
        }




