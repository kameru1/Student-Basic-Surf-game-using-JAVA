 
/**
     * classe Command qui scan le clavier et récupère ce que l'on
     * tape pour pouvoir contrôler notre personnage dans le jeu
     *  @author  L.kamel
     * @version 2008.03.30 + 2013.09.15
     */
public class Command
{ private String aCommandWord ;
  private String aSecondWord  ;
  
    
  
  public Command ( final String pCommandWord , final String pSecondWord )
  {
      this.aCommandWord=pCommandWord ;
      this.aSecondWord= pSecondWord ;
      
      
      
    }// Constructeur Naturel
    
  public String getCommandWord()
  {
      return this.aCommandWord ;
      
    } //    Accesseur CommandWord
    
  public String getSecondWord()
  { return this.aSecondWord ;
    } //  Accesseur  SecondWord
    
  public boolean hasSecondWord()
  {    
       return this.aSecondWord!=null;
      
      
    }// fonction booléen
  public boolean isUnknown()
  {
      return this.aCommandWord==null ;
    }
} // Command
