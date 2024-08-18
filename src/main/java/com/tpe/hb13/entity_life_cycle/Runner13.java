package com.tpe.hb13.entity_life_cycle;

import com.tpe.hb12.get_load.Student12;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Runner13 {
    public static void main(String[] args) {

        Student13 student=new Student13("Jack",99);//transient


        Configuration config=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student13.class);

        SessionFactory sessionFactory =config.buildSessionFactory();

        Session session =sessionFactory.openSession();

        Transaction tx =session.beginTransaction();

//        session.save(student);//persisted
//        student.setName("Ali Can");

        Student13 student2=session.get(Student13.class,1);//persisted
        student2.setName("Ayşe");

        session.delete(student2);//removed




        tx.commit();
        session.close();
        sessionFactory.close();

    }
}
