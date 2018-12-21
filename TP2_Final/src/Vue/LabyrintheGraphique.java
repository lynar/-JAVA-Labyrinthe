package Vue;

import javax.swing.*;

import Controleur.FileFormatException;
import Controleur.ImpossibleMoveException;
import Controleur.Mein;
import Modele.CaseMur;
import Modele.CaseTrou;
import Modele.Labyrinthe;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.File;

import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

/**
 * TP1 de Java Avancé - Réalisation d'un labyrinthe en mode console
 * 
 * Classe LabyrintheGraphique permet d'afficher le labyrintheen mode graphique
 * C'est la classe qui met un place la grille du layrinthe et les boutons de gestion du labyrinthe
 * 
 * @author Lyna François
 * 
 * @version 1.0
 *
 */
public class LabyrintheGraphique extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JFrame background;
	public Labyrinthe labyrinth;
	public JPanel frame, back, center;
	public JLabel titre, fond;
	public JPanel menu, laby, touche;
	public JTextField text;
	public JButton dep1, dep2, dep3, dep4, button1, button2, button3, button4;
	private JLabel[][] grille;
	private static int HEIGHT = 700;
	private static int WIDTH = 1000;
	
	
	/**
	 * Constructeur surchargé de la classe qui prend un parametre un objet de la classe labyrinthe
	 * et qui met en place la grille de Jlabel qui affiche la labyrinthe
	 * qui met également en place les boutons de gestion des déplacements et qui affiche les photos
	 * @param labyrinth
	 */
	public LabyrintheGraphique (Labyrinthe labyrinth)
	{
		super("Labyrinthe");
		
		UIManager.put("OptionPane.background",Color.blue);
		
		//recuperer le chemin des photos
		ImageIcon icon1 = new ImageIcon( "C:/Users/lynar/eclipse-workspace/TP2_Final/Images/haut.png");
		ImageIcon icon2 = new ImageIcon("C:/Users/lynar/eclipse-workspace/TP2_Final/Images/bas.png");
		ImageIcon icon3 = new ImageIcon("C:/Users/lynar/eclipse-workspace/TP2_Final/Images/gauche.png");
		ImageIcon icon4 = new ImageIcon("C:/Users/lynar/eclipse-workspace/TP2_Final/Images/droite.png");		
		ImageIcon icon5 = new ImageIcon("C:/Users/lynar/eclipse-workspace/TP2_Final/Images/fond.jpg");
		
		///met en place le frame du fond avec la taille et la possibilité de fermer la fenetre
		background = new JFrame();
		this.background.setSize(WIDTH, HEIGHT);
	    this.background.setLocationRelativeTo(null);               
	    this.background.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		//mise en place du panl de fnd    
	    back = new JPanel();
	    //mise en place du panel du centre
	    center = new JPanel(new BorderLayout(20, 20));
		 frame= new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
		 this.labyrinth = labyrinth;
		 
		 //textfield pour rentrer le nom du fichier
		 text = new JTextField("Nom du fichier à charger");
		 text.addActionListener(this);
		 
		 //mise en place des boutons de déplacement
		 dep1 = new JButton("Deplacement Manuel");
		 dep1.addActionListener(this);
		 dep2 = new JButton("Deplacement Automatique");
		 dep2.addActionListener(this);
		 dep3 = new JButton("Deplacement BFS");
		 dep3.addActionListener(this);
		 
		 ///mise en place du titre de la page
		 titre= new JLabel("Labyrinthe",SwingConstants.CENTER);
		 titre.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,70));
		 titre.setForeground(Color.white);
		 titre.setOpaque(true);
		 titre.setPreferredSize(new Dimension(900, 150));
		 
		 //label du fond
		 fond = new JLabel(icon5);
		 
		 menu = new JPanel();
		 touche = new JPanel();
		 laby = new JPanel(new GridLayout(5,5));
		 menu.add(text);
		 menu.add(dep1);
		 menu.add(dep2);
		 menu.add (dep3);
		 this.menu.setOpaque(false);
		 
		 ///creation des touche de déplacement dans le labyrinthe
		 button1 = new JButton("haut", icon1);;
		 button1.addActionListener(this);
		 button2 = new JButton("droite", icon4);
		 button2.addActionListener(this);
		 button3 = new JButton("gauche", icon3);
		 button3.addActionListener(this);
		 button4 = new JButton("bas", icon2);
		 button4.addActionListener(this);
		 
		 ///pour ne pas afficher les boutons mais juste les fleches
		 	button1.setOpaque(false);
			button1.setContentAreaFilled(false);
			button1.setBorderPainted(false);
			button2.setOpaque(false);
			button2.setContentAreaFilled(false);
			button2.setBorderPainted(false);
			button3.setOpaque(false);
			button3.setContentAreaFilled(false);
			button3.setBorderPainted(false);
			button4.setOpaque(false);
			button4.setContentAreaFilled(false);
			button4.setBorderPainted(false);
		 
	
		 this.touche.setLayout(new BorderLayout());
		  
		 touche.add(button1,BorderLayout.NORTH );
		 touche.add(button2,BorderLayout.EAST);
		 touche.add(button3,BorderLayout.WEST);
		 touche.add(button4,BorderLayout.SOUTH);
		 this.touche.setOpaque(false);
		 
		 ///mise en place de la grille de label pour le labyrinthe
		 this.grille = new JLabel[5][5];
		 for (int i = 0; i < 5 ; i++)
			{
			 for (int j = 0; j < 5 ; j++)
				{
				 this.grille[i][j] = new JLabel();
				 this.laby.add(this.grille[i][j]);
				}
			}
		 
		 this.frame.add(this.laby);
		 this.frame.add(this.touche);
		 
		 this.frame.setOpaque(false);
		 
		 center.add("North", this.menu);
		 center.add("Center", this.frame);
		 this.titre.setOpaque(false);
		 this.center.setOpaque(false);
		 this.back.add(this.titre);
		 this.back.add(this.center);
		this.back.setOpaque(false);

		this.background.setContentPane(this.fond);
		this.background.getContentPane().setLayout(new BorderLayout());
		this.background.getContentPane().add(back);
		this.background.setVisible(true);
		this.frame.setVisible(false);

	}

	/**
	 * fonction qui permet l'affichage du labyrinthe en chargent les images dans la grille de Jlabel
	 * @param labyrinth
	 */
	public void afficherLabyrinthe(Labyrinthe labyrinth) 
	{
		ImageIcon icon1 = new ImageIcon( "C:/Users/lynar/eclipse-workspace/TP2_Final/Images/herbe.png");
		ImageIcon icon2 = new ImageIcon("C:/Users/lynar/eclipse-workspace/TP2_Final/Images/arbre.png");
		ImageIcon icon3 = new ImageIcon("C:/Users/lynar/eclipse-workspace/TP2_Final/Images/bandit1.png");
		ImageIcon icon4 = new ImageIcon("C:/Users/lynar/eclipse-workspace/TP2_Final/Images/robin1.png");
		
			for(int i=0; i<labyrinth.tailleX;  i++)
			{
				for (int j=0; j<labyrinth.tailleY; j++)
				{
					if(labyrinth.posX==i && labyrinth.posY==j)
					{
						this.grille[i][j].setIcon(icon4);
						
					}
					else if(labyrinth.arriveeX==i && labyrinth.arriveeY==j)
					{
						this.grille[i][j].setIcon(icon3);
					}
					else if(!labyrinth.matrice[i][j].canMoveToCase())
					{
						this.grille[i][j].setIcon(icon2);
					}
					else if(labyrinth.matrice[i][j].canMoveToCase())
					{
						this.grille[i][j].setIcon(icon1);
					}
				}
			}

	}
	


