package exemplu;

import javax.persistence.*;

@Entity
@Table(name="cursuri")
public class Curs {
	@Id @GeneratedValue
	@Column (name="id")
	private int id;
	
	@Column (name="denumire")
	private String denumire;
	
	@Column (name="numar_ore")
	private int numar_ore;
	
	@Column (name="valoare")
	private String valoare;
	
	@Column (name="diploma")
	private boolean diploma;
	
	@Column (name="anul")
	private int anul;
	public Curs(){}
	public Curs(int id, String denumire, int numar_ore, String valoare, boolean diploma,
			int anul) 
	{
		super();
		this.id = id;
		this.denumire = denumire;
		this.numar_ore = numar_ore;
		this.valoare = valoare;
		this.diploma = diploma;
		this.anul = anul;
	}
	public Curs(String denumire, int numar_ore, String valoare, boolean diploma,
			int anul) 
	{
		super();
		this.denumire = denumire;
		this.numar_ore = numar_ore;
		this.valoare = valoare;
		this.diploma = diploma;
		this.anul = anul;
	}
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getDenumire() 
	{
		return denumire;
	}
	public void setDenumire(String denumire) 
	{
		this.denumire = denumire;
	}
	public int getNumar_ore() 
	{
		return numar_ore;
	}
	public void setNumar_ore(int numar_ore) 
	{
		this.numar_ore = numar_ore;
	}
	public String getValoare() 
	{
		return valoare;
	}
	public void setValoare(String valoare) 
	{
		this.valoare = valoare;
	}
	public boolean isDiploma() 
	{
		return diploma;
	}
	public void setDiploma(boolean diploma) 
	{
		this.diploma = diploma;
	}
	public int getAnul() 
	{
		return anul;
	}
	public void setAnul(int anul) 
	{
		this.anul = anul;
	}
	@Override
	public String toString() 
	{
		return "Curs [id=" + id + ", denumire=" + denumire + ", numar_ore=" + numar_ore
				+ ", valoare=" + valoare + ", diploma=" + diploma + ", anul=" + anul + "]";
	}
}
