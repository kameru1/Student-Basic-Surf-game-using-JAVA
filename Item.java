import java.util.HashMap;
import java.util.Set;
/**
 * class Item 
 *
 * @author (Kamel L)
 * @version (2021)
 */
public class Item
{
    private String aNom;
    private int aPoid;
    private String aDes;
       /**
 *constructeur de la classe Item
 * @param pNom
 * @param pDes
 * @param pPoid
 */
    public Item(final String pNom,final String pDes,final int pPoid )
    {
        this.aNom=pNom;
        this.aDes=pDes;
        this.aPoid=pPoid;
        
    }//constructeur naturel
    
     /**
 *constructeur de la classe Item
 *@return String
 */
    public String getItemName()
    {
        return this.aNom;
    }
    
     /**
 *constructeur de la classe Item
 *@return String
 */
       public String getItemDes()
    {
        return this.aDes;
    }
    
     /**
 *constructeur de la classe Item
 *@return int
 */
       public int getItemPrix()
    {
        return this.aPoid;
    }
    
}
