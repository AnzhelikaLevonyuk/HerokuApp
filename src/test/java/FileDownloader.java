import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class FileDownloader extends BaseTest {
    @Test
    public void testFileDownloader() throws InterruptedException {

        var downloadDir = Paths.get("src/test/resources").toAbsolutePath().toString();

        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadDir);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("http://the-internet.herokuapp.com/download");

        List<WebElement> links = driver.findElements(By.xpath("//a"));
        links.get(3).click();
        String fileNameOnApp = links.get(3).getText();

        var downloadFilePath = Paths.get(downloadDir, fileNameOnApp);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(d -> downloadFilePath.toFile().exists());

        Assert.assertTrue(downloadFilePath.toFile().exists(), "Downloaded document is not found");
        downloadFilePath.toFile().deleteOnExit();
        driver.quit();
    }
}
