package Controleur;

/**
 * TP1 de Java Avancé - Réalisation d'un labyrinthe en mode console
 * 
 * Cette classe a été crée pour y inséré la fonction main. Elle appelle la classe Menu pour l'affichage du menu et contient les foncton de lecture du fichier.
 * et du choix de type de déplacement dans le labyrinthe, manuel, automatique aléatoire ou BFS
 * 
 * @author Lyna François
 * 
 * @version 1.0
 *
 */

import java.io.File;
import java.util.Scanner;

import Modele.Labyrinthe;
import Vue.LabyrintheGraphique;
import Vue.Menu;

public class Mein {
	
/**
 * Cette fonction a pour but de demander a lutilisateur de saisir le nom du fichier qu'il veut lire et de l'enregistree dans la matrice de Case
 * 
 * @param labyrinth
 * 		reçoit en parametre le labyrinthe car la fonction de lecture du fichier texte est dans la classe labyrinthe
 * @throws FileFormatException
 * 		cette exception est déclenché en cas de probbleme de leture du fichier texte
 */
public void ouvrirfichier(Labyrinthe labyrinth, Mein main) throws FileFormatException
{
	Scanner sc= new Scanner(System.in);
	System.out.println("Veuillez saisir le nom du fichier text:");
	String filename = sc.nextLine();
	File file = new File("C:/Users/lynar/eclipse-workspace/TP2_Final"+ filename +".txt");
	labyrinth.initFromFile(file, labyrinth, main);
	//sc.close();
}

/**
 * Cette fonction est liée au menu que voit l'utilisateur, elle permet de valider le choix de l'utilisateur et de lancer la boucle de jeu en fonction
 * du choix de l'utilisateur
 * 
 * @param choix
 * 		Saisi de l'utilisateur pour lancer la boucle de jeu
 * @throws FileFormatException
 * 		exception qui apparait en cas de probleme de lecture du fichier texte
 * @throws ImpossibleMoveException
 * 		exception qui apparait en cas de mouvement dans le labyrinthe qui sont impossibles
 */
public void choixDeplacement(int choix, Mein main) throws FileFormatException, ImpossibleMoveException
{
	Labyrinthe labyrinth=new Labyrinthe();
	Menu Menu = new Menu();
	boolean finish=true;

switch (choix)
	{
	case 1:
		System.out.println("Choix du déplacement manuel");
		ouvrirfichier(labyrinth, main);
		while(finish==true)
		{Menu.afficherLabyrinthe(labyrinth);
		DepTouche(labyrinth);
		finish=verifjeu(labyrinth);
		}
		System.out.println();
		break;
	case 2:
		System.out.println("Choix du déplacement aléatoire");
		ouvrirfichier(labyrinth, main);
		while(finish==true)
		{Menu.afficherLabyrinthe(labyrinth);
		labyrinth.autoMove(labyrinth);
		finish=verifjeu(labyrinth);
		}
		System.out.println();
		break;
	case 3:
		System.out.println("Choix du déplacement intelligent");
		ouvrirfichier(labyrinth, main);
	while(finish==true)
		{
		labyrinth.BFS(labyrinth);
		finish=verifjeu(labyrinth);
		}
		System.out.println();
		break;
	case 4:
		System.out.println("A bientôt");
		System.exit(1);
		break;
	}


}

/**
 * Fonction qui permet le déplacement manuel dans le labyrinthe, c'est l'utilisateur qui choisit ou il veut aller
 * 
 * @param labyrinth
 * 		reçoit en parametre le labyrinthe car la fonction de lecture du fichier texte est dans la classe labyrinthe
 * @throws ImpossibleMoveException
 * 		cette exception est déclenché en cas de déplacement impossible
 */
public void DepTouche(Labyrinthe labyrinth) throws ImpossibleMoveException
{
	Scanner sc= new Scanner(System.in);
	int x=0;
	int y=0;
	System.out.println("Veuillez choisir un sens de déplacement");
	System.out.println("- 8 pour aller vers le haut,");
	System.out.println("- 4 pour aller vers la gauche,");
	System.out.println("- 6 pour aller vers la droite,");
	System.out.println("- 2 pour aller vers le bas.");
	
	int choice = sc.nextInt();
	
	switch (choice)
	{
	case 8:
	try
	{	//j--
		x=labyrinth.posX-1;
		y=labyrinth.posY;
           labyrinth.move(x, y);
           
	}
	catch(ImpossibleMoveException e)
	{
		System.out.println("Erreur " +e.getMessage());
	}
		break;
		
	case 4:
	try
	{
		//I--
		x=labyrinth.posX;
		y=labyrinth.posY-1;
		labyrinth.move(x,y);
	}
	catch(ImpossibleMoveException e)
	{
		System.out.println("Erreur " +e.getMessage());
	}
		break;
		
	case 2:
	try
	{//i++
		x=labyrinth.posX+1;
		y=labyrinth.posY;
		labyrinth.move(x,y);
	}
	catch(ImpossibleMoveException e)
	{
		System.out.println("Erreur " +e.getMessage());
	}
		break;
		
	case 6:
	try
	{//j++
		x=labyrinth.posX;
		y=labyrinth.posY+1;
		labyrinth.move(x,y);
	}
	catch(ImpossibleMoveException e)
	{
		System.out.println("Erreur " +e.getMessage());
	}
		break;
	
	default:
		System.out.println("Votre saisie est invalide");
		break;
		
		
		
	}
	//source.close();
}



/**
 * Cette fonction permet de déterminer si le jeu est fini ou non, en renvoyeant un boolean pour determiner si position 
 * du joueur est celle du point d'arrivée ou non
 * 
 * @param labyrinth
 * 		reçoit en parametre le labyrinthe car la fonction de lecture du fichier texte est dans la classe labyrinthe
 * @return true or false en fonction de si la position du joueur est celle du point d'arrivée ou non
 */
public boolean verifjeu(Labyrinthe labyrinth)
{
	if((labyrinth.posX==labyrinth.arriveeX) && (labyrinth.posY==labyrinth.arriveeY))
	{
		System.out.println("Vous avez gagné");
		return false;
	}
	else
		return true;
}
	
	/**
	 * Fonction main qui permet le lancement du programme
	 * 
	 * @param args
	 * 		Parametre de base de la fonction main
	 * @throws FileFormatException
	 * 		exception qui apparait en cas de probleme de lecture du fichier texte
	 * @throws ImpossibleMoveException
     * 		exception qui apparait en cas de mouvement dans le labyrinthe qui sont impossibles
	 */
/*	public static void main(String[] args) throws FileFormatException, ImpossibleMoveException
	{
		while(true)
		{Mein main= new Mein();
		Menu menu= new Menu(main);
		
		}
	}*/

public static void main(String[] args) throws FileFormatException, ImpossibleMoveException
{
	Labyrinthe laby= new Labyrinthe();
	new LabyrintheGraphique(laby);
}
	

}
