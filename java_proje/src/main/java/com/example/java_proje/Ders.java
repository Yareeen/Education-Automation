package com.example.java_proje;

public class Ders {
    //private Ders secilenDersler;
    private int kod;
    private String ders_adi;
    private int kac_saat;
    private String gunu;


    public Ders(int kod, String ders_adi, int kac_saat, String gunu) {
        this.kod = kod;
        this.ders_adi = ders_adi;
        this.kac_saat = kac_saat;
        this.gunu = gunu;
    }


    public Ders(int kod) {
        this.kod = kod;
    }

    public int getKod() {
        return kod;
    }

    public void setKod(int kod) {
        this.kod = kod;
    }

    public String getDers_adi() {
        return ders_adi;
    }

    public void setDers_adi(String ders_adi) {
        this.ders_adi = ders_adi;
    }

    public int getKac_saat() {
        return kac_saat;
    }

    public void setKac_saat(int kac_saat) {
        this.kac_saat = kac_saat;
    }

    public String getGunu() {
        return gunu;
    }

    public void setGunu(String gunu) {
        this.gunu = gunu;
    }
}
