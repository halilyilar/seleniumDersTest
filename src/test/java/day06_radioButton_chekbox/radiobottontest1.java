package day06_radioButton_chekbox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;

public class radiobottontest1 {

    static WebDriver driver;

    @Before
      public void setup(){

          WebDriverManager.chromedriver().setup();
          driver=new ChromeDriver();
          driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void test() throws InterruptedException {

          driver.get("https://www.facebook.com");
          driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']")).click();
        WebElement female=driver.findElement(By.xpath("//input[@value='1']"));

        if (!female.isSelected()){
            female.click();
        }
        Thread.sleep(3000);
          driver.findElement(By.xpath("//input[@value='2']"));
          driver.findElement(By.xpath("//input[@value='-1']"));


    }
   @After
    public void tearDown() {
        driver.close();
   }

    }

