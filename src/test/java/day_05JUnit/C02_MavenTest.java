package day_05JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_MavenTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://zero.webappsecurity.com");
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        driver.navigate().back();
        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();
        driver.findElement(By.xpath("//input[@id='sp_amount']")).sendKeys("500");
        driver.findElement(By.xpath("//input[@id='sp_date']")).sendKeys("2020-09-10");
        driver.findElement(By.xpath("//input[@id='pay_saved_payees']")).click();
       //driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']"));
       WebElement odemeislemi=driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']"));
       if (odemeislemi.isDisplayed()){
           System.out.println("test passed");

       }else System.out.println("test failed");
        driver.close();

    }
}
