package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        
        try { // To make sure session is closed
            Session session = factory.getCurrentSession();
            Employee emp = new Employee("Sherlock", "Holmes", "Detective", 400);
            session.beginTransaction();
            session.save(emp); // save = INSERT
            //session.getTransaction().commit(); // Close transaction
            
            int myId = emp.getId();
//            session = factory.getCurrentSession();
//            session.beginTransaction(); // Open new session
            Employee employee = session.get(Employee.class, myId); // get = SELECT
            session.getTransaction().commit();
            System.out.println(employee);
            
            System.out.println("Success");
        }
        finally {
            factory.close();
        }
    }
}
