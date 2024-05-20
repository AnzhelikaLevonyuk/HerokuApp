import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenu extends BaseTest {
    @Test
    public void testContextMenu() {
        driver.navigate().to("http://the-internet.herokuapp.com/context_menu");

        Actions actions = new Actions(driver);
        WebElement hotSpot = driver.findElement(By.id("hot-spot"));
        actions.contextClick(hotSpot).perform();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "You selected a context menu");

        alert.accept();
        driver.switchTo().defaultContent();
    }
}

