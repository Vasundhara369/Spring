package com.hibenate.HibernateExample1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
	App()
	{
		
	}
    public static void main( String[] args )
    {
    	Student st=new Student();
        	
    	Configuration con=new Configuration().configure().addAnnotatedClass(Student.class);
        ServiceRegistry sr=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    	SessionFactory sf=con.buildSessionFactory(sr);
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();
        tx.commit();
    }
}
