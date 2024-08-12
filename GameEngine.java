import java.util.Stack;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Set;
/**
 * classe Game qui se contente d'affichée les informations et créée le jeu 
 * dans lequel on peut agir 
 *  @author  L.kamel
 * @version 2021
 */ 

public class GameEngine
{

    private Player aPlayer      ;

    private Parser aParser      ;
    private UserInterface aGui  ;

    //les attributs (privés toujours)
    /**
     * Constructor for objects of class GameEngine
     */
    public GameEngine()
    {
        this.aParser = new Parser();
        this.aPlayer=new Player("kameru san");
        this.createRooms();

    }

    /**
     *  créé les pièces du jeu et les connexions entre
     *  les différentes pièces
     */
    private void createRooms()
    {

        Room vStreet0= new Room(" in the city","city0.gif");
        Room vStreet0bis= new Room(" in the city","city1.gif");
        Room vRoad0= new Room(" on the road","road.gif");
        Room vRoad0bis= new Room("in a gaz station","gaz1.gif");
        Room vBeach0= new Room(" at the beach","beach0.gif");
        Room vBeach0bis= new Room(" at the beach","beach1.gif");
        Room vBoat0= new Room(" on the boat","boat0.gif");
        Room vBoat0bis= new Room(" on the boat","boat1.gif");
        Room vHole= new Room(" in the hole","hole.gif");
        Room vHole1=new Room(" in the hole","tunnel1.gif");
        Room vHole2=new Room(" in the hole","tunnel2.gif");
        Room vHole21=new Room(" in the hole","tunnel21.gif");
        Room vHole22=new Room(" in the hole","tunnel22.gif");
        Room vsanc=new Room("at the tunnel spirit Sanctuary","sanctuary.gif");
        Room vNoir=new Room("at the tunnel spirit Sanctuary","noir.gif");
        Room vHolend=new Room("out of the hole","hole_end.gif");
        Room vTrap=new Room("on a jetski","jetski.gif");

        // déclaration des  lieux

        vStreet0.setExits("east",vStreet0bis) ;
        vStreet0bis.setExits("east",vRoad0bis) ;
        vStreet0bis.setExits("west",vStreet0) ;
        vRoad0.setExits("east",vBeach0) ;
        vRoad0.setExits("west",vRoad0bis) ;
        vRoad0bis.setExits("east",vRoad0) ;
        vRoad0bis.setExits("west",vStreet0bis) ;
        vBeach0.setExits("east",vBeach0bis) ;
        vBeach0.setExits("down",vHolend) ;
        vBeach0.setExits("west",vRoad0) ;
        vBeach0bis.setExits("west",vBeach0) ;
        vBeach0bis.setExits("down",vHole) ;
        vHole.setExits("up",vBeach0bis);
        vHole.setExits("down",vHole1);
        vHole1.setExits("up",vHole);
        vHole1.setExits("down",vHole2);
        vHole2.setExits("up",vHole1);      

        vHole2.setExits("east",vHole22);
        vHole22.setExits("west",vHole2);
        vHole22.setExits("east",vsanc);
        vsanc.setExits("west",vHole22);
        vHole2.setExits("down",vHole21);  
        vsanc.setExits("down",vNoir);
        vNoir.setExits("up",vsanc);

        vHole21.setExits("elevator",vHolend);
        vHole21.setExits("up",vHole2);
        vHolend.setExits("up", vBeach0);
        vHolend.setExits("down",vHole21);

        vHole.setExits("east",vTrap);
        vTrap.setExits("east",vBoat0);
        vTrap.setExits("west",vHole);
        vBoat0.setExits("west",vTrap);
        vBoat0.setExits("east",vBoat0bis);
        vBoat0bis.setExits("west",vBoat0);
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
        this.aPlayer.setCurrentRoom(vBeach0bis);
        this.aPlayer.getStack().add(vBeach0bis);

        // initialise le lieu courant

        // les items

        vBeach0bis.setItem("board1","ceci est la première planche de surf!!!",101);
        vBeach0.setItem("board2","ceci est la deuxième planche de surf!!!",50);
        vBeach0.setItem("coquillage","brillant",0);
        vNoir.setItem("magiccookie","nani?? masaka!!",10);
    } // procédure createsRoom

