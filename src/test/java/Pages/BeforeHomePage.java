package Pages;

import Methods.BasePage;
import org.openqa.selenium.By;

public class BeforeHomePage extends BasePage {

    public By loginButtonLocator = By.cssSelector("button[data-testid='login-button']");
    public static By popUpButtonLocator = By.cssSelector("div[id='onetrust-close-btn-container']");
}
