package com.tpe.hb07.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch07 {
    public static void main(String[] args) {
        Configuration config = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);

        SessionFactory sessionFactory = config.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();

//        //id:101 olar kitap
//        Book07 book = session.get(Book07.class, 101);
//        System.out.println(book);
//        //bu kitabin sahibi olan ogrenci
//        System.out.println(book.getStudent());
//
//        System.out.println("------------------------------------");
//
//        //id:1002 olan ogrenciyi getir
//        Student07 student = session.get(Student07.class, 1002);
//        System.out.println(student.getBookList());

//        //book07 tablosunda tüm kayıtları silelim
//        String hql="DELETE FROM Book07";
//        int deletedBooks=session.createQuery(hql).executeUpdate();
//        System.out.println("Silinen kitap sayısı : "+deletedBooks);
//
//        //student07 tablosunda tüm kayıtları silelim
//        String hql2="DELETE FROM Student07";
//        int deletedStudents=session.createQuery(hql2).executeUpdate();
//        System.out.println("Silinen öğrenci sayısı : "+deletedStudents);

        //ismi sefiller olan kitabi silelim
        String hql3 = "DELETE FROM Book07 b where b.name='Sefiller' ";
        int numDeletedBook = session.createQuery(hql3).executeUpdate();
        System.out.println("Silinen satir sayisi : " + numDeletedBook);

        // !!! Kitab bilgisi olan bir ogrenciyi silmek istersek
        // 1.yol ) once Book tablosunda iliskili oldugu booklar silinir
        // daha sonra istenen student objesi silinebilir
        // 2.yol ) Student07 classina Cascade / orphanRemoval

        //id:1002 olan öğrenciyi silelim
//        Student07 student2=session.get(Student07.class,1002);
//        session.delete(student2);
        //cascadeType.REMOVE/orphanRemoval aynı

        //id:1001 olan öğrencinin kitap listesinden ilkini silelim
        Student07 student3=session.get(Student07.class,1001);
        student3.getBookList().remove(0);//1001--->102
        student3.getBookList().set(0,null);//1001-->...
        //collectiondan bir eleman silinir veya null yapılırsa
        // referansı olmayan bu nesneyi tablodan da siler

        //std-book-->std kitabi iade etti -->listeden kldirdik -->tablodandad silmemeliyiz -



        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
