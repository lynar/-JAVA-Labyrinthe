package Controleur;

/**
 * TP1 de Java Avanc� - R�alisation d'un labyrinthe en mode console
 * 
 * Cette classe permet de d�clencher l�exception ImpossibleMoveException si la
 * case d�borde du labyrinthe ou si on ne peut pas aller dans la case.
 * Cette classe h�rite de la classe java Exception qui permet de renvoyer le message d'erreur en cas d'exception de mouvement
 * 
 * @author Lyna Fran�ois
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
	 * fonction qui affiche le message d'erreur en cas d'exception pour nous sp�cifier le type d'erreur (exception)
	 */
	@Override
	public String getMessage(){
		String s = "D�placement impossible";
		return s;
		
	}
	
	/**
	 * Constructeur de ImpossibleMovetException qui appelle la classe mere grace � l'utilisation de la fonction super()
	 */
	public ImpossibleMoveException(){
		super();
	}
	

}
