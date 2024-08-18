package com.tpe.hb03.uni_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch03 {
    public static void main(String[] args) {

        Configuration config=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student03.class).addAnnotatedClass(Diary.class);

        SessionFactory sessionFactory =config.buildSessionFactory();

        Session session =sessionFactory.openSession();

        Transaction tx =session.beginTransaction();

        //PROBLEM: sorgu yazmadan diaryden studenta , studentdan diarye ulaşmak istersem?

        //uni_directional relation : Diary --> Student03
        //bi_directional relation : Diary04 <--> Student04

        //id:1001 olan studentı fetch edelim
        Student03 student=session.get(Student03.class,1001);

        //id:11 olan diary i fetch edelim
        Diary diary=session.get(Diary.class,11);

        System.out.println("**************************");
        System.out.println(student);
        System.out.println("**************************");
        System.out.println(diary);
        //günlük kimin?
        System.out.println(diary.getStudent());

        //id:1002 olan öğrencinin günlüğü hangisi?
        Student03 student2=session.get(Student03.class,1002);
        //student2.getDiary()
        session.createSQLQuery("SELECT name FROM diary WHERE std_id=1002").uniqueResult();


        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
