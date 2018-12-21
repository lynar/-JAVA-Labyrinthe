package Modele;

/**
 * TP1 de Java Avancé - Réalisation d'un labyrinthe en mode console
 * 
 * <p> la Classe CaseTrou    hérite de la clase CaseImplementee, elle nous permet de définir des objet libre dans la matrice (le dessin du labyrinthe.</p>
 * 
 * @author Lyna François
 * 
 * @version 1.0
 *
 */

public class CaseTrou extends CaseImplementee {
	
	/**
	 * Cette fonction a été défini dans la classe CaseImplementee et c'est une redefinition de la fonction car pour une instance de CaseTrou,
	 *  on peut se déplacer sur la Case.
	 * 
	 * @return true dans le cas des trous, on peut se déplacer dessus
	 */
	@Override
	public boolean canMoveToCase()
	{
		return true;
	}

}
