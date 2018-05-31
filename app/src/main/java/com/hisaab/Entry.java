package com.hisaab;

import android.widget.Button;

/**
 * Created by Lalit dhankher on 5/31/2018.
 */

public class Entry {

    private String paidVia;
    private Double amount;
    private Boolean m;
    private Boolean p;
    private Boolean l;
    private Boolean s;

    private String random;

    public Entry(String paidVia, Double amount, Boolean m, Boolean p, Boolean l, Boolean s) {
        this.paidVia = paidVia;
        this.amount=amount;
        this.m=m;
        this.p=p;
        this.l=l;
        this.s=s;
    }

    public String getPaidVia() {

        return paidVia;
    }

    public void setPaidVia(String paidVia) {
        this.paidVia = paidVia;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Boolean getM() {
        return m;
    }

    public void setM(Boolean m) {
        this.m = m;
    }

    public Boolean getP() {
        return p;
    }

    public void setP(Boolean p) {
        this.p = p;
    }

    public Boolean getL() {
        return l;
    }

    public void setL(Boolean l) {
        this.l = l;
    }

    public Boolean getS() {
        return s;
    }

    public void setS(Boolean s) {
        this.s = s;
    }


}
