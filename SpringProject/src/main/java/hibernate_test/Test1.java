package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        
        try { // To make sure session is closed
            Session session = factory.getCurrentSession();
            Employee emp = new Employee("Peter", "Burke", "FBI agent", 1500);
            session.beginTransaction();
            session.save(emp); // INSERT
            session.getTransaction().commit(); // Close transaction
            
            System.out.println("Success");
            System.out.println("Id = " + emp.getId());
        }
        finally {
            factory.close();
        }
    }
}
