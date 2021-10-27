import java.util.HashMap;
import java.util.Set;
/**
     * classe room qui créé les pièces du jeux et manipule les données
     *  @author  L.kamel
     * @version 2008.03.30 + 2013.09.15
     */
public class Room
{
    private String aDescription ;
    private HashMap<String, Room> exits;
 // Room

 /**
   * constructeur naturel de la classe Room qui crée les pièces a l'aide 
   * du hashmap avec une description pour la pièce qu'on veut crée
   * @param prend un string
   */ 
public Room (final String pDescription )
{
    this.aDescription= pDescription ;
    exits= new HashMap<String, Room>();
    
    
} // constructeur naturel

/**
   * accesseur qui permet de récuperer le string contenue dans la Room
   * que l'on veut
   * @param void
   * @return string "description"
   */ 
public String getDescription()
 {
     return aDescription;
     
 }//Accesseur
 /**
   * cette méthode permet de définir les sorties de chaques pièces
   * donc de crée la carte du jeu
   * @param prend un string "la direction" et un Room
   * (la pièce a côté).
   * @return void
   */ 
 public void setExits(String pDirection , Room pNeighbor )
 {
     exits.put(pDirection, pNeighbor);
     
      } //modificateurs
      
      /**
   * accesseur qui permet de récuperer la direction
   * sous forme de string
   * @param prend un string "la direction"
   * @return un string "une direction"
   */ 
public Room getExit(String pdirection)
{
    return exits.get(pdirection);
}// recuperer les sorties d'une room 

/**
   * méthode qui permet de recupérer les directions possibles d'une
   * pièce
   * @param void
   * @return un string qui est l'ensemble des directions possibles
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
   * @param void
   * @return retourne une description de la pièce,avec 
   * les sorties possibles.
   */ 
  public String getLongDescription()
  {
      return "You are "+aDescription+".\n"+getExitString();
    }




}



 
