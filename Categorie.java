public class Categorie
{
	private String libelle;

	public Categorie ( String libelle )
	{
		this.libelle = libelle;
	}

	public String getLibelle()
	{
		return this.libelle;
	}

	public String toString()
	{
		return this.libelle;
	}

	// Deux catégoriew sont identiquew si elles ont le même libellé
	public boolean equals ( Categorie autre )
	{
		return this.libelle.equals ( autre.libelle );
	}
}

