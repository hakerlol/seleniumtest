import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


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

    @Step("Открытие браузера. URL адрес: {url}")
    private void openBrowser(String url){
        driver.get(url);
    }

    @Attachment(value = "Думай!!!", fileExtension = ".jpeg")
    private static byte[] getBytesAnnotation(String resourceName) throws IOException {
        return Files.readAllBytes(Paths.get("src/test/resources", resourceName));
    }

    @Attachment
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Test
    @Story(value = "Открытие браузера")
    @Description(value = "Тест проверяет открытие стартовой страницы google.com и возможность поиска")
    public void test() throws IOException {
        openBrowser(url);
        getBytesAnnotation("1.jpeg");
        WebDriverWait driverWait = new WebDriverWait(driver, 5);
        By searchWindow = By.xpath("/html/body/div/div[3]/form/div[2]/div/div[1]/div/div[1]/input");
        WebElement searchWindowElement = driverWait.until(ExpectedConditions.presenceOfElementLocated(searchWindow));
        searchWindowElement.click();
        searchWindowElement.sendKeys("How to google");
        WebElement startSearch = driver.findElement(By.xpath("/html/body/div/div[3]/form/div[2]/div/div[3]/center/input[1]"));
        startSearch.click();
        attachScreenshot();
        searchWindowElement.sendKeys("2323");
    }

    @Test
    @Story(value = "Поиск картинок")
    @Description(value = "Тест проверяет открытие страницы с картинками")
    public void testPic() throws IOException {
        openBrowser("https://www.google.ru/search?newwindow=1&hl=ru&tbm=isch&source=hp&biw=960&bih=900&ei=eOkmXZetKb2HwPAP4omowAY&q=s&oq=s&gs_l=img.12..0l10.4166.4166..4894...0.0..0.134.273.2j2......0....1..gws-wiz-img.....0.XT827_bPiQ8");
        WebDriverWait driverWait = new WebDriverWait(driver, 5);
        By searchWindow = By.id("0b3pyJvzyKZqIM:");
        WebElement searchWindowElement = driverWait.until(ExpectedConditions.presenceOfElementLocated(searchWindow));
        searchWindowElement.click();
    }
}
