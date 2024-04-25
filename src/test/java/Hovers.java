import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Hovers extends BaseTest {
    @Test
    public void testHovers() {
        driver.navigate().to("http://the-internet.herokuapp.com/hovers");
        Actions builder = new Actions(driver);

        WebElement firstProfile = driver.findElement(By.xpath("//div[@class='figure'][1]"));
        builder.moveToElement(firstProfile).perform();
        WebElement name = driver.findElement(By.xpath("//h5[text()='name: user1']"));
        WebElement link = driver.findElement(By.xpath("//h5[text()='name: user1']/following-sibling::a"));
        Assert.assertTrue(name.isDisplayed(), "Name of the first user is visible when you hover the mouse");
        link.click();
        WebElement verifyPage = driver.findElement(By.xpath("//h1[text()='Not Found']"));
        Assert.assertTrue(verifyPage.isDisplayed(), "'Not found message' is displayed for first user");
        driver.navigate().back();

        WebElement secondProfile = driver.findElement(By.xpath("//div[@class='figure'][2]"));
        builder.moveToElement(secondProfile).perform();
        name = driver.findElement(By.xpath("//h5[text()='name: user2']"));
        link = driver.findElement(By.xpath("//h5[text()='name: user2']/following-sibling::a"));
        Assert.assertTrue(name.isDisplayed(),"Name of the second user is visible when you hover the mouse");
        link.click();
        verifyPage = driver.findElement(By.xpath("//h1[text()='Not Found']"));
        Assert.assertTrue(verifyPage.isDisplayed(),"'Not found message' is displayed for second user");
        driver.navigate().back();

        WebElement thirdProfile = driver.findElement(By.xpath("//div[@class='figure'][3]"));
        builder.moveToElement(thirdProfile).perform();
        name = driver.findElement(By.xpath("//h5[text()='name: user3']"));
        link = driver.findElement(By.xpath("//h5[text()='name: user3']/following-sibling::a"));
        Assert.assertTrue(name.isDisplayed(),"Name of the third user is visible when you hover the mouse");
        link.click();
        verifyPage = driver.findElement(By.xpath("//h1[text()='Not Found']"));
        Assert.assertTrue(verifyPage.isDisplayed(), "'Not found message' is displayed for third user");
        driver.navigate().back();
    }
}
