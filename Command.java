 
/**
     * classe Command qui scan le clavier et récupère ce que l'on
     * tape pour pouvoir contrôler notre personnage dans le jeu
     *  @author  L.kamel
     * @version 2021
     */
public class Command
{ private String aCommandWord ;
  private String aSecondWord  ;
  
    
  /**
   * constructeur naturel de la classe Command
   * @param pCommandWord
   * @param pSecondWord
   */ 
  public Command ( final String pCommandWord , final String pSecondWord )
  {
      this.aCommandWord=pCommandWord ;
      this.aSecondWord= pSecondWord ;
      
    }// Constructeur Naturel
    
  /**
   * accesseur qui permet de récuperer le string du premier mot
   * @return String 
   */   
  public String getCommandWord()
  {
      return this.aCommandWord ;
      
    } //    Accesseur CommandWord
    
  /**
   * accesseur qui permet de récuperer 
   * le string du deuxième mot tapé
   * @return string deuxième mot tapé
   */ 
  public String getSecondWord()
  { return this.aSecondWord ;
    } //  Accesseur  SecondWord
    
  /**
   * vérifie si il y a un second mot
   * @return retourne un booléen
   */   
  public boolean hasSecondWord()
  {    
       return this.aSecondWord!=null;
   
  }// fonction booléen
    
    /**
    * vérifie si le premier mot est une commande connu du jeu
    * @return retourne un booléen
    */ 
  public boolean isUnknown()
  {
      return this.aCommandWord==null ;
  }
} // Command
