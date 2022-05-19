package day01_handleWindow;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandleWindow1 {

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void test1(){
       driver.get("https://amazon.com");
       String ilksayfahandledegeri=driver.getWindowHandle();
       WebElement aramakutusu=driver.findElement(By.id("twotabsearchtextbox"));
       aramakutusu.sendKeys("nutella"+ Keys.ENTER);
       //driver.findElement(By.id("nav-search-submit-button")).click();
       WebElement ilkurunresmi= driver.findElement(By.xpath("(//img[@class='s-image'])[1]"));
       driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");
        WebElement aramakutusu2=driver.findElement(By.id("twotabsearchtextbox"));
        aramakutusu2.sendKeys("nutella"+ Keys.ENTER);
        //driver.findElement(By.id("nav-search-submit-button")).click();
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
       WebElement title= driver.findElement(By.xpath("//span[@id='productTitle']"));
        System.out.println("ilk sayfa title" + title.getText());
        System.out.println(driver.getCurrentUrl());
        driver.switchTo().window(ilksayfahandledegeri);
        System.out.println(driver.getCurrentUrl());

    }
}
