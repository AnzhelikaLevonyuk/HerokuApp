import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Inputs extends BaseTest {
    @Test
    public void testInputs() {
        driver.navigate().to("http://the-internet.herokuapp.com/inputs");

        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_UP);
        String arrowUpResult = driver.findElement(By.tagName("input")).getAttribute("value");
        Assert.assertEquals(arrowUpResult, "1", "ARROW_UP work correctly, 1 is displayed in the dropdown menu");

        driver.navigate().refresh();
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_DOWN);
        String arrowDownResult = driver.findElement(By.tagName("input")).getAttribute("value");
        Assert.assertEquals(arrowDownResult, "-1", "ARROW_DOWN work correctly, -1 is displayed in the dropdown menu");

        driver.navigate().refresh();
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_UP, Keys.ARROW_UP, Keys.ARROW_UP, Keys.ARROW_DOWN);
        String arrowResult = driver.findElement(By.tagName("input")).getAttribute("value");
        Assert.assertEquals(arrowResult, "2", "ARROW_UP and ARROW_DOWN work correctly together");

        driver.navigate().refresh();
        driver.findElement(By.tagName("input")).sendKeys("abc");
        String charResult = driver.findElement(By.tagName("input")).getAttribute("value");
        Assert.assertEquals(charResult, "", "It is not possible to enter characters from the keyboard'");

        driver.navigate().refresh();
        driver.findElement(By.tagName("input")).sendKeys("123");
        String digitalResult = driver.findElement(By.tagName("input")).getAttribute("value");
        Assert.assertEquals(digitalResult, "123", "Entering digital from the keyboard is possible");
    }
}
