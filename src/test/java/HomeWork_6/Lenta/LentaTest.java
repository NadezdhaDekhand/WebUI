package HomeWork_6.Lenta;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;

public class LentaTest extends BaseTest{
    @Test
    public void testSearch(){
        final String text = "лук";
        webDriver.findElement(By.xpath("//div[@class=\"catalog-search__field-block\"]/input")).sendKeys(text + "\n");
        List<WebElement> itemList = webDriver.findElements(By.xpath("//div[@class=\"sku-in-search-results__title-block\"]/a"));
        Assert.assertTrue(itemList.size() != 0);
        for (int i = 0; i < itemList.size(); i++) {
            Assert.assertTrue(itemList.get(i).getText().toLowerCase().contains(text));
            System.out.println(itemList.get(i).getText());
        }
    }
    @Test
    public  void testCooke(){
        webDriver.findElement(By.xpath("//a[@class=\"header__catalog\"]")).click();
        webDriver.findElement(By.cssSelector(" div.catalog-groups-grid.catalog-groups-grid--small-paddings > a:nth-child(2)"));
        webDriver.findElement(By.xpath("//div[@class=\"header__logo-container\"]/a"));
        System.out.println(webDriver.manage().getCookies());
    }
}
