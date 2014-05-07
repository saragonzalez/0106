
/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item
{
   private String description;
   private double weight;
   //constructor
   public Item (String description, double weight)
   {
       this.description=description;
       this.weight=weight;
   }
   
   /**
    * Metodo que devuelve una description larga
    */
   
   public String getLongDescription()
   {
       return description + " (" + weight + " kg.)";
   }
}


