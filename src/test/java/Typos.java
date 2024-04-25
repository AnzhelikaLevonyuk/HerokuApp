import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@Test
public class Typos extends BaseTest {
    // First solution
    @Test
    public void testTyposWithoutXpath() {
        driver.navigate().to("http://the-internet.herokuapp.com/typos");
        List<WebElement> elements = driver.findElements(By.tagName("p"));
        Assert.assertEquals(elements.get(1).getText(), "Sometimes you'll see a typo, other times you won't.", "Text is wrong");
    }

    //Second solution with Xpath
    @Test
    public void testTypos() {
        driver.navigate().to("http://the-internet.herokuapp.com/typos");
        WebElement text = driver.findElement(By.xpath("//div[@class = \"example\"]/p[2]"));
        Assert.assertEquals(text.getText(), "Sometimes you'll see a typo, other times you won't.", "Text is wrong");
    }
}
