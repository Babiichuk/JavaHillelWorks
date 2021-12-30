import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class TestRozetkaSearchPageCountProduct {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void before() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://rozetka.com.ua");
    }

    @Test
    public void test() throws IOException {
        FileWriter fw = new FileWriter("rozetkaText.txt");
        WebElement laptopAndCompCategory = driver.findElement(By.xpath("//ul[@class='menu-categories menu-categories_type_main']/li[1]"));
        laptopAndCompCategory.click();
        WebElement laptopCategory = driver.findElement(By.xpath("//a[@title='Ноутбуки']"));
        laptopCategory.click();

        List<WebElement> titleOfGoods = driver.findElements(By.xpath("//span[@class='goods-tile__title']"));
        List<WebElement> priceOfGoods = driver.findElements(By.xpath("//span[@class='goods-tile__price-value']"));

        LinkedHashMap<String, String> listOfGoodsWithPrice = new LinkedHashMap<>();

        for (int i = 0; i < titleOfGoods.size(); i++) {
            listOfGoodsWithPrice.put(titleOfGoods.get(i).getText(), priceOfGoods.get(i).getText());
        }

        int countOfGoods = titleOfGoods.size();
        assertEquals(countOfGoods, 60, "We have expected quantity of goods");

        for (String key : listOfGoodsWithPrice.keySet()) {
            fw.write(key + " - " + listOfGoodsWithPrice.get(key));
            fw.append('\n');
        }
        fw.close();


    }


    @AfterMethod
    public void after() {
        driver.quit();
    }


}
