package hibernate_test;

import hibernate_test.entity.Employee;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test3 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        
        try { 
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            // HQL - Hibernate Query Language
//            List<Employee> emps = session.createQuery("from Employee") // Name of class
//                    .getResultList(); // Get all employees
            
            // Select employee by name
            List<Employee> emps = session.createQuery("from Employee " 
                    + "where name = 'Peter' AND salary > 1000") 
                    .getResultList(); // 'name' is a name of a class field 
            
            for (Employee e: emps)
                System.out.println(e);
            
            session.getTransaction().commit(); // Close transaction
            
            System.out.println("Success");
        }
        finally {
            factory.close();
        }
    }
}
