package Modele;

/**
 * TP1 de Java Avancé - Réalisation d'un labyrinthe en mode console
 * 
 * <p> La classe CaseImplementee est la classe qui va nous permettre de générer une matrice d'abjet.
 * Elle contient plusieurs attributs qui sont en protected car c'est une classe mère pour deux autres classes filles que nous verrons pas la suite.</p>
 * <p> Cette classe implements une interface: Case.</p>
 * 
 * @see Case
 * 
 * @author Lyna François
 * 
 * @version 1.0
 *
 */

public class CaseImplementee implements Case {
	
	/**
     * la positions X représente la position en abscisse de la case
     * 
     * @see CaseImplementee#getPositionX()
     * 
     */
	protected int posX, posY;
	/**
     * la positions Y représente la position en ordonnée de la case
     * 
     * @see CaseImplementee#getPositionY()
     * 
     */
	
	/**
     * le boolean vasy, permet de déterminer si on peut se déplacer sur la case ou non
     * 
     * @see CaseImplementee#canMoveToCase()
     * 
     */
	protected boolean vasy;
	
	/**
	 * constructeur surchargé de la classe CaseImplementee qui est utilisé pour la créaation de case 'noeud' dans l'algorithme du BFS.
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
	 * constructeur dont l'implementation est necessaire à partir du moment ou nous avons eu besoin de créer un constructeur surchargé.
	 * En effet, ce constructeur correspond au constructeur par défaut que nous utilisions sans implementation initialement avant la création 
	 * du constructeur surchargé
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
	 * getter de la posibilité de se déplacer sur cette Case
	 * @return vasy un boolean qui autorise ou non a se déplacer sur la case
	 * Cette fonction est redéfinit plus tard dans d'autre classes
	 *            
	 */
	public boolean canMoveToCase(){
		return vasy;
	}
	


}
