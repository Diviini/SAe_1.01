import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileReader;
import iut.algo.Decomposeur;
import java.io.FileInputStream;
import java.util.Collections;


public class Metier_exo4
{
	/*-------------------*/
	/*    Attributs      */
	/*-------------------*/

	private ArrayList<Categorie> alCategorie;
	private ArrayList<Editeur>   alEditeur;

	private ArrayList<Auteur>    alAuteur;
	private ArrayList<Jeu>       alJeu;



	/*-------------------*/
	/*    Méthodes       */
	/*-------------------*/
                                                                                     // ------------
	public Metier_exo4()                                                                 // constructeur
	{                                                                               // ------------
		this.initCategorie();
		this.initEditeur  ();

		this.initAuteur   ();
		this.initJeu      ();
	}

	                                                                                 // -------------
	private void initCategorie()                                                     // initCategorie
	{                                                                                // -------------
		this.alCategorie = new ArrayList<Categorie> ();
		ArrayList<String> temp = new ArrayList<String>();

		try
		{
			Scanner sc = new Scanner ( new FileReader ( "categorie.data" ) );

			while ( sc.hasNextLine() )
			{	
				temp.add( sc.nextLine());			
			}
			Collections.sort(temp);

			for (String categorie: temp){
				alCategorie.add(new Categorie(categorie));
			}
		}
		catch (Exception e){ e.printStackTrace(); } 
	}

	                                                                                 // -----------
	private void initEditeur()                                                       // initEditeur
                                                                               // -----------


		// parcours  du  Fichier  Editeur  pour  initialiser  alEditeur
		// notez que l'ordre des Editeur dans le  fichier  editeur.data
		// correspond à l'ordre des refEditeur dans le fichier jeu.data

	{
		try{
			this.alEditeur = new ArrayList<Editeur>();
			Scanner sc = new Scanner (new FileInputStream ( "editeur.data" ),"UTF-8" );
			Decomposeur dec = new Decomposeur("\t");
			while ( sc.hasNextLine() )
			{
				dec = new Decomposeur (sc.nextLine());
				this.alEditeur.add(new Editeur(dec.getString(0),dec.getString(1)));
			}
		}
		catch (Exception e){ e.printStackTrace(); }
	
	
		}

	                                                                                 // ----------
	private void initAuteur()                                                        // initAuteur
	{
		this.alAuteur = new ArrayList<>();
		Decomposeur dec;

		try
		{
			Scanner sc = new Scanner ( new FileInputStream ( "jeu.data" ),"UTF-8" );

			while ( sc.hasNextLine() )
			{
				dec = new Decomposeur(sc.nextLine());

				Auteur auteur1 = new Auteur(dec.getString(3));
				if (this.rechercherAuteur(dec.getString(3)) == null) {
					this.alAuteur.add(auteur1);
				}

				if (!dec.getString(4).equals("")) {
					Auteur auteur2 = new Auteur(dec.getString(4));
					if (this.rechercherAuteur(dec.getString(4)) == null) {
						this.alAuteur.add(auteur2);
					}
				}


			}
		}
		catch (Exception e){ e.printStackTrace(); }

	}
	                                                                                 // -------
	private void initJeu()                                                           // initJeu                                                                           // -------
		// A chaque que l'on récupère un nouveau nom  d'auteur,  il  faut
		// vérifier qu'il ne se trouve pas déjà dans alAuteur.
		// On part du principe qu'il y a pas d'homonyme sur nom et prénom
	{                                                                                // -------
		// Variables intermédiaires pour créer un Auteur
		Categorie categorie;
		Auteur    auteur1;
		Auteur    auteur2;
		Editeur   editeur;

	
		this.alJeu = new ArrayList<Jeu> ();
	
		Decomposeur dec = new Decomposeur("");
	
		try
		{
			Scanner sc = new Scanner ( new FileInputStream ( "jeu.data" ),"UTF-8" );
	
			while ( sc.hasNextLine() )
			{
				categorie = null;
				auteur1 = null;
				auteur2 = null;
				editeur = null;
	
				dec = new Decomposeur(sc.nextLine());
	
				for (Categorie indice : alCategorie) 
				{
					if (indice.getLibelle().charAt(0) == dec.getChar(0)) 
					{
						categorie = indice;
					}
				}
	
				for (Auteur indice : alAuteur) 
				{
					if (indice.getPrenomNom().equals(dec.getString(3))) 
					{
						auteur1 = indice;
					}
	
					if (indice.getPrenomNom().equals(dec.getString(4))) 
					{
						auteur2 = indice;
					}
				}
	
				editeur = alEditeur.get(dec.getInt(5) - 1);
	
				alJeu.add ( new Jeu ( categorie, dec.getString(1), dec.getString(2), auteur1, auteur2, editeur,
				dec.getInt(6), dec.getInt(7), dec.getInt(8), dec.getInt(9), dec.getString(10)));
			}
		}
		catch (Exception e){ e.printStackTrace(); }
	
	}

	                                                                                 // ----------------
	private Auteur rechercherAuteur ( String prenomNom )                             // rechercherAuteur
	{
		if (prenomNom.equals("")) {
			return null;
		}

		for (Auteur auteur : this.alAuteur) {
			if (auteur.getPrenomNom().equals(prenomNom)) {
				return auteur;
			}
		}
			

		return null;
	}

	                                                                                 // ------------
	public void genererPages( String repDest)                                        // genererPages
	{                                                                                // ------------
		try
		{
			if ( !Files.exists ( Paths.get("./" + repDest) ) )
			{
				Files.createDirectory ( Paths.get("./" + repDest) );
			}
		}catch(Exception e){ e.printStackTrace(); }

		GenerationPageAccueil .generer ( repDest, alAuteur, alEditeur );
		GenerationPagesAuteur .generer ( repDest, alAuteur, alJeu     );
		GenerationPagesEditeur.generer ( repDest, alEditeur, alJeu    );
	}

	                                                                                 // --------
	public String toString()                                                         // toString
	{                                                                                // --------
		String sRet = "Categorie\n";

		for ( Categorie cat : alCategorie )
			sRet += cat.toString() + "\n";


		sRet += "\nEditeur\n";

		for ( Editeur ed : alEditeur )
			sRet += ed.toString() + "\n";


		sRet += "\nAuteur\n";

		for ( Auteur aut : alAuteur )
			sRet += aut.toString() + "\n";


		sRet += "\nJeu\n";

		for ( Jeu jeu : alJeu )
			sRet += jeu.toString() + "\n";

		return sRet;
	}


}