import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class FirstSelenideTest {

    @BeforeMethod
    public void before(){
        Configuration.startMaximized = true;
        open("https://rozetka.com.ua");
    }

    @Test
    public void firstTest(){
       $ (By.name("search")).setValue("Mac");
       $(By.xpath("//button[text() = ' Найти ']"))
               .shouldBe(Condition.visible)
               .shouldNotHave(Condition.text("Alex"))
               .shouldHave(Condition.text("Найти"))
               .click();
       sleep(5000);
    }

}
