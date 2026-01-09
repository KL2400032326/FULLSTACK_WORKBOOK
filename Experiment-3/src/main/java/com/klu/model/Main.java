package com.klu.model;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class Main {

    public static void main(String[] args) {

        insertProducts();
        sortByPriceAsc();
        sortByPriceDesc();
        sortByQuantity();
        pagination();
        aggregates();
    }

    static void insertProducts() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(new Product("Laptop", 60000.00, 5, "Electronics"));
        session.save(new Product("Mouse", 500.0, 20, "Electronics"));
        session.save(new Product("Keyboard", 1500.0, 15, "Electronics"));
        session.save(new Product("Chair", 3000.00, 10, "Furniture"));
        session.save(new Product("Table", 7000.0, 3, "Furniture"));
        session.save(new Product("Pen", 20.0, 100, "Stationery"));

        tx.commit();
        session.close();

        System.out.println("Products inserted");
    }

    static void sortByPriceAsc() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Product> q =
            session.createQuery("from Product order by price asc", Product.class);

        System.out.println("\nPrice Ascending:");
        for (Product p : q.list())
            System.out.println(p.getName() + " - " + p.getPrice());

        session.close();
    }

    static void sortByPriceDesc() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Product> q =
            session.createQuery("from Product order by price desc", Product.class);

        System.out.println("\nPrice Descending:");
        for (Product p : q.list())
            System.out.println(p.getName() + " - " + p.getPrice());

        session.close();
    }

    static void sortByQuantity() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Product> q =
            session.createQuery("from Product order by quantity desc", Product.class);

        System.out.println("\nQuantity Descending:");
        for (Product p : q.list())
            System.out.println(p.getName() + " - " + p.getQuantity());

        session.close();
    }

    static void pagination() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Product> q =
            session.createQuery("from Product", Product.class);

        q.setFirstResult(0);
        q.setMaxResults(3);
        System.out.println("\nFirst 3 Products:");
        for (Product p : q.list())
            System.out.println(p.getName());

        q.setFirstResult(3);
        q.setMaxResults(3);
        System.out.println("\nNext 3 Products:");
        for (Product p : q.list())
            System.out.println(p.getName());

        session.close();
    }

    static void aggregates() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Long count =
            (Long) session.createQuery("select count(*) from Product").uniqueResult();

        Object[] res =
            (Object[]) session.createQuery(
                "select min(price), max(price) from Product").uniqueResult();

        System.out.println("\nTotal Products: " + count);
        System.out.println("Minimum Price: " + res[0]);
        System.out.println("Maximum Price: " + res[1]);

        session.close();
    }
}
