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
     String N="";
     String E="";
     String W="";
     String S="";
     String D="";
     String U="";
     if(this.getExit("north") != null) {
             N="north";
        }
        if(this.getExit("east") != null) {
            E= "east ";
        }
        if(this.getExit("south") != null) {
            S="south ";
        }
        if(this.getExit("west") != null) {
            W="west ";
        }
        if(this.getExit("down") != null) {
            D="down ";
        }
        if(this.getExit("up") != null) {
            U="up ";
        }
        
        
     return N+E+W+S+D+U ;
}//retourne les directions de sorties possible
}



 
