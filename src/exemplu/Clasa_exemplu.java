package exemplu;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
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
import org.hibernate.cfg.AnnotationConfiguration;

public class Clasa_exemplu 
{
	private static SessionFactory factory;
	
	public static void main(String[] args) throws IOException 
	{
		try
		{
			Configuration configuration = new Configuration();
			configuration.configure();
			configuration.addAnnotatedClass(Angajat.class);
			configuration.addAnnotatedClass(Curs.class);
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
			configuration.getProperties()).buildServiceRegistry();
			factory = configuration.buildSessionFactory(serviceRegistry);
		}
		catch(Throwable ex)
		{
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		Calendar calendar= Calendar.getInstance();
		String opt;
		int id_global;
		String cale = "D:/eclipse-workspace-Java/Exemplu/src/id_angajat.txt";
		FileReader fileReader = new FileReader(cale);
		id_global = fileReader.read();
		do
		{
			System.out.println();
			System.out.println("Alegeti optiunea:");
			System.out.println("0.Iesire");
			System.out.println("1.Afisare angajati");
			System.out.println("2.Adaugare angajat");
			System.out.println("3.Stergere angajat");
			System.out.println("4.Actualizare angajat");
			System.out.println("5.Cautare angajat dupa nume");
			System.out.println("6.Stergere curs");
			System.out.println("7.Actualizare curs");
			System.out.println("8.Cautare curs dupa denumire");
			System.out.println("9.Afisare angajati dupa firma");
			System.out.println("10.Afisare angajati dupa vechime");
			System.out.println("11.Afisare angajati dupa curs");
			InputStreamReader reader=new InputStreamReader(System.in);  
			BufferedReader br=new BufferedReader(reader);
			opt=br.readLine();
			switch(opt)
			{
				case "0":
				{
					System.out.println("La revedere");
					System.exit(0);
				}
				case "1":
				{
					afisare();
					break;
				}
				case "2":
				{
					FileWriter fileWriter = new FileWriter(cale);
					System.out.println("Dati numele");
					String nume = br.readLine();
					System.out.println("Dati firma");
					String firma = br.readLine();
					System.out.println("Dati functia");
					String functia = br.readLine();
					System.out.println("Dati anul angajarii");
					String an = br.readLine();
					System.out.println("Dati luna angajarii");
					String luna = br.readLine();
					System.out.println("Dati ziua angajarii");
					String zi = br.readLine();
					calendar.set(Integer.parseInt(an), Integer.parseInt(luna)-1, Integer.parseInt(zi));
					System.out.println("Dati numarul de cursuri");
					String nr_curs = br.readLine();
					Set<Curs> set = new HashSet<Curs>();
					for( short index=0; index < Integer.parseInt(nr_curs); index++ )
					{				
						System.out.println("Dati denumirea cursului");
						String denumire = br.readLine();
						System.out.println("Dati numarul de ore");
						String ore = br.readLine();
						System.out.println("Dati valoarea");
						String valoare = br.readLine();
						System.out.println("Se emite diploma?Pentru da tastati 1, iar pentru nu tastati 0");
						String diploma = br.readLine();		
						System.out.println("Dati anul");
						String anul = br.readLine();
						set.add(new Curs(denumire,Integer.parseInt(ore),valoare,Boolean.parseBoolean(diploma),Integer.parseInt(anul)));
					}				
					adaugare(new Angajat(++id_global,nume,firma,functia,calendar.getTime(),set));
					fileWriter.write( (char)id_global );
					fileWriter.close();
					break;
				}
				case "3":
				{
					System.out.println("Dati id-ul angajatului");
					String id = br.readLine();
					if( !exista_id(Integer.parseInt(id),"Angajat") )
					{
						System.out.println("Nu exista id");
						break;
					}
					stergere_angajat(Integer.parseInt(id));
					break;
				}
				case "4":
				{
					System.out.println("Dati id-ul angajatului");
					String id = br.readLine();
					if( !exista_id(Integer.parseInt(id),"Angajat") )
					{
						System.out.println("Nu exista id");
						break;
					}
					System.out.println("Dati functia");
					String functie = br.readLine();
					actualizare_angajat(Integer.parseInt(id),functie);
					break;
				}
				case "5":
				{
					System.out.println("Dati numele");
					String nume = br.readLine();
					cautare_angajat_dupa_nume(nume);
					break;
				}
				case "6":
				{
					System.out.println("Dati id-ul cursului");
					String id = br.readLine();
					if( !exista_id(Integer.parseInt(id),"Curs") )
					{
						System.out.println("Nu exista id");
						break;
					}
					stergere_curs(Integer.parseInt(id));
					break;
				}
				case "7":
				{
					System.out.println("Dati id-ul cursului");
					String id = br.readLine();
					if( !exista_id(Integer.parseInt(id),"Curs") )
					{
						System.out.println("Nu exista id");
						break;
					}
					System.out.println("Dati numarul nou de ore");
					String ore = br.readLine();
					actualizare_curs(Integer.parseInt(id),Integer.parseInt(ore));
					break;
				}
				case "8":
				{
					System.out.println("Dati cursul");
					String denumire = br.readLine();
					cautare_curs_dupa_denumire(denumire);
					break;
				}
				case "9":
				{
					System.out.println("Dati firma");
					String firma = br.readLine();
					afisare_dupa_firma(firma);
					break;
				}
				case "10":
				{
					System.out.println("Dati vechimea");
					String vechime = br.readLine();
					afisare_vechime( Integer.parseInt(vechime) );
					break;
				}
				case "11":
				{
					System.out.println("Dati cursul");
					String curs = br.readLine();
					afisare_dupa_curs(curs);
					break;
				}
				default:
				{
					System.out.println("optiune gresita");
				}
			}
		}
		while( !opt.equals("0") );
	}

