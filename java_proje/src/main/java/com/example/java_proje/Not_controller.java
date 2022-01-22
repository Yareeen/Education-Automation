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

public class Not_controller extends Ekran_degis{

    @FXML
    private TableView<Not> table;
    @FXML
    private TableColumn<Not, String> col_ders_adi;

    @FXML
    private TableColumn<Not, Integer> col_not;



    @FXML
    private Button menu;


    ObservableList<Not> obslist = FXCollections.observableArrayList();

    public void initialize() throws SQLException{

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/devlet_egitim?serverTimezone=UTC", "root", "");
        Statement statement = connection.createStatement(); //sql sorguları yapmak için statement oluşturulur.
        ResultSet resultset;
        resultset = statement.executeQuery("Select alinan_ders.ogrenci_kod,alinan_ders.ders_adi, alinan_ders.not1 from devlet_egitim.alinan_ders where alinan_ders.ogrenci_kod ="+Integer.valueOf(Controller.kod_vt));

        while (resultset.next()) {

           obslist.add(new Not((resultset.getString("ders_adi")),
                   Integer.parseInt(resultset.getString("not1"))));
        }

        col_ders_adi.setCellValueFactory(new PropertyValueFactory<>("ders_adi"));
        col_not.setCellValueFactory(new PropertyValueFactory<>("not1"));

        table.setItems(obslist);

    }


    @FXML
    void menuDonButton(ActionEvent event) throws IOException {
        degis(menu,Controller.dosya_fxml);
    }


}
