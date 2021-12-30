import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class RozetkaFirstTest {
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
    public void firstTest() {

        WebElement inputSearch = driver.findElement(By.xpath("//input[@name='search']"));
        inputSearch.sendKeys("Mac");
        WebElement searchBtn = driver.findElement(By.xpath("//*[text()=' Найти ']"));
        searchBtn.click();

        WebElement titleOfFirstItem = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(@class, 'goods-tile__heading ng-star-inserted') and @title='Бокал для шампанского Chef&Sommelier 300 мл серия Macaron (L9348) ']"))));

        String titleOfFirstItemText = titleOfFirstItem.getText().trim();
        String titleOfFirstItemTextExpected = "Бокал для шампанского Chef&Sommelier 300 мл серия Macaron (L9348)";

        assertEquals(titleOfFirstItemTextExpected, titleOfFirstItemText, "Title doesn't equals");
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}