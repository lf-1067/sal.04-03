package com.hibernate.lesson;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.security.auth.login.AppConfigurationEntry;

public class SelSal {
    public static void main(String[] args) {
        org.hibernate.cfg.Configuration con = new Configuration().configure();
        SessionFactory sf = con.buildSessionFactory();
        Session se=sf.openSession();

        SalEntity sty=(SalEntity)se.get(SalEntity.class,8);

        System.out.println(sty.getName()+ "" + sty.getPassword());

        sty.setPassword("tg");
        sty.setName("21");

        Transaction tx=se.beginTransaction();

        se.update(sty);//
        tx.commit();

        tx=se.beginTransaction();
        se.delete(sty);//

        tx.commit();
       sty=(SalEntity)se.get(SalEntity.class,8);

        System.out.println(sty.getName()+ "" + sty.getPassword());

        se.close();
    }
}
