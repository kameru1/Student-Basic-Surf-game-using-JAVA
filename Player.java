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
    private HashMap<String,Item> aItemSac;
    private String pNomPlayer;
    
    /**
 * constructeur de la classe Player
 *
 * @param pName
 */
    public Player(final String pName)
    {
      this.pNomPlayer=pName;
      this.aBackRoom=new Stack();
      this.aItemSac=new HashMap();
    }
    
 /**
 * accesseur de la hashmap aItemSac
 *
 * @return HashMap
 */
    public HashMap getItemSac(){
        return this.aItemSac;
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
        aItemSac.put(pItemName,pItem);
    }
    
       /**
 *pour deposer l'item
 * 
 */
    public void pdrop(final String pString){
        aItemSac.remove(pString);
        
    }

}
