package com.darling.pojo;

public class Kind {
    private String kname;
    private String kid;
    private String knote;

    public Kind(){

    }

    public Kind(String kname, String kid) {
        this.kname = kname;
        this.kid = kid;
    }

    public Kind(String kname, String kid, String knote) {
        this.kname = kname;
        this.kid = kid;
        this.knote = knote;
    }

    public String getKname() {
        return kname;
    }

    public void setKname(String kname) {
        this.kname = kname;
    }

    public String getKid() {
        return kid;
    }

    public void setKid(String kid) {
        this.kid = kid;
    }

    public String getKnote() {
        return knote;
    }

    public void setKnote(String knote) {
        this.knote = knote;
    }

    @Override
    public String toString() {
        return "Kind{" +
                "kname='" + kname + '\'' +
                ", kid='" + kid + '\'' +
                ", knote='" + knote + '\'' +
                '}';
    }
}
