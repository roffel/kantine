
/**
 * Klasse KantineMedewerker is een subklasse van de superklasse Persoon
 * In deze klasse worden KantineMedewerker specifieke velden gedefineerd en
 * kunnen deze worden opgehaald.
 * 
 * @author Rutger Roffel & Patrick Swijgman
 * @version 1.0
 */
public class KantineMedewerker extends Persoon
{
    // instance variables - replace the example below with your own
    private int medewerkersNummer;
    private boolean magAchterKassa;

    /**
     * Constructor:
     * Initialiseer de velden voor een persoon
     * @params bsn, voornaam, achternaam, geboorteDag, geboorteMaand, geboorteJaar, geslacht, medewerkersNummer, magAchterKassa
     */
    public KantineMedewerker(int bsn, String voornaam, String achternaam, int geboorteDag, int geboorteMaand, int geboorteJaar, char geslacht
                   ,int medewerkersNummer, boolean magAchterKassa)
    {
        super(bsn,  voornaam,  achternaam,  geboorteDag,  geboorteMaand,  geboorteJaar,  geslacht);
        setMedewerkersNummer(medewerkersNummer);
        setMagAchterKassa(magAchterKassa);
    }

    /**
     * Methode - Geeft het medewerkersNummer terug
     * 
     * @return medewerkersNummer        Het nummer van een KantineMedewerker 
     */
    public int getMedewerkersNummer()
    {
        return medewerkersNummer;
    }
    
    /**
     * Methode - Geeft true/false terug van magAchterKassa
     * 
     * @return magAchterKassa        De waarde van een magAchterKassa 
     */
    public boolean getMagAchterKassa()
    {
        return magAchterKassa;
    }
    
    /**
     * Methode - Zet het medewerkersNummer 
     * 
     * @param medewerkersNummer
     */
    public void setMedewerkersNummer(int medewerkersNummer)
    {
        this.medewerkersNummer = medewerkersNummer;
    }
    
    /**
     * Methode - Zet de waarde voor magAchterKassa
     * 
     * @param magAchterKassa
     */
    public void setMagAchterKassa(boolean magAchterKassa)
    {
        this.magAchterKassa = magAchterKassa;
    }
    
    public void drukAf()
    {
        System.out.println("MedewerkersNR: " + getMedewerkersNummer());
        System.out.println("Mag achter de kassa: " + getMagAchterKassa());
    }
    
}
