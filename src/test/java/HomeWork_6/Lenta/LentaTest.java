package HomeWork_6.Lenta;


import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("2")
public class LentaTest extends BaseTest{


    @Test
    @Severity(SeverityLevel.TRIVIAL)
    @Description("Поиск товара")
    @Link("https://lenta.com/")
    public void testSearch(){
        final String text = "кофе";
        webDriver.findElement(By.xpath("//div[@class=\"catalog-search__field-block\"]/input")).sendKeys(text + "\n");
        List<WebElement> itemList = webDriver.findElements(By.xpath("//div[@class=\"sku-in-search-results__title-block\"]//a"));
        assertTrue(itemList.size() != 0);
        for (int i = 0; i < itemList.size(); i++) {
            assertTrue(itemList.get(i).getText().toLowerCase().contains(text));
            System.out.println(itemList.get(i).getText());
        }
    }
    @Test
    @Severity(SeverityLevel.TRIVIAL)
    @Description("Скрин")
    @Link("https://lenta.com/")
    public  void testCooke(){
        webDriver.findElement(By.xpath("//a[@class=\"header__catalog\"]")).click();
        webDriver.findElement(By.cssSelector(" div.catalog-groups-grid.catalog-groups-grid--small-paddings > a:nth-child(2)"));
        webDriver.findElement(By.xpath("//div[@class=\"header__logo-container\"]/a"));
        MyUtils.makeScreenshot(getWebDriver(),"Lenta" + System.currentTimeMillis() + ".png");
        System.out.println(webDriver.manage().getCookies());
    }


    }

