package Controleur;

/**
 * TP1 de Java Avancé - Réalisation d'un labyrinthe en mode console
 * 
 * Déclenche l’exception FileFormatException si le fichier ne peut être lu ou si son format est incorrect
 * Cette classe hérite de la classe java Exception qui permet de renvoyer le message d'erreur en cas d'exception de lecture du fichier
 * 
 * @author Lyna François
 * 
 * @version 1.0
 *
 */

public class FileFormatException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * fonction qui affiche le message d'erreur en cas d'exception pour nous spécifier le type d'erreur (exception)
	 */
	@Override
	public String getMessage(){
		String s = "Lecture de fichier impossible";
		return s;
		
	}
	
	/**
	 * Constructeur de FileFormatException qui appelle la classe mere grace à l'utilisation de la fonction super()
	 */
	public FileFormatException(){
		super();
	}

}
