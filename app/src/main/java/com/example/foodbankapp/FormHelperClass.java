package com.example.foodbankapp;

class FormHelperClass {
    String vname, vqty, vnumber, vpkts, vadd, vpeople, vproduct;

    public FormHelperClass() {

    }

    public FormHelperClass(String vname, String vnumber, String vqty, String vpkts, String vadd, String vpeople, String vproduct) {
        this.vname = vname;
        this.vqty = vqty;
        this.vnumber = vnumber;
        this.vpkts = vpkts;
        this.vadd = vadd;
        this.vpeople = vpeople;
        this.vproduct = vproduct;
    }

    public String getVproduct() {
        return vproduct;
    }

    public void setVproduct(String vproduct) {
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

    public String getVpkts() {
        return vpkts;
    }

    public void setVpkts(String vpkts) {
        this.vpkts = vpkts;
    }

    public String getVadd() {
        return vadd;
    }

    public void setVadd(String vadd) {
        this.vadd = vadd;
    }

    public String getVpeople() {
        return vpeople;
    }

    public void setVpeople(String vpeople) {
        this.vpeople = vpeople;
    }
}
