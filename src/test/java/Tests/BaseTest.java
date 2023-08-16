package Tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class BaseTest {

    public static WebDriver driver;
    public static WebDriverWait wait;


    @BeforeAll
    public static void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://open.spotify.com/?");
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(5000); //Her şey bitince 5sn bekleyip tarayıcıyı kapatıyor.
        driver.quit();
        System.out.println("Test Bitti");
    }
}


