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
public class DeferredTest extends LoginTest
{
    public void addToDeferred() throws InterruptedException
    {

        login();


        WebElement searchField = driver.findElement(By.id("header-search"));
        searchField.sendKeys("Робот-пылесос управление со смартфона");

        WebElement searchButton = driver.findElement(By.className("search2__button")).findElement(By.tagName("button"));
        searchButton.click();

        WebElement vacuum_cleaner = driver.findElement(By.linkText("Пылесос Xiaomi Mi Robot Vacuum Cleaner"));
        vacuum_cleaner.click();

        WebElement addToDeferred = driver.findElement
                (By.cssSelector("span.n-product-toolbar__item-label.n-product-toolbar__item-label_activated_no"));
        addToDeferred.click();

        WebElement goToDeferred = driver.findElement(By.linkText("Перейти к отложенным"));
        goToDeferred.click();

        WebElement VacuumCleanerName = driver.findElement(By.className("snippet-card__header-text"));

        System.out.print(VacuumCleanerName.getText());
        Assert.assertEquals(VacuumCleanerName.getText(), "Пылесос Xiaomi Mi Robot Vacuum Cleaner");




    }
}
