package com.tpe.hb12.get_load;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
/*
   get -> dönen objeye hemen ihtiyaç duyulursa get kullanılır.
       -> hemen db ye başvurur
       -> obje yoksa null döner
       -> id ile obje olduğuna emin değilsek get kullanılmalı

   load -> proxy(gölge) döner
        -> hemen db ye başvurmaz->ne zaman ihtiyaç duyulursa gerçek nesneyi döner
        -> obje yoksa not found exception fırlatır
        -> id ile obje olduğuna eminsek load kullanılmalı
        -> objeye reference olarak ihtiyaç duyulursa kullanılmalı

 */
public class RunnerFetch12 {
    public static void main(String[] args) {
        Configuration config=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student12.class);

        SessionFactory sessionFactory =config.buildSessionFactory();

        Session session =sessionFactory.openSession();

        Transaction tx =session.beginTransaction();

        //get
//        System.out.println("------------get metodundan önce");
//        Student12 student1=session.get(Student12.class,1);
//        System.out.println("------------get metodundan sonra");
//        System.out.println("ID : "+student1.getId());
//        System.out.println("Öğrencinin adı : "+student1.getName());

        //load
//        System.out.println("------------load metodundan önce");
//        Student12 student2=session.load(Student12.class,1);
//        System.out.println("------------load metodundan sonra");
//        System.out.println("ID : "+student2.getId());
//        System.out.println("Öğrencinin adı : "+student2.getName());


        //---------------olmayan bir ID ile obje getirmek istersek-------------------------------

        Student12 student=session.get(Student12.class,10);
        if (student!=null){
            System.out.println(student);
            System.out.println(student.getName());
        }else {
            System.out.println("Öğrenci bulunamadı!!!");
        }


        try {
            Student12 student3=session.load(Student12.class,11);
            System.out.println(student3);
        }catch (ObjectNotFoundException e){
            System.out.println("Öğrenci bulunamadı!!!");
        }



        tx.commit();
        session.close();
        sessionFactory.close();

    }
}
