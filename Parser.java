import java.util.StringTokenizer;


/**
 *le parser possède un ensemble de mots de commande connus.
 *Il vérifie les entrées de l’utilisateur par rapport aux
 *commandes connues, et si l’entrée n’est pas l’une 
 *des commandes connues, elle
 *renvoie comme message "inconnue".
 * 
 * @author  L.Kamel
 * @version 2021
 */
public class Parser 
{
    private CommandWords aValidCommands;  // (voir la classe CommandWords)
         
    /**
     * Constructeur par défaut qui crée les 2 objets prevus pour les attributs
     */
    public Parser() 
    {
        this.aValidCommands = new CommandWords();
   
    } // Parser()

    /**
     * @param pInputLine
     * @return retourne la commande suivante de l’utilisateur
     */
    public Command getCommand( final String pInputLine) 
    {
        String vWord1 ;
        String vWord2 ;
        
        StringTokenizer vtokenizer = new StringTokenizer( pInputLine );
        
        if ( vtokenizer.hasMoreTokens() ) 
            vWord1 = vtokenizer.nextToken();      // recupere le premier mot
          
            else 
                vWord1 =null;  
             if ( vtokenizer.hasMoreTokens() )
            vWord2 = vtokenizer.nextToken();      // get second word
        else
            vWord2 = null; 
         
        // Veifie si le premier mot est une commande connue. Si oui, cree une Command avec.
        // Sinon, cree une commande vide avec "null" (pour dire 'commande inconnue').
        if ( this.aValidCommands.isCommand( vWord1 ) ) {
            return new Command( vWord1, vWord2 );
        }
        else {
            return new Command( null, vWord2 ); // C'est surtout le premier null qui est important ici.
        }
    }
     // getCommand()
    /**
     * affiche la liste des commandes valides
     * @return String
     */
    public String getCommandString()
    {
        return aValidCommands.getCommandList();
        
    }
    
} // Parser