    /**
     * crée l'interface du jeu
     * @param pUserInterface
     */
    public void setGUI( final UserInterface pUserInterface )
    {
        this.aGui = pUserInterface;
        this.printWelcome();
    }

    /**
     * affiche le lieu et les directions de sorties possibles
     */
    private void printLocationInfo()
    {
        this.aGui.println(this.aPlayer.getCurrentRoom().getLongDescription());

    }// affiche le lieux et les directions de sortie possible

    /**
     * commande pour se déplacer dans le jeu
     * @param pCommand
     */
    public void goRoom( final Command pCommand )
    {   

        if (pCommand.getSecondWord()==null) { 
            System.out.print("Go where ?");
            return;
        } 
        // s'il n'y a pas de second mot
        String vDirection= pCommand.getSecondWord() ;
        Room vNextRoom = this.aPlayer.getCurrentRoom().getExit (vDirection);

        if (vNextRoom==null){ 
            this.aGui.println("There is no way!");
        }

        else { 
            this.aGui.println("pas="+this.aPlayer.getPas());
            this.aGui.println("");

            this.aPlayer.changeRoom(vNextRoom);
            printLocationInfo();
            if ( this.aPlayer.getCurrentRoom().getImageName() != null )
                this.aGui.showImage( this.aPlayer.getCurrentRoom().getImageName() );

        }
    }// commande pour se déplacer dans le jeu
    /**
     * affiche le message de bienvenue au début du jeu
     */
    public void printWelcome()
    {
        this.aGui.print( "\n" );
        this.aGui.println( "Welcome to the World of Zuul!" );
        this.aGui.println( "World of Zuul is a new, incredibly boring adventure game." );
        this.aGui.println( "Type 'help' if you need help." );
        this.aGui.print( "\n" );
        this.aGui.println( this.aPlayer.getCurrentRoom().getLongDescription() );
        if ( this.aPlayer.getCurrentRoom().getImageName() != null )
            this.aGui.showImage( this.aPlayer.getCurrentRoom().getImageName() );

    } // message au début du jeu

    /**
     * affiche des messages d'aides pour le joue
     */
    public void printHelp()
    {
        System.out.println("You are lost. You are alone.");
        System.out.println("You wander around at the beach.");
        System.out.println("Your command words are: "+ this.aParser.getCommandString() );

    } //aide pour les joueurs

    /**
     *  vérifie si le joueur a taper quit ou non
     *  @param pCommand
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
     * @param pCommand
     */
    public void interpretCommand(final String pCommand) 

