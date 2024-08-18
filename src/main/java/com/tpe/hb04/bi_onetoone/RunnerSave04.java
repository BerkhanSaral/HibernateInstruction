package com.tpe.hb04.bi_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave04 {
    public static void main(String[] args) {

        Student04 student1=new Student04();
        student1.setId(1001);
        student1.setName("Jack");
        student1.setGrade(100);

        Student04 student2=new Student04();
        student2.setId(1002);
        student2.setName("Harry");
        student2.setGrade(90);

        Student04 student3=new Student04();
        student3.setId(1003);
        student3.setName("Fred");
        student3.setGrade(95);

        Diary04 diary1=new Diary04();
        diary1.setId(11);
        diary1.setName("Harry's Diary");

        Diary04 diary2=new Diary04();
        diary2.setId(12);
        diary2.setName("Jack's Diary");

        Diary04 diary3=new Diary04();
        diary3.setId(13);
        diary3.setName("X");

        //ilişkinin sahibi olan tablo(class) tarafında setlemeliyiz.
        diary1.setStudent(student2);
        diary2.setStudent(student1);

        //student1.setDiary(diary2);-->mappedBy ile otomatik yapılır:gerek yok!!!

        Configuration config=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student04.class).addAnnotatedClass(Diary04.class);

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
