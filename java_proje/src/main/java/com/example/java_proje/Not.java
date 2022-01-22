package com.example.java_proje;

public class Not{
    private int ogrenci_kod;
    private int ogretmen_kod;
    private String ders_adi;
    private int not1=0;
    private int not2;

    public Not(int ogrenci_kod, int ogretmen_kod, String ders_adi, int not1, int not2) {
        this.ogrenci_kod = ogrenci_kod;
        this.ogretmen_kod = ogretmen_kod;
        this.ders_adi = ders_adi;
        this.not1 = not1;
        this.not2 = not2;
    }

    public Not(String ders_adi, int not1) {
        this.ders_adi = ders_adi;
        this.not1 = not1;
    }


    public int getOgrenci_kod() {
        return ogrenci_kod;
    }

    public void setOgrenci_kod(int ogrenci_kod) {
        this.ogrenci_kod = ogrenci_kod;
    }

    public int getOgretmen_kod() {
        return ogretmen_kod;
    }

    public void setOgretmen_kod(int ogretmen_kod) {
        this.ogretmen_kod = ogretmen_kod;
    }

    public String getDers_adi() {
        return ders_adi;
    }

    public void setDers_adi(String ders_adi) {
        this.ders_adi = ders_adi;
    }

    public int getNot1() {
        return not1;
    }

    public void setNot1(int not1) {
        this.not1 = not1;
    }

    public int getNot2() {
        return not2;
    }

    public void setNot2(int not2) {
        this.not2 = not2;
    }
}
