package com.tpe.hb02.embeddable;

import com.tpe.hb01.annotation.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave02 {
    public static void main(String[] args) {

        Student02 student1=new Student02(1001,"Faruk Bey",93);
        Student02 student2=new Student02(1002,"Sezer Bey",94);
        Student02 student3=new Student02(1003,"Mahinur Hanım",95);

        Address address1=new Address("Orange street","London","England","12345");
        Address address2=new Address("Apple street","NewYork","USA","67890");

        student1.setAddress(address1);
        student2.setAddress(address1);
        student3.setAddress(address2);



        Configuration config=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student02.class);

        SessionFactory sessionFactory =config.buildSessionFactory();

        Session session =sessionFactory.openSession();

        Transaction tx =session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);


        tx.commit();
        session.close();
        sessionFactory.close();

    }
}