package com.tpe.hb05.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave05 {
    public static void main(String[] args) {

        University university=new University(07,"Akdeniz uni");

        Student05 student1=new Student05();
        student1.setId(1001);
        student1.setName("Jack");
        student1.setGrade(34);

        Student05 student2 =new Student05();
        student2.setId(1002);
        student2.setName("Trump");
        student2.setGrade(87);

        Student05 student3 =new Student05();
        student3.setId(1003);
        student3.setName("Micheal");
        student3.setGrade(56);

        student1.setUniversity(university);
        student2.setUniversity(university);


        Configuration config=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student05.class).addAnnotatedClass(University.class);

        SessionFactory sessionFactory =config.buildSessionFactory();

        Session session =sessionFactory.openSession();

        Transaction tx =session.beginTransaction();

        session.save(university);
        session.save(student1);
        session.save(student2);
        session.save(student3);



        tx.commit();
        session.close();
        sessionFactory.close();

    }
}
