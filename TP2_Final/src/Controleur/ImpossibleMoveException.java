package Controleur;

/**
 * TP1 de Java Avancé - Réalisation d'un labyrinthe en mode console
 * 
 * Cette classe permet de déclencher l’exception ImpossibleMoveException si la
 * case déborde du labyrinthe ou si on ne peut pas aller dans la case.
 * Cette classe hérite de la classe java Exception qui permet de renvoyer le message d'erreur en cas d'exception de mouvement
 * 
 * @author Lyna François
 * 
 * @version 1.0
 *
 */

public class ImpossibleMoveException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * fonction qui affiche le message d'erreur en cas d'exception pour nous spécifier le type d'erreur (exception)
	 */
	@Override
	public String getMessage(){
		String s = "Déplacement impossible";
		return s;
		
	}
	
	/**
	 * Constructeur de ImpossibleMovetException qui appelle la classe mere grace à l'utilisation de la fonction super()
	 */
	public ImpossibleMoveException(){
		super();
	}
	

}