    {
        this.aGui.println( "> " + pCommand );
        Command vCommand = this.aParser.getCommand( pCommand );
        String vCommandWord = vCommand.getCommandWord();

        String vDirection= vCommand.getSecondWord();
        Room vNextRoom = this.aPlayer.getCurrentRoom().getExit (vDirection);

        if(this.aPlayer.getPas()>50){
            this.aGui.println( "Stop :((" );
            return;
        }

        if (vCommand.isUnknown() ) {
            this.aGui.println("I don't know what you mean...");
        } 
        else if(vCommandWord.equals("help")){
            printHelp();
        }
        else if(vCommandWord.equals("test")){
            if ( vCommand.hasSecondWord() )
            {
                this.lecture(vCommand);
            }
        }
        else if(vCommandWord.equals("go")){
            if(isExit(this.aPlayer.getCurrentRoom())){
                if(vDirection.equals("west")){
                    this.aGui.println("There is no way!");
                    return;
                }
            }
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

        else if(vCommandWord.equals("back"))
        {

            if(vCommand.hasSecondWord()||this.aPlayer.getStack().empty()==true) 
                this.aGui.println( "error" );
            else{
                aPlayer.goBack();
                printLocationInfo();
                if (  this.aPlayer.getCurrentRoom().getImageName() != null )
                    this.aGui.showImage(  this.aPlayer.getCurrentRoom().getImageName() );
            }
        }
        else if(vCommandWord.equals("take"))
        {

            take(vCommand);
        }
        else if(vCommandWord.equals("drop"))
        {
            drop(vCommand);
        }
        else if(vCommandWord.equals("eat")){
            eat(vCommand);
        }
        else if(vCommandWord.equals("items")){
            this.aGui.println( inv() );
        }
        else
            this.endGame();

    }// effectue une méthode en fonction de la commande taper

    /** renvoie vrai si la pièce passer en paramètre 
     * est la pièce piège. sinon renvoie faux
     * @param pRoom
     * @return boolean
     **/
    public boolean isExit(final Room pRoom)
    {
        if(pRoom.getDescription()== "on a jetski"){
            this.aPlayer.getStack().clear();
            return true;
        }
        else
          return false;
    }

    /** permet d'afficher les items 
     * dans l'inventaire du joueur
     * @return String
     **/
    public String inv()
    {
        String returnstring="";
        Set<String> keys = this.aPlayer.getItemSac().keySet();
        for (String vS:keys){
            returnstring+=" "+vS;
        }
        return returnstring;
    }

    /** permet de prendre un item
     * @param pCommand
     **/
    public void take(final Command pCommand){
        if (!pCommand.hasSecondWord())
            this.aGui.println("take what???");

        else{
            String vItemString=pCommand.getSecondWord();
            Room vPlayerRoom= this.aPlayer.getCurrentRoom();
            Item vItem=(Item)vPlayerRoom.getItems().get(vItemString);
            if(this.aPlayer.getMax()<vItem.getItemPrix())
            {   this.aGui.println("not enought money :((");
                return;} 
            if (vItem==null)
                this.aGui.println("There no items here");
            else{
                this.aPlayer.ptake(vItemString,vItem);
                vPlayerRoom.removeItem(vItemString);

            }
        }
    }

    /** permet d'enlever un item
     * @param pCommand
     **/
    public void drop(final Command pCommand){
        if (!pCommand.hasSecondWord())
            this.aGui.println("drop what???");

        else{
            String vItemString=pCommand.getSecondWord();
            Room vPlayerRoom= this.aPlayer.getCurrentRoom();
            Item vItem=(Item)this.aPlayer.getItemSac().get(vItemString);

            if (this.aPlayer.getItemSac().isEmpty()==true)
                this.aGui.println("There is nothing to drop");
            else{
                this.aPlayer.pdrop(vItemString);
                vPlayerRoom.addItem(vItemString,vItem);

            }
        }

    }

    /** permet de lire un fichier 
     * @param pG
     **/
    public void lecture( final Command pG )
    {
        Scanner vSc;
        if(!pG.hasSecondWord())
        { this.aGui.println("tester quoi ? ");
            return;
        }
        else{
            try { // pour "essayer" les instructions suivantes
                vSc = new Scanner( new File( pG.getSecondWord()) );
                while ( vSc.hasNextLine() ) {
                    String vLigne = vSc.nextLine();
                    this.interpretCommand(vLigne);
                    // traitement de la ligne lue

                } // while
            } // try
            catch ( final FileNotFoundException pFNFE ) {
                this.aGui.println("pas bon ?");
            } // catch
        }
    } // lecture

    /**
     * renvoi la description de la pièce dans 
     * laquelle on se trouve
     */
    private void look()
    {
        this.aGui.println( this.aPlayer.getCurrentRoom().getLongDescription());
    } // description de la pièce courante

    /**
     * affiche le messages qui nous indique que l'on a mangé
     */
    private void eat(final Command pCommand)
    {
        if (!pCommand.hasSecondWord()){
            this.aGui.println("eat what? :)");
            return;
        }
        String vItemString=pCommand.getSecondWord();
        if(vItemString.equals("magiccookie")){
            this.aGui.println("You have eaten now and you are not hungry any more");
            this.aPlayer.setMax(this.aPlayer.getMax()*2);
        }
        else {
            this.aGui.println("can't find that ;(");
        }
    }// action manger

    /**
     * affiche le message de fin de jeu
     */
    private void endGame()
    {
        this.aGui.println( "Thank you for playing.  Good bye." );
        this.aGui.enable( false );
    }
} // Game
