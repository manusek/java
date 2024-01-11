import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();

        System.out.println("Creating car records...");
        Car mustang = new Car();
        mustang.firstName = "mustang";
        mustang.lastName = "�40,000.00";

        Car mondeo = new Car();
        mondeo.firstName = "mondeo";
        mondeo.lastName = "�20,000.00";

        session.beginTransaction();
        session.save(mustang);
        session.save(mondeo);
        session.getTransaction().commit();

        //read

        Query q = session.createQuery("select _car from Car _car");

        List<Car> cars = q.list();

        System.out.println("Reading car records...");
        System.out.printf("%-30.30s  %-30.30s%n", "Model", "Price");
        for (Car c : cars) {
            System.out.printf("%-30.30s  %-30.30s%n", c.firstName, c.lastName);
        }

        session.close();
    }
}
