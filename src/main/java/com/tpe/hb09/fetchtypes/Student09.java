package com.tpe.hb09.fetchtypes;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
/*
2.taraf Many ise default olarak Lazy , One ise default olarak EAGER yapar :

OneToMany       --> LAZY
ManyToMany      --> LAZY
OneToOne        --> EAGER
ManyToOne       --> EAGER
*/
@Entity
public class Student09 {

    @Id
    private int id;

    @Column(name="student_name",nullable = false)
    private String name;

    private int grade;

    @OneToMany(mappedBy = "student",fetch = FetchType.EAGER)//ilişki karşı taraftan takip edilsin
    private List<Book09> bookList=new ArrayList<>();

    public Student09() {
    }

    public Student09(int id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public List<Book09> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book09> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Student09{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}