	private static void actualizare_angajat(Integer id, String functie )
	{
		Session session = factory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			Angajat angajat= (Angajat)session.get(Angajat.class, id);
			angajat.setFunctia( functie );
			session.update(angajat);
			tx.commit();
		}
		catch (HibernateException e) 
		{
			if (tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		finally 
		{
			session.close();
		}
	}

	private static void actualizare_curs(Integer id, int numar_ore)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			Curs curs= (Curs)session.get(Curs.class, id);
			curs.setNumar_ore(numar_ore);
			session.update(curs);
			tx.commit();
		}
		catch (HibernateException e) 
		{
			if (tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		finally 
		{
			session.close();
		}
	}
	
	private static void stergere_angajat(Integer id)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			Angajat angajat= (Angajat)session.get(Angajat.class, id);
			session.delete(angajat);
			tx.commit();
		}
		catch (HibernateException e) 
		{
			if (tx!=null) 
				tx.rollback();
			e.printStackTrace();
		}
		finally 
		{
			session.close();
		}
	}
	
	private static void stergere_curs(Integer id)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			Curs curs= (Curs)session.get(Curs.class, id);
			session.delete(curs);
			tx.commit();
		}
		catch (HibernateException e) 
		{
			if (tx!=null) 
				tx.rollback();
			e.printStackTrace();
		}
		finally 
		{
			session.close();
		}
	}
	
	public static void adaugare(Angajat angajat)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			session.save(angajat);
			tx.commit();
		}
		catch (HibernateException e) 
		{
			if (tx!=null) 
				tx.rollback();
			e.printStackTrace();
		}
		finally 
		{
			session.close();
		}
	}
	
	public static void afisare( )
	{
		Session session = factory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			List<Angajat> angajati = session.createQuery("FROM Angajat").list();
			for (Angajat angajat:angajati)
			{
				System.out.println( angajat );
			}
			tx.commit();
		}
		catch (HibernateException e) 
		{
			if (tx!=null) 
				tx.rollback();
			e.printStackTrace();
		}
		finally 
		{
			session.close();
		}
	}
	
	public static void afisare_dupa_firma( String firma )
	{
		Session session = factory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			Query q = session.createQuery("FROM Angajat where firma= :f");
			q.setParameter("f",firma);
			List<Angajat> angajati = q.list();
			for (Angajat angajat:angajati)
			{
				System.out.println( angajat );
			}
			tx.commit();
		}
		catch (HibernateException e) 
		{
			if (tx!=null) 
				tx.rollback();
			e.printStackTrace();
		}
		finally 
		{
			session.close();
		}
	}
	public static void cautare_angajat_dupa_nume( String nume )
	{
		Session session = factory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			Query q = session.createQuery("FROM Angajat where nume= :n");
			q.setParameter("n",nume);
			List<Angajat> angajati = q.list();
			for (Angajat angajat:angajati)
			{
				System.out.println( angajat );
			}
			tx.commit();
		}
		catch (HibernateException e) 
		{
			if (tx!=null) 
				tx.rollback();
			e.printStackTrace();
		}
		finally 
		{
			session.close();
		}
	}
	public static void cautare_curs_dupa_denumire( String denumire )
	{
		Session session = factory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			Query q = session.createQuery("FROM Curs where denumire= :n");
			q.setParameter("n",denumire);
			List<Curs> cursuri = q.list();
			for (Curs curs:cursuri)
			{
				System.out.println( curs );
			}
			tx.commit();
		}
		catch (HibernateException e) 
		{
			if (tx!=null) 
				tx.rollback();
			e.printStackTrace();
		}
		finally 
		{
			session.close();
		}
	}
	public static void afisare_vechime( int vechime )
	{
		Session session = factory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			List<Angajat> angajati = session.createQuery("FROM Angajat").list();
			for (Angajat angajat:angajati)
			{
				Calendar calendar= Calendar.getInstance();
				Date acum =calendar.getTime();
				Date data_angajarii = angajat.getdata_angajarii();
				
				long diferenta = acum.getTime() - data_angajarii.getTime();

				long zile = diferenta / (24 * 60 * 60 * 1000);
				if (zile > vechime )
				{
					System.out.println( angajat );
				}
			}
			tx.commit();
		}
		catch (HibernateException e) 
		{
			if (tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		finally 
		{
			session.close();
		}
	}
	public static void afisare_dupa_curs( String nume_curs )
	{
		Session session = factory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			Query q = session.createQuery("FROM Angajat");
			List<Angajat> angajati = q.list();
			for (Angajat angajat:angajati)
			{
				Set<Curs> cursuri = angajat.getCursuri();
				for (Curs curs:cursuri)
				{
					if( curs.getDenumire().equals(nume_curs) )
					{
						System.out.println( angajat );
					}
				}

			}
			tx.commit();
		}
		catch (HibernateException e)
		{
			if (tx!=null) 
				tx.rollback();
			e.printStackTrace();
		}
		finally 
		{
			session.close();
		}
	}
	public static boolean exista_id( Integer id, String tabel )
	{
		boolean ok=false;
		Session session = factory.openSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			Query q = session.createQuery("FROM " +tabel);
			if(tabel.equals("Angajat"))
			{
				List<Angajat> angajati = q.list();
				for (Angajat angajat:angajati)
				{
					if(angajat.getId() == id)
					{
						ok = true;
						break;
					}
				}
			}
			else if(tabel.equals("Curs"))
			{
				List<Curs> cursuri = q.list();
				for (Curs curs:cursuri)
				{
					if(curs.getId() == id)
					{
						ok = true;
						break;
					}
				}
			}		
			tx.commit();
		}
		catch (HibernateException e)
		{
			if (tx!=null) 
				tx.rollback();
			e.printStackTrace();
		}
		finally 
		{
			session.close();				
			return ok;
		}
	}
}
