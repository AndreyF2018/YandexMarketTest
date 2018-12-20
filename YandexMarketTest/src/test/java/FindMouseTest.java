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
public class FindMouseTest extends WebDriverTuning
{
    private int ChangePrice(String price)
    {
        int intPrice = Integer.parseInt(ClearSpace(price.substring(0, price.length() - 1)));
        return intPrice;
    }
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

    private void deleteInvalidItem(List<WebElement> mouses)
    {
        for (WebElement mouse : mouses)
        {
            if(mouse.getText().equals(""))
            {
                mouses.remove(mouse);
            }
        }
    }

    private String ReduceNumberItems(String str)
    {
        String amountElements = str.substring(8, str.length() - 12);
        System.out.println(amountElements);
        return amountElements;
    }

    private void changePrice(WebElement allElements) throws InterruptedException
    {
        String amountElements = ReduceNumberItems(allElements.getText());

        while(amountElements.equals(ReduceNumberItems(driver.findElement(By.className("n-search-preciser__results-count")).getText())))
        {
            Thread.sleep(3000);
            System.out.println("Wait 30 seconds");
        }

    }

    public void findMouse() throws InterruptedException
    {
        WebElement searchField = driver.findElement(By.id("header-search"));
        searchField.sendKeys("Компьютерные мыши");

        WebElement searchButton = driver.findElement(By.className("search2__button")).findElement(By.tagName("button"));
        searchButton.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement allElements = driver.findElement(By.className("n-search-preciser__results-count"));

        WebElement MinPriceField = driver.findElement(By.id("glpricefrom"));
        MinPriceField.sendKeys("800");

        WebElement MaxPriceField = driver.findElement(By.id("glpriceto"));
        MaxPriceField.sendKeys("1000");
        changePrice(allElements);

        List<WebElement> mouses = driver.findElement(By.className("n-snippet-list")).findElements(By.xpath("//div[@class = 'price']"));
        deleteInvalidItem(mouses);
        for (WebElement mousePrice : mouses)
        {
            int price = ChangePrice(mousePrice.getText());
            Assert.assertTrue(price <= 1000 && price >= 800);
        }
    }
}
