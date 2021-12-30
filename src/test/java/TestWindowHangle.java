import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestWindowHangle {

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
    public void firstTest() throws InterruptedException{
        WebElement loginBtn = driver.findElement(By.xpath("//button[@class='header__button ng-star-inserted']"));
        loginBtn.click();

        WebElement registrateInLogPopup = driver.findElement(By.xpath("//div[@class='form__row auth-modal__form-bottom']/button[2]"));
        registrateInLogPopup.click();

        String mainHandle = driver.getWindowHandle();


        WebElement policyInRegPopup = driver.findElement(By.xpath("//a[@class='button button_type_link'] "));
        policyInRegPopup.click();
        Thread.sleep(3000);

        driver.switchTo().window(mainHandle);
        Thread.sleep(3000);

        Set<String> ourHandels  = driver.getWindowHandles();
        System.out.println(ourHandels.size());

        Thread.sleep(3000);


    }


    @AfterMethod
    public void after() {
        driver.quit();
    }

}
