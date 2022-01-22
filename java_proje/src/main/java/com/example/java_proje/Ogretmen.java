package com.example.java_proje;

public class Ogretmen extends Personel{

    private String brans;

    public Ogretmen(int no, String TC, String isim, int okul_kod) {
        super(no, TC, isim, okul_kod);
    }

    public Ogretmen(int no, String TC, String isim) {
        super(no, TC, isim);
    }


}