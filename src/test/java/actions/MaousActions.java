package actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class MaousActions extends TestBase {
    @Test
    public void test(){
        driver.get("https://the-internet.herokuapp.com/context_menu");
        System.out.println(driver.getWindowHandle());
        String ilkwindow=driver.getWindowHandle();
        WebElement element=driver.findElement(By.xpath("//div[@id='hot-spot']"));
        Actions action=new Actions(driver);
        action.contextClick(element).perform();
        System.out.println(driver.switchTo().alert().getText());
        String expectedname="You selected a context menu";
        String actualname=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedname, actualname);
        driver.switchTo().alert().accept();
        driver.findElement(By.linkText("Elemental Selenium")).click();
        Set<String> webhandles = driver.getWindowHandles();
        System.out.println(webhandles);
        String ikinciwindow="";
        for (String w : webhandles) {
            if (w!=ilkwindow){
                ikinciwindow=w;
            }
        }
        System.out.println(ikinciwindow);
        driver.switchTo().window(ikinciwindow);
        String actualresult1=driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).getText();
        String expectedresult1="Elemental Selenium";
        Assert.assertEquals(actualresult1,expectedresult1);

    }

}
