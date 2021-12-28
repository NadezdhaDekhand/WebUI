package HomeWork_8;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyStep {


    private static WebDriver driver;
    private static String URL = "https://lenta.com/";



        @Given("user on the home page")
        public void userOnTheHomePage () {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.addArguments("start-maximized");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.get(URL);
        }

        @When("enters in the Search field the text {string}")
        public void entersInTheSearchFieldTheText (String text){
            driver.findElement(By.xpath("//div[@class=\"catalog-search__field-block\"]/input")).sendKeys(text + "\n");
        }

        @Then("the user sees results corresponding to {string}")
        public void theUserSeesResultsCorrespondingTo (String text){
            List<WebElement> itemList = driver.findElements(By.xpath("//div[@class=\"sku-in-search-results__title-block\"]//a"));
            assertTrue(itemList.size() != 0);
            for (int i = 0; i < itemList.size(); i++) {
                assertTrue(itemList.get(i).getText().toLowerCase().contains(text));
                System.out.println(itemList.get(i).getText());
            }
            driver.quit();
        }

    }
