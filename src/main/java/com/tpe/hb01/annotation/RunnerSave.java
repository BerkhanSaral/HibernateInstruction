package com.tpe.hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave {
    public static void main(String[] args) {

        Student student1=new Student();
        student1.setId(1001);
        student1.setName("Sümeyya Hanım");
        student1.setGrade(90);

        Student student2=new Student();
        student2.setId(1002);
        student2.setName("Feyza Hanım");
        student2.setGrade(95);


        Student student3=new Student();
        student3.setId(1003);
        student3.setName("Berkhan Bey");
        student3.setGrade(98);
        //configure metoduna parametre girilmezse defaultta "hibernate.cfg.xml" dosyasına göre konfig. yapar.
        Configuration config=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class);
        //hibernate annote ettiğimiz sınıfı gösterdik

        SessionFactory sessionFactory =config.buildSessionFactory();
        //session oluşturmamızı sağlar, genellikle tüm uygulamada
        //1 kere oluşturulur, tekrar tekrar kullanılır.
        Session session =sessionFactory.openSession();
        //DB de bir oturum başlatmamızı sağlar. Bu session
        //DB ile iletişime geçip bazı işlemleri(CRUD) yapmamızı sağlayan metodları içerir
        //uygulamada 1 den fazla session oluşturulabilir

        //transaction:veritabanı işlemlerinin atomik olmasını sağlar
        Transaction tx =session.beginTransaction();

        //student1 obj tabloya ekleyelim
        //INSERT INTO t_student VALUES(1001,Sümeyya Hanım,90)

        //session.save(student1);
        session.save(student2);
        session.save(student3);


        //DB deki değişikliklerin kalıcı hale gelmesi için
        // transactionın onaylanması gerekir
        tx.commit();//transactionı onaylar ve sonlandırır
        session.close();
        sessionFactory.close();
    }
}