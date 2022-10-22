package com.example.grandhotel;



public class Oder {

    private String noNasigorang;
    private String Nobiriyani;
    private String noFriedrice;
    private String NoStringhop;
    private String noRedRice;
    private String noKotthu;
    private String NoNoodless;
    private String Date;
    private String Email;


    public Oder() {
    }

    public Oder(String noNasigorang, String nobiriyani, String noFriedrice, String noStringhop, String noRedRice, String noKotthu, String noNoodless, String date, String email) {
        this.noNasigorang = noNasigorang;
        Nobiriyani = nobiriyani;
        this.noFriedrice = noFriedrice;
        NoStringhop = noStringhop;
        this.noRedRice = noRedRice;
        this.noKotthu = noKotthu;
        NoNoodless = noNoodless;
        Date = date;
        Email = email;
    }

    public String getNoNasigorang() {
        return noNasigorang;
    }

    public String getNobiriyani() {
        return Nobiriyani;
    }

    public String getNoFriedrice() {
        return noFriedrice;
    }

    public String getNoStringhop() {
        return NoStringhop;
    }

    public String getNoRedRice() {
        return noRedRice;
    }

    public String getNoKotthu() {
        return noKotthu;
    }

    public String getNoNoodless() {
        return NoNoodless;
    }

    public String getDate() {
        return Date;
    }

    public String getEmail() {
        return Email;
    }


    public void setNoNasigorang(String noNasigorang) {
        this.noNasigorang = noNasigorang;
    }

    public void setNobiriyani(String nobiriyani) {
        Nobiriyani = nobiriyani;
    }

    public void setNoFriedrice(String noFriedrice) {
        this.noFriedrice = noFriedrice;
    }

    public void setNoStringhop(String noStringhop) {
        NoStringhop = noStringhop;
    }

    public void setNoRedRice(String noRedRice) {
        this.noRedRice = noRedRice;
    }

    public void setNoKotthu(String noKotthu) {
        this.noKotthu = noKotthu;
    }

    public void setNoNoodless(String noNoodless) {
        NoNoodless = noNoodless;
    }

    public void setDate(String date) {
        Date = date;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
