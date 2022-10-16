import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.File;


public class GenerationPagesAuteur
{
	public static void generer(String repertoire, ArrayList<Auteur> alAuteur, ArrayList<Jeu> alJeu)
	{
  		PrintWriter pw = null;

		for ( int cpt = 0; cpt < alAuteur.size(); cpt ++ )
		{
			try{	pw = new PrintWriter ( new File ( "../" + repertoire + "/auteur" + cpt + ".html"), "utf-8" ); }
			catch (Exception e){e.printStackTrace();}
			
			// Debut HTML //
			pw.println ( "<!DOCTYPE html>" );
			pw.println ( "<html lang=fr>" );
			pw.println ( "<head> <title> Auteurs </title> <link rel='stylesheet' href='../Generateur/styles.css'> <meta charset='UTF-8'></head>" );
			pw.println ( "\t<body>" );

			//Header//
			pw.println("\t\t\t<header>"+"\t\t\t\t<h1>Ludotheque: "+alAuteur.get(cpt).getPrenomNom() +"</h1>\t\t\t");
			pw.println ( "\t\t\t<nav aria-label=\"Ariane\"><strong>"+"\t\t\t\t\t<a href=\"index.html\">Accueil</a>"+ " > Auteur: "+alAuteur.get(cpt).getPrenomNom()+"</strong></nav>"+"\t\t\t");
			pw.println("</header>");
			//------//

			pw.println ( "\t<div id='divTabAuteur'>");
			pw.println ( "\t\t<table class='tabAuteur'>" );			
			pw.println ( "\t\t\t<thead>" );

			// Variables et compteurs //
			int sJeux = 0;
			int moyenneTemps = 0;
			int cptJeu = 1;
			//-----------------------//

			//Boucle parcourant tous les jeux de l'ArrayList//
			for ( Jeu jeu : alJeu ){

				// Verification de la presence d'un auteur2 afin de pouvoir executer la condition, cas ou il y en a un//
				if (jeu.getAuteur2() != null){
					if ( jeu.getAuteur1().getPrenomNom().equals(alAuteur.get(cpt).getPrenomNom()) || jeu.getAuteur2().getPrenomNom().equals(alAuteur.get(cpt).getPrenomNom())){
						
						// Incrementation du nombre de jeux et du temps total // 
						sJeux ++;
						moyenneTemps += jeu.getTempsMoyen();
						//----------------------------------------------------//

						pw.println ( "\t\t\t\t<th colspan = 3><br/><br/><strong>"+cptJeu+". "+ jeu.getTitre()+"</strong></th>" );
						pw.println ( "\t\t\t</thead>");
						pw.println ( "\t\t\t<tbody>");
						pw.println("\t\t\t<tr>");
						pw.println("\t\t\t\t<td rowspan = 7> <img src=../Generateur/images/couvertures/" + jeu.getImage()+" alt='Couverture'></td>");
					//	pw.println("\t\t\t\t<td> <img src='../Generateur/images/couvertures/" + jeu.getImage()        + "' alt='Couverture'></td>");
						pw.println("\t\t\t</tr>");
						pw.println("\t\t\t<tr>");
						pw.println("\t\t\t\t<td>Créé le:</td>");
						pw.println("\t\t\t\t<td>"+jeu.getDateDeSortie()+"</td>");
						pw.println("\t\t\t</tr>");
						pw.println("\t\t\t<tr>");
						pw.println("\t\t\t\t<td>Par: </td>");
						pw.println("\t\t\t<td>"+jeu.getAuteur1() +" et " +jeu.getAuteur2()+"</td>");
						pw.println("\t\t\t</tr>");					
						pw.println("\t\t\t<tr>");
						pw.println("\t\t\t\t<td>À partir de:  </td>");
						pw.println("\t\t\t<td>"+jeu.getAgeMini()+" ans</td>");
						pw.println("\t\t\t</tr>");
						pw.println("\t\t\t<tr>");
						pw.println("\t\t\t\t<td>Nombre de Joueurs: </td>");
						pw.println("\t\t\t<td>De "+jeu.getNbJoueurMini()+" à "+jeu.getNbJoueurMaxi()+" joueurs </td>");
						pw.println("\t\t\t</tr>");
						pw.println("\t\t\t<tr>");
						pw.println("\t\t\t\t<td>Une partie dure environ: </td>");
						pw.println("\t\t\t<td>"+jeu.getTempsMoyen()+" minutes</td>");
						pw.println("\t\t\t</tr>");
						pw.println("\t\t\t<tr>");
						pw.println("\t\t\t\t<td>Catégorie: </td>");
						pw.println("\t\t\t<td>"+jeu.getCategorie()+"</td>");
						pw.println("\t\t\t</tr>");
						cptJeu++;

					}
				}
				
				// Verification de la presence d'un auteur2 afin de pouvoir executer la condition, cas ou il y en a un//
				else{
					if (jeu.getAuteur1().getPrenomNom().equals(alAuteur.get(cpt).getPrenomNom())){
						sJeux ++;
						moyenneTemps += jeu.getTempsMoyen();
						pw.println ( "\t\t\t\t<th colspan = 3><br/><br/><strong>"+cptJeu+". "+ jeu.getTitre()+"</strong></th>" );
						pw.println ( "\t\t\t</thead>");
						pw.println ( "\t\t\t<tbody>");
						pw.println("\t\t\t<tr>");
						pw.println("\t\t\t\t<td rowspan = 7> <img src=../Generateur/images/couvertures/" + jeu.getImage()+" alt='Couverture'></td>");
						pw.println("\t\t\t<tr>");
						pw.println("\t\t\t\t<td>Créé le:</td>");
						pw.println("\t\t\t\t<td>"+jeu.getDateDeSortie()+"</td>");
						pw.println("\t\t\t</tr>");
						pw.println("\t\t\t<tr>");
						pw.println("\t\t\t\t<td>Par: </td>");
						pw.println("\t\t\t<td>"+jeu.getAuteur1());
						pw.println("\t\t\t</tr>");					
						pw.println("\t\t\t<tr>");
						pw.println("\t\t\t\t<td>À partir de:  </td>");
						pw.println("\t\t\t<td>"+jeu.getAgeMini()+" ans</td>");
						pw.println("\t\t\t</tr>");
						pw.println("\t\t\t<tr>");
						pw.println("\t\t\t\t<td>Nombre de Joueurs: </td>");
						pw.println("\t\t\t<td>De "+jeu.getNbJoueurMini()+" à "+jeu.getNbJoueurMaxi()+" joueurs </td>");
						pw.println("\t\t\t</tr>");
						pw.println("\t\t\t<tr>");
						pw.println("\t\t\t\t<td>Une partie dure environ: </td>");
						pw.println("\t\t\t<td>"+jeu.getTempsMoyen()+" minutes</td>");
						pw.println("\t\t\t</tr>");
						pw.println("\t\t\t<tr>");
						pw.println("\t\t\t\t<td>Catégorie: </td>");
						pw.println("\t\t\t<td>"+jeu.getCategorie()+"</td>");
						pw.println("\t\t\t</tr>");
						cptJeu++;
					}
				}
				
			}
			pw.println ( "\t\t\t</tbody>");
			pw.println ( "\t\t</table><br/><br/>" );
			pw.println ("\t</div><br/>");

			// Footer //
			pw.println ("\t\t<footer><p>Nombres de Jeux: "+ sJeux +" | Temps moyen: "+ (moyenneTemps/sJeux)+" minutes"+"<br/>© Departement Informatique, IUT du Havre.</p></footer>");
			//--------//

			// Fin du HTML //
			pw.println ( "</html>" );

			// Fermeture du printWriter //
			pw.close();
		}
  	}
}