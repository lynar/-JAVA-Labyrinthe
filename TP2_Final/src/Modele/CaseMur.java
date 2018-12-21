package Modele;

/**
 * TP1 de Java Avancé - Réalisation d'un labyrinthe en mode console
 * 
 * <p> la Classe CaseMur    hérite de la clase CaseImplementee, elle nous permet de définir des objet mur dans la matrice (le dessin du labyrinthe.</p>
 * 
 * @author Lyna François
 * 
 * @version 1.0
 *
 */


public class CaseMur extends CaseImplementee {
	
	/**
	 * Cette fonction a été défini dans la classe Case>Implementee et c'est une redefinition de la fonction car pour une instance de CaseMur,
	 *  on ne peut pas se déplacer sur la Case.
	 * 
	 * @return false dans le cas des murs, on ne peut pas se déplacer dessus
	 */
	@Override
	public boolean canMoveToCase()
	{
		return false;
	}

}
