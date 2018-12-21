package Modele;

/**
 * TP1 de Java Avancé - Réalisation d'un labyrinthe en mode console
 * 
 * <p>L'interface Case est   l'interface qui va nous permettre de déclarer les prototype des fonctions présente dans la classe CaseImplementee.</br>
 * 
 * @author Lyna François
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
	 * getter de la posibilité de se déplacer sur cette Case
	 *            
	 */
	public boolean canMoveToCase();
	
}
