package Pages;

import Methods.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LoginPage extends BasePage {

    public static By emailLocator = By.id("login-username");

    public By passwordLocator = By.id("login-password");

    public By loginButton2Locator = By.id("login-button");

    By loginCheckTextLocator = By.xpath("//h1[@class='Type__TypeElement-sc-goli3j-0 jaaEvK sc-eDWCr kcLdfM']");



    public void checkLoginPage() {
        //Burada oturum açma ekranının tam olarak yüklendiğini kontrol ediyoruz.
        WebElement loginCheckTextElement = find(loginCheckTextLocator);
        Assertions.assertEquals("Spotify'da oturum aç", loginCheckTextElement.getText(), "Login sayfası yüklenemedi.");


    }


}
