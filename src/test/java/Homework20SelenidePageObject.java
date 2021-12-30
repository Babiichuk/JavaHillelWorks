import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class Homework20SelenidePageObject {

    @BeforeMethod
    public void before() {
        Configuration.startMaximized = true;
        open("https://rozetka.com.ua");
    }

    @Test
    public void firstTest() {


        String titleOnSearchPage = String.valueOf(new MainPageLogic().clickOnCategory(new MainPageElements().compAndLaptopCategory)
                .clickOnCategory(new CategoryPageElements().laptopCategory)
                .clickOnAddToCartOnProduct(new SearchPageElements().addToCartBtn)
                .checkQuantityOfProductInCart("1")
                .getProductOnSearchPageTitle(new SearchPageElements().firstProductTitleOnSearchPage));

        String titleInCart = String.valueOf(new SearchPageLogic().clickOnCart(new SearchPageElements().cartCounter)
                .getProductInCartTitle(new CartPageElements().titleOfProductInCart));


        Assert.assertEquals(titleOnSearchPage, titleInCart);

    }

}
