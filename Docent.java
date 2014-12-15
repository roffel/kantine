
/**
 * Klasse Docent is een subklasse van de superklasse Persoon
 * In deze klasse worden Docent specifieke velden gedefineerd en
 * kunnen deze worden opgehaald.
 * 
 * @author Rutger Roffel & Patrick Swijgman
 * @version 1.0
 */
public class Docent extends Persoon
{
    // instance variables - replace the example below with your own
    private String afkorting;
    private String afdeling;

    /**
     * Constructor:
     * Initialiseer de velden voor een persoon
     * @params bsn, voornaam, achternaam, geboorteDag, geboorteMaand, geboorteJaar, geslacht, afkorting, afdeling
     */
    public Docent(int bsn, String voornaam, String achternaam, int geboorteDag, int geboorteMaand, int geboorteJaar, char geslacht
                   ,String afkorting, String afdeling)
    {
       super(bsn,  voornaam,  achternaam,  geboorteDag,  geboorteMaand,  geboorteJaar,  geslacht);
        setAfkorting(afkorting);
        setAfdeling(afdeling);
    }
    
    /**
     * Methode - Zet de afkorting van een docent 
     * 
     * @param afkorting
     */
    public void setAfkorting(String afkorting){
        if (afkorting.length() > 4) {
            this.afkorting = afkorting.substring(0,4).toUpperCase();
        } else {
            this.afkorting = afkorting.toUpperCase();
        }
    }

    /**
     * Methode - Zet de afdeling van een docent 
     * 
     * @param afdeling
     */
    public void setAfdeling(String afdeling){
        this.afdeling = afdeling;
    }
    
    /**
     * Methode - Geeft de afkorting van een docent terug
     * 
     * @return afkorting        de afkorting van een docent
     */
    public String getAfkorting(){
        return afkorting;
    }

    /**
     * Methode - Geeft de afdeling van een docent terug
     * 
     * @return afdeling        de afdeling van een docent 
     */
    public String getAfdeling(){
        return afdeling;
    }
    
    public void drukAf()
    {
        System.out.println("Afkorting: " + getAfkorting());
        System.out.println("Afdeling: " + getAfdeling());
    }
    
}
