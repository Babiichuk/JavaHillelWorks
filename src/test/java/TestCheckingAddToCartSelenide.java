import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestCheckingAddToCartSelenide {

    @BeforeMethod
    public void before(){
        Configuration.startMaximized =true;
        open("https://rozetka.com.ua");
    }

    @Test
    public void firstTest(){

        SelenideElement compAndLaptopCategory = $(By.xpath("//ul[@class='menu-categories menu-categories_type_main']/li[1]"));
        compAndLaptopCategory.click();

        SelenideElement laptopCategory = $(By.xpath("//a[@title='Ноутбуки']"));
        laptopCategory.click();

        SelenideElement firstProductTitleOnSearchPage =$(By.xpath("//span[@class='goods-tile__title']"));
        String firstProductTitleOnSearchPageText = firstProductTitleOnSearchPage.text();

        SelenideElement addToCartBtn = $(By.xpath("//button[@class='buy-button goods-tile__buy-button ng-star-inserted']"));
        addToCartBtn.click();

        SelenideElement cartCounter = $(By.xpath("//span[@class='counter counter--green ng-star-inserted']"));
        String counterInCartPopup = cartCounter.innerText().trim();
        Assert.assertEquals(counterInCartPopup, "1");

        cartCounter.click();

        SelenideElement titleOfProductInCart = $(By.xpath("//a[@class='cart-product__title']"));
        String titleOfProductInCartText = titleOfProductInCart.text();
        Assert.assertEquals(firstProductTitleOnSearchPageText, titleOfProductInCartText);
    }




}




