package com.java.pojo;

public class Account {
    private int cno;
    private String cname;
    private String ccredit;

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCcredit() {
        return ccredit;
    }

    public void setCcredit(String ccredit) {
        this.ccredit = ccredit;
    }

    @Override
    public String toString() {
        return "Account{" +
                "cno=" + cno +
                ", cname='" + cname + '\'' +
                ", ccredit='" + ccredit + '\'' +
                '}';
    }
}
