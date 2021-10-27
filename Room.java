import java.util.HashMap;
import java.util.Set;

public class Room
{
    private String aDescription ;
    private HashMap<String, Room> exits;
 // Room

public Room (final String pDescription )
{
    this.aDescription= pDescription ;
    exits= new HashMap<String, Room>();
    
    
} // constructeur naturel

public String getDescription()
 {
     return aDescription;
     
 }//Accesseur
 
 public void setExits(String pDirection , Room pNeighbor )
 {
     exits.put(pDirection, pNeighbor);
     
      } //modificateurs
      
      
public Room getExit(String pdirection)
{
    return exits.get(pdirection);
}// recuperer les sorties d'une room 

public String getExitString()
{
     String returnString="Exits:";
     Set<String> keys = exits.keySet();
     for(String exit : keys){
         returnString += " " + exit;
     }
     return returnString;
}//retourne les directions de sorties possible
}



 
