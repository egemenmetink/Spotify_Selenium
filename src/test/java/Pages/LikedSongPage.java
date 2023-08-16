package Pages;

import Methods.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LikedSongPage extends BasePage {


    PlaylistPage1 playlistPage1 = new PlaylistPage1();
    public By likedSongListButtonLocator = By.xpath("//div[@aria-labelledby='listrow-title-spotify:collection:tracks listrow-subtitle-spotify:collection:tracks']");

    //Spotify'da listesinin en üstündeki şarkının aria-rowindex'i 2'dir.Biz en üstteki şarkıyı istiyoruz çünkü o son eklendi.
    public By likedSong = By.xpath("//div[@aria-rowindex='2'] //div[@class='Type__TypeElement-sc-goli3j-0 fZDcWX t_yrXoUO3qGsJS4Y6iXX standalone-ellipsis-one-line']");

    public void checkSong() throws InterruptedException {
        Thread.sleep(1000);
        //Burada favoriler listenin en üstündeki şarkının adını alıyoruz.
        WebElement likedSongElement = find(likedSong);
        String likedSongName = likedSongElement.getText();
        logger.info("Favoriler listesine eklenen şarkının ismi alındı.");


        logger.info("Şarkıların isimleri karşılaştırıldı.");
        //Burada seçilen şarkının ismiyle, favoriler listesine eklenen şarkının isimlerini karşılaştırıyoruz.
        if (playlistPage1.selectedSongName.equals(likedSongName)) {
            System.out.println("Şarkılar birbirlerine eşit.");
        }else {
            logger.info("Şarkılar birbirlerini tutmuyor.");
        }



    }
}