package hibernate_test;

import hibernate_test.entity.Employee;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test4 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        
        try { 
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            
            //Employee emp = session.get(Employee.class, 1);
            //emp.setSalary(100); // setter = UPDATE
           
            session.createQuery("update Employee set salary = salary + 10 "
            + "where name = 'Peter'").executeUpdate();
            
            session.getTransaction().commit(); // Close transaction
            
            System.out.println("Success");
        }
        finally {
            factory.close();
        }
    }
}
