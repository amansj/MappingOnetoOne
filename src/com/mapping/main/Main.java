package com.mapping.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mapping.entity.Instructor;
import com.mapping.entity.InstructorDetails;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(InstructorDetails.class).addAnnotatedClass(Instructor.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		try {
			
			Instructor inst=new Instructor("A4", "S4", "abc4@abc.com");
			InstructorDetails instDetails =new InstructorDetails("https://www.youtube.com/abc4", "Cricket4");
			inst.setInstructorDeatils(instDetails);
			session.beginTransaction();
			//System.out.println(inst);
			session.save(inst);
			
			session.getTransaction().commit();
			session.close();
			//System.out.println(inst);
		}catch(Exception e){System.out.println(e.getMessage());}finally {
			factory.close();
		}
		
	}

}
