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
        WebElement selectedOption = select.getFirstSelectedOption();
        Assert.assertEquals(selectedOption.getText(), "Option 1", "Option 1 is selected");

        select.selectByValue("2");
        selectedOption = select.getFirstSelectedOption();
        Assert.assertEquals(selectedOption.getText(), "Option 2", "Option 2 is selected");

    }
}
