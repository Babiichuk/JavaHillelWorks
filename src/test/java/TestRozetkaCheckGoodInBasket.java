import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestRozetkaCheckGoodInBasket {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void before() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://rozetka.com.ua");
    }

    @Test
    public void firstTest() throws InterruptedException {

        WebElement notebooksAndComputers = driver.findElement(By.xpath("//ul[@class='menu-categories menu-categories_type_main']//li[1]"));
        notebooksAndComputers.click();

        WebElement notebooks = driver.findElement(By.xpath("//a[@title='Ноутбуки']"));
        notebooks.click();

        WebElement basketButtonOfItem = driver.findElement(By.xpath("//button[@class='buy-button goods-tile__buy-button ng-star-inserted']"));
        basketButtonOfItem.click();

        WebElement firstGoodTitle = driver.findElement(By.xpath("//span[@class='goods-tile__title']"));
        String goodsTitleOnMainPage = firstGoodTitle.getText().trim();

        WebElement goodsQuantityIcon = driver.findElement(By.xpath("// span[@class='counter counter--green ng-star-inserted']"));
        String goodsQuantityInBasket = goodsQuantityIcon.getText().trim();

        Assert.assertEquals(goodsQuantityInBasket, "1");

        WebElement mainBaskets = driver.findElement(By.xpath("//button[@class='header__button ng-star-inserted header__button--active']"));
        mainBaskets.click();

        WebElement goodsQuantity = driver.findElement(By.xpath("//a[@class='cart-product__title']"));
        String productTitleOnBasket = goodsQuantity.getText().trim();

        Assert.assertEquals(goodsTitleOnMainPage, productTitleOnBasket);

    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
