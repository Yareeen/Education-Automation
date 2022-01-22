package com.example.java_proje;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.*;

public class Kisiler_Controller extends Ekran_degis {
    @FXML
    private Button guncelle;

    /*güncelle ekranı*/
    @FXML
    private Button guncelle_vt;


    @FXML
    private TextField guncel_No;

    @FXML
    private Button devamsiz_ekle;

    @FXML
    private TextField guncel_Tc;

    @FXML
    private TextField guncel_isim;

    @FXML
    private PasswordField guncel_sifre;

    @FXML
    private TextField okul_kod_fx;

    @FXML
    private Label guncel_uyari;


    @FXML
    private Button menu;

    @FXML
    private Button cikis;

   /* @FXML
    private Button Bilgileri_goruntuleme;*/

    @FXML
    private Label isim_fx;

    @FXML
    private Label numara_fx;

    @FXML
    private Label sifre_fx;

    @FXML
    private Label tc_fx;


    public static String tablo_ismi;

    @FXML
    private Label label_tc;
    @FXML
    private Label label_okul;

    @FXML
    private Label label_sifre;

    @FXML
    private Label label_isim;

    @FXML
    private Label label_numara;

    @FXML
    private Label okul_fx;

    @FXML
    private Button ogrci_ekle_vt;

    @FXML
    private Button ogret_ekle;

    @FXML
    private Button ogr_ekle;

    @FXML
    private DatePicker tarih;

    public static String basilan_ekle;

    @FXML
    private TextField ogr_kod;

    @FXML
    private Button ders_sec;

    @FXML
    private Button Ders_prog_ac;

    @FXML
    private TextField ogr_not;


    @FXML
    private Button not_g_ac;

    @FXML
    void bilgilerimiGuncelle(ActionEvent event) throws IOException {
        degis(guncelle, "guncelle.fxml");
    }


    @FXML
    void guncelle_vt_Button(ActionEvent event) throws IOException, SQLException {


        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/devlet_egitim?serverTimezone=UTC", "root", "");
        Statement statement = connection.createStatement(); //sql sorguları yapmak için statement oluşturulur.

        int ınt_TC = Integer.valueOf(guncel_Tc.getText());


        if (Controller.value.equals("Öğrenci")) {
            statement.execute("UPDATE devlet_egitim.ogrenci set no='" + guncel_No.getText() + "',TC='" + ınt_TC + "', sifre='" + guncel_sifre.getText() + "', isim='" + guncel_isim.getText() + "' where no=" + Controller.noin);
        } else if (Controller.value.equals("Öğretmen")) {
            statement.execute("UPDATE devlet_egitim.ogretmen set no='" + guncel_No.getText() + "',TC='" + ınt_TC + "', sifre='" + guncel_sifre.getText() + "', isim='" + guncel_isim.getText() + "' where no=" + Controller.noin);
        } else if (Controller.value.equals("İdari Personel")) {
            statement.execute("UPDATE devlet_egitim.idari_personel set no='" + guncel_No.getText() + "',TC='" + ınt_TC + "', sifre='" + guncel_sifre.getText() + "', isim='" + guncel_isim.getText() + "' where no=" + Controller.noin);
        }


        statement.cancel();
        connection.createStatement();
        guncel_uyari.setText("Güncellendi");

    }

    @FXML
    void menuDonButton(ActionEvent event) throws IOException, SQLException {
        degis(menu, Controller.dosya_fxml);

    }

    @FXML
    void cikisButton(ActionEvent event) throws IOException {
        degis(cikis, "login.fxml");
    }


    @FXML
    void Bilgi_goruntule_button(ActionEvent event) throws IOException, SQLException {


        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/devlet_egitim?serverTimezone=UTC", "root", "");
        Statement statement = connection.createStatement(); //sql sorguları yapmak için statement oluşturulur.
        ResultSet resultSet = null;

        if (Controller.value.equals("Öğrenci")) {
            resultSet = statement.executeQuery("SELECT * from devlet_egitim.okul INNER JOIN devlet_egitim.ogrenci ON ogrenci.okul_kod=okul.kod and no=" + Integer.valueOf(Controller.noin));
            tablo_ismi = "ogrenci";
        } else if (Controller.value.equals("Öğretmen")) {
            resultSet = statement.executeQuery("SELECT * from devlet_egitim.okul INNER JOIN devlet_egitim.ogretmen ON ogretmen.okul_kod=okul.kod and no=" + Controller.noin);
            tablo_ismi = "ogretmen";
        } else if (Controller.value.equals("İdari Personel")) {
            resultSet = statement.executeQuery("SELECT okul.kod, okul.isim, idari_personel.* from devlet_egitim.okul INNER JOIN devlet_egitim.idari_personel ON idari_personel.okul_kod=okul.kod and devlet_egitim.idari_personel.no=" + Controller.noin);
            tablo_ismi = "idari_personel";
        }
        resultSet.next();
        label_tc.setVisible(true);
        label_okul.setVisible(true);
        label_numara.setVisible(true);
        label_sifre.setVisible(true);
        label_isim.setVisible(true);


        tc_fx.setText(resultSet.getString(tablo_ismi + ".TC"));
        numara_fx.setText(resultSet.getString(tablo_ismi + ".no"));
        isim_fx.setText(resultSet.getString(tablo_ismi + ".isim"));
        sifre_fx.setText(resultSet.getString(tablo_ismi + ".sifre"));
        okul_fx.setText(resultSet.getString("okul.isim"));

    }


