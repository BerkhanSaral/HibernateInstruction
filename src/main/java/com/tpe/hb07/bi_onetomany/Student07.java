package com.tpe.hb07.bi_onetomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student07 {//ONE--PARENT

    @Id
    private int id;

    @Column(name="student_name", nullable = false)
    private String name;

    private int grade;

    @OneToMany(mappedBy = "student",/*cascade = CascadeType.REMOVE,*/orphanRemoval = true)
    //orphanRemoval = true/cascadeType.REMOVE:
    // parent tablodan(student) satır silmek istediğimizde önce ilişkili olduğu
    //satırları(bookList) diğer tablodan(book) siler, ardından parenttan silme işlemi yapar.
    //yani aşamalı(kademeli) silme işlemini otomatik yapar.

    /*
    orphanRemoval:sadece OneToMany anotasyonunda vardır.
    studentin kitap listesinden bir kitabı silersek veya null yaparsak
    Book tablosundan bu kitabı siler.
     */
    private List<Book07> bookList=new ArrayList<>();//MANY-CHILD

    //const
    public Student07() {
    }

    public Student07(int id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public List<Book07> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book07> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Student07{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", bookList=" + bookList +
                '}';
    }
}
