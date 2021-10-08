package v1;

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
