package Modele;

/**
 * TP1 de Java Avancé - Réalisation d'un labyrinthe en mode console
 * 
 * Classe Labyrinthe permet de faire l'utilisateur dans le labyrinthe
 * C'est la classe qui contient tous les algorithme de déplacement
 * Et les fonctions de verification de la possibilité d'aller sur une classe
 * 
 * @author Lyna François
 * 
 * @version 1.0
 *
 */

import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.JOptionPane;

import Controleur.FileFormatException;
import Controleur.ImpossibleMoveException;
import Controleur.Mein;
import Vue.Menu;


public class Labyrinthe {
	

	//attributs privés
	/**
	 * TailleX représente la taille en abscisse de la matrice de Case
	 */
		public int tailleX, tailleY;
		/**
		 * TailleY représente la taille en ordonnee de la matrice de Case
		 */
		
		/**
		 * departX représente la coordonnée en X du point de départ du labyrinthe
		 */
		public int departX, departY;
		/**
		 * departY représente la coordonnée en Y du point de départ du labyrinthe
		 */
		
		/**
		 * arriveeX represente la coordonnee en X du point d'arrivee du labyrinthe
		 */
		public int arriveeX, arriveeY;
		/**
		 * arriveeY represente la coordonnee en Y du point d'arrivee du labyrinthe
		 */
		
		/**
		 * posX représente la position en X de nimporte quelle case
		 */
		public int posX, posY;
		/**
		 * posY représente la position en Y de nimporte quelle case
		 */
		
		//attributs publics
		/**
		 * attributs de la matrice de CaseImplementee
		 */
		public CaseImplementee[][] matrice;
		
		//méthodes
		
		/**
		 * Lit un labyrinthe avec un fichier en paramètre (voir classe File en annexe) au format décrit plus haut
		 * Initialise tous les attributs avec les valeurs lues dans le fichier puis instancie la collection de cases et chaque case
		 * Déclenche l’exception FileFormatException si le fichier ne peut être lu ou si son format est incorrect
		 * 
		 * @param labFile
		 * 		Nom du fichier texte qui contient le schéma du labyrinthe
		 * @throws FileFormatException
		 * 		cette exception est déclenché en cas de probbleme de leture du fichier texte
		 */
		public void initFromFile(File labFile,Labyrinthe labyrinth, Mein main) throws FileFormatException{
			
			try{
				Scanner sc = new Scanner(labFile);
				tailleX = sc.nextInt();
				tailleY = sc.nextInt();
				posX = departX = sc.nextInt();
				posY = departY = sc.nextInt();
				arriveeX = sc.nextInt();
				arriveeY = sc.nextInt();
				matrice = new CaseImplementee[tailleX][tailleY];
				
				String linefile;
				//lire les cases du labyrinthe
				for (int i=0; i<tailleX; i++)
				{
					linefile=sc.next();
					for (int j=0; j<tailleX; j++)
					{
						if(linefile.charAt(j)=='X')
						{
							matrice[i][j]= new CaseMur();
						}
						if(linefile.charAt(j)=='_')	
						{
							matrice[i][j]= new CaseTrou();
						}
					}
				}
				
				sc.close();
				
			}//fin try
			
			catch (FileNotFoundException e)
			{
				System.out.println("Erreur "+ e.getMessage());
				JOptionPane.showMessageDialog(null,e.getMessage(),"WARNING",JOptionPane.WARNING_MESSAGE);
				//main.ouvrirfichier(labyrinth, main);
				//throw new FileFormatException();
		    }
		}
		
public void initFromFile(File labFile) throws FileFormatException{
			
			try{
				Scanner sc = new Scanner(labFile);
				tailleX = sc.nextInt();
				tailleY = sc.nextInt();
				posX = departX = sc.nextInt();
				posY = departY = sc.nextInt();
				arriveeX = sc.nextInt();
				arriveeY = sc.nextInt();
				matrice = new CaseImplementee[tailleX][tailleY];
				
				String linefile;
				//lire les cases du labyrinthe
				for (int i=0; i<tailleX; i++)
				{
					linefile=sc.next();
					for (int j=0; j<tailleX; j++)
					{
						if(linefile.charAt(j)=='X')
						{
							matrice[i][j]= new CaseMur();
						}
						if(linefile.charAt(j)=='_')	
						{
							matrice[i][j]= new CaseTrou();
						}
					}
				}
				
				sc.close();
				
			}//fin try
			
			catch (FileNotFoundException e)
			{
				System.out.println("Erreur "+ e.getMessage());
				JOptionPane.showMessageDialog(null,e.getMessage(),"WARNING",JOptionPane.WARNING_MESSAGE);
				//throw new FileFormatException();
		    }
		}
			
