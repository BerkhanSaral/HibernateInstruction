package com.tpe.hb05.manytoone;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity//bir classi entity olarak isaretledigimizde artik hibernate tarafindan takip edilir
@Table(name = "t_student05")
public class Student05 {//MANY

    @Id
    private int id;//11

    private String name;

    private int grade;

    private LocalDateTime createOn;

    @ManyToOne//Student05 ile University arasında M-1 ilişkiyi kurar.
    //t_student05 e FK ekleyerek ilişkiyi kurar:university_id
    private University university;//ONE

    @PrePersist//db ye kaydetmeden hemen once bu methodu cagirir
    public void prePersist() {
        this.createOn = LocalDateTime.now();

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

    public LocalDateTime getCreateOn() {
        return createOn;
    }

//    public void setCreateOn(LocalDateTime createOn) {
//        this.createOn = createOn;
//    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "Student05{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", createOn=" + createOn +
                ", university=" + university +
                '}';
    }
}