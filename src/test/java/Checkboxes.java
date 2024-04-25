import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Checkboxes extends BaseTest {
    @Test
    public void testCheckboxes() {

        driver.navigate().to("http://the-internet.herokuapp.com/checkboxes");

        List<WebElement> checkboxElements = driver.findElements(By.cssSelector("[type='checkbox']"));

        WebElement firstCheckbox = checkboxElements.get(0);
        WebElement secondCheckbox = checkboxElements.get(1);

        Assert.assertFalse(firstCheckbox.isSelected(), "First checkbox should be unchecked");
        firstCheckbox.click();
        Assert.assertTrue(firstCheckbox.isSelected(), "First checkbox should be checked");

        Assert.assertTrue(secondCheckbox.isSelected(), "Second checkbox should be checked");
        secondCheckbox.click();
        Assert.assertFalse(secondCheckbox.isSelected(), "Second checkbox should be unchecked");
    }
}
