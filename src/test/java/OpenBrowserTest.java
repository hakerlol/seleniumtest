import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class OpenBrowserTest {
    private WebDriver driver;
    private String url;

    @BeforeTest
    public void setUp(){
        url = "https://www.google.com/";
        driver = new ChromeDriver();
    }

    @AfterTest
    public void shutDown(){
        driver.close();
    }

    @Test
    public void test(){
        driver.get(url);
        WebDriverWait driverWait = new WebDriverWait(driver, 5);
        By searchWindow = By.xpath("/html/body/div/div[3]/form/div[2]/div/div[1]/div/div[1]/input");
        WebElement searchWindowElement = driverWait.until(ExpectedConditions.presenceOfElementLocated(searchWindow));
        searchWindowElement.click();
        searchWindowElement.sendKeys("How to google");
        WebElement startSearch = driver.findElement(By.xpath("/html/body/div/div[3]/form/div[2]/div/div[3]/center/input[1]"));
        startSearch.click();

    }
}
