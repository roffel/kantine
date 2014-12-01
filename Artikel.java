/**
 * Met deze klasse kunnen artikelen worden aangemaakt en informatie over deze
 * artikelen worden verstrekt.
 * 
 * @author Rutger Roffel & Patrick Swijgman
 * @version 1.0
 */
public class Artikel
{
    /**
     * Velden:
     * Defineer de velden voor het artikel
     */
    private String naam;
    private double prijs;

    
    /**
     * Constructor:
     * Initialiseer de velden voor het artikel via parameters
     * @param naam De naam voor het artikel
     * @param prijs De prijs voor het artikels
     */
    public Artikel(String naam, double prijs)
    {
       setNaam(naam);
       setPrijs(prijs);
    }
    
    /**
     * Constructor:
     * Initialiseer de velden voor het artikel zonder data
     */
    public Artikel()
    {
        setNaam("Onbekend");
        setPrijs(0.00);
    }
    
    /**
     * Methode:
     * Return de naam van het artikel
     * @return naam;
     */
    public String getNaam(){
        return naam;
    }
    /**
     * Methode:
     * Return de prijs van het artikel
     * @return prijs
     */
    public double getPrijs(){
        return prijs;
    }
    
    /**
     * Methode:
     * Defineer een nieuwe naam voor het artikel
     * @param naam
     */
    public void setNaam(String naam){
        this.naam = naam;
    }
    
    /**
     * Methode:
     * Defineer een nieuwe prijs voor het artikel
     * @param prijs
     */
    public void setPrijs(double prijs){
        this.prijs = prijs;
    }

    /**
     * Methode:
     * Laat de gegevens van het artikel zien in een terminal-venster
     */
    public void drukAf()
    {
        System.out.println("Naam: "+ getNaam());
        System.out.println("Prijs: "+ getPrijs());
    }
}
