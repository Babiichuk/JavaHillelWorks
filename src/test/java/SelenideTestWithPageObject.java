import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTestWithPageObject {

    @BeforeMethod
    public void before(){
        Configuration.startMaximized = true;
        open("https://rozetka.com.ua");
    }

    @Test
    public void firstTest(){
        new MainPageLogic().clickOnCategoryByJs(new MainPageElements().compAndLaptopCategory)
                .clickOnCategory(new CategoryPageElements().laptopCategory)
                .checkProductQuantity(60);



    }

}
