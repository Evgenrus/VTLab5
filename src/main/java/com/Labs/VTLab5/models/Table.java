package com.Labs.VTLab5.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String studentName;

    private int vtMark, tvimsMark, econMark, oopMark;

    /*----------------------------------------------------
     ---------------getters and setters-------------------
     -----------------------------------------------------*/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getVtMark() {
        return vtMark;
    }

    public void setVtMark(int vtMark) {
        this.vtMark = vtMark;
    }

    public int getTvimsMark() {
        return tvimsMark;
    }

    public void setTvimsMark(int tvimsMark) {
        this.tvimsMark = tvimsMark;
    }

    public int getEconMark() {
        return econMark;
    }

    public void setEconMark(int econMark) {
        this.econMark = econMark;
    }

    public int getOopMark() {
        return oopMark;
    }

    public void setOopMark(int oopMark) {
        this.oopMark = oopMark;
    }
    /*----------------------------------------------------
     -------------end of getters and setters--------------
     -----------------------------------------------------*/


}
