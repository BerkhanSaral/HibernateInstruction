package com.tpe.hb05.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch05 {
    public static void main(String[] args) {

        Configuration config = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student05.class).addAnnotatedClass(University.class);

        SessionFactory sessionFactory = config.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();

        //1001 id li öğrenciyi fetch edelim
        Student05 student = session.get(Student05.class, 1001);
        System.out.println(student);
        System.out.println(student.getUniversity());

        System.out.println("------------------------------------------------");
        //id:11 olan üniversitenin tüm öğrencilerini listeleyelim:HQL ile
        String hql = "SELECT s FROM Student05 s WHERE s.university=11";
        List<Student05> resultList = session.createQuery(hql, Student05.class).getResultList();
        for (Student05 s : resultList) {
            System.out.println(s);
        }
        System.out.println("------------------------------------------------");

        String hql2 = "select s.name, s.grade, s.university.name from Student05 s ";
        List<Object[]> resultList1=session.createQuery(hql2).getResultList();
        for (Object[] obj : resultList1) {
            System.out.println(Arrays.toString(obj));
        }

        tx.commit();
        session.close();
        sessionFactory.close();


    }
}