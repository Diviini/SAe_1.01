import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.File;

public class GenerationPagesEditeur
{
	public static void generer(String repertoire, ArrayList<Editeur> alEditeur, ArrayList<Jeu> alJeu)
	{
  		PrintWriter pw = null;



		for ( int cpt = 0; cpt < alEditeur.size(); cpt ++ )
		{
			try{	pw = new PrintWriter ( new File ( "../" + repertoire + "/editeur" + cpt + ".html"), "utf-8" ); }
			catch (Exception e){e.printStackTrace();}


			pw.println ( "<html>" );
			pw.println ( "<head> <title>Editeurs</title> <link rel='stylesheet' href='../SAE_1.01/style.css'><meta charset='UTF-8'></head>" );
			pw.println ( "\t<body>" );
			//Header//
			pw.println("\t\t\t<header>"+"\t\t\t\t<h1>Ludotheque: "+alEditeur.get(cpt).getNom() +"</h1>\t\t\t");
			pw.println ( "\t\t\t<nav aria-label=\"Ariane\">"+"\t\t\t\t\t<a href=\"index.html\">Accueil</a>"+ " > Editeur: "+alEditeur.get(cpt).getNom()+"</nav>"+"\t\t\t<article>");
			pw.println("\t\t\t<div id = divLogo>");
			pw.println("<img id = \"logoEditeur\" src=../SAE_1.01/images/editeurs/" + alEditeur.get(cpt).getLogo()+" alt='Couverture'></br>");
			pw.println("\t\t\t</div>");
			pw.println("</header>");
			//Fin Header//
			pw.println ( "\t<div id='divTabEditeur'>");
			pw.println ( "\t\t<table id='tabEditeur'>" );
			pw.println ( "\t\t\t<thead>" );

			for ( Jeu jeu : alJeu ){
				if ( jeu.getEditeur().getNom().equals(alEditeur.get(cpt).getNom())){
					pw.println ( "\t\t\t\t<th>"+ jeu.getTitre()+"</th>" );
					pw.println ( "\t\t\t\t<th> Jeu </th>" );
					pw.println ( "\t\t\t\t<th> Infos </th>" );
					pw.println ( "\t\t\t</thead>");
					pw.println ( "\t\t\t<tbody>");
					pw.println("\t\t\t<tr>");
					pw.println("\t\t\t\t<td rowspan = 7> <img src=../SAE_1.01/images/couvertures/" + jeu.getImage()+" alt='Couverture'></td>");
					pw.println("\t\t\t<tr>");
					pw.println("\t\t\t\t<td>Créé le:</td>");
					pw.println("\t\t\t\t<td>"+jeu.getDateDeSortie()+"</td>");
					pw.println("\t\t\t</tr>");
					pw.println("\t\t\t<tr>");
					pw.println("\t\t\t\t<td>Par: </td>");
					if (jeu.getAuteur2()==null)
						pw.println("\t\t\t<td>"+jeu.getAuteur1()+"</td>");
					else
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
					pw.println("\t\t\t<tr></br></br>");
				}
			}
			pw.println ( "\t\t\t<tbody>");
			pw.println ( "\t\t</table>" );
			pw.println ("\t<t/div>");
			pw.println ( "\t<body>" );
			pw.println ("\t\t<footer>© Departement Informatique, IUT du Havre.</footer");
			pw.println ( "\t<body>" );

			pw.println ( "</html>" );

			pw.close();
		}
  	}
}
