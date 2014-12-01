import java.util.*;
/**
 * class Dienblad
 * Maakt een dienlad aan waaraan artikelen gekoppeld kunnen worden.
 *
 * @author Patrick Swijgman & Rutger Roffel
 * @version 1.0
 */

public class Dienblad {
    private Stack<Artikel> artikelen;
    
    /** Constructor */
    public Dienblad() {
        artikelen = new Stack<Artikel>();
    }
    
    /**
    * Methode om artikel aan dienblad toe te voegen
    * @param artikel
    */
   
    public void voegToe(Artikel artikel) {
       artikelen.push(artikel);
    }
    
    /**
    * Methode om aantal artikelen op dienblad te tellen
    * @return Het aantal artikelen
    */
    public int getAantalArtikelen() {
        return artikelen.size();
    }
    
    /**
    * Methode om de totaalprijs van de artikelen * op dienblad uit te rekenen
    * @return De totaalprijs
    */
    public double getTotaalPrijs() {
        double totaalPrijs = 0;
        for(Artikel artikel : artikelen){
            totaalPrijs += artikel.getPrijs();
        }
        return totaalPrijs;
    }
}