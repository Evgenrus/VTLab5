package com.Labs.VTLab5.models;

import javax.persistence.*;

@Entity
@javax.persistence.Table(name="Tables")
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="uid")
    private Long id;

    @Column(name="name")
    private String studentName;

    @Column(name="vtmark")
    private int vtMark;

    @Column(name="tvimsmark")
    private int tvimsMark;

    @Column(name="ecomark")
    private int econMark;

    @Column(name="oopmark")
    private int oopMark;

    /*-------------------constructors-------------------*/

    public Table(String studentName, int vtMark, int tvimsMark, int econMark, int oopMark) {
        this.studentName = studentName;
        this.vtMark = vtMark;
        this.tvimsMark = tvimsMark;
        this.econMark = econMark;
        this.oopMark = oopMark;
    }

    public Table() {
    }

    /*---------------end-of-constructors------------------*/

    /*---------------getters and setters-------------------*/
    public void setMarks(int vtMark, int tvimsMark, int econMark, int oopMark) {
        this.vtMark = vtMark;
        this.tvimsMark = tvimsMark;
        this.econMark = econMark;
        this.oopMark = oopMark;
    }

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
    /*-------------end of getters and setters--------------*/

}
