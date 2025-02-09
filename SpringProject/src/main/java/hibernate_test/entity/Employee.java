package hibernate_test.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO
    @Column(name = "id") // No need to write this if names are the same
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "department")
    private String department;
    @Column(name = "salary")
    private int salary;
    
    public Employee(){
    }
    
    public Employee(String name, String surname, String department, int salary){
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
    }
    
    @Override
    public String toString() {
        return "Employee{ " +
                "id = " + id +
                ", name = \'" + name + '\'' +
                ", surname = \'" + surname + '\'' +
                ", department = \'" + department + '\'' +  
                ", salary = " + salary + "}";
                
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    
    public void setSalary(int salary) {
        this.salary = salary;
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getSurname() {
        return surname;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public int getSalary() {
        return salary;
    }
}
