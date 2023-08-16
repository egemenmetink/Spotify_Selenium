package Tests;

import Pages.*;
import org.junit.jupiter.api.Test;

import static Methods.BasePage.clickByLocator;
import static Methods.BasePage.sendText;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)


public class First_Test extends BaseTest {



    BeforeHomePage beforeHomePage = new BeforeHomePage();

    LoginPage loginPageObj = new LoginPage();

    AfterLoginHomepage afterLoginHomepageObj = new AfterLoginHomepage();

    PlaylistPage1 playlistPage1 = new PlaylistPage1();


    LikedSongPage likedSongPage = new LikedSongPage();


    @Test
    @Order(1)
    public void Login() throws InterruptedException {

        //popup kapa
        clickByLocator(BeforeHomePage.popUpButtonLocator);

        //Giriş Yap butonuna tıkla
        clickByLocator(beforeHomePage.loginButtonLocator);

        //Emaili gir
        sendText(loginPageObj.emailLocator, "egemen.metinkaya@testinium.com");

        //Şifreyi gir
        sendText(loginPageObj.passwordLocator, "EgemenTestinium123");

        //Login sayfası kontrolü
        loginPageObj.checkLoginPage();

        //Giriş Yap butonuna tıkla
        clickByLocator(loginPageObj.loginButton2Locator);
    }

    @Test
    @Order(2)
    public void FavList() throws InterruptedException {

        //Hot Hits listesine gir
        clickByLocator(afterLoginHomepageObj.playlistLocator);

        //şarkı listesini oluştur
        playlistPage1.createSongList();

        //şarkıyı seç
        playlistPage1.selectSong();

        //şarkıyı bul
        playlistPage1.findSong();
    }

    @Test
    @Order(3)
    public void LikeAndCheck() throws InterruptedException {
        //şarkıyı favoriler listesine ekle.
        playlistPage1.addToFavoriteList();

        //Favoriler listesine git.
        clickByLocator(likedSongPage.likedSongListButtonLocator);

        //Favorilere eklediğimiz şarkı, Favoriler Listesine eklenmiş mi diye kontrol et.
        likedSongPage.checkSong();
    }
}
