package alert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Alert1 {

    static  WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @AfterClass
    public static void tearDown() {
        //driver.close();
    }

        @Test
        public void test1() throws InterruptedException {

        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        WebElement sonucyazisi=driver.findElement(By.xpath("//*[text()='You successfully clicked an alert']"));
        String expectedresult="You successfully clicked an alert";
        String actualyazi=sonucyazisi.getText();
        Assert.assertEquals(expectedresult,actualyazi);
    }
    @Test
    public void test2(){
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();
        WebElement result= driver.findElement(By.xpath("//*[text()='You clicked: Cancel']"));
        String expectedresult="successfully";
        String sonucyazisi=result.getText();
        Assert.assertFalse(sonucyazisi.contains(expectedresult));
    }
    @Test
    public void test3(){
        WebElement result= driver.findElement(By.xpath("//*[text()='Click for JS Prompt']"));
        result.click();
        driver.switchTo().alert().sendKeys("halil");
        driver.switchTo().alert().accept();
        String expectedname="halil";
        WebElement result1= driver.findElement(By.xpath("//p[@id='result']"));
        String actualname=result1.getText();
        Assert.assertTrue(actualname.contains(expectedname));
    }

}
