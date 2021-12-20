package HomeWork_6.MyStore;

import HomeWork_6.MyStore.BasePageTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchTest extends BasePageTest {

    @Test
    void searchInn() {
    new Search(getWebDriver()).setSearch("Dress");
        webDriver.findElement(By.name("submit_search")).click();
        WebElement result = webDriver.findElement(By.cssSelector("#center_column > h1 > span.heading-counter"));
        result.getText();
        assertEquals(result.getText(), "7 results have been found.");
        System.out.println(result.getText());
    }
}