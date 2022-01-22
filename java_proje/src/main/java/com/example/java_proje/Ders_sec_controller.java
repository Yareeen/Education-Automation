package com.example.java_proje;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class Ders_sec_controller extends Ekran_degis{
    @FXML
    private ComboBox<String> ders_combo;

    String ders_kod;
    String ders_adi;
    ArrayList<String> array;


    @FXML
    private TextArea ders_area;




    @FXML
    private ListView<String> ders_liste;

    @FXML
    private Button menu;

    public static int obs_uzunluk;

    public static String dersler;

    public static ObservableList <String> secilenler;

    @FXML
    private Button vt_ekle;

    int flag=0;

    @FXML
    private Label guncel_uyari;



    public void initialize() throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/devlet_egitim?serverTimezone=UTC", "root", "");
        Statement statement = connection.createStatement(); //sql sorguları yapmak için statement oluşturulur.
        ResultSet resultSet = null;

        resultSet = statement.executeQuery("Select ders_adi from devlet_egitim.ders");

        while (resultSet.next()) {

            ders_liste.getItems().add(resultSet.getString("ders_adi"));
            ders_liste.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        }

    }

    @FXML
    void menuDonButton(ActionEvent event)  throws IOException, SQLException{
            degis(menu,Controller.dosya_fxml);
    }


    @FXML
    void secilen_derse_ekle(ActionEvent event) throws IOException{

        dersler="";
        secilenler =ders_liste.getSelectionModel().getSelectedItems(); //observable list yaptım.

        obs_uzunluk=0;
        for(String gecici:secilenler){ //foreach
            dersler+=gecici+"\n";
            obs_uzunluk++; //observable listenin uzunluğunu hesapladım.
        }
        if(obs_uzunluk>0){
            vt_ekle.setVisible(true);
        }
        ders_area.setText(dersler);
    }

    @FXML
    void vt_ekle(ActionEvent event) throws SQLException{


        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/devlet_egitim?serverTimezone=UTC", "root", "");
        Statement statement = connection.createStatement(); //sql sorguları yapmak için statement oluşturulur.


            for (int i = 0; i < obs_uzunluk; i++) {
                statement.execute("INSERT INTO devlet_egitim.alinan_ders(ogrenci_kod, ders_adi) VALUES ('" + Integer.valueOf(Controller.kod_vt) + "','" + secilenler.get(i) + "')");
                guncel_uyari.setText("Dersleriniz ders programınıza eklenmiştir");
            }


    }



}
