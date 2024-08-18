package com.tpe.hb03.uni_onetoone;

import com.tpe.hb02.embeddable.Student02;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave03 {
    public static void main(String[] args) {

        Student03 student1=new Student03(1001,"Ali",70);
        Student03 student2=new Student03(1002,"Veli",80);
        Student03 student3=new Student03(1003,"Ayşe",90);

        Diary diary1=new Diary();
        diary1.setId(11);
        diary1.setName("X");

        Diary diary2=new Diary();
        diary2.setId(12);
        diary2.setName("Y");

        Diary diary3=new Diary();
        diary3.setId(13);
        diary3.setName("Z");


        diary1.setStudent(student1);
        diary2.setStudent(student3);
        diary3.setStudent(student2);
        //diary ile studentları ilişkilendirdik
        //yani FK sütununa studentların id leri eklendi. DİKKAT:tekrarsız



        Configuration config=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student03.class).addAnnotatedClass(Diary.class);

        SessionFactory sessionFactory =config.buildSessionFactory();

        Session session =sessionFactory.openSession();

        Transaction tx =session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(diary1);
        session.save(diary2);
        session.save(diary3);


        tx.commit();
        session.close();
        sessionFactory.close();
    }
}