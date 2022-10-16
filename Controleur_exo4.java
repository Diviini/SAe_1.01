
public class Controleur_exo4
{
	private Metier_exo4 metier;

	public Controleur_exo4(String repDest )
	{
		this.metier = new Metier_exo4();

		this.metier.genererPages(repDest);

		System.out.println ( this.metier.toString() );
	}


	public static void main(String[] a)
	{
		String repCible = "ludotheque";

		new Controleur_exo4( repCible );
	}

}