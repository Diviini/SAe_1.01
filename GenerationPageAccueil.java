import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.File;



public class GenerationPageAccueil
{
	public static void generer( String repertoire, ArrayList<Auteur> alAuteur, ArrayList<Editeur> alEditeur)
	{
  		PrintWriter pw = null;

  		try{	pw = new PrintWriter ( new File ( "./" + repertoire + "/index.html" ), "utf-8" ); }
  		catch (Exception e){e.printStackTrace();}

		pw.println ( "<html>" );
		pw.println ( "\t<head> <link rel='stylesheet' href='../SAE_1.01/style.css'><meta charset='UTF-8'></head>");
		pw.println ( "\t\t<body>" );
		pw.println("\t\t\t<a name='Haut'></a>");
		pw.println("\t\t\t<header>"+"\t\t\t\t<h1>Ludothèque</h1>\t\t\t");
		pw.println ( "\t\t\t<nav aria-label=\"Ariane\">"+"\t\t\t\t\t<a href=\"index.html\">Accueil</a></nav>"+"\t\t\t<article>");
		pw.println("</header>");
		pw.println ("\t\t\t<div id='divTabAccueil'>");		
		pw.println ( "\t\t\t\t<table id='tabEditeurAccueil'>");
		pw.println ( "\t\t\t\t\t<thead><th>Auteurs</th><thead>");

		pw.println ( "\t\t\t\t\t<tbody>");

		pw.println ( "\t\t\t\t\t\t<tr>");
		int i = 0;

		for ( Auteur auteur : alAuteur ){
			pw.println ( "\t\t\t\t\t\t<tr>");
			pw.println ( "\t\t\t\t\t\t\t<td>" + "<a href=../ludotheque/auteur" + i + ".html>" + auteur.toString() + "</td>" );
			pw.println ( "\t\t\t\t\t\t</tr>");
			i ++;
		}
				
		pw.println ( "\t\t\t\t\t\t<tr>");

		pw.println ( "\t\t\t\t\t<tbody>");
		
		pw.println ( "\t\t\t\t</table>");

		pw.println ( "\t\t\t\t<table id='tabAuteurAccueil'>");

		pw.println ( "\t\t\t\t\t<thead> <th>Editeurs</th><thead>");

		pw.println ( "\t\t\t\t\t<tbody>");

		pw.println ( "\t\t\t\t\t\t<tr>");
		i = 0;
		for ( Editeur ed : alEditeur ){
			pw.println ( "\t\t\t\t\t\t<tr>");
			pw.println ( "\t\t\t\t\t\t\t<td>" + "<a href=../ludotheque/editeur" + i + ".html>" +  ed.toString() + "</td>");
			/*pw.println ("\t\t\t\t\t\t\t<td colspan = 1> <img src=../SAE_1.01/images/editeurs/" + alEditeur.get(i).getLogo()+" alt='Couverture'> </td>");*/
			pw.println ( "\t\t\t\t\t\t</tr>");
			i++;
		}
		
		pw.println ( "\t\t\t\t\t\t<tr>");

		pw.println ( "\t\t\t\t\t</tbody>");
		pw.println ( "\t\t\t\t</table>");
		pw.println ("\t\t\t</div>");
		pw.println("\t\t<footer>© Departement Informatique, IUT du Havre.<a href=\'#Haut\'> Retour en Haut</a></footer>");
		pw.println ( "\t\t</body>" );

		pw.println ( "</html>" );

		pw.close();
  	}
}