    @FXML
    void ogr_ekle_ac(ActionEvent event) throws IOException, SQLException {
        degis(ogr_ekle, "ogrenci_ekle.fxml");
        basilan_ekle = "Öğrenci";
    }


    @FXML
    void ogretmen_ekle_ac(ActionEvent event) throws IOException, SQLException {
        degis(ogret_ekle, "ogrenci_ekle.fxml");
        basilan_ekle = "Öğretmen";
    }


    @FXML
    void vt_ekle(ActionEvent event) throws IOException, SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/devlet_egitim?serverTimezone=UTC", "root", "");
        Statement statement = connection.createStatement(); //sql sorguları yapmak için statement oluşturulur.

        if (basilan_ekle.equals("Öğrenci")) {
            statement.execute("INSERT INTO devlet_egitim.ogrenci(no, TC, sifre, isim, okul_kod) VALUES ('" + Integer.valueOf(guncel_No.getText()) + "','" + guncel_Tc.getText() + "','" + guncel_sifre.getText() + "','" + guncel_isim.getText() + "','" + Integer.valueOf(okul_kod_fx.getText()) + "')");
        } else if (basilan_ekle.equals("Öğretmen")) {
            statement.execute("INSERT INTO devlet_egitim.ogretmen(no, TC, sifre, isim, okul_kod) VALUES ('" + Integer.valueOf(guncel_No.getText()) + "','" + guncel_Tc.getText() + "','" + guncel_sifre.getText() + "','" + guncel_isim.getText() + "','" + Integer.valueOf(okul_kod_fx.getText()) + "')");
        } else if (basilan_ekle.equals("Devamsizlik")) {
            statement.execute("INSERT INTO devlet_egitim.devamsizlik(ogrenci_kod, tarih) VALUES ('" + Integer.valueOf(ogr_kod.getText()) + "','" + tarih.getValue() + "')");
        }
        guncel_uyari.setText("Eklendi");

    }


    @FXML
    void devamsiz_ekle(ActionEvent event) throws IOException {
        degis(devamsiz_ekle, "devamsizlik_ekle.fxml");
        basilan_ekle = "Devamsizlik";
    }

    @FXML
    void ders_sec_ac(ActionEvent event) throws IOException {
        degis(ders_sec, "ders_sec.fxml");
    }

    @FXML
    void ders_prog_ac_button(ActionEvent event) throws IOException {
        degis(Ders_prog_ac, "ders_programi.fxml");
    }


    @FXML
    private Button not_ekle_ac;

    @FXML
    void not_ekle_ac_button(ActionEvent event) throws IOException {
        degis(not_ekle_ac, "not_ekle.fxml");
    }

    @FXML
    private TextField ders_ad;

    @FXML
    void not_ekle_vt_button(ActionEvent event) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/devlet_egitim?serverTimezone=UTC", "root", "");
        Statement statement = connection.createStatement(); //sql sorguları yapmak için statement oluşturulur.
        statement.execute("UPDATE devlet_egitim.alinan_ders set not1='" + Integer.valueOf(ogr_not.getText()) + "' where alinan_ders.ders_adi='" + ders_ad.getText() + "' and ogrenci_kod=" + Integer.valueOf(ogr_kod.getText()));
        statement.cancel();
        connection.createStatement();
        guncel_uyari.setText("Not eklendi");
    }


    @FXML
    void not_g_ac_button(ActionEvent event) throws IOException{
        degis(not_g_ac, "not_goruntule.fxml");
    }


    @FXML
    private Button devamsizlik_g_ac;
    @FXML
    void devamsiz_g_ac_button(ActionEvent event) throws IOException{
        degis(devamsizlik_g_ac, "Devamsizlik_goruntule.fxml");
    }

    @FXML
    private Button ogr_goruntule;
    @FXML
    void ogr_gr_ac(ActionEvent event) throws IOException{
        degis(ogr_goruntule, "Ogrenci_bilgisi_goruntule.fxml");
    }


}