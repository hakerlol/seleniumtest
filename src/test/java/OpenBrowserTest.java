import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class OpenBrowserTest {
    private WebDriver driver;
    private String url;

    @BeforeTest
    public void setUp(){
        url = "https://www.google.com/";
        driver = new ChromeDriver();
    }

    @Test
    public void test(){
        driver.get(url);
        assertThat(driver.getCurrentUrl(), is(url));
    }
}
