package HomeWork_6.MyStore;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Link;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.jupiter.api.Assertions.assertEquals;
@Epic("2")
class CartTest extends BasePageTest {
    @Test
    @Description("Перейти на страницу корзины")
    @Link("http://automationpractice.com")
    void goToCart() {

        new Cart(getWebDriver()).goToCart();
        WebElement result = webDriver.findElement(By.xpath("//div[@id=\"columns\"]//span[text()=\"Your shopping cart\"]"));
        result.getText();
        assertEquals(result.getText(), "Your shopping cart");
    }
    @Test
    @Description("Добавление товара в корзину")
    @Link("http://automationpractice.com")
    void addToCart() {

        webDriver.findElement(By.xpath("//img[@alt='Faded Short Sleeve T-shirts']")).click();
        webDriver.findElement(By.xpath("//select [@id=\"group_1\"]//option[3]")).click();
        webDriver.findElement(By.xpath("//div//li/a[@id=\"color_14\"]")).click();
        webDriver.findElement(By.xpath("//p[@id=\"add_to_cart\"]/button/span")).click();
        new Cart(getWebDriver()).goToCartBtn();
        WebElement result = webDriver.findElement(By.id("summary_products_quantity"));
        System.out.println(result.getText());
    }

}