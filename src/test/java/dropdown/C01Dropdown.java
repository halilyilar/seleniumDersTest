package dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01Dropdown {

   static WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));



    }
    @After
    public void teardown(){
        driver.close();

    }
    @Test
    public void test(){
        driver.get("https://www.amazon.com");
        WebElement selectmenu = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(selectmenu);
        select.selectByVisibleText("Automotive");
        WebElement aramakutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramakutusu.sendKeys("java"+ Keys.ENTER);
        WebElement aramasonucu=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonucyazisi=aramasonucu.getText();
        String aranankelime="java";
        Assert.assertTrue(sonucyazisi.contains("java"));

    }
}
