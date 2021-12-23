package HomeWork_6.MyStore;

import HomeWork_6.MyStore.BasePageTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Link;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
@Epic("2")
class SearchTest extends BasePageTest {

    @Test
    @Description("Поиск товара")
    @Link("http://automationpractice.com")
    void searchInn() {
    new Search(getWebDriver()).setSearch("Dress");
        webDriver.findElement(By.name("submit_search")).click();
        WebElement result = webDriver.findElement(By.cssSelector("#center_column > h1 > span.heading-counter"));
        result.getText();
        assertEquals(result.getText(), "7 results have been found.");
        System.out.println(result.getText());
    }
}