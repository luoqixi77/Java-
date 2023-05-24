package com.tiyamati.pojo;

import java.util.List;

public class stuClass {
    private Integer sid;
    private String sname;
    private List<student> students;

    public stuClass() {
    }

    public stuClass(Integer sid, String sname, List<student> students) {
        this.sid = sid;
        this.sname = sname;
        this.students = students;
    }

    public stuClass(Integer sid, String sname) {
        this.sid = sid;
        this.sname = sname;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public List<student> getStudents() {
        return students;
    }

    public void setStudents(List<student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "stuClass{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", students=" + students +
                '}';
    }

}
