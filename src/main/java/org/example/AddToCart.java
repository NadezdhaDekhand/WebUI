package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class AddToCart
{
    public static void main( String[] args )

    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://automationpractice.com");
        driver.findElement(By.xpath("//img[@alt='Faded Short Sleeve T-shirts']")).click();
        driver.findElement(By.xpath("//select [@id=\"group_1\"]//option[3]")).click();
        driver.findElement(By.xpath("//div//li/a[@id=\"color_14\"]")).click();
        driver.findElement(By.xpath("//p[@id=\"add_to_cart\"]/button/span")).click();
        driver.quit();
    }
}
