package com.common;


import org.springframework.stereotype.Component;

@Component
public class pojo {
    private String sname;
    private Long sno;
    private String school;
    private String schoolname;

    public pojo() {
    }

    public pojo(String sname, Long sno) {
        this.sname = sname;
        this.sno = sno;
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

    @Override
    public String toString() {
        return "pojo{" +
                "sname='" + sname + '\'' +
                ", sno=" + sno +
                '}';
    }
}
