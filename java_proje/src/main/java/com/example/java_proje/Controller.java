package com.example.java_proje;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.*;


public class Controller  {

    public static String noin;
    public static String sifrein;
    private String sifre_vt;
    private String no_vt;
    public static String kod_vt;
    public static String dosya_fxml;
    public static String value;



    @FXML
    private Button giris_buton;

    @FXML
    private TextField ogr_no;

    @FXML
    private PasswordField sifre;

    @FXML
    private Label uyari;


    @FXML
    private ComboBox<String> yetki_combo;

    @FXML
    public void initialize() {
        yetki_combo.getItems().addAll("Öğrenci", "Öğretmen", "İdari Personel");
    }


    PreparedStatement preparedStatement = null;

    @FXML
    protected void girisYap(ActionEvent e) throws IOException, SQLException {

        sifrein = sifre.getText();
        noin = ogr_no.getText();

       value = yetki_combo.getValue();


        //  Class.forName("com.mysql.cj.jdbc.Driver");


        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/devlet_egitim?serverTimezone=UTC", "root", "");
        Statement statement = connection.createStatement(); //sql sorguları yapmak için statement oluşturulur.
        ResultSet resultSet = null;


        if (value.equals("Öğrenci")) {
            resultSet = statement.executeQuery("Select * from devlet_egitim.ogrenci");
            dosya_fxml = "ogr_menu.fxml";
        } else if (value.equals("Öğretmen")) {
            resultSet = statement.executeQuery("Select * from devlet_egitim.ogretmen");
            dosya_fxml = "ogretmen_menu.fxml";
        } else if (value.equals("İdari Personel")) {
            resultSet = statement.executeQuery("Select * from devlet_egitim.idari_personel");
            dosya_fxml = "idari_personel_menu.fxml";
        }


        while (resultSet.next()) {
            sifre_vt = resultSet.getString("sifre");
            no_vt = resultSet.getString("no");


            if (sifrein.equals(sifre_vt) && noin.equals(no_vt)) {

                kod_vt=resultSet.getString("kod");
                giris_buton.getScene().getWindow().hide();
                Stage giris_buton = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource(dosya_fxml));  //ana menüye gider
                Scene scene = new Scene(root);
                giris_buton.setResizable(false);
                giris_buton.setScene(scene);
                giris_buton.show();

            } else {
                uyari.setText("Numaranız veya şifreniz hatalı");
                ogr_no.setText("");
                sifre.setText("");
            }


        }


    }
}