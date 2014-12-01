import java.util.ArrayList;

/**
 * class Kassa - Alle bewerkingen en informatie voor een kassa
 * @author Patrick Swijgman & Rutger Roffel
 * @version 1.0
 */
public class Kassa
{
    private KassaRij kassarij;
    private double inKas;
    private int verkochteArtikelen;

    /**
     * Constructor voor objects van class Kassa
     * @param kassarij
     */
    public Kassa(KassaRij kassarij)
    {
        // geef de instance variables een beginwaarde
        this.inKas = 00.00;
        this.kassarij = kassarij;
        this.verkochteArtikelen = 0;
    }

    /**
     * Vraag het aantal artikelen en de totaalprijs.
     * De implementatie wordt later vervangen.
     * door een echte betaling door de persoon
     * @param persoon die moet afrekenen
     */
    public void rekenAf(Persoon persoon)
    {
        double betaling = persoon.getTotaalPrijs();
        verkochteArtikelen += persoon.getAantalArtikelen();
        inKas += betaling;
    }
    
    /**
     * Geef het aantal artikelen dat de kassa
     * heeft gepasseerd,
     * vanaf dat moment dat de methode resetWaarden
     * is aangeroepen
     * @return aantal artikelen
     */
    public int aantalArtikelen()
    {
        return verkochteArtikelen;
    }
    
    /**
     * Geeft het totaalbedrag van alle artikelen die
     * de kassa zijn gepasseerd, vanaf het moment dat de methode
     * resetKassa
     * is aangeroepen.
     * return hoeveelheid geld in de kassa
     * @return inKas;
     */
    public double hoeveelheidGeldInKassa()
    {
       return inKas;
    }
    
    /**
     * reset de waarden van het aantal gepasseerde artikelen en
     * de totale hoeveelheid geld in de kassa
     */
    public void resetKassa()
    {
        verkochteArtikelen = 0;
        inKas = 0;
    }
}