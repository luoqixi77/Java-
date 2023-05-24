package com.tiyamati.pojo;

import java.util.Arrays;

public class student implements Person{
    private Integer sid;
    private String sname;
    private Integer age;
    private String gender;
    private Double sorce;
    private String[] hobby;
    private stuClass stuClass;

    public student() {
    }


//    public student(Integer sid, String sname,String gender ,Integer age ) {
//        this.sid = sid;
//        this.sname = sname;
//        this.gender = gender;
//        this.age = age;
//    }
//
//    public student(Integer sid, String sname,  String gender,Double sorce) {
//        this.sid = sid;
//        this.sname = sname;
//        this.gender = gender;
//        this.sorce=sorce;
//    }

    public student(Integer sid, String sname, Integer age, String gender, Double sorce, String[] hobby, com.tiyamati.pojo.stuClass stuClass) {
        this.sid = sid;
        this.sname = sname;
        this.age = age;
        this.gender = gender;
        this.sorce = sorce;
        this.hobby = hobby;
        this.stuClass = stuClass;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getSorce() {
        return sorce;
    }

    public void setSorce(Double sorce) {
        this.sorce = sorce;
    }


    public com.tiyamati.pojo.stuClass getStuClass() {
        return stuClass;
    }

    public void setStuClass(com.tiyamati.pojo.stuClass stuClass) {
        this.stuClass = stuClass;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", sorce=" + sorce +
                ", hobby=" + Arrays.toString(hobby) +
                ", stuClass=" + stuClass +
                '}';
    }

}

