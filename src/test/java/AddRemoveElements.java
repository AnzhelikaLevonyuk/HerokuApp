import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AddRemoveElements extends BaseTest {
    @Test
    public void testAddRemoveElements() {
        driver.navigate().to("http://the-internet.herokuapp.com/add_remove_elements/");

        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        List<WebElement> elements = driver.findElements(By.xpath("//button[text()='Delete']"));
        Assert.assertEquals(elements.size(), 2, "Two buttons are displayed");

        driver.findElement(By.xpath("//button[text()='Delete']")).click();
        elements = driver.findElements(By.xpath("//button[text()='Delete']"));
        Assert.assertEquals(elements.size(), 1, "One button is remaining");

    }
}
