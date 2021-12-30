import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.page;

public class SearchPageLogic extends SearchPageElements {

    public SearchPageLogic checkProductQuantity(int size) {
        titles.shouldHaveSize(size);
        return this;
    }

    public SearchPageLogic checkQuantityOfProductInCart(String cartNumber) {
        cartCounter.shouldHave(Condition.text(cartNumber));
        return this;
    }

    public String getProductOnSearchPageTitle(SelenideElement productTitle) {

        String title = productTitle.text().trim();
        return title;
    }

    public SearchPageLogic clickOnAddToCartOnProduct(SelenideElement addToCartOnProduct) {
        addToCartOnProduct.shouldBe(Condition.visible).click();
        return this;
    }

    public CartPageLogic clickOnCart(SelenideElement cart) {
        cart.shouldBe(Condition.visible).click();
        return page(CartPageLogic.class);
    }
}