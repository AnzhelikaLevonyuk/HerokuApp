import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class NotificationMessages extends BaseTest {

    public void testNotificationMessages() {
        driver.navigate().to("http://the-internet.herokuapp.com/notification_message_rendered");

        driver.findElement(By.xpath("//a[text() = 'Click here']")).click();
        driver.findElement(By.cssSelector("#flash")).isDisplayed();
        Assert.assertEquals(driver.findElement(By.cssSelector("#flash")).getText(), "Action successful", "'Action successful' notification is displayed correct");
    }
}
