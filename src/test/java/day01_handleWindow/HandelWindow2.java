package day01_handleWindow;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandelWindow2 {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void test(){
        driver.get("https://amazon.com");
        String actualURL= driver.getCurrentUrl();
        String hashcode=driver.getWindowHandle();
        Assert.assertTrue(actualURL.contains("amazon"));
        driver.switchTo().newWindow(WindowType.TAB);
        driver.getCurrentUrl();
        String hashcode2=driver.getWindowHandle();
        driver.get("https://bestbuy.com");
        String besttitle=driver.getTitle();
        System.out.println(besttitle);
        Assert.assertTrue(besttitle.contains("Best Buy"));
        driver.switchTo().window(hashcode);
        WebElement arama = driver.findElement(By.id("twotabsearchtextbox"));
        arama.sendKeys("java"+ Keys.ENTER);
        WebElement sonuc=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        sonuc.getText().contains("java");
        driver.switchTo().window(hashcode2);
        driver.findElement(By.xpath("//div[@lang='en']")).isDisplayed();






    }
}