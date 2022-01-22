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

public class Devamsiz_controller extends Ekran_degis{

    @FXML
    private TableView<Devamsiz> table;


    @FXML
    private TableColumn<Devamsiz, String> col_devamsizlik;



    @FXML
    private Button menu;


    ObservableList<Devamsiz> obslist = FXCollections.observableArrayList();

    public void initialize() throws SQLException{

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/devlet_egitim?serverTimezone=UTC", "root", "");
        Statement statement = connection.createStatement(); //sql sorguları yapmak için statement oluşturulur.
        ResultSet resultset;
        resultset = statement.executeQuery("Select * from devlet_egitim.devamsizlik where devamsizlik.ogrenci_kod ="+Integer.valueOf(Controller.kod_vt));

        while (resultset.next()) {


           obslist.add(new Devamsiz((resultset.getString("tarih"))));
        }

        col_devamsizlik.setCellValueFactory(new PropertyValueFactory<>("tarih"));


        table.setItems(obslist);

    }


    @FXML
    void menuDonButton(ActionEvent event) throws IOException {
        degis(menu,Controller.dosya_fxml);
    }


}
