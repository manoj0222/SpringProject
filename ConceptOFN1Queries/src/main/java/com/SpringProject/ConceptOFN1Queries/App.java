package com.SpringProject.ConceptOFN1Queries;

import java.util.List;import javax.sound.midi.SysexMessage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * Hello world!
 *
 */
public class App 
{
    @SuppressWarnings("deprecation")
	public static void main( String[] args )
    {
    	Person person1 = new Person();
    	Person person2 = new Person();
    	person1.setPersonName("Manoj");
    	person2.setPersonName("Bharath");
  
    	LapTop laptop5 = new LapTop();
    	LapTop laptop6 = new LapTop();
    	LapTop laptop7 = new LapTop();
    	LapTop laptop8 = new LapTop();
    	LapTop laptop9 = new LapTop();
    	LapTop laptop10 = new LapTop();
    	laptop5.setLapTopCompanyName("lenovo");
    	laptop6.setLapTopCompanyName("Asus");
    	laptop7.setLapTopCompanyName("GalaxyProBook");
    	laptop8.setLapTopCompanyName("Dell");
    	laptop9.setLapTopCompanyName("Acer");
    	laptop5.setPersonName(person1);
    	laptop6.setPersonName(person1);
    	laptop7.setPersonName(person2);
    	laptop8.setPersonName(person2);
    	laptop9.setPersonName(person1);
   
    	
    	
    	
    	
       Configuration config = new Configuration().configure("NQuery.xml")
    		   .addAnnotatedClass(Person.class).addAnnotatedClass(LapTop.class);
       SessionFactory sessionFactory = config.buildSessionFactory();
       Session currentSession = sessionFactory.openSession();
       Transaction transaction =currentSession.beginTransaction();
		/*
		 * currentSession.persist(person1); currentSession.persist(person2);
		 * currentSession.persist(laptop5); currentSession.persist(laptop6);
		 * currentSession.persist(laptop7); currentSession.persist(laptop8);
		 * currentSession.persist(laptop9);
		 */
        List<Person> listOfPerson = currentSession.createQuery(" from Person p JOIN fetch p.listOfLapList").list();
    for (Person person:listOfPerson) {
       	System.out.println("<<<<<<<<------------------>>>>>>");
    	System.out.println(person.getPersonName()+" "+person.getId());
		List<LapTop> listOfLapList = person.getListOfLapList();
		 for (LapTop laptop : listOfLapList) {
			System.out.println(laptop.getLapTopCompanyName());
		}
		 System.out.println("<<<<<<<<------------------>>>>>>");
	}  
       transaction.commit();
       currentSession.close();
    	
    }
}
