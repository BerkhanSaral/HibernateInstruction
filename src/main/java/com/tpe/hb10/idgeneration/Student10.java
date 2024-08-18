package com.tpe.hb10.idgeneration;

import javax.persistence.*;
/*
IDENTITY:1 den başlar 1er artırarak id leri generate eder.
TABLE:id üretmek için tablo oluşturur,EN YAVAŞ, bu sebeple pek tercih edilmez
SEQUENCE:id set oluşturur,başlangıç değeri verebiliriz,HIZLIDIR
AUTO:Kullanılan DB ye göre stratejiyi belirler
       Oracle DB - PostgreSQL ---> Sequence ( kontrolü developera bırakır, Id üretilirken
            başlangıç değeri veya kaç tane id cachelenecek bu gibi bilgileri developer setliyebilir)
       MySQL - Microsoft SQL   ---> IDENTITY ( kontrol DB de , kendi yapısına göre ıd oluşturur,
            içlerindeki en basitidir)
 */
@Entity
public class Student10 {

    @Id
    @GeneratedValue(generator = "sequence",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequence",//@GeneratedValuedaki generator ile aynı
            sequenceName = "idsequence",//DB de oluşan sequenceın ismi, default:hibernate_sequence
            initialValue = 1000,//id için başlangıç değeri, default:1
            allocationSize = 10 )//id setinde kaç adet id olacak, default:50

    private int id;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;

    @Column(name="student_name",nullable = false)
    private String name;

    private int grade;

    //getter-setter


    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

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
}