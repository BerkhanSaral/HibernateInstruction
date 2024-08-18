package com.tpe.hb04.bi_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch04 {
    public static void main(String[] args) {


        Configuration config=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student04.class).addAnnotatedClass(Diary04.class);

        SessionFactory sessionFactory =config.buildSessionFactory();

        Session session =sessionFactory.openSession();

        Transaction tx =session.beginTransaction();

        //id:11 olan diary i fetch edelim
        Diary04 diary=session.get(Diary04.class,11);
        System.out.println(diary);
        //bu günlük kime ait?
        System.out.println(diary.getStudent());

        System.out.println("-----------------------------------------------");
        //id:1001 olan studenti getirelim
        Student04 student=session.get(Student04.class,1001);
        System.out.println(student);

        //bu öğrencinin günlüğü hangisi?
        System.out.println(student.getDiary());

        //bi-directional: student-->diary
        //               diary-->student


        // !!! Task 1: Diary ve Student tablolarında ortak kayıtlardan
        //student name ve diary name fieldlarını getirelim.
        System.out.println("--------------------------------------------------------");
        String hql="SELECT s.name, d.name FROM Student04 s INNER JOIN Diary04 d ON s.id=d.student";//d.student.id
        List<Object[]> resultList1=session.createQuery(hql).getResultList();
        for (Object[] o:resultList1){
            System.out.println(Arrays.toString(o));
        }

        // !!! Task 2: Tüm öğrencilerin
        //student name ve varsa diary name fieldlarını getirelim.
        System.out.println("--------------------------------------------------------");
        String hql2="SELECT s.name, d.name FROM Student04 s LEFT JOIN Diary04 d ON s.id=d.student";//d.student.id
        List<Object[]> resultList2=session.createQuery(hql2).getResultList();
        for (Object[] o:resultList2){
            System.out.println(Arrays.toString(o));
        }

        // Task 3 : Butun gunlukler ve varsa gunlugu olan ogrenciler gelsin
        System.out.println("--------------------------------------------------------");
        String hql3="SELECT s.name, d.name FROM Student04 s RIGHT JOIN Diary04 d ON s.id=d.student";//d.student.id
        String hql4="SELECT s.name, d.name FROM Diary04 d LEFT JOIN Student04 s ON s.id=d.student";//d.student.id
        List<Object[]> resultList3=session.createQuery(hql3).getResultList();
        for (Object[] o:resultList3){
            System.out.println(Arrays.toString(o));
        }

        // Task 4 : tüm günlük ve öğrencilerin isimlerini getirelim.
        String hql5="SELECT s.name, d.name FROM Student04 s FULL JOIN Diary04 d ON s.id=d.student";//d.student.id
        List<Object[]> resultList4=session.createQuery(hql5).getResultList();
        for (Object[] o:resultList4){
            System.out.println(Arrays.toString(o));
        }



        tx.commit();
        session.close();
        sessionFactory.close();

    }
}