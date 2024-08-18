package com.tpe.hb07.bi_onetomany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book07 {//MANY--ilişkinin sahibi

    @Id
    private int id;//101

    private String name;

    @ManyToOne//FK burada olsun isteriz
    //@JoinColumn-->OPSİYONEL
    private Student07 student;//ONE--1001

    //const
    public Book07() {
    }

    public Book07(int id, String name, Student07 student) {
        this.id = id;
        this.name = name;
        this.student = student;
    }
    //getter-setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student07 getStudent() {
        return student;
    }

    public void setStudent(Student07 student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Book07{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}