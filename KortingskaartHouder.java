/**
 * interface KortingskaartHouder - geef hier een beschrijving van deze interface
 *
 * @author Rutger Roffel & Patrick Swijgman
 * @version 1.0
 */
public interface KortingskaartHouder {
    // methode om kortingspercentage op te vragen
    public double geefKortingsPercentage();
    // methode om op te vragen of er maximum per keer aan de korting zit
    public boolean heeftMaximum();
    // methode om het maximum kortingsbedrag op te vragen public double geefMaximum();
    public double geefMaximum();
}