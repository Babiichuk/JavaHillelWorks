import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.page;

public class CartPageLogic extends CartPageElements {

    public String getProductInCartTitle(SelenideElement titleInCart) {
        String title = titleInCart.text().trim();
        return title;
    }

    public SearchPageLogic closeCart() {
        closeBtn.shouldBe(Condition.visible);
        closeBtn.click();
        return page(SearchPageLogic.class);
    }


}
