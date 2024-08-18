package com.tpe.hb09.fetchtypes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
/*
2.taraf Many ise default olarak Lazy , One ise default olarak EAGER yapar :

OneToMany       --> LAZY
ManyToMany      --> LAZY
OneToOne        --> EAGER
ManyToOne       --> EAGER
*/
public class RunnerFetch09 {
    public static void main(String[] args) {
        Configuration config=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student09.class).addAnnotatedClass(Book09.class);

        SessionFactory sessionFactory =config.buildSessionFactory();

        Session session =sessionFactory.openSession();

        Transaction tx =session.beginTransaction();

        //student fetch edelim
        Student09 student=session.get(Student09.class,1001);//onetomany-->LAZY
        System.out.println(student.getBookList());

        //book fetch edelim
        Book09 book=session.get(Book09.class,11);//manytoone-->EAGER
        System.out.println(book.getStudent());


        tx.commit();
        session.close();

        // System.out.println(student.getBookList());
        //      System.out.println(book.getStudent());

        sessionFactory.close();
    }
}