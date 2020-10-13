package exemplu;


import java.util.Date;
import java.util.Set;

public class Angajat {
	private int id;
	private String nume;
	private String firma;
	private String functia;
	private Date data_angajarii;
	private Set cursuri;
	public Angajat(){}
	public Angajat(int id,String nume,String firma, String functia, Date data_angajarii, Set cursuri)
	{
		this.id=id; 
		this.nume=nume; 
		this.firma=firma;
		this.functia=functia;
		this.data_angajarii=data_angajarii;
		this.cursuri=cursuri;
	}
	public Angajat(int id,String nume,String firma, String functia, Date data_angajarii)
	{
		this.id=id; 
		this.nume=nume; 
		this.firma=firma;
		this.functia=functia;
		this.data_angajarii=data_angajarii;
	}
	public Angajat(String nume,String firma, String functia, Date data_angajarii)
	{
		this.nume=nume; 
		this.firma=firma;
		this.functia=functia;
		this.data_angajarii=data_angajarii;
	}
	public Angajat(String nume,String firma, String functia, Date data_angajarii, Set cursuri)
	{
		this.nume=nume; 
		this.firma=firma;
		this.functia=functia;
		this.data_angajarii=data_angajarii;
		this.cursuri=cursuri;
	}
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getNume() 
	{
		return nume;
	}
	public void setNume(String nume) 
	{
		this.nume = nume;
	}
	public String getFirma() 
	{
		return firma;
	}
	public void setFirma(String firma) 
	{
		this.firma = firma;
	}
	public String getFunctia() 
	{
		return functia;
	}
	public void setFunctia(String functia) 
	{
		this.functia = functia;
	}
	public Date getdata_angajarii() 
	{
		return data_angajarii;
	}
	public void setdata_angajarii(Date data_angajarii) 
	{
		this.data_angajarii = data_angajarii;
	}
	public Set getCursuri() {
		return cursuri;
	}
	public void setCursuri( Set cursuri ) {
		this.cursuri = cursuri;
	}
	@Override
	public String toString() {
		String ret="Angajat [id=" + id + ", nume=" + nume + ", firma=" + firma + ", functia=" + functia
				+ ", data_angajarii=" + data_angajarii + ", cursuri=";
		for(Object c : cursuri )
		{		
			ret+="\n";
			ret+=c.toString();
		}
		return ret;
	}
}