		/** 
		 * Tente de bouger le curseur dans la case (x, y) en paramètres. Déclenche l’exception ImpossibleMoveException si la
		 * case déborde du labyrinthe ou si on ne peut pas aller dans la case :
		 * voir la méthode canMoveToCase() de la classe Case 
		 * 
		 * @param x
		 * 		Ces deux parametres représentent les nouvelles position que va prendre l'utilisateur en se déplaceant
		 *  @param y
		 *  	Ces deux parametres représentent les nouvelles position que va prendre l'utilisateur en se déplaceant
		 * @throws ImpossibleMoveException
		 * 		exception qui apparait en cas de mouvement dans le labyrinthe qui sont impossibles
		 * 
		 * */
		public void move(int x, int y) throws ImpossibleMoveException
		{
			try
			{
			//cas de débordement
			if (x<0 || (x>tailleX) || y<0 || (y>tailleY))
				{
				throw new ImpossibleMoveException();
				}
			
			else if((matrice[x][y].canMoveToCase())==false)
				{
				throw new ImpossibleMoveException();
				}
		
			else
				{
				posX = x;
				posY = y;
				}
			}
			catch(ImpossibleMoveException e)
			{
				System.out.println("Erreur " +e.getMessage());
				JOptionPane.showMessageDialog(null,e.getMessage(),"WARNING",JOptionPane.WARNING_MESSAGE);
			}
		}


		
		/**
		 *  Se déplace aléatoirement d’une seule case (direction en x et y aléatoire) de la position 
		 *  courante (posX, posY) sauf si ce déplacement sort du labyrinthe ou va dans un mur 
		 *  
		 *  @param labyrinth
		 *  	reçoit en parametre le labyrinthe car la fonction de lecture du fichier texte est dans la classe labyrinthe
		 *  */
		public void autoMove(Labyrinthe labyrinth){
			Random r = new Random();
			int valeur = 0 + r.nextInt(4 - 0);
			System.out.println("" + valeur);
				switch (valeur)
				{
				case 0:
					//j--
					if (labyrinth.posX-1<0 || labyrinth.posX-1>tailleX || labyrinth.posY<0 || labyrinth.posY>tailleY)
					{System.out.println("Direction impossible");}
					
					else if(matrice[labyrinth.posX-1][labyrinth.posY].canMoveToCase()==false)
						{System.out.println("Direction impossible");}
					
					else{
						posX=labyrinth.posX-1;
						posY=labyrinth.posY;
					}

					break;
					
				case 1:
					//I--
					if (labyrinth.posX<0 || labyrinth.posX>tailleX || labyrinth.posY-1<0 || labyrinth.posY-1>tailleY)
					{System.out.println("Direction impossible");}
					
					else if(matrice[labyrinth.posX][labyrinth.posY-1].canMoveToCase()==false)
						{System.out.println("Direction impossible");}
					
					else{
						posX=labyrinth.posX;
						posY=labyrinth.posY-1;
					}

					break;
					
				case 2:
					//i++
					if (labyrinth.posX+1<0 || labyrinth.posX+1>=tailleX || labyrinth.posY<0 || labyrinth.posY>tailleY)
					{System.out.println("Direction impossible");}
					
					else if(matrice[labyrinth.posX+1][labyrinth.posY].canMoveToCase()==false)
						{System.out.println("Direction impossible");}
					
					else{
						posX=labyrinth.posX+1;
						posY=labyrinth.posY;
					}
					break;
					
				case 3:
					//j++
					if (labyrinth.posX<0 || labyrinth.posX>tailleX || labyrinth.posY+1<0 || labyrinth.posY+1>=tailleY)
					{System.out.println("Direction impossible");}
					
					else if(matrice[labyrinth.posX][labyrinth.posY+1].canMoveToCase()==false)
						{System.out.println("Direction impossible");}
					
					else{
						posX=labyrinth.posX;
						posY=labyrinth.posY+1;
					}
					break;
				
				default:
					System.out.println("Votre saisie est invalide");
					break;
			}
		}
		
		/**
		 * Classe structure qui permet lutilisation des deux position simultanément
		 */
		class struct{ int posX; int posY;}
		
