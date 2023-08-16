package Pages;

import java.util.ArrayList;
import java.util.List;
import Methods.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PlaylistPage1 extends BasePage {

    //Şarkıları bir WebElementi haline getirip listeye atacığımız o liste. Adı 'songList' .
    List<WebElement> songList = new ArrayList<>();
    public static WebElement selectedSong;

    public static WebElement selectedSongNameElement;

    public static String selectedSongName;
    int songNum;
    public void createSongList() {
        //Tüm şarkıları element olarak bul ve onlarla bir liste oluşturma metodu
        WebElement songElement;
        for (int i = 2; i <= 51; i++) { //51 yerine ne gelebilir bulamadım
            String songXPath = "//div[@aria-rowindex='" + i + "']";
            songElement = find(By.xpath(songXPath));
            //songElement = scroll(find(By.xpath(songXPath)));
            scrollDown(songElement);
            songList.add(songElement);
            //şarkılarımız songElement, songList list adlı bir listenin içindeler suanda.
        }
        logger.info("Playlisteki şarkılardan bir liste oluşturuldu.");
    }

    //Şarkıyı seçme metodu
    public void selectSong() throws InterruptedException {
        songNum = createRandomNumber(songList.size() - 1) + 1; //şarkının numarasını bulduk (0 ve 1 yok)
        selectedSong = songList.get(songNum); //WebElement selectedSong
        logger.info("Şarkı seçildi.");
    }

    //şarkıyı bulma metodu
        public void findSong() throws InterruptedException {
        selectedSong = find(By.xpath(" //div[@aria-rowindex='" + songNum + "']"));


        //Burada seçtiğimiz şarkımızın adını alıyoruz.
        String expandedXPath = "//div[@aria-rowindex='" + songNum + "'"+"]//"+"div[@class='Type__TypeElement-sc-goli3j-0 fZDcWX t_yrXoUO3qGsJS4Y6iXX standalone-ellipsis-one-line']";
        selectedSongNameElement = find(By.xpath(expandedXPath));
        selectedSongName = selectedSongNameElement.getText();
        logger.info("Seçilen şarkının ismi alındı.");


    }

    //Favorilere ekleme.
    public void addToFavoriteList() throws InterruptedException {
        WebElement selectedSongFavButton = find(By.xpath(" //div[@aria-rowindex='" + songNum + "']//button[@data-encore-id='buttonTertiary']"));
        String buttonAttributeValue = selectedSongFavButton.getAttribute("aria-checked");
        //Şarkı zaten favorilere eklenmiş bir şarkıysa önce şarkıyı favorilerden çıkartıyor sonra geri ekliyor.
        if (buttonAttributeValue.equals("false")) {
            hoverElement(selectedSong);
            addToFavorites(songNum);
        } else if (buttonAttributeValue.equals("true")) {
            hoverElement(selectedSong);
            addToFavorites(songNum);
            addToFavorites(songNum);
        }
    }

}