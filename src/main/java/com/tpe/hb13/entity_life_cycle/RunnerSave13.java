package com.tpe.hb13.entity_life_cycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave13 {
    public static void main(String[] args) {

        Student13 student1 = new Student13("Jack", 99);//-->transient
        Student13 student2 = new Student13("Harry", 99);//-->transient


        Configuration config = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student13.class);

        SessionFactory sessionFactory = config.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();

//        session.save(student1);//-->persisted/managed
//        student1.setName("Sherlock");
//
//        session.evict(student1);//objeyi detach eder.
//
//        student1.setGrade(700);
//
//        session.update(student1);//detach edilen objeyi yeniden persisted durumuna getirir
//        student1.setName("Mehmet");
//
//         //1,700,Mehmet

        //--------------------------------------------------------
        session.save(student2);//perisisted
        student2.setGrade(88);


        tx.commit();
        session.close();

        //    student1.setName("Ahmet");//detached
        //hala DB de bir satıra karşılık gelir.

        //DB: 1,700,Mehmet
        //student1:1,700,Ahmet-->Java

        //-----------------------------------------
        student2.setName("Ali");//detached
        System.out.println(student2.getName());//Java:2,88,Ali
        //DB-->2,88,Harry

        Session session2 = sessionFactory.openSession();
        Transaction transaction2 = session2.beginTransaction();

//        session2.update(student1);//persisted//student1:1,700,Ahmet-->Java
//        student1.setGrade(999);

        //update:DB deki satırı Java objesi ile günceller.

        //1,999,Mehmet

        //------------------------------
        session2.update(student2);//persisted
        //DB->2,88,Ali

        transaction2.commit();
        session2.close();


        sessionFactory.close();

//        1- update methodu persistede çeker
//        2- update methodu javadaki güncellemeleri DB ye aktarır

    }
}
