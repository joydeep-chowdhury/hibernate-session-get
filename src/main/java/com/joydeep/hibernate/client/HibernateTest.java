package com.joydeep.hibernate.client;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.joydeep.hibernate.model.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails uds=new UserDetails();
		uds.setUserId(1);
		uds.setUserName("Joydeep Chowdhury");
		uds.setAddress("CL266 Sector 2");
		uds.setJoinedDate(new Date());
		uds.setDescription("Description of the user goes here");
        SessionFactory sf=new Configuration().configure().buildSessionFactory();
        Session session=sf.openSession();
        session.beginTransaction();
        session.save(uds);
        session.getTransaction().commit();
        session.close();
        uds=null;
         session=sf.openSession();
        session.beginTransaction();
        uds=session.get(UserDetails.class,1);
        System.out.println(uds);
	}

}
