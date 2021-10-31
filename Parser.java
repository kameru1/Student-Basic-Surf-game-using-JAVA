
import java.util.Scanner;

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
    private Scanner      aReader;         // permettra de lire les commandes au clavier

    /**
     * Constructeur par défaut qui crée les 2 objets prevus pour les attributs
     */
    public Parser() 
    {
        this.aValidCommands = new CommandWords();
        this.aReader        = new Scanner( System.in );
        // System.in designe le clavier, comme System.out designe l'ecran
    } // Parser()

    /**
     * @param void
     * @return retourne la commande suivante de l’utilisateur
     */
    public Command getCommand() 
    {
        String vInputLine;    // contiendra toute la ligne tapee
        String vWord1 = null;
        String vWord2 = null;

        System.out.print( "> " );  // affiche le prompt (invite de commande)

        vInputLine = this.aReader.nextLine(); // lit la ligne tapee au clavier

        // cherche jusqu'a 2 mots dans la ligne tapee
        Scanner vTokenizer = new Scanner( vInputLine );
        if ( vTokenizer.hasNext() ) {
            vWord1 = vTokenizer.next();      // recupere le premier mot
            if ( vTokenizer.hasNext() ) {
                vWord2 = vTokenizer.next();  // recupere le deuxieme mot
                // note : on ignore tout le reste de la ligne tapee !
            } // if
        } // if

        // Veifie si le premier mot est une commande connue. Si oui, cree une Command avec.
        // Sinon, cree une commande vide avec "null" (pour dire 'commande inconnue').
        if ( this.aValidCommands.isCommand( vWord1 ) ) {
            return new Command( vWord1, vWord2 );
        }
        else {
            return new Command( null, null ); // C'est surtout le premier null qui est important ici.
        }
    } // getCommand()
    /**
     * affiche la liste des commandes valides
     */
    public String showCommands()
    {
        return aValidCommands.getCommandList();
        
    }
    
} // Parser
