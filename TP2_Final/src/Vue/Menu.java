package Vue;

/**
 * TP1 de Java Avancé - Réalisation d'un labyrinthe en mode console
 * 
 * Cette classe permet l'affichage du Menu et du labyrinthe
 * 
 * @author Lyna François
 * 
 * @version 1.0
 *
 */

import java.util.Scanner;

import Controleur.FileFormatException;
import Controleur.ImpossibleMoveException;
import Controleur.Mein;
import Modele.Labyrinthe;

public class Menu {
	


	/**
	 * Cette fonction est une constructeur surchargé de Menu, il permet l'affichage du menu.
	 * 
	 * @param main
	 * 		l'affichage ce fait en utilisant un objet de la classe Mein
	 * @throws FileFormatException
	 * 		cette exception est déclenché en cas de probbleme de leture du fichier texte
	 * @throws ImpossibleMoveException
	 * 		exception qui apparait en cas de mouvement dans le labyrinthe qui sont impossibles
	 */
	public Menu(Mein main) throws FileFormatException, ImpossibleMoveException
	{
		affichageMenu(main);
	}
	
	/**
	 * Cette fonction affiche le menu
	 * 
	 * @param main
	 * 		l'affichage ce fait en utilisant un objet de la classe Mein
	 * @throws FileFormatException
	 * 		cette exception est déclenché en cas de probbleme de leture du fichier texte
	 * @throws ImpossibleMoveException
	 * 		exception qui apparait en cas de mouvement dans le labyrinthe qui sont impossibles
	 */
	public void affichageMenu(Mein main) throws FileFormatException, ImpossibleMoveException
	{
       Scanner sc = new Scanner(System.in);
		
		System.out.println("Veuillez faire un choix pour trouver la sortie du Labyrithe:");
		System.out.println("1- Déplacement manuel");
		System.out.println("2- Déplacement automatique aléatoire");
		System.out.println("3- Déplacement automatique par BFS");
		System.out.println("4- Quitter jeu");
		int choix = sc.nextInt();
		main.choixDeplacement(choix, main);
		//sc.close();
	}
	
	/**
	 * Constructeur de Menu
	 */
	public Menu() 
	{
	}

	/**
	 * Fonction qui affiche la labyrinthe sur la console
	 * 
	 * @param labyrinth
	 * 		reçoit en parametre le labyrinthe car la fonction de lecture du fichier texte est dans la classe labyrinthe
	 */
	public static void afficherLabyrinthe(Labyrinthe labyrinth) 
	{
			for(int i=0; i<11;i++)
			{ 
				System.out.print('_');	
			}
			System.out.println();
			for(int i=0; i<labyrinth.tailleX;  i++)
			{
				for (int j=0; j<labyrinth.tailleY; j++)
				{
					System.out.print('|');
					if(labyrinth.posX==i && labyrinth.posY==j)
					{
						System.out.print('D');
					}
					else if(labyrinth.arriveeX==i && labyrinth.arriveeY==j)
					{
						System.out.print('A');
					}
					else if(!labyrinth.matrice[i][j].canMoveToCase())
					{
						System.out.print('X');
					}
					else if(labyrinth.matrice[i][j].canMoveToCase())
					{
						System.out.print('_');
					}
				}
				System.out.print('|');
				System.out.println();
			}

	}
	

	
	
}
