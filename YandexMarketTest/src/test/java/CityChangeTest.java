import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Test
public class CityChangeTest extends WebDriverTuning
{
    private String ClearSpace(String price)
    {
        StringBuffer newPrice = new StringBuffer(price);
        for (int i = 0; i < newPrice.length(); i++)
        {
            if(newPrice.charAt(i) == ' ')
            {
                newPrice.deleteCharAt(i);
            }
        }
        return new String(newPrice);
    }
    @Test
    public void changeCity() throws InterruptedException {
        WebElement buttonSelectCity = driver.findElement(By.className("n-region-notification_layout_init")).findElement(By.className("button2_theme_normal"));
        buttonSelectCity.click();

        WebElement cityField = driver.findElement(By.className("header2-region-popup")).findElement(By.className("input__control"));
        cityField.sendKeys("Энгельс");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement region = driver.findElement(By.className("header2-region-popup")).findElement(By.className("region-suggest__list")).findElement(By.tagName("div"));

        region.click();
        region.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement buttonSelectRegion = driver.findElement(By.className("header2-region-popup")).findElement(By.tagName("button"));
        buttonSelectRegion.click();

        String newCity = "Энгельс";
        String changedCity = ClearSpace(driver.findElement(By.className("header2-menu__text")).getText());
        Assert.assertEquals(changedCity, newCity);


       WebElement buttonReturnCity = driver.findElement(By.className("n-region-notification_layout_manual")).findElement(By.tagName("a"));
       buttonReturnCity.click();
    }

}
