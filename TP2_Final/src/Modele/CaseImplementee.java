package Modele;

/**
 * TP1 de Java Avanc� - R�alisation d'un labyrinthe en mode console
 * 
 * <p> La classe CaseImplementee est la classe qui va nous permettre de g�n�rer une matrice d'abjet.
 * Elle contient plusieurs attributs qui sont en protected car c'est une classe m�re pour deux autres classes filles que nous verrons pas la suite.</p>
 * <p> Cette classe implements une interface: Case.</p>
 * 
 * @see Case
 * 
 * @author Lyna Fran�ois
 * 
 * @version 1.0
 *
 */

public class CaseImplementee implements Case {
	
	/**
     * la positions X repr�sente la position en abscisse de la case
     * 
     * @see CaseImplementee#getPositionX()
     * 
     */
	protected int posX, posY;
	/**
     * la positions Y repr�sente la position en ordonn�e de la case
     * 
     * @see CaseImplementee#getPositionY()
     * 
     */
	
	/**
     * le boolean vasy, permet de d�terminer si on peut se d�placer sur la case ou non
     * 
     * @see CaseImplementee#canMoveToCase()
     * 
     */
	protected boolean vasy;
	
	/**
	 * constructeur surcharg� de la classe CaseImplementee qui est utilis� pour la cr�aation de case 'noeud' dans l'algorithme du BFS.
	 * 
	 * @param x,y
	 *            correspondent aux nouvelles positions de la case.
	 */
	public CaseImplementee(int x,int y)
	{
		posX=x;
		posY=y;
	}
	
	/**
	 * constructeur dont l'implementation est necessaire � partir du moment ou nous avons eu besoin de cr�er un constructeur surcharg�.
	 * En effet, ce constructeur correspond au constructeur par d�faut que nous utilisions sans implementation initialement avant la cr�ation 
	 * du constructeur surcharg�
	 *           
	 */
	public CaseImplementee()
	{
		
	}
	
	
	/**
	 * getter de la position en abscisse de l'objet CaseImplementee
	 * @return posX la position en abscisse de l'instance de la classe, retourne un int
	 *            
	 */
	public int getPositionX(){
		return posX;
	}
	
	/**
	 * getter de la position en ordonnee de l'objet CaseImplementee
	 * @return posY la position en ordonnee de l'instance de la classe, retourne un int
	 *            
	 */
	public int getPositionY(){
		return posY;
	}
	
	/**
	 * getter de la posibilit� de se d�placer sur cette Case
	 * @return vasy un boolean qui autorise ou non a se d�placer sur la case
	 * Cette fonction est red�finit plus tard dans d'autre classes
	 *            
	 */
	public boolean canMoveToCase(){
		return vasy;
	}
	


}
