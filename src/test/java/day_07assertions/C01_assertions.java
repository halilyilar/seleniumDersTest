package day_07assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_assertions {

    static WebDriver driver;

    @BeforeClass
    public static void setup(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com");
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void test1(){
        String expectedurl="https://www.bestbuy.com/";
        String actualurl=driver.getCurrentUrl();
        Assert.assertEquals(expectedurl, actualurl);
    }
    @Test
    public void test2() throws InterruptedException {
        String title="Rest";
        String actualtitle= driver.getTitle();
        Assert.assertFalse(actualtitle.contains(title));

    }
    @Test
    public void test3(){

        WebElement logo= driver.findElement(By.xpath("(//img[@class='logo'])[1]"));

        Assert.assertTrue(logo.isDisplayed());
    }
    @Test
    public void test4(){
        WebElement francies=driver.findElement(By.xpath("//*[text()='Français']"));
        Assert.assertTrue(francies.isDisplayed());
    }
}
