package com.csv.bean;

public class Rk {

    private String sname;
    private Long sno;
    private String school;


    public Rk() {
    }

    public Rk(String sname, Long sno, String school) {
        this.sname = sname;
        this.sno = sno;
        this.school = school;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Long getSno() {
        return sno;
    }

    public void setSno(Long sno) {
        this.sno = sno;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Rk{" +
                "sname='" + sname + '\'' +
                ", sno=" + sno +
                ", school='" + school + '\'' +
                '}';
    }
}
