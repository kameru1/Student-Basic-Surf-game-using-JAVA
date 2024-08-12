import java.util.HashMap;
import java.util.Set;
/**
 * Write a description of class ItemList here.
 *
 * @author (Kamel)
 * @version (2021)
 */
public class ItemList
{
    private HashMap<String, Item> aItems ;
    
        /**
   * constructeur de la classe ItemList
   * 
   */ 
    public ItemList(){
        aItems= new HashMap<String, Item>();
        
    }
    
        /**
   * accesseur pour récupérer la hashmap
   * @return Hashmap
   */ 
    public HashMap<String, Item> getIt() {
        return this.aItems;
    }
    
        /**
   * permet d'ajouter un item a la HashMap
   * @param pString
   * @param pItem
   */ 
    public void addItem(final String pString,final Item pItem)
    {
        this.aItems.put(pString,pItem);
    }
    
    
        /**
   * permet d'enlever un item a la HashMap
   * @param pString
   */ 
    public void removeItem(final String pString)
    {
        this.aItems.remove(pString);
    }
    
      /**
   * permet de récupérer la description de l'item
   * @return String
   */
    public String getItemString() {
        String returnString = "Items:\n";
        if (this.aItems.isEmpty()) {
            return returnString + " No items";
        }
        Set<String> keys = this.aItems.keySet();
        for (String vS : keys) {
            returnString += " " + vS;
        }
        return returnString;
   }
}

