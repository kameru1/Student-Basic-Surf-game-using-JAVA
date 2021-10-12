 
public class Game
{ private Room   aCurrentRoom ;
  private Parser aParser      ;
    
    
    
  private void createRooms()
  {
      
      //Room vOutside= new Room("oustside the main entrance of the university");
      //Room vTheatre= new Room("in a lecture theatre") ;
      //Room vPub    = new Room("in the campus pub");
      //Room vLab    = new Room("in a computing lab");
      //Room vOffice = new Room(" in the computing admin office") ;
      
      Room vStreet0= new Room("you are in the city");
      Room vStreet0bis= new Room("you are in the city");
      Room vRoad0= new Room("you are in a gaz station");
      Room vRoad0bis= new Room("you are in a gaz station");
      Room vBeach0= new Room("you are at the beach");
      Room vBeach0bis= new Room("you are at the beach");
      Room vBoat0= new Room("you are on the boat");
      Room vBoat0bis= new Room("you are on the boat");
      
      
      
      
      // déclaration des 5 lieux
   
      //vPub.setExits(null,vOutside,null,null) ;
      //vOutside.setExits(null,vTheatre,vPub,vLab);
      //vTheatre.setExits(null,null,vOutside,null) ;
      //vLab.setExits(vOutside,vOffice,null,null);
      //vOffice.setExits(null,null,vLab,null);
      
      vStreet0.setExits(null,vStreet0bis,null,null) ;
      vStreet0bis.setExits(null,vRoad0,vStreet0,null) ;
      vRoad0.setExits(null,vRoad0bis,vStreet0bis,null) ;
      vRoad0bis.setExits(null,vBeach0,vRoad0,null) ;
      vBeach0.setExits(null,vBeach0bis,vRoad0bis,null) ;
      vBeach0bis.setExits(null,null,vBeach0,null) ;
      
      
      // position des sorties
      
      this.aCurrentRoom=vBeach0bis ;
      
      // initialise le lieu courant
      
    } // procédure createsRoom
      
    
    public Game ()
      { 
          this.createRooms() ;
          this.printWelcome();
          this.aParser=new Parser();
       }  // constructeur par défaut
       
    private void printLocationInfo()
    {
        System.out.println("You are "+aCurrentRoom.getDescription());
        System.out.print("Exits: ");
        System.out.print (aCurrentRoom.getExitString());
        
    }
       
       
       
       
       
    public void goRoom( final Command pCommand )
    {   
        if (pCommand.getSecondWord()==null) { 
            System.out.print("Go where ?");
            return;
        } 
        // s'il n'y a pas de second mot
        
        String vDirection= pCommand.getSecondWord() ;
        Room vNextRoom = aCurrentRoom.getExit (vDirection);
        
        
        if (vNextRoom==null){ 
            System.out.print("There is no way!");
        }
        else { 
             
            this.aCurrentRoom=vNextRoom;
            printLocationInfo();
            
        }
        
    }// commande pour se déplacer dans le jeu
    public void printWelcome()
        {
            System.out.println("Welcome to the World of Zuul!");
            System.out.println("World of Zuul is a new, incredibly boring adventure game.");
            System.out.println("Type 'help' if you need help.");
            printLocationInfo();
          
        } // message au début du jeu
    public void printHelp()
    {
        System.out.print("You are lost. You are alone.");
        System.out.println("You wander around at the beach.");
        System.out.println("Your command words are:  ");
        
        System.out.print("  go quit help  ");
        
    } //aide pour les joueurs
    private boolean quit(final Command pCommand)
    {
        if( pCommand.getSecondWord()!=null) {
            System.out.print("Quit what ??");
            return false;
        }
        else
        return false ;
    } // commande quit
    
    private boolean processCommand(final Command pCommand)
    {
        if (pCommand.isUnknown()==true) {
            System.out.print("I don't know what you mean...");
            return false;
        }
        else if (quit(pCommand)==true) {
         return true;}
        else
         return false;
   }
   boolean vFinished=false;
   public void play()
   {
       while (vFinished==false){
           Command vCommand=aParser.getCommand();
           vFinished=processCommand(vCommand);
           
       }
       System.out.println("Thank you for playing.  Good bye.");
       
       
    }    
} // Game
