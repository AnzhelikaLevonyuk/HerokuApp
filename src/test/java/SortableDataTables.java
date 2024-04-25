import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortableDataTables extends BaseTest {
    @Test
    public void testSortableDataTables() {
        driver.navigate().to("http://the-internet.herokuapp.com/tables");

        String cellFirstName = driver.findElement(By.xpath("//table//tr[1]//td[2]")).getText();
        Assert.assertEquals(cellFirstName, "John", "Сell should contain value: 'John'");

        String cellEmail = driver.findElement(By.xpath("//table//tr[2]//td[3]")).getText();
        Assert.assertEquals(cellEmail, "fbach@yahoo.com", "Сell should contain value: 'fbach@yahoo.com'");

        String cellDue = driver.findElement(By.xpath("//table//tr[3]//td[4]")).getText();
        Assert.assertEquals(cellDue, "$100.00", "Сell should contain value: '$100.00");

        String cellLastName = driver.findElement(By.xpath("//table[2]//tr[3]//td[1]")).getText();
        Assert.assertEquals(cellLastName, "Doe", "Сell should contain value: 'Doe'");

        String cellAction = driver.findElement(By.xpath("//table[2]//tr[2]//td[6]")).getText();
        Assert.assertEquals(cellAction, "edit delete", "Сell should contain value: 'edit delete'");
    }
}
