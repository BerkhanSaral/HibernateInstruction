package com.tpe.hb11.caching;

import com.tpe.hb10.idgeneration.Student10;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave11 {
    public static void main(String[] args) {

        Student11 student1=new Student11("Jack",99);
        Student11 student2=new Student11("Harry",99);
        Student11 student3=new Student11("Sherlock",99);
        Student11 student4=new Student11("Rod",99);


        Configuration config=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student11.class);

        SessionFactory sessionFactory =config.buildSessionFactory();

        Session session =sessionFactory.openSession();

        Transaction tx =session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(student4);



        tx.commit();
        session.close();
        sessionFactory.close();




    }
}
