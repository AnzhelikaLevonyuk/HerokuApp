import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.fail;

public class DynamicControls extends BaseTest{
    @Test
    public void testDynamicControls() {
        driver.navigate().to("http://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.cssSelector("form[id = 'checkbox-example'] button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));

        try
        {
            driver.findElement(By.id("checkbox"));
            fail("Expected NoSuchElementException to be thrown, but it wasn't");
        }
        catch (NoSuchElementException e){
        }

        Assert.assertFalse(driver.findElement(By.tagName("input")).isEnabled());
        driver.findElement(By.cssSelector("form[id = 'input-example'] button")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));
        Assert.assertTrue(driver.findElement(By.tagName("input")).isEnabled());

    }
}
