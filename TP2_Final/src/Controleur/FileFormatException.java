package Controleur;

/**
 * TP1 de Java Avanc� - R�alisation d'un labyrinthe en mode console
 * 
 * D�clenche l�exception FileFormatException si le fichier ne peut �tre lu ou si son format est incorrect
 * Cette classe h�rite de la classe java Exception qui permet de renvoyer le message d'erreur en cas d'exception de lecture du fichier
 * 
 * @author Lyna Fran�ois
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
	 * fonction qui affiche le message d'erreur en cas d'exception pour nous sp�cifier le type d'erreur (exception)
	 */
	@Override
	public String getMessage(){
		String s = "Lecture de fichier impossible";
		return s;
		
	}
	
	/**
	 * Constructeur de FileFormatException qui appelle la classe mere grace � l'utilisation de la fonction super()
	 */
	public FileFormatException(){
		super();
	}

}
