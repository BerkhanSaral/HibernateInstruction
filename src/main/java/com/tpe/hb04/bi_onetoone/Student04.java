package com.tpe.hb04.bi_onetoone;

import javax.persistence.*;

@Entity
@Table(name = "t_student04")
public class Student04 {//ONE
    @Id
    private int id;

    @Column(name = "std_name")
    private String name;

    private int grade;

    @OneToOne(mappedBy = "student")//bu ilişki zaten diary04 tarafında kuruldu
    //diary04 classındaki studentın değerine göre eşleştirme yapar
    //student tablosuna fazladan FK eklemez!!!
    //mappedBy kullanilmazsa her ik tabloda FK eklenir
    private Diary04 diary;//öğrencinin günlüğü hangisi?//ONE

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

    public Diary04 getDiary() {
        return diary;
    }

    public void setDiary(Diary04 diary) {
        this.diary = diary;
    }

    @Override
    public String toString() {
        return "Student04{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
