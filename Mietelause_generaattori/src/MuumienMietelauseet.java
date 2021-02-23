
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MuumienMietelauseet extends Application {

    Stage window;
    @Override
    public void start(Stage window) {
        // tehdään ohjelma joka antaa päivän mietelauseen kerätystä listasta. 
        // käyttäjä voi myös itse lisätä mietelauseen ohjelmaan
        //try-catch toiminto antaa statissa tehdyistä virheistä ilmoituksen eikä ohjelma ns. kaadu
        try {
            
            //Lisätään listaan lauseita valmiiksi
            List<String> mietelauseet = new ArrayList<>();
            mietelauseet.add("Kaikki hauska on hyvää vatsalle. – Muumimamma");
            mietelauseet.add("Apua! En minä jaksa kantaa näin painavaa vaimoa! –Muumipappa");
            mietelauseet.add("Minä en jätä huomiseen mitään, minkä voin tehdä tänään. -Myy");
            mietelauseet.add("Rahalla ei voi ostaa nuoruutta. -Pikku Myy");
            mietelauseet.add("Vakiintunut elämä ei tarjoa mitään jännityksiä. -Pikku Myy");
            mietelauseet.add("Sisimpäni suorastaan kiljuu kahvia! -Muumipappa");
            mietelauseet.add("Takaisin luontoon. Elämme vain kerran. Hiiteen velvollisuudet!\n" +
            "Muumipappa");
            mietelauseet.add("Minulla on varpaan nipukoita myöten hyvä olo. -Mymmeli");
            
            //näyttämöä pystyyn ja nimetään se. Olen laittanut sen windowsiksi jotta sen saa napista suljettua
            Stage stage = new Stage();
            stage.setTitle("Muumien mietelauseet");
            //ryhmä pystyyn
            Group ryhmis = new Group();
            
            //tuodaan taustakuva
            Image tausta = new Image("muumipappa1.jpg",600,600,false,false);
            ImageView natural_size_view = new ImageView( tausta) ;
            natural_size_view.setRotate(natural_size_view.getRotate());

            
            //Luodaan arvonta-nappula lauseen vaihtoa varten
            Button arvoLause = new Button();
            arvoLause.setText("Uusi miete");
            arvoLause.setFont(Font.font("verdana",FontWeight.BLACK,14));
            arvoLause.setLayoutX(50);
            arvoLause.setLayoutY(230);
            
            //Arvotaan mietelause alkuun
            Random ran = new Random();
            int r = ran.nextInt(mietelauseet.size());
            //Tehdään uusi teksti, ja säädetään sitä vähän. Asetetaan eka lause siihen
            Text lause = new Text();
            lause.setFont(Font.font("verdana",FontWeight.BOLD, 14));
            lause.setFill(Color.WHITE);
            lause.setX(50);
            lause.setY(200);
            lause.setText(mietelauseet.get(r));
            
            //kysytään käyttäjältä mietelausetta
            TextField uusi = new TextField();
            uusi.setText("Anna oma mietelauseesi");
            uusi.setMinSize(600,30);
            uusi.setFont(Font.font("verdana",14));
            uusi.setStyle("-fx-text-fill: GREY; -fx-font-size: 14px;");
            
            //tyhjätään ruutu kun sitä painetaan ettei ohjeteksti mene lauseeksi
            uusi.setOnMousePressed((MouseEvent event) ->{
                                    uusi.setText("");});
            
            
            
            Button lisaa = new Button();
            lisaa.setText("Lisää lause");
            lisaa.setFont(Font.font("verdana", 14));
            lisaa.setLayoutX(500);
            lisaa.setLayoutY(0);
            lisaa.setOnAction( e -> mietelauseet.add(uusi.getText()));
            
            //Annetaan nappulalle toiminto 
            arvoLause.setOnAction((ActionEvent e) -> {
                 int i = ran.nextInt(mietelauseet.size());
                 lause.setText(mietelauseet.get(i));
            });
            
            //lisätään kamaa ryhmään
            ryhmis.getChildren().addAll(natural_size_view,lause, arvoLause,uusi,lisaa);
            
            //tehdään scene ja määritetään sen koko ja lisätään ryhmä siihen
            Scene scene = new Scene(ryhmis, 600, 480);
            
            //laitetaan scene näyttämölle ja show pystyyn
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            System.out.println("It didn't work");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
