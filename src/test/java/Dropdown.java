import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Dropdown extends BaseTest {
    @Test
    public void testDropdown() {
        driver.navigate().to("http://the-internet.herokuapp.com/dropdown");

        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);

        select.selectByValue("1");
        WebElement option1 = driver.findElement(By.xpath("//select[@id='dropdown']/option[@value='1']"));
        Assert.assertTrue(option1.isSelected(), "Option 1 is selected");

        select.selectByValue("2");
        WebElement option2 = driver.findElement(By.xpath("//select[@id='dropdown']/option[@value='2']"));
        Assert.assertTrue(option2.isSelected(), "Option 2 is selected");

    }
}
