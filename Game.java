 /**
     * classe Game qui se contente d'afficher les informations et créé le jeux 
     * dans lequel on peut agir dans le jeu
     *  @author  L.kamel
     * @version 2021
     */
public class Game
{ private Room   aCurrentRoom ;
  private Parser aParser      ;
  //les attributs (privés toujours)
    
    
    /**
     *  créé les pièces du jeu et les connexions entre
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
     * affiche le lieu et les directions de sorties possibles
     * @param void 
     * @return void
     */
    private void printLocationInfo()
    {
        System.out.println(aCurrentRoom.getLongDescription());
        
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
            System.out.println("Welcome to the Surf-man World ");
            System.out.println("World of Surf-man is a new, incredibly boring adventure game.");
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
        System.out.println("You are lost. You are alone.");
        System.out.println("You wander around at the beach.");
        System.out.println("Your command words are:  ");
        System.out.println(aParser.showCommands());
        
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
        else if(pCommand.getCommandWord().equals("help")){
            printHelp();
        }
        else if(pCommand.getCommandWord().equals("go")){
            goRoom(pCommand);
        }
        else if(pCommand.getCommandWord().equals("look")){
            look();
        }
        else if(pCommand.getCommandWord().equals("quit")){
            boolean wantToQuit = quit(pCommand);
        }
        
        else if(pCommand.getCommandWord().equals("eat")){
            eat();
        }
        return false;
    }// effectue une méthode en fonction de la commande taper
   
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
    
} // Game
