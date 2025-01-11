package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test5 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        
        try { 
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            
            //Employee emp = session.get(Employee.class, 8);
            //Employee emp = new Employee("Pig", "one", "Sacrifice", 0);
            //session.save(emp);
            
            //session.delete(emp); // DELETE
            session.createQuery("delete Employee where name = 'Pig'").executeUpdate();
            
            session.getTransaction().commit(); // Close transaction
            System.out.println("Success");
        }
        finally {
            factory.close();
        }
    }
}
