package com.hibernate.lesson;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class OperateSal {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure(); //创建配置文件
        SessionFactory sf = con.buildSessionFactory();//创建会话工厂


        Session session = sf.openSession();//连接会话并打开
        Transaction tx = null; //增加修改的时候创建
        try {
            tx = session.beginTransaction();//添加事务
            SalEntity se = new SalEntity();//保存数据
            se.setName("hi");//新创建数据
            se.setPassword("04");

            session.save(se);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        }
    }
}