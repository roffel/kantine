import java.util.*;

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
     * en controleer als het persoon genoeg saldo heeft
     * om de transactie te maken.
     * @param persoon die moet afrekenen
     */
    public void rekenAf(Persoon persoon)
    {
        double betaling = getTotaalPrijs(persoon);
        double kortingsPercentage = 0.00;
        double kortingsBedrag = 0.00;
        boolean heeftMaximum = false;
        
        if (persoon instanceof KortingskaartHouder) {
            KortingskaartHouder kaartHouder = (KortingskaartHouder) persoon;
            kortingsPercentage = kaartHouder.geefKortingsPercentage();
            heeftMaximum = kaartHouder.heeftMaximum();
            if (kortingsPercentage > 0){
                kortingsBedrag = betaling * kortingsPercentage;
            }
            if (heeftMaximum){
                kortingsBedrag = Math.min(kortingsBedrag, kaartHouder.geefMaximum());
            }
        }
        if (persoon.getBetaalwijze().betaal(betaling-kortingsBedrag)) {
            verkochteArtikelen += getAantalArtikelen(persoon);
            inKas += betaling;
        } else {
            System.out.println("Niet genoeg saldo!");
        }
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
    
    public int getAantalArtikelen(Persoon persoon){
        Iterator<Artikel> it = persoon.getDienblad().getArtikelIterator();
        int aantal = 0;
        while (it.hasNext()){
            it.next();
            aantal++;
        }
        return aantal;
    }
    
    public double getTotaalPrijs(Persoon persoon){
        double totaalPrijs = 0.00;
        Iterator<Artikel> it = persoon.getDienblad().getArtikelIterator();
        while (it.hasNext()){
            Artikel artikel = it.next();
            totaalPrijs += artikel.getPrijs();
        }
        
        return totaalPrijs;
    }
}
