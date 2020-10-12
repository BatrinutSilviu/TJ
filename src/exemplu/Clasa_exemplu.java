package exemplu;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Clasa_exemplu 
{
	private static SessionFactory factory;
	
	public static void main(String[] args) 
	{
		Calendar calendar= Calendar.getInstance();
		try
		{
//			factory = new Configuration().configure().buildSessionFactory();	
			Configuration configuration = new Configuration();
			configuration.configure();
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
			configuration.getProperties()).buildServiceRegistry();
			factory = configuration.buildSessionFactory(serviceRegistry);
		}
		catch(Throwable ex)
		{
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}

		Set<Curs> set1 = new HashSet<Curs>();
		set1.add(new Curs("agricultura",20,"nesemnificativ",true,1992));
		set1.add(new Curs("it",30,"nesemnificativ",false,2020));
		set1.add(new Curs("inginerie",30,"nesemnificativ",true,2005));
		calendar.getTime();
		adaugare(new Angajat(1,"Ionel","rockfm","dj",calendar.getTime(),set1));
		
		Set<Curs> set2 = new HashSet<Curs>();
		set2.add(new Curs("frizer",25,"nesemnificativ",false,2006));
		set2.add(new Curs("bucatar",35,"nesemnificativ",true,2019));
		
		adaugare(new Angajat(2,"Fanel","aquatim","scanfandru",calendar.getTime(),set2));
		afisare();
	}
	
//	private static void inserare_angajat(String nume, String firma, String functie, Date data)
//	{
//		Session session = factory.openSession();
//		Transaction tx = null;
//		try
//		{
//			tx = session.beginTransaction();
//			Angajat angajat= new Angajat(nume, firma, functie, data);
//			session.save(angajat);
//			tx.commit();
//		}
//		catch (HibernateException e) 
//		{
//			if (tx!=null) 
//				tx.rollback();
//			e.printStackTrace();
//		}
//		finally 
//		{ 
//			session.close(); 
//		}
//	}
	
//	private static void inserare_curs(int id, String nume, String firma, String functie, Calendar data)
//	{
//		Session session = factory.openSession();
//		Transaction tx = null;
//		try
//		{
//			tx = session.beginTransaction();
//			Angajat angajat= new Angajat(id, nume, firma, functie, data);
//			session.save(angajat);
//			tx.commit();
//		}
//		catch (HibernateException e) 
//		{
//			if (tx!=null) 
//				tx.rollback();
//			e.printStackTrace();
//		}
//		finally 
//		{ 
//			session.close(); 
//		}
//	}
//	
//	private static void afisare_angajati( )
//	{
//		Session session = factory.openSession();
//		Transaction tx = null;
//		try
//		{
//			tx = session.beginTransaction();
//			Query query= session.createQuery("from Angajat");
//			List<Angajat> angajati = query.list();
//			for (Angajat p: angajati)
//			{
//				System.out.println(p);
//			}
//			tx.commit();
//		}
//		catch (HibernateException e)
//		{
//			if (tx!=null) 
//				tx.rollback();
//			e.printStackTrace();
//		}
//		finally 
//		{
//			session.close();
//		}
//	}
//	
//	private static void afisare_cursuri( )
//	{
//		Session session = factory.openSession();
//		Transaction tx = null;
//		try
//		{
//			tx = session.beginTransaction();
//			Query query= session.createQuery("from cursuri");
//			List<Angajat> angajati = query.list();
//			for (Angajat p: angajati)
//			{
//				System.out.println(p);
//			}
//			tx.commit();
//		}
//		catch (HibernateException e)
//		{
//			if (tx!=null) 
//				tx.rollback();
//			e.printStackTrace();
//		}
//		finally 
//		{
//			session.close();
//		}
//	}
//	
//	private static void actualizare_angajat(Integer id, String functie )
//	{
//		Session session = factory.openSession();
//		Transaction tx = null;
//		try
//		{
//			tx = session.beginTransaction();
//			Angajat angajat= (Angajat)session.get(Angajat.class, id);
//			angajat.setFunctia( functie );
//			session.update(angajat);
//			tx.commit();
//		}
//		catch (HibernateException e) 
//		{
//			if (tx!=null)
//				tx.rollback();
//			e.printStackTrace();
//		}
//		finally 
//		{
//			session.close();
//		}
//	}
//	
//	private static void actualizare_curs(Integer id, String functie )
//	{
//		Session session = factory.openSession();
//		Transaction tx = null;
//		try
//		{
//			tx = session.beginTransaction();
//			Angajat angajat= (Angajat)session.get(Angajat.class, id);
//			angajat.setFunctia( functie );
//			session.update(angajat);
//			tx.commit();
//		}
//		catch (HibernateException e) 
//		{
//			if (tx!=null)
//				tx.rollback();
//			e.printStackTrace();
//		}
//		finally 
//		{
//			session.close();
//		}
//	}
//	
//	private static void stergere_angajat(Integer id)
//	{
//		Session session = factory.openSession();
//		Transaction tx = null;
//		try
//		{
//			tx = session.beginTransaction();
//			Angajat angajat= (Angajat)session.get(Angajat.class, id);
//			session.delete(angajat);
//			tx.commit();
//		}
//		catch (HibernateException e) 
//		{
//			if (tx!=null) 
//				tx.rollback();
//			e.printStackTrace();
//		}
//		finally 
//		{
//			session.close();
//		}
//	}
//	
//	private static void stergere_curs(Integer id)
//	{
//		Session session = factory.openSession();
//		Transaction tx = null;
//		try
//		{
//			tx = session.beginTransaction();
//			Angajat angajat= (Angajat)session.get(Angajat.class, id);
//			session.delete(angajat);
//			tx.commit();
//		}
//		catch (HibernateException e) 
//		{
//			if (tx!=null) 
//				tx.rollback();
//			e.printStackTrace();
//		}
//		finally 
//		{
//			session.close();
//		}
//	}
	
	public static void adaugare(Angajat angajat)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		try{
		tx = session.beginTransaction();
		session.save(angajat);
		tx.commit();
		}
		catch (HibernateException e) {
		if (tx!=null) tx.rollback();
		e.printStackTrace();
		}
		finally {
		session.close();
		}
	}
	
	public static void afisare( )
	{
		Session session = factory.openSession();
		Transaction tx = null;
		try{
		tx = session.beginTransaction();
		List<Angajat> angajati = session.createQuery("FROM Angajat").list();
		for (Angajat angajat:angajati){
		System.out.println( angajat );
		Set<Curs> cursuri = angajat.getCursuri();
		for (Curs curs:cursuri){
		System.out.println("-"+curs);
		}
		}
		tx.commit();
		}
		catch (HibernateException e) {
		if (tx!=null) tx.rollback();
		e.printStackTrace();
		}
		finally {
		session.close();
		}
	}
	
}
