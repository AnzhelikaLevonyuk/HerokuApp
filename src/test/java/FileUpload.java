import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;


public class FileUpload extends BaseTest {
    @Test
    public void testFileUpload() {
        driver.get("https://the-internet.herokuapp.com/upload");
        File uploadFile = new File("src/test/resources/hello.jpg");

        WebElement fileInput = driver.findElement(By.id("file-upload"));
        fileInput.sendKeys(uploadFile.getAbsolutePath());
        driver.findElement(By.id("file-submit")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("uploaded-files")));

        Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText(), "hello.jpg");
    }
}