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
public class LoginTest extends  WebDriverTuning
{
        public void login() throws InterruptedException
        {
            WebElement buttonLogin = driver.findElement(By.className("n-passport-suggest-popup-opener")).findElement(By.tagName("a"));
            buttonLogin.click();

            Thread.sleep(6000);

            String oldWindow = driver.getWindowHandle();
            ArrayList<String> newWindow = new ArrayList<String>(driver.getWindowHandles());
            newWindow.remove(oldWindow);
            driver.switchTo().window(newWindow.get(0));



            WebElement login = driver.findElement(By.name("login"));
            login.sendKeys("fedorovfortesting");


            WebElement password = driver.findElement(By.name("passwd"));
            password.sendKeys("TestPassword");

            buttonLogin = driver.findElement(By.className("passport-Button"));
            buttonLogin.click();


            driver.switchTo().window(oldWindow);
            Thread.sleep(6000);


            Thread.sleep(6000);



            WebElement clickSpace = driver.findElement(By.id("header-search"));
            clickSpace.click();

            Thread.sleep(6000);

            WebElement iconUser = driver.findElement(By.cssSelector(".n-passport-suggest-popup-opener .user__icon"));
            iconUser.click();

            WebElement userName = driver.findElement(By.cssSelector(".n-passport-suggest-popup-opener .user__name"));
            Assert.assertEquals(userName.getText(), "fedorovfortesting");
        }

}
