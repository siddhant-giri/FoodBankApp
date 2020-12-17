package com.example.foodbankapp;

class FormHelperClass {
    String vname, vqty, vnumber, vpickup, vdate, vproduct;

    public FormHelperClass() {

    }

    public FormHelperClass(String vname, String vnumber, String vqty, String vpickup, String vdate, String vproduct) {
        this.vname = vname;
        this.vqty = vqty;
        this.vnumber = vnumber;
        this.vpickup = vpickup;
        this.vdate = vdate;
        this.vproduct = vproduct;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getVqty() {
        return vqty;
    }

    public void setVqty(String vqty) {
        this.vqty = vqty;
    }

    public String getVnumber() {
        return vnumber;
    }

    public void setVnumber(String vnumber) {
        this.vnumber = vnumber;
    }

    public String getVpickup() {
        return vpickup;
    }

    public void setVpickup(String vpickup) {
        this.vpickup = vpickup;
    }

    public String getVdate() {
        return vdate;
    }

    public void setVdate(String vdate) {
        this.vdate = vdate;
    }

    public String getVproduct() {
        return vproduct;
    }

    public void setVproduct(String vproduct) {
        this.vproduct = vproduct;
    }
}
