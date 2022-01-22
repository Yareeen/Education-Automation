package com.example.java_proje;

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

public class Ogrenci_goruntule_controller extends Ekran_degis{

    @FXML
    private TableView<Ogrenci> table;


    @FXML
    private TableColumn<Ogrenci, String> col_isim;

    @FXML
    private TableColumn<Ogrenci, Integer> col_no;

    @FXML
    private TableColumn<Ogrenci, String> col_tc;


    @FXML
    private Button menu;


    ObservableList<Ogrenci> obslist = FXCollections.observableArrayList();

    public void initialize() throws SQLException{

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/devlet_egitim?serverTimezone=UTC", "root", "");
        Statement statement = connection.createStatement(); //sql sorguları yapmak için statement oluşturulur.
        ResultSet resultset;
        resultset = statement.executeQuery("Select * from devlet_egitim.ogrenci");

        while (resultset.next()) {


           obslist.add(new Ogrenci(Integer.parseInt(resultset.getString("no")),resultset.getString("TC"),resultset.getString("isim")));
        }

        col_no.setCellValueFactory(new PropertyValueFactory<>("no"));
        col_tc.setCellValueFactory(new PropertyValueFactory<>("TC"));
        col_isim.setCellValueFactory(new PropertyValueFactory<>("isim"));

        table.setItems(obslist);

    }


    @FXML
    void menuDonButton(ActionEvent event) throws IOException {
        degis(menu,Controller.dosya_fxml);
    }


}
