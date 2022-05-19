package dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Co2Dropdown2 {
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
      driver.get("https://the-internet.herokuapp.com/dropdown");
      WebElement dropdown=  driver.findElement(By.xpath("//select[@id='dropdown']"));
      Select select=new Select(dropdown);

    }
}