/**
 * fonction qui permet de donner un role a chaque bouton créer dans le frame
 * en fonction du nom du bouton selectionné, la tache accomplie ne sera pas la même	
 */
	@Override
	public void actionPerformed(ActionEvent e) {
boolean finish=true;
		// TODO Auto-generated method stub

		if(e.getActionCommand().equals("Deplacement Manuel"))
		{
			String name= text.getText();
			File file = new File("C:/Users/lynar/eclipse-workspace/TP2_Final/"+ name +".txt");
			try {
				labyrinth.initFromFile(file);
		        afficherLabyrinthe(labyrinth);
				this.frame.setVisible(true);	
				
			}
			catch (FileFormatException e1)
			{
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,e1.getMessage(),"WARNING",JOptionPane.WARNING_MESSAGE);
				e1.printStackTrace();
				this.frame.setVisible(false);
			}
		}
		else if(e.getActionCommand().equals("Deplacement Automatique"))
		{
			String name= text.getText();
			File file = new File("C:/Users/lynar/eclipse-workspace/TP2_Final/"+ name +".txt");
			try {
				labyrinth.initFromFile(file);
				this.frame.setVisible(true);
				while(finish==true)
			{
				afficherLabyrinthe(labyrinth);
				labyrinth.autoMove(labyrinth);
				finish=labyrinth.verifjeu(labyrinth);
				afficherLabyrinthe(labyrinth);
			}
		 if (!finish)
		    {
			 JOptionPane.showMessageDialog(null,"VOUS AVEZ GAGNE","BRAVO",JOptionPane.INFORMATION_MESSAGE);
			}
		
			} catch (FileFormatException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,e1.getMessage(),"WARNING",JOptionPane.WARNING_MESSAGE);
				//e1.printStackTrace();
				this.frame.setVisible(false);
			}
		}
		else if(e.getActionCommand().equals("Deplacement BFS"))
		{
			String name= text.getText();
			File file = new File("C:/Users/lynar/eclipse-workspace/TP2_Final/"+ name +".txt");
			try {
				labyrinth.initFromFile(file);
		        afficherLabyrinthe(labyrinth);
				this.frame.setVisible(true);
				while(finish==true)
				{
				labyrinth.BFS(labyrinth);
				afficherLabyrinthe(labyrinth);
				finish=labyrinth.verifjeu(labyrinth);
				}
			
			 if (!finish)
			    {
				 JOptionPane.showMessageDialog(null,"VOUS AVEZ GAGNE","BRAVO",JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (FileFormatException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,e1.getMessage(),"WARNING",JOptionPane.WARNING_MESSAGE);
				e1.printStackTrace();
			}
		}
		else if(e.getActionCommand().equals("haut"))
		{
			try {
				labyrinth.DepTouche(labyrinth, 8);
				 afficherLabyrinthe(labyrinth);
				 finish=labyrinth.verifjeu(labyrinth);
				 if (!finish)
				    {
					 JOptionPane.showMessageDialog(null,"VOUS AVEZ GAGNE","BRAVO",JOptionPane.INFORMATION_MESSAGE);
					}
			} catch (ImpossibleMoveException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,e1.getMessage(),"WARNING",JOptionPane.WARNING_MESSAGE);
				e1.printStackTrace();
			}
		}
		else if(e.getActionCommand().equals("droite"))
		{
			try {
				labyrinth.DepTouche(labyrinth, 6);
				finish=labyrinth.verifjeu(labyrinth);
				 afficherLabyrinthe(labyrinth);
				 if (!finish)
				    {
					 JOptionPane.showMessageDialog(null,"VOUS AVEZ GAGNE","BRAVO",JOptionPane.INFORMATION_MESSAGE);
					}
			} catch (ImpossibleMoveException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,e1.getMessage(),"WARNING",JOptionPane.WARNING_MESSAGE);
				e1.printStackTrace();
			}
		}
		else if(e.getActionCommand().equals("gauche"))
		{
			try {
				labyrinth.DepTouche(labyrinth, 4);
				 afficherLabyrinthe(labyrinth);
				 finish=labyrinth.verifjeu(labyrinth);
				 if (!finish)
				    {
				    	JOptionPane.showMessageDialog(null,"VOUS AVEZ GAGNE","BRAVO",JOptionPane.INFORMATION_MESSAGE);
					}
			} catch (ImpossibleMoveException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,e1.getMessage(),"WARNING",JOptionPane.WARNING_MESSAGE);
				e1.printStackTrace();
			}
		}
		else if(e.getActionCommand().equals("bas"))
		{
			try {
				labyrinth.DepTouche(labyrinth, 2);
				 afficherLabyrinthe(labyrinth);
				 finish=labyrinth.verifjeu(labyrinth);
				 if (!finish)
				    {
				    	JOptionPane.showMessageDialog(null,"VOUS AVEZ GAGNE","WINNING MESSAGE",JOptionPane.INFORMATION_MESSAGE);
					}
			} catch (ImpossibleMoveException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,e1.getMessage(),"WARNING",JOptionPane.WARNING_MESSAGE);
				e1.printStackTrace();
			}
		}
	}
	

}
