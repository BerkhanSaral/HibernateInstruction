package com.tpe.hb06.onetomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_student06")
public class Student06 {

    @Id
    private int id;

    @Column(name = "student_name", nullable = false)
    private String name;

    private int grade;



    public Student06(){}

    public Student06(int id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    @OneToMany //tablolar arasinda iliskinin kurulmasini saglar:iliski tablosu olusturur
    @JoinColumn(name = "student_id") //join table iptal, book tablosuna FK sutunu ekler
    //join column kullanilmazsa join table olusturulur
    List<Book> bookList = new ArrayList<>();//many


    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student06{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", bookList=" + bookList +
                '}';
    }
}
