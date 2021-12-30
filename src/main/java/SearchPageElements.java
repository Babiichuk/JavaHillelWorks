import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPageElements {

    ElementsCollection titles = $$(By.xpath("//span[@class='goods-tile__title']"));
    SelenideElement addToCartBtn = $(By.xpath("//button[@class='buy-button goods-tile__buy-button ng-star-inserted']"));
    SelenideElement firstProductTitleOnSearchPage = $(By.xpath("//span[@class='goods-tile__title']"));
    SelenideElement cartCounter = $(By.xpath("//span[@class='counter counter--green ng-star-inserted']"));
}
