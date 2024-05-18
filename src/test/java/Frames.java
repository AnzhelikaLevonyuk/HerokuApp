

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Frames extends BaseTest {
    @Test
    public void testFrames() {
        driver.navigate().to("http://the-internet.herokuapp.com/frames");
        driver.findElement(By.xpath(" //li[2]/a")).click();

        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);

        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "Your content goes here.");
    }
}