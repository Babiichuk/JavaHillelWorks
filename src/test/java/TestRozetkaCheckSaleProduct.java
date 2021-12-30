import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestRozetkaCheckSaleProduct {

    WebDriver driver;
    WebDriverWait wait;
    private final String MAIN_URL = "https://rozetka.com.ua/";

    @BeforeMethod
    public void before() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(MAIN_URL);
    }

    @Test
    public void firstTest() {

        List<WebElement> saleBlockGoods = driver.findElements(By.xpath("//h2[contains(text(), ' Акционные предложения ')]/../ul/li"));
        int quantityOfGoodsOnPage = saleBlockGoods.size();

        for (int i = 1; i <= quantityOfGoodsOnPage; i++) {

            proverkaDliaLekhi(5, i);

        }


    }

    public void proverkaDliaLekhi(int expectedQuantityOfGoods, int numberOfGood) {

        driver.get(MAIN_URL);

        List<WebElement> saleBlockGoods = driver.findElements(By.xpath("//h2[contains(text(), ' Акционные предложения ')]/../ul/li"));
        int quantityOfGoodsInBlock = saleBlockGoods.size();
        Assert.assertEquals(quantityOfGoodsInBlock, expectedQuantityOfGoods);

        WebElement priceOfFirstGoodInSaleBlock = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h2[contains(text(), ' Акционные предложения ')]/../ul/li[" + numberOfGood + "]//span[@class='tile__price-value']"))));
        String priceOfFirstGoodInSaleBlockText = priceOfFirstGoodInSaleBlock.getText().trim();

        saleBlockGoods.get(numberOfGood - 1).click();

        WebElement priceOfGoodOnProductPage = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='product-prices__inner ng-star-inserted']//p"))));
        String priceOfGoodOnProductPageText = priceOfGoodOnProductPage.getText().trim();
        priceOfGoodOnProductPageText = priceOfGoodOnProductPageText.substring(0, priceOfGoodOnProductPageText.length() - 1);
        Assert.assertEquals(priceOfFirstGoodInSaleBlockText, priceOfGoodOnProductPageText);

        driver.get(MAIN_URL);

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, MAIN_URL);
        Assert.assertEquals(quantityOfGoodsInBlock, expectedQuantityOfGoods);

    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
