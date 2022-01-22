package com.example.java_proje;


public class Personel extends Kisi{

    private String [] sertifika = new String[100];
    private String mezun_oldugu_okul;
    private double maas;

    public Personel(int no, String TC, String isim, int okul_kod) {
        super(no, TC, isim, okul_kod);
    }

    public Personel(int no, String TC, String isim) {
        super(no, TC, isim);
    }
}



