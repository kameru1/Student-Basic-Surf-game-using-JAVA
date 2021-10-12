 

public class Room
{
    private String aDescription ;
    private  Room aNorthExit ;
    private  Room aEastExit ;
    private  Room aWestExit ;
    private  Room aSouthExit ;
 // Room

public Room (final String pDescription )
{
    this.aDescription= pDescription ;
    
    
    
} // constructeur naturel

public String getDescription()
 {
     return this.aDescription;
     
 }//Accesseur
 
 public void setExits( final Room pNorthExit , final Room pEastExit , final Room pWestExit , final Room pSouthExit )
 {
     this.aNorthExit=pNorthExit;
     this.aEastExit=pEastExit ;
     this.aWestExit=pWestExit ;
     this.aSouthExit=pSouthExit ;
     
      } //modificateurs
      
      
public Room getExit(String pdirection)
{
    if ( pdirection.equals("north")){
        return aNorthExit;
    }
    if ( pdirection.equals("east")){
        return aEastExit;
    }
    if ( pdirection.equals("west")){
        return aWestExit;
    }
    if ( pdirection.equals("south")){
        return aSouthExit;
    }
    return null ;
}// recuperer les sorties d'une room 

public String getExitString()
{
     String N="";
     String E="";
     String W="";
     String S="";
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
        
     return N+E+W+S ;
}
}



 
