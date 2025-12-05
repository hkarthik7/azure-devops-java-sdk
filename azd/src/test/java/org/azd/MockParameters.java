package org.azd;

import org.azd.abstractions.serializer.SerializableEntity;

public class MockParameters extends SerializableEntity {
    private String o;
    private String t;
    private String p;
    private String ti;
    private String c;
    private String cs;

    public String getTI() {
        return ti;
    }

    public void setTI(String ti) {
        this.ti = ti;
    }


    public String getO() {
        return o;
    }

    public void setO(String o) {
        this.o = o;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getCs() {
        return cs;
    }

    public void setCs(String cs) {
        this.cs = cs;
    }
}
