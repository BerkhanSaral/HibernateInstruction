package com.tpe.hb12.get_load;

import com.tpe.hb11.caching.Student11;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave12 {
    public static void main(String[] args) {

        Student12 student1=new Student12("Jack",99);
        Student12 student2=new Student12("Harry",99);
        Student12 student3=new Student12("Johnson",99);


        Configuration config=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student12.class);

        SessionFactory sessionFactory =config.buildSessionFactory();

        Session session =sessionFactory.openSession();

        Transaction tx =session.beginTransaction();


        session.save(student1);
        session.persist(student2);
        session.persist(student3);//persist~save-->SAVE:deprecated


        tx.commit();
        session.close();
        sessionFactory.close();

    }
}
