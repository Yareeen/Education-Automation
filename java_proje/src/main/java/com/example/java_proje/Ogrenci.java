package com.example.java_proje;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Ogrenci extends Kisi{

    private static int sinif_mevcudu;
    private boolean disiplin_cezasi;

    public Ogrenci(int no, String TC, String isim, int okul_kod) {
        super(no, TC, isim, okul_kod);
    }

    public Ogrenci(int no, String TC, String isim) {
        super(no, TC, isim);
    }


    public static int getSinif_mevcudu() {
        return sinif_mevcudu;
    }

    public static void setSinif_mevcudu(int sinif_mevcudu) {
        Ogrenci.sinif_mevcudu = sinif_mevcudu;
    }

    public boolean isDisiplin_cezasi() {
        return disiplin_cezasi;
    }

    public void setDisiplin_cezasi(boolean disiplin_cezasi) {
        this.disiplin_cezasi = disiplin_cezasi;
    }



}
