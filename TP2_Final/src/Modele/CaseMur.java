package Modele;

/**
 * TP1 de Java Avanc� - R�alisation d'un labyrinthe en mode console
 * 
 * <p> la Classe CaseMur    h�rite de la clase CaseImplementee, elle nous permet de d�finir des objet mur dans la matrice (le dessin du labyrinthe.</p>
 * 
 * @author Lyna Fran�ois
 * 
 * @version 1.0
 *
 */


public class CaseMur extends CaseImplementee {
	
	/**
	 * Cette fonction a �t� d�fini dans la classe Case>Implementee et c'est une redefinition de la fonction car pour une instance de CaseMur,
	 *  on ne peut pas se d�placer sur la Case.
	 * 
	 * @return false dans le cas des murs, on ne peut pas se d�placer dessus
	 */
	@Override
	public boolean canMoveToCase()
	{
		return false;
	}

}
