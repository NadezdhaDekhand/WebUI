package HomeWork_8;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class Selenide {
    final String text = "кофе";
    @BeforeAll
    public static void setApp(){
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";

    }
    @Test
    void searchTest(){
        open("https://lenta.com/");
        $(By.xpath("//div[@class=\"catalog-search__field-block\"]/input")).sendKeys("кофе");
        $$(By.xpath("//div[@class=\"sku-in-search-results__title-block\"]//a")).findBy(text(text)).shouldBe(visible);
        System.out.println(screenshotEmAll);
        }

    @RegisterExtension
    static ScreenShooterExtension screenshotEmAll = new ScreenShooterExtension(true).to("target/screenshots");
}

