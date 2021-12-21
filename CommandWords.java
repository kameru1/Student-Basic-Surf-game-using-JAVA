 

/**
 * Cette classe contient une table d’énumération de tous 
 *les mots de commande connus du jeu.
 *elle est utilisé pour reconnaître les commandes au fur et à
 *mesure qu’elles sont tapées.
 *
 * @author  L.Kamel
 * @version 2021
 */
public class CommandWords
{
       //a constant array that holds all valid command words 
   private static final String aValidCommands[]={
       "go","quit","help","look" , "eat","back","test",
       "take","drop"
    };
    // a constant array that will hold all valid command words
    //private final String[] aValidCommands;

    /**
     * Constructeur - initialise les commandes .
     */
    public CommandWords()
    {
        
        //this.aValidCommands = new String[5];
        ///this.aValidCommands[0] = "go";
        //this.aValidCommands[1] = "help";
        //this.aValidCommands[2] = "quit";
        //this.aValidCommands[3] = "look";
        //this.aValidCommands[4] = "eat";
    } // CommandWords()

    /**
     * vérifie si pString est une commande valide. 
     * @param pString
     * @return true si pString est une commande valide,
     * false sinon.
     */
    public boolean isCommand( final String pString )
    {
        for ( int i=0; i<this.aValidCommands.length; i++ ) {
            if ( this.aValidCommands[i].equals( pString ) )
                return true;
        } // for
        // if we get here, the string was not found in the commands
        return false;
    } // isCommand()
   
    
    /**
     * @return
     * affiche toutes les commandes valides
     */
    public String getCommandList()
    {
        String returnString="";
        for(String command : aValidCommands){
            returnString += " " + command;
            
        }
       return returnString;
    
    }
} // CommandWords
