package com.tpe.hb09.fetchtypes;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Book09 {//MANY:ilişki sahibi

    @Id
    private int id;

    private String name;

    //bir kitabı DB ye kaydettiğimde bu kitabın sahibi olan öğrenciyi de otomatik olarak kaydeder
    @ManyToOne(cascade = CascadeType.ALL)
    private Student09 student;//ONE

    public Book09() {
    }

    public Book09(int id, String name) {
        this.id = id;
        this.name = name;
    }

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

    public Student09 getStudent() {
        return student;
    }

    public void setStudent(Student09 student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Book09{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}