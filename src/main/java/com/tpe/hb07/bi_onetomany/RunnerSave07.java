package com.tpe.hb07.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave07 {
    public static void main(String[] args) {
        Student07 student1 = new Student07(1001, "Jack", 99);
        Student07 student2 = new Student07(1002, "Harry", 89);
        Student07 student3 = new Student07(1003, "Fred", 95);

        Book07 book1 = new Book07(101, "Sefiller", student1);
        Book07 book2 = new Book07(102, "Suç ve Ceza", student1);
        Book07 book3 = new Book07(103, "Beyaz Diş", student2);
        Book07 book4 = new Book07(104, "Aşk ve Gurur", student2);
        //kitabı öğrenciye verdiğimizde ilişki kurulur, FK sütununa
        //studentın id si eklenir.

        //student1.getBookList().add(book1);-->mappedBy ile otomatik olarak eşleştirilir


        Configuration config=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);

        SessionFactory sessionFactory =config.buildSessionFactory();

        Session session =sessionFactory.openSession();

        Transaction tx =session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);

        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.save(book4);


        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
