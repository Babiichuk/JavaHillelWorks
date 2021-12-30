import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class ElementCollectionTest {

    @BeforeMethod
    public void before(){
        Configuration.startMaximized =true;
        open("https://rozetka.com.ua");
    }

    @Test
    public void firstTest(){
        ElementsCollection categories = $$(By.xpath("//ul[@class='menu-categories menu-categories_type_main']/li"));
        int sizeOfCollection = categories.size();
        System.out.println(sizeOfCollection);

        String text = categories.get(1).text();
        System.out.println(text);
    }
}