		/**
		 * Fonction qui permet le parcourt du labyrinthe par un BFS affin de trouver le plus court chein. Cette fonction utilise la Stack (file)
		 * pour enfiler les différentes cases (les positions de ces cases)
		 * 
		 * @param menu
		 * 		le menu est en parametre pour permettre un affichage noeud par noeud du resultat avec l'utilisation de la fonction afficherLabyrinthe
		 * @param labyrinth
		 * 		le menu est en parametre pour permettre un affichage noeud par noeud du resultat avec l'utilisation de la fonction afficherLabyrinthe
		 */
		public void BFS(Labyrinthe labyrinth) 
		{
			//Creation
			struct posE = new struct();//pos enregistré
			Stack<struct> stack= new Stack<struct>();
			struct marked[]= new struct[60];//retient endroit où on est deja passé
			boolean aPush=false, youCan2=false, isMarked=false;
			int iMarked=0;
			
			marked[0]=new struct();
			//Initialisation
			for(int a=0; a<marked.length;a++)
			{marked[a]=new struct(); marked[a].posX=7; marked[a].posY=7; }
			posE = new struct();
			posE.posX=posX;
			posE.posY=posY;
			stack.push(posE);
			
			//Start AI
			while(stack.peek().posX!=arriveeX||stack.peek().posY!=arriveeY)//tant que pas arrivé au point d'arrivé
			{
				if(aPush==true) { aPush=false;}//si on a pushé dans la stack la nouvelle position, rinitiallisé afin de redemarrer les directions de zero
				
				while(aPush==false)
				{
					for(int direct=0;direct<4;direct++)//pour changer de direction
					{
						isMarked=false;
						if (direct == 0) {
								
								for(int b=0;b<iMarked+1;b++)//verification que ca n'existe pas deja
								{
									if(marked[b].posX==(posX+1) && marked[b].posY==posY ){isMarked=true;b=iMarked+2;} 
									else {isMarked=false;}
									}
									
									if(isMarked==false )
									{
										marked[iMarked].posX=posX+1; 
										marked[iMarked].posY=posY;
										iMarked++;
										youCan2=Testmove(posX+1,posY);
										if(youCan2==true)
										{	posE = new struct();
											posE.posX=posX;
											posE.posY=posY;
											stack.push(posE);
										
											aPush=true;
											direct=4;
										}else aPush=false;
										
									}isMarked=false;
								
						}
						else if (direct == 1) {
								
								for(int b=0;b<iMarked+1;b++)
								{
									if(marked[b].posX==posX && marked[b].posY==posY+1 ){isMarked=true;b=iMarked+2;} 
									else {isMarked=false;}
								}
									if(isMarked==false)
									{
										marked[iMarked].posX=posX; 
										marked[iMarked].posY=posY+1;
										iMarked++;
										youCan2=Testmove(posX,posY+1);
										if(youCan2==true)
										{	posE = new struct();
											posE.posX=posX;
											posE.posY=posY;
											stack.push(posE);
											
											aPush=true;
											direct=4;
										}else aPush=false;
									}isMarked=false;
						}
						else if (direct == 2) {
								
								for(int b=0;b<iMarked+1;b++)
								{
									if(marked[b].posX==posX-1 && marked[b].posY==posY ){isMarked=true;b=iMarked+2;} 
									else {isMarked=false;}
								}
									if(isMarked==false)
									{
										marked[iMarked].posX=posX-1; 
										marked[iMarked].posY=posY;
										iMarked++;
										youCan2=Testmove(posX-1,posY);
										if(youCan2==true)
										{	posE = new struct();
											posE.posX=posX;
											posE.posY=posY;
											stack.push(posE);
											
											aPush=true;
											direct=4;
										}else aPush=false;
										
								}isMarked=false;

						}
						else if (direct == 3) {

								
								for(int b=0;b<iMarked+1;b++)
								{
									if(marked[b].posX==posX && marked[b].posY==posY-1 ){isMarked=true;b=iMarked+2;} 
									else {isMarked=false;}
								}
									if(isMarked==false)
									{
										marked[iMarked].posX=posX; 
										marked[iMarked].posY=posY-1;
										iMarked++;
										youCan2=Testmove(posX,posY-1);
										if(youCan2==true)
										{	posE = new struct();
											posE.posX=posX;
											posE.posY=posY;
											stack.push(posE);
											
											aPush=true;
											direct=4;
										}
								}else if(aPush==false) 
								{stack.pop(); 
								posX=stack.peek().posX; 
								posY=stack.peek().posY; 
								aPush=true;}	
		
						}
					
					}
					
				}
				
			}
			
		}
		
		/**
		 * Cette fonction est similaire a la fonction move de la classe labyrinthe, mais contrairement a move qui est une fonction void, Testmove retourne
		 * un boolean pour savoir si il est possible d'aller sur la case ou non.
		 * 
		 * @param x
		 * 		position en abscisse qui sera prise
		 * @param y
		 * 		position en ordonnee qui sera prise
		 * @return un boolean true or false, pour savoir si l'on peut se déplacer ou non sur la case et si oui donner des nouvelles coordonnées au point 
		 * de départ
		 */
		public boolean Testmove(int x, int y){
			boolean youCan=false;
			
			if ((x < 0 || y < 0 || x >= tailleX || y >= tailleY)) {
				System.out.println("Direction impossible");
			} else if (!matrice[x][y].canMoveToCase()) { 
				youCan=false;

			} else if (matrice[x][y].canMoveToCase()) {
				youCan=true;
				posX = x;
				posY = y;
			}
			return youCan;

		}
		
		
		//setters & getters
		/**
		 * getter qui recupere la position actuel en X
		 * @return posX
		 */
		public int getCurrentPositionX(){// Donne la position courante en posX
			return posX;
		}
		
		
		/**
		 * getter qui recupere la position actuel en Y
		 * @return posY
		 */
		public int getCurrentPositionY(){// Donne la position courante en posY
			return posY;
		}
		

		public void DepTouche(Labyrinthe labyrinth, int choice) throws ImpossibleMoveException
		{
			int x=0;
			int y=0;
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
				
			}
		/**
		 * Fonction de verification de la fin du jeu renvoie un boulean a la boucle de jeu
		 * @param labyrinth
		 * @return boolean qui permett de dire si le jeu est fini ou non
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

}


