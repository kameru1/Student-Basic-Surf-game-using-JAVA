import java.util.Stack;
import java.util.HashMap;
/**
 * Write a description of class Player here.
 *
 * @author (kamel)
 * @version (2021)
 */
public class Player
{
    private Room aCurrentRoom;
    private Stack<Room> aBackRoom;
    private String pNomPlayer;
    private ItemList aSac;
    private int aMax=100;
    private int aPas; 
    /**
     * constructeur de la classe Player
     * @param pName
     */
    public Player(final String pName)
    {
        this.pNomPlayer=pName;
        this.aBackRoom=new Stack();
        //this.aItemSac=new HashMap(); 
        this.aPas=1;
        this.aSac=new ItemList();
    }

    /**
     * accesseur de l'entier aMax
     *
     * @return int
     */
    public int getMax(){
        return this.aMax;
    }
    
    
     /**
     * modificateur de l'entier aMax
     *@param pInt
     */
    public void setMax(final int pInt){
        this.aMax=pInt;
    }
    
    
    /**
     * accesseur de la hashmap aItemSac
     *
     * @return HashMap
     */
    public HashMap getItemSac(){
        return this.aSac.getIt();
    }

    /**
     * permet de changer de pièce et 
     * de stocker les pièces précédents
     *
     * @param pRoom
     */
    public void changeRoom(final Room pRoom){
        this.aBackRoom.push(this.aCurrentRoom);
        this.aCurrentRoom=pRoom;
        this.aPas=aPas+1;
    }

    /**
     *accesseur du nb de pas
     * @return int
     */
    public int getPas(){
        return this.aPas;

    }
    
    /**
     *permet de retourner en arrière
     * 
     */
    public void goBack(){

        this.aCurrentRoom=aBackRoom.pop();

    }

    /**
     *accesseur de la pièce courante
     * @return Room
     */
    public Room getCurrentRoom(){
        return this.aCurrentRoom;

    }

    /** modificateur de la pièce courante
     * 
     * @param pRoom 
     */
    public void setCurrentRoom(final Room pRoom){
        this.aCurrentRoom=pRoom;

    }

    /**
     * accesseur de la pile backroom
     * @return Stack
     */
    public Stack getStack(){
        return this.aBackRoom;

    }

    /** pour prendre l'item
     * 
     */
    public void ptake(final String pItemName,final Item pItem){
        
        {
         this.aSac.addItem(pItemName,pItem);}
    }

    /**
     *pour deposer l'item
     * 
     */
    public void pdrop(final String pString){
        this.aSac.removeItem(pString);

    }
 
 
 
 
}
