package Modele;

/**
 * TP1 de Java Avanc� - R�alisation d'un labyrinthe en mode console
 * 
 * <p>L'interface Case est   l'interface qui va nous permettre de d�clarer les prototype des fonctions pr�sente dans la classe CaseImplementee.</br>
 * 
 * @author Lyna Fran�ois
 * 
 * @version 1.0
 *
 */

public interface Case {
	
	/**
	 * getter de la position en abscisse de l'objet CaseImplementee
	 *            
	 */
	public int getPositionX();
	
	/**
	 * getter de la position en ordonnee de l'objet CaseImplementee
	 *            
	 */
	public int getPositionY();
	
	/**
	 * getter de la posibilit� de se d�placer sur cette Case
	 *            
	 */
	public boolean canMoveToCase();
	
}
