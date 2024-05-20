import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DynamicControls extends BaseTest{
    @Test
    public void testDynamicControls() {
        driver.navigate().to("http://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.cssSelector("form[id = 'checkbox-example'] button")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));

        Assert.assertFalse(isElementPresent(By.id("checkbox")));

        Assert.assertFalse(driver.findElement(By.tagName("input")).isEnabled());
        driver.findElement(By.cssSelector("form[id = 'input-example'] button")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));
        Assert.assertTrue(driver.findElement(By.tagName("input")).isEnabled());

    }
}
