package com.example.java_proje;

import java.util.Date;

public class Devamsiz {
    private int ogrenci_kod;
    private String tarih;


    public Devamsiz(int ogrenci_kod, String tarih) {
        this.ogrenci_kod = ogrenci_kod;
        this.tarih = tarih;
    }

    public Devamsiz(String tarih) {
        this.tarih = tarih;
    }

    public int getOgrenci_kod() {
        return ogrenci_kod;
    }

    public void setOgrenci_kod(int ogrenci_kod) {
        this.ogrenci_kod = ogrenci_kod;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }
}
