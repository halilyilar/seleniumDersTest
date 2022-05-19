package day06_radioButton_chekbox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class kendimtest {

   static WebDriver driver;

    @Test
    public void test() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        Thread.sleep(3000);
        WebElement checkbox1=driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkbox2=driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        if (!checkbox1.isSelected()){
            checkbox1.click();
        }
        if (!checkbox2.isSelected()){
            checkbox2.click();
        }

        Thread.sleep(3000);
        driver.close();


    }
}
