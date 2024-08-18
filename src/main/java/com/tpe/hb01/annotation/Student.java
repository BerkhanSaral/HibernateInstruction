package com.tpe.hb01.annotation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//artik pojo class degil entity class oldu
//hedef:
//dataları persist etmek için bu classa karşılık bir tablo gerekli
//tablonun sütunları:id,name,grade
//create table student(id int, name varchar...)
//hibernate(ORM) bizim için bu hedefi otomatik olarak yapar.

@Entity//bu sinifin DB de bir tabloya karsilik gelmesini sagliyoruz, tablonun adı: student
@Table(name = "t_student")//tablonun ismini kendimiz verebiliriz.OPSİYONEL
//!!! Javaca konuşurken bu sınıfı belirtirken Student,
//SQLce konuşurken t_student kullanırız.
public class Student {

    @Id//id sütununa PK kısıtlamasını ekler
    //@Column(name = "std_id")
    private int id;

    @Column(name = "student_name", length = 50, nullable = false, unique = false)//opsiyonel
    private String name;//varchar(50)//default size:255

    private int grade;

//    @Transient//DB de tabloda bu fielda karşılık bir sütun oluşmasını engeller.
//    private int midterm;
//
//    @Lob//Large Object: bu sütunda büyük boyutlu datalar saklanır:resim,video,ses...
//    private byte[] image;

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

    //toString

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}