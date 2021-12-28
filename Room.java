import java.util.HashMap;
import java.util.Set;
/**
 * classe room qui créé les pièces du jeux et manipule les données
 *  @author  L.kamel
 * @version 2021
 */
public class Room
{
    private String aDescription ;
    private HashMap<String, Room> exits;
    // attributs de la classe Room

    private HashMap<String, Room> rooms;
    private String aImageName;
    private Item aItem;

    //private HashMap<String, Item> Items ;
    private ItemList aIt;

    private HashMap<String, Item> Items ;

    /**
     * constructeur naturel de la classe Room qui crée les pièces a l'aide 
     * du hashmap avec une description pour la pièce qu'on veut crée
     * @param pDescription
     * @param pImage
     */ 
    public Room (final String pDescription, final String pImage )
    {
        this.aDescription= pDescription ;
        exits= new HashMap<String, Room>();
        rooms= new HashMap<String, Room>();
        this.aImageName = pImage;

        //Items= new HashMap<String, Item>();
        this.aItem=new Item("","",0);
        this.aIt=new ItemList();

        Items= new HashMap<String, Item>();
        this.aItem=new Item("","",0);

    } // constructeur naturel

    /**
     * permet de créée des items
     * @param pString
     * @param pDes
     * @param pPoid
     */ 
    public void setItem(final String pString,final String pDes,final int pPoid)
    {
        Item vItem=new Item(pString, pDes, pPoid);

        //Items.put(pString,vItem);
        aIt.addItem(vItem.getItemName(),vItem);          
    }// modificateur

    /**
     * permet de récupérer la description de l'item
     * @return String
     */ 
    public String getItemString()
    {
        String returnString="Items :\n";
        int i=0;
        Set<String> keys = this.aIt.getIt().keySet();
        for(String vS : keys){
            i=i+1;
            returnString+=" "+vS ;
        }
        if (!(i>=1))
        {
            return returnString+" "+"No items";    
        }
        return returnString;
    } 

    // modificateur

    /**
     * accesseur qui permet de récuperer le string contenue dans la Room
     * que l'on veut
     * @return string "description"
     */ 
    public String getDescription()
    {
        return aDescription;

    }//Accesseur

    /**
     * cette méthode permet de définir les sorties de chaques pièces
     * donc de crée la carte du jeu
     * @param pDirection
     * @param pNeighbor
     */ 
    public void setExits(String pDirection , Room pNeighbor )
    {
        exits.put(pDirection, pNeighbor);

    } //modificateurs

    /** crée une méthode qui permet de crée 
     *une hashmap qui contient toute les pièces du jeux
     * @param pDescription
     * @param pRoom
     */ 
    public void setRooms(String pDescription , Room pRoom )
    {
        rooms.put( pDescription, pRoom);
    }// crée une méthode qui permet de crée 
    //une hashmap qui contient toute les pièces du jeux

    /**
     * accesseur qui permet de récuperer la direction
     * sous forme de string
     * @param pdirection
     * @return Room
     */ 
    public Room getExit(String pdirection)
    {
        return exits.get(pdirection);
    }// recuperer les sorties d'une room 

    /**
     * accesseur de la HashMap items
     * @return HashMap
     */ 
    
    public HashMap getItems(){
        return this.aIt.getIt();

    }

    /**
     * ajoute des items au HashMap Items
     * @param pString
     * @param pItem
     */ 
    public void addItem(final String pString,final Item pItem)
    {
        this.aIt.addItem(pString,pItem);

    }

    /**
     * enlève des items au HashMap Items
     * @param pString
     */ 
    public void removeItem(final String pString){
        this.aIt.removeItem(pString);

    }

   
    /**
     * méthode qui permet de recupérer les directions possibles d'une
     * pièce
     * @return String
     */ 
    public String getExitString()
    {
        String returnString="Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys){
            returnString += " " + exit;
        }
        return returnString;
    }//retourne les directions de sorties possible

    /**
     * retourne une longue description de la pièce, de la forme: 
     *        you are at the beach
     *     Exits: north west   
     * @return String
     */ 
    public String getLongDescription()
    {
        return "You are "+aDescription+".\n"+getExitString()+"\n"+getItemString()+"\n";
    }//retourne la description de la pièce + les sorties

    /**
     * retourne le nom de l'image
     * @return String
     */ 
    public String getImageName()
    {
        return this.aImageName;
    }

}

 
