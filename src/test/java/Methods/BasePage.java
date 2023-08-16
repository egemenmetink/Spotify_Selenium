package Methods;

import Tests.BaseTest;
import org.apache.log4j.LogManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Random;

import org.apache.log4j.Logger;


public class BasePage extends BaseTest {

    public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    static Random random = new Random();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    public static final Logger logger = LogManager.getLogger(Driver.class);


    //Element bulma metodum.
    public static WebElement find(By locator) {
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (org.openqa.selenium.TimeoutException e) {
            throw new RuntimeException("Bu element bulunamadı: " + locator, e);
        }
    }


    //Tıklama metodum.
    public static void clickByLocator(By locator) {
        find(locator).click();
        logger.info(locator + ": elementine tıklandı...");
    }


    //Elemente Action kullanarak tıklatma metodum.
    public static void clickElementWithAction(WebElement element) {
        Actions actions = new Actions(driver);
        actions.click(element).perform();
        logger.info(element + ": elementine tıklandı...");
    }

    //Text-Box'a metin yazdırma metodu.
    public static void sendText(By locator, String text) {
        find(locator).sendKeys(text);
        logger.info(text + "yazıldı.");

    }

    //Rastgele sayı oluştma metodu.
    public static int createRandomNumber(int num) {
        int randomNumber = random.nextInt(num);
        return randomNumber;

    }

    //Fareyi elementin üzerine götürme metodu. (Locator alarak)
    public static void hoverElement(By locator) {
        WebElement webElement = find(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).build().perform();
    }

    //Fareyi elementin üzerine götürme metodu. (WebElement alarak)
    public static void hoverElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }


    //Elementin görünüp görünmediğini kontrol eden metot. Görünüyorsa 'true' döndürüyor.
    public static boolean isElementVisible(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException | NullPointerException e) {
            return false;
        }
    }

    //Elementin tıklanabilir olup olmadığını kontrol eden metot. Tıklanabiliyorsa 'true' döndürüyor.
    public static boolean isClickable(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true; // Element tıklanabilir durumdaysa true döndür
        } catch (Exception e) {
            return false; // Element tıklanabilir değilse false döndür
        }
    }

    //İstenen element bulunana kadar sayfayı aşşağıya kaydıran metot.
    public static void scrollDown(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //İstenen element bulunana kadar sayfayı yukarıya kaydıran metot.
    public static void scrollUp(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(false);", element);
        //js.executeScript("javascript:window.scrollBy(250,350)");
        //js.executeScript("window.scrollTo(0, document.body.scrollHeight / 2)");
    }

    //Şarkı numarasını girince o şarkıyı bulup favorilere ekleyen metot.
    public static void addToFavorites(int num) throws InterruptedException {
        WebElement addToFavoritesButtonElement = find(By.xpath("//div[@aria-rowindex='" + num + "']//button[@data-testid='add-button']"));
        scrollUp(addToFavoritesButtonElement);
        clickElementWithAction(addToFavoritesButtonElement);
        logger.info("Şarkı eklendi");
    }


}