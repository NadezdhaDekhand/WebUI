package HomeWork_6.MyStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Search extends BasePage {
    @FindBy(id = "search_query_top")
    private WebElement search;


    public Search(WebDriver driver) {
        super(driver);
    }

    public Search setSearch (String search) {
        this.search.click();
        this.search.sendKeys(search);
        return this;
    }



}


