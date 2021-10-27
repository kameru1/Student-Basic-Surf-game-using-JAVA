 /**
     * classe Game qui se contente d'afficher les informations et créé le jeux 
     * dans lequel on peut agir
     *  @author  L.kamel
     * @version 2008.03.30 + 2013.09.15
     */
public class Game
{ private Room   aCurrentRoom ;
  private Parser aParser      ;
    
    
    /**
     *  créé les pièce du jeu et les connexion entre
     *  les différentes pièces
     *  @param void
     *  @return void
     */
  private void createRooms()
  {
      

      Room vStreet0= new Room(" in the city");
      Room vStreet0bis= new Room(" in the city");
      Room vRoad0= new Room(" in a gaz station");
      Room vRoad0bis= new Room("in a gaz station");
      Room vBeach0= new Room(" at the beach");
      Room vBeach0bis= new Room(" at the beach");
      Room vBoat0= new Room(" on the boat");
      Room vBoat0bis= new Room(" on the boat");
      Room vHole= new Room(" in the hole");
      
      
      
      // déclaration des 5 lieux
   
      
      
      vStreet0.setExits("east",vStreet0bis) ;
      vStreet0bis.setExits("east",vRoad0) ;
      vStreet0bis.setExits("west",vStreet0) ;
      vRoad0.setExits("east",vRoad0bis) ;
      vRoad0.setExits("west",vStreet0bis) ;
      vRoad0bis.setExits("east",vBeach0) ;
      vRoad0bis.setExits("west",vRoad0) ;
      vBeach0.setExits("east",vBeach0bis) ;
      vBeach0.setExits("west",vRoad0bis) ;
      vBeach0bis.setExits("west",vBeach0) ;
      vBeach0bis.setExits("down",vBeach0) ;
      vHole.setExits("up",vBeach0bis);
      
      // position des sorties
      
      this.aCurrentRoom=vBeach0bis ;
      
      // initialise le lieu courant
      
    } // procédure createsRoom
      
    /**
     * lancement du jeu
     * @param void
     * @return void
     */
      public Game ()
      { 
          this.createRooms() ;
          this.printWelcome();
          this.aParser=new Parser();
      }  // constructeur par défaut
       
      /**
     * affiche le lieux et les directions de sortie possible
     * @param void 
     * @return void
     */
    private void printLocationInfo()
    {
        System.out.println(aCurrentRoom.getLongDescription());
        
    }// affiche le lieux et les directions de sortie possible
       
       
       
       
        /**
     * commande pour se déplacer dans le jeu
     * @param prend un parametre de type Command 
     * @return void 
     */
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
    
    
       /**
     * affiche le message de bienvenue au début du jeu
     * @param void
     * @return void 
     */
    public void printWelcome()
        {
            System.out.println("Welcome to the World of Zuul!");
            System.out.println("World of Zuul is a new, incredibly boring adventure game.");
            System.out.println("Type 'help' if you need help.");
            printLocationInfo();
          
        } // message au début du jeu
        
           /**
     * affiche des messages d'aides pour le joueur
     * @param void
     * @return void 
     */
    public void printHelp()
    {
        System.out.print("You are lost. You are alone.");
        System.out.println("You wander around at the beach.");
        System.out.println("Your command words are:  ");
        
        System.out.print("  go quit help  ");
        
    } //aide pour les joueurs
    
       /**
     *  vérifie si le joueur a taper quit ou non
     *  @param prend un parametre de type Command
     * @return retourne un booléen
     */
    private boolean quit(final Command pCommand)
    {
        if( pCommand.getSecondWord()!=null) {
            System.out.print("Quit what ??");
            return false;
        }
        else
        return false ;
    } // commande quit
    
       /**
     * analyse ce que le joueur écrit sur le clavier
     * @param prend un parametre de type Command
     * @return retourne un booléen 
     */
    private boolean processCommand(final Command pCommand)
    {
        if (pCommand.isUnknown()==true) {
            System.out.print("I don't know what you mean...");
        } 
        if(pCommand.equals("help")){
            printHelp();
            System.out.print("You are lost. You are alone.");
        }
        else if(pCommand.equals("go")){
            goRoom(pCommand);
        }
        else if(pCommand.equals("look")){
            look();
        }
        else if(pCommand.equals("quit")){
            boolean wantToQuit = quit(pCommand);
            
        }
        return false;
   }
   boolean vFinished=false;
   
      /**
     * lance le début du jeu
     *  @param void
     * @return void 
     */
   public void play()
   {
       while (vFinished==false){
           Command vCommand=aParser.getCommand();
           vFinished=processCommand(vCommand);
           
       }
       System.out.println("Thank you for playing.  Good bye.");
       
       
    }    //lance le jeu
    
    private void look()
    {
        System.out.println(aCurrentRoom.getLongDescription());
    }
    
    
    
} // Game
