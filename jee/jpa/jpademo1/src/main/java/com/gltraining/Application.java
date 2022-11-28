package com.gltraining;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Application {
    public static void main(String args[]){
       Application demo=new Application();
       demo.start();

    }

    public void start(){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("empms");
        EntityManager em=emf.createEntityManager();
        EntityTransaction transaction =em.getTransaction();
        transaction.begin();
        Employee employee1=new Employee("nikhil",22,90000);
        Employee employee2=new Employee("alfayeed",23,100000);
        System.out.println("employees not added in pc");
        display(employee1);
        display(employee2);

        System.out.println("persist() done on employee1");
        em.persist(employee1);
        int emp1Id=employee1.getId();

        em.persist(employee2);
        System.out.println("persist() done on employee2");

        int emp2Id=employee2.getId();

        System.out.println("nikhil id="+emp1Id +" alfayeedid="+emp2Id);
        System.out.println("displaying employees in pc");
        display(employee1);
        display(employee2);

        transaction.commit();

        em.close();
        emf.close();
    }

    void display(Employee employee){
        System.out.println("id="+employee.getId()+",name="+employee.getName()+",age="+employee.getAge()+",salary="+employee.getSalary());
    }
}
