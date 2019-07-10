import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class OpenBrowserTest {
    private WebDriver driver;
    private String url;

    @BeforeTest
    public void setUp(){
        url = "https://google.com";
        driver = new ChromeDriver();
    }

    @AfterTest
    public void shutDown(){
        driver.close();
    }

    @Test
    public void test(){

    }
}
