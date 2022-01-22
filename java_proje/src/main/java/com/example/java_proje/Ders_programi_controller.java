package com.example.java_proje;

import com.mysql.cj.protocol.Resultset;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.*;

public class Ders_programi_controller extends Ekran_degis{

    @FXML
    private TableView<Ders> table;
    @FXML
    private TableColumn<Ders, String> col_ders_adi;

    @FXML
    private TableColumn<Ders, Integer> col_kac_saat;

    @FXML
    private TableColumn<Ders, String> col_gunu;

    @FXML
    private TableColumn<Ders, Integer> col_ders_kodu;


    @FXML
    private Button menu;


    ObservableList<Ders> obslist = FXCollections.observableArrayList();

    public void initialize() throws SQLException{

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/devlet_egitim?serverTimezone=UTC", "root", "");
        Statement statement = connection.createStatement(); //sql sorguları yapmak için statement oluşturulur.
        ResultSet resultset = null;
        resultset = statement.executeQuery("Select alinan_ders.ders_adi, alinan_ders.ogrenci_kod, ders.* from devlet_egitim.ders INNER JOIN devlet_egitim.alinan_ders on ders.ders_adi like alinan_ders.ders_adi and  alinan_ders.ogrenci_kod ="+Controller.kod_vt);

        while (resultset.next()) {

           obslist.add(new Ders(Integer.valueOf(resultset.getString("kod")),resultset.getString("ders_adi"),
                   Integer.valueOf(resultset.getString("kac_saat")),resultset.getString("gunu")));
        }
        col_ders_kodu.setCellValueFactory(new PropertyValueFactory<>("kod"));
        col_ders_adi.setCellValueFactory(new PropertyValueFactory<>("ders_adi"));
        col_kac_saat.setCellValueFactory(new PropertyValueFactory<>("kac_saat"));
        col_gunu.setCellValueFactory(new PropertyValueFactory<>("gunu"));


        table.setItems(obslist);

    }


    @FXML
    void menuDonButton(ActionEvent event) throws IOException {
        degis(menu,Controller.dosya_fxml);
    }


}
