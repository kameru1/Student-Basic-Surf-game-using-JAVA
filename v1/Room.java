package v1;

public class Room
{
    private String aDescription ;
    public  Room aNorthExit ;
    public  Room aEastExit ;
    public  Room aWestExit ;
    public  Room aSouthExit ;
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
}
 
