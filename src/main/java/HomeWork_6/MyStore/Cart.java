package HomeWork_6.MyStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Cart extends BasePage {

    public Cart(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class=\"shopping_cart\"]/a")
    private WebElement cart;

    @FindBy(xpath = "//div[@id=\"layer_cart\"]//a")
    private WebElement cartBtn;

    public void goToCart() {
        this.cart.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("order"));
    }
    public void goToCartBtn() {
        this.cartBtn.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("order"));
    }


}