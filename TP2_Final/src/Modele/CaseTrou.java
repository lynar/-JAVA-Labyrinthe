package Modele;

/**
 * TP1 de Java Avanc� - R�alisation d'un labyrinthe en mode console
 * 
 * <p> la Classe CaseTrou    h�rite de la clase CaseImplementee, elle nous permet de d�finir des objet libre dans la matrice (le dessin du labyrinthe.</p>
 * 
 * @author Lyna Fran�ois
 * 
 * @version 1.0
 *
 */

public class CaseTrou extends CaseImplementee {
	
	/**
	 * Cette fonction a �t� d�fini dans la classe CaseImplementee et c'est une redefinition de la fonction car pour une instance de CaseTrou,
	 *  on peut se d�placer sur la Case.
	 * 
	 * @return true dans le cas des trous, on peut se d�placer dessus
	 */
	@Override
	public boolean canMoveToCase()
	{
		return true;
	}

}
