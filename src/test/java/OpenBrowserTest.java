import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class OpenBrowserTest {
    private WebDriver driver;
    private String url;

    @BeforeTest
    public void setUp(){
        url = "http://localhost:8080/main";
        driver = new ChromeDriver();
    }

    @AfterTest
    public void shutDown(){
        driver.close();
    }

    @Test
    public void test(){
        driver.get(url);
        assertThat(driver.getCurrentUrl(), is(url));
        assertThat(driver.getPageSource().contains("wow"), is(true));
    }
}
