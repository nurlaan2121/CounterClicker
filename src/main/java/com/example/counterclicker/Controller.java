package com.example.counterclicker;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicLong;

public class Controller {
    Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/counterzikr", "postgres", "nurlan21");

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button clicker;
    @FXML
    private Label itog;

    @FXML
    private Button itogBtn;

    @FXML
    private Label display;
    @FXML
    private Button convert;

    @FXML
    private Label zikr;

    @FXML
    private Label zikr_translate;
    public static long counter = 0L;

    public Controller() throws SQLException {
    }

    @FXML
    void initialize() {


        String mediaPath = "/com/example/counterclicker/c8fd8d10309e3e0.mp3";
        Media media = new Media(Objects.requireNonNull(getClass().getResource(mediaPath)).toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        AtomicLong counter = new AtomicLong();
        clicker.setOnAction(actionEvent -> {
            mediaPlayer.stop();
            mediaPlayer.play();
            counter.getAndIncrement();
            int i = counter.intValue();
            String style = zikr_translate.getStyle();
            Controller.counter = i;
            if (100 >= i) {
                try {
                    add1(i, "subhanallah", 1);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (100 <= i && 200 >= i) {
                try {
                    add1(i, "alhamdulillah", 2);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                zikr.setText(" 'АЛХАМДУЛИЛЛАХ' ");
                zikr_translate.setText(" Аллах Таалага чексиз мактоолор болсун ");
            }
            if (200 <= i && 300 >= i) {

                try {
                    add1(i, "allahuakbar", 3);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                zikr.setText(" 'АЛЛАХУ АКБАР' ");
                zikr_translate.setText("Аллах Таала баарынан Улуу");
            }
            if (300 <= i && 400 >= i) {

                try {
                    add1(i, "laailaahaillaloh", 4);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                zikr.setText("'ЛАА ИЛААХА ИЛЛАЛЛООХ,МУХАММАДУР РАСУУЛУЛЛООХ'");
                zikr_translate.setStyle("-fx-font-size: 12; -fx-background-color:  blue;");
                zikr_translate.setText("Алладан башка сыйынууга ылайыктуу зат жок, Мухаммад (с.а.в) Алланын элчиси");

            }
            if (400 <= i && 500 >= i) {

                try {
                    add1(i, "laahavlaavalaakuffataillabillah", 5);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                zikr.setText("ЛАА ХАВЛА ВАЛАА КУВВАТА ИЛЛАА БИЛЛААХ");
                zikr_translate.setStyle("-fx-font-size: 12; -fx-background-color:  blue;");
                zikr_translate.setText("Аллах Тааладан башка таянып-ишене турган эч бир улуу Күч жок!");

            }
            if (500 <= i && 600 >= i) {

                try {
                    add1(i, "astagfirullah", 6);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                zikr.setText(" 'Астагфируллах' ");
                zikr_translate.setStyle("-fx-font-size: 12; -fx-background-color:  blue;");
                zikr_translate.setText("Аллаху тааладан ката жана кемчиликтеримди кечирүүсүн суранамын, тилеймин");

            }
            if (600 <= i && 700 >= i) {

                try {
                    add1(i, "laailaahaillaantasubanakinnikuntu", 7);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                zikr_translate.setStyle(style);
                zikr.setText("'Ла илаха илла анта субханака инни кунту миназзалимин'");
                zikr_translate.setText(" ");


            }
            if (700 <= i && 800 >= i) {
                try {
                    add1(i, "laailaahaillaantasubanakinnikuntu", 7);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (800 < i) {
                try {
                    add1(i, "aralash", 8);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        itogBtn.setOnAction(actionEvent -> {
            Long countt = 0L;
            String getone = "SELECT MAX(counter) AS max_counter FROM alhamdulillah;";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(getone);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    countt += resultSet.getLong("max_counter");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            String gettwo = "SELECT MAX(counter) AS max_counter from subhanallah;";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(gettwo);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    countt += resultSet.getLong("max_counter");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            String tree = "SELECT MAX(counter) AS max_counter from laailaahaillaloh;";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(tree);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    countt += resultSet.getLong("max_counter");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            String four = "SELECT MAX(counter) AS max_counter from laailaahaillaantasubanakinnikuntu;";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(four);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    countt += resultSet.getLong("max_counter");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            String fife = "SELECT MAX(counter) AS max_counter from laahavlaavalaakuffataillabillah;";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(fife);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    countt += resultSet.getLong("max_counter");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            String six = "SELECT MAX(counter) AS max_counter from astagfirullah;";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(six);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    countt += resultSet.getLong("max_counter");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            String seven = "SELECT MAX(counter) AS max_counter from allahuakbar;";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(seven);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    countt += resultSet.getLong("max_counter");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            String eight = "SELECT MAX(counter) AS max_counter from aralash;";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(eight);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    countt += resultSet.getLong("max_counter");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            itog.setText(String.valueOf(countt));
        });

    }

    private void add1(int i, String name, int id) throws SQLException {
        System.out.println(name);
        String add = "insert into " + name + " (zikirge_id) values (?) ";
        PreparedStatement preparedStatement = connection.prepareStatement(add);
        preparedStatement.setInt(1, id);
        preparedStatement.setInt(1, 1);
        int i1 = preparedStatement.executeUpdate();
        if (i1 > 0) {
            display.setText(String.valueOf(i));
        }
    }

    public void convertZikr(int allcounter) throws SQLException {
        String getallcounter = "select * from massiv ;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getallcounter);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long count = resultSet.getLong("count") + allcounter;
                String update = "update massiv set count = (?)";
                PreparedStatement preparedStatement1 = connection.prepareStatement(update);
                preparedStatement1.setLong(1, count);
                int i = preparedStatement1.executeUpdate();
                if (i > 0) {
                    System.out.println("Succes");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
