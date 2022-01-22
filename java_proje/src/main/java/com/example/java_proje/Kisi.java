package com.example.java_proje;

public class Kisi {

    private int no;
    private String TC;
    private String isim;
    private String sifre;
    private int okul_kod;


    public Kisi(int no, String TC, String isim, int okul_kod) {
        this.no = no;
        this.TC = TC;
        this.isim = isim;
        this.okul_kod = okul_kod;
    }


    public Kisi(int no, String TC, String isim) {
        this.no = no;
        this.TC = TC;
        this.isim = isim;
    }




    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getTC() {
        return TC;
    }

    public void setTC(String TC) {
        this.TC = TC;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public int getOkul_kod() {
        return okul_kod;
    }

    public void setOkul_kod(int okul_kod) {
        this.okul_kod = okul_kod;
    }



    @Override
    public String toString(){

        return this.TC;

    }

}