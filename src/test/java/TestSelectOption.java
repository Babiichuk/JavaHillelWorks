import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestSelectOption {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void before() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://autodoc.de");
    }


    @Test
    public void firstTest() throws InterruptedException {



        WebElement makerList = driver.findElement(By.id("form_maker_id"));
        makerList.click();
       WebElement makerListOption = driver.findElement(By.xpath("//select[@id='form_maker_id']/optgroup[1]/option[@value='16']"));
       makerListOption.click();
       TimeUnit.SECONDS.sleep(5);

    }


    @AfterMethod
    public void after() {
        driver.quit();
    }
}
