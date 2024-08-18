package com.tpe.hb08.manytomany;

import com.tpe.hb07.bi_onetomany.Book07;
import com.tpe.hb07.bi_onetomany.Student07;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave08 {
    public static void main(String[] args) {

        Student08 student1=new Student08(1001,"Ali Can",99);
        Student08 student2=new Student08(1002,"Veli Han",89);
        Student08 student3=new Student08(1003,"Ayşe Can",99);
        Student08 student4=new Student08(1004,"Fatma Han",99);

        Course course1=new Course(11,"Adv Java");
        Course course2=new Course(22,"Hibernate");


        //ilişki student tarafından kurulmalı
        student1.getCourseList().add(course1);
        student1.getCourseList().add(course2);

        student2.getCourseList().add(course1);
        student2.getCourseList().add(course2);

        student3.getCourseList().add(course2);



        Configuration config=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student08.class).addAnnotatedClass(Course.class);

        SessionFactory sessionFactory =config.buildSessionFactory();

        Session session =sessionFactory.openSession();

        Transaction tx =session.beginTransaction();

        session.save(course1);
        session.save(course2);
        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(student4);


        tx.commit();
        session.close();
        sessionFactory.close();
    }
}