package com.demo.ExampleHibernate;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App 
{
    public static void main( String[] args )
    {
    	/*Student st=new Student();
    	st.setSid(101);
    	st.setSname("Mike");
    	Course course=new Course();
    	course.setCourseId(1);
    	course.setCname("CSE");
    	st.setCourse(course);*/
    	Configuration con=new Configuration().configure().addAnnotatedClass(Course.class).addAnnotatedClass(Student.class);
        ServiceRegistry sr=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    	SessionFactory sf=con.buildSessionFactory(sr);
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();
        //session.save(st);
        //session.save(course);
        Query query=session.createQuery("from Student where course_courseId like:x");
        query.setParameter("x", "M%");
        List<Student> list=query.list();
        System.out.println(list);
        tx.commit();
        session.close();
        sf.close();
    }
}