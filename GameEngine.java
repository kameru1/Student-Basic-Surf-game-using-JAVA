 /**
     * classe Game qui se contente d'afficher les informations et créé le jeux 
     * dans lequel on peut agir dans le jeu
     *  @author  L.kamel
     * @version 2021
     */
public class GameEngine
{ private Room   aCurrentRoom ;
  private Parser aParser      ;
  private UserInterface aGui;
  //les attributs (privés toujours)
      /**
     * Constructor for objects of class GameEngine
     */
  public GameEngine()
    {
        this.aParser = new Parser();
        this.createRooms();
    }
    
    /**
     *  créé les pièces du jeu et les connexions entre
     *  les différentes pièces
     *  @param void
     *  @return void
     */
  private void createRooms()
  {
      

      Room vStreet0= new Room(" in the city","city0.gif");
      Room vStreet0bis= new Room(" in the city","city1.gif");
      Room vRoad0= new Room(" in a gaz station","gaz0.gif");
      Room vRoad0bis= new Room("in a gaz station","gaz1.gif");
      Room vBeach0= new Room(" at the beach","beach0.gif");
      Room vBeach0bis= new Room(" at the beach","beach1.gif");
      Room vBoat0= new Room(" on the boat","boat0.gif");
      Room vBoat0bis= new Room(" on the boat","boat1.gif");
      Room vHole= new Room(" in the hole","hole.gif");
      
     
      
      // déclaration des  lieux
   
      
      
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
      vBeach0bis.setExits("down",vHole) ;
      vHole.setExits("up",vBeach0bis);
      
      // position des sorties
      
      vStreet0.setRooms("in the city",vStreet0bis) ;
      vStreet0bis.setRooms("in the city",vStreet0bis) ;
      vRoad0.setRooms("in a gaz station",vRoad0) ;
      vRoad0bis.setRooms("in a gaz station",vRoad0bis) ;
      vBeach0.setRooms("at the beach",vBeach0) ;
      vBeach0bis.setRooms("at the beach",vBeach0bis) ;
      vHole.setRooms("in the hole",vHole);
      vBoat0.setRooms("on the boat",vBoat0);
      vBoat0bis.setRooms("on the boat",vBoat0bis);
 
      
      // rempli le hashmap avec toutes les rooms dedans
      
      this.aCurrentRoom=vBeach0bis ;
      
      // initialise le lieu courant
      
    } // procédure createsRoom
      
    /**
     * crée l'interface du jeu
     * @param de type userInterface
     * @return void
     */
      public void setGUI( final UserInterface pUserInterface )
    {
        this.aGui = pUserInterface;
        this.printWelcome();
    }
       
      /**
     * affiche le lieu et les directions de sorties possibles
     * @param void 
     * @return void
     */
    private void printLocationInfo()
    {
        this.aGui.println(aCurrentRoom.getLongDescription());
        
    }// affiche le lieux et les directions de sortie possible
       
       
       
       
        /**
     * commande pour se déplacer dans le jeu
     * @param prend un paramètre de type Command 
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
            this.aGui.println("There is no way!");
        }
        else { 
             
            this.aCurrentRoom=vNextRoom;
            printLocationInfo();
            if ( this.aCurrentRoom.getImageName() != null )
                this.aGui.showImage( this.aCurrentRoom.getImageName() );
        
            
        }
        
    }// commande pour se déplacer dans le jeu
    
    
       /**
     * affiche le message de bienvenue au début du jeu
     * @param void
     * @return void 
     */
    public void printWelcome()
        {
            this.aGui.print( "\n" );
        this.aGui.println( "Welcome to the World of Zuul!" );
        this.aGui.println( "World of Zuul is a new, incredibly boring adventure game." );
        this.aGui.println( "Type 'help' if you need help." );
        this.aGui.print( "\n" );
        this.aGui.println( this.aCurrentRoom.getLongDescription() );
        if ( this.aCurrentRoom.getImageName() != null )
            this.aGui.showImage( this.aCurrentRoom.getImageName() );
          
        } // message au début du jeu
        
           /**
     * affiche des messages d'aides pour le joueur
     * @param void
     * @return void 
     */
    public void printHelp()
    {
        System.out.println("You are lost. You are alone.");
        System.out.println("You wander around at the beach.");
        System.out.println("Your command words are: "+ this.aParser.getCommandString() );
        
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
    public void interpretCommand(final String pCommand)
    {
        this.aGui.println( "> " + pCommand );
        Command vCommand = this.aParser.getCommand( pCommand );
        String vCommandWord = vCommand.getCommandWord();
        if (vCommand.isUnknown() ) {
            this.aGui.println("I don't know what you mean...");
        } 
        else if(vCommandWord.equals("help")){
            printHelp();
        }
        else if(vCommandWord.equals("go")){
            goRoom(vCommand);
        }
        else if(vCommandWord.equals("look")){
            look();
        }
        else if(vCommandWord.equals("quit")){
            //boolean wantToQuit = quit(pCommand);
            if ( vCommand.hasSecondWord() )
                this.aGui.println( "Quit what?" );
            else
                this.endGame();
        }
        
        else if(vCommandWord.equals("eat")){
            eat();
        }
        else
                this.endGame();
        
    }// effectue une méthode en fonction de la commande taper
   
   
    
     /**
     * renvoi la description de la pièce dans 
     * laquelle on se trouve
     *  @param void
     * @return void 
     */
    private void look()
    {
        System.out.println(aCurrentRoom.getLongDescription());
    } // description de la pièce courante
    
     /**
     * affiche le messages qui nous indique que l'on a mangé
     *  @param void
     * @return void 
     */
    private void eat()
    {
        System.out.println("You have eaten now and you are not hungry any more");
    }// action manger
    
    private void endGame()
    {
        this.aGui.println( "Thank you for playing.  Good bye." );
        this.aGui.enable( false );
    }
} // Game
