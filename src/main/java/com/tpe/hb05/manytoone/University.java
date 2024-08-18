package com.tpe.hb05.manytoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class University {
    @Id
    private int uni_id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne
    private Student05 student05;

    public University() {
    }

    public University(int uni_id, String name) {
        this.uni_id = uni_id;
        this.name = name;
    }

    public int getUni_id() {
        return uni_id;
    }

    public void setUni_id(int uni_id) {
        this.uni_id = uni_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "University{" +
                "uni_id=" + uni_id +
                ", name='" + name + '\'' +
                '}';
    }
}
