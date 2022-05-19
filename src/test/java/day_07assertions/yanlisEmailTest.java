package day_07assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class yanlisEmailTest {

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://automationpractice.com/index.php");
    }

    @AfterClass
    public static void tearDown(){
    driver.close();
    }
    @Test
    public void test1() throws InterruptedException {
        driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
        Thread.sleep(3000);
    }

     @Test
      public void test2(){

            driver.findElement(By.xpath("//input[@id='email']"));
            WebElement emailbox= driver.findElement(By.xpath("//input[@id='email']"));
            emailbox.sendKeys("galip*gmail.com" + Keys.ENTER );
        }
        @Test
        public void test3(){
            WebElement valid = driver.findElement(By.xpath("//*[text()='Invalid email address.']"));
            Assert.assertTrue(valid.isDisplayed());

        }



    }

