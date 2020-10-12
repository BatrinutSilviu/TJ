package exemplu;

public class Persoana 
{
	private int ID;
	private String Nume;
	private int Varsta;
	public Persoana(){}
	public Persoana(int ID,String Nume,int Varsta)
	{
		this.ID=ID; this.Nume=Nume; this.Varsta=Varsta;
	}
	public int getID() 
	{
		return ID;
	}
	public void setID(int ID) 
	{
		this.ID = ID;
	}
	public String getNume() 
	{
		return Nume;
	}
	public void setNume(String Nume) 
	{
		this.Nume = Nume;
	}
	public int getVarsta() 
	{
		return Varsta;
	}
	public void setVarsta(int Varsta) 
	{
		this.Varsta = Varsta;
	}
	@Override
	public String toString() 
	{
		return ID + ", " + Nume + ", " + Varsta;
	}
}
