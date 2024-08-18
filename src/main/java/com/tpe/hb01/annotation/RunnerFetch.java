package com.tpe.hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch {
    public static void main(String[] args) {

        Configuration config = new Configuration().configure().addAnnotatedClass(Student.class);

        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();

        //transaction fetch işlemlerinde gerekli değildir.

        /*
          DB den data çekmek için
          Task:id=1001 olan öğrenciyi tüm fieldlarıyla getirmek(fetch) istiyoruz.
           1) sessionın metodu:get():en pratik ama kullanım alanı kısıtlı
           2) SQL : DB ce
           3) HQL(Hibernate Query Language): Javaca

         */

        //get
        Student student1 = session.get(Student.class, 1001);
        System.out.println(student1);

        System.out.println("-------------------------");

        //SQL
        String sql = "SELECT * FROM t_student WHERE id=1002";
        Object[] student2 = (Object[]) session.createSQLQuery(sql).uniqueResult();
        //uniqueResult():sorgunun tek satır getireceğini biliyorsak kullanılır

        System.out.println(Arrays.toString(student2));

        System.out.println("-------------------------");

        //HQL
        String hql = "FROM Student WHERE id=1003";
        Student student3 = session.createQuery(hql, Student.class).uniqueResult();
        System.out.println(student3);

        System.out.println("-------------------------");

        //tüm kayıtları çekelim
        //hql ile
        String hql2 = "FROM Student";
        List<Student> studentList = session.createQuery(hql2, Student.class).getResultList();

        for (Student s : studentList) {
            System.out.println(s);
        }


        //sql ile:exercise
        System.out.println("-------------SQL------------");
        String sql2 = "Select * from t_student";
        List<Object[]> resultList = session.createSQLQuery(sql2).getResultList();
        for (Object[] objects : resultList) {
            System.out.println(Arrays.toString(objects));
        }

        System.out.println("-------------------------");

        // HQL ile grade degeri 90 olan ogrencilerin id ve name bilgilerini getirelim
        String hql3 = "select s.id, s.name from Student s  where s.grade=90";
        List<Object[]> resultList2 = session.createQuery(hql3).getResultList();
        for (Object[] objects : resultList2) {
            System.out.println(Arrays.toString(objects));
        }

        //HQL ile
        //1- ismi Feyza olan ogrencilerin tum bilgileri
        //2- tum ogrencilerin sadece isimlerini getirelim
        //3- SQL ile tum ogrencilerin sadece isimlerini getirelim





        session.close();
        sessionFactory.close();

    }
}