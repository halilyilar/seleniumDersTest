package alistirmalar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class alistirma1 {

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

        driver.close();
   }
   @Test
    public void test(){
        driver.get("https://www.amazon.com");
    /*
       String actualname="https//www.facebook.com";
       driver.getCurrentUrl();
       if (driver.getCurrentUrl().equals(actualname)){
           System.out.println("test passed");
       }else System.out.println("test failed");*/

       String actualname="https://www.facebook.com";
       driver.getCurrentUrl();
       Assert.assertEquals(actualname, driver.getCurrentUrl());






    }

}