import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPageLogic extends MainPageElements{

    public CategoryPageLogic clickOnCategoryByJs(SelenideElement category){
        category.shouldBe(Condition.visible);
     //   JavascriptExecutor jse = (JavascriptExecutor) getWebDriver();
      //  jse.executeScript("arguments[0].click();", category);
        category.click();
        return page(CategoryPageLogic.class);

    }
}
