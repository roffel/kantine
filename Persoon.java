/**
 * Klasse Persoon
 * In deze klasse worden alle gegevens van personen bijgehouden etc.
 * @author Rutger Roffel & Patrick Swijgman
 * @version 1.0
 */
public class Persoon
{
    /**
     * Velden:
     * Defineer de velden voor een persoon
     */
    private int bsn;            // Bsn van persoon
    private String voornaam;    // Voornaam van persoon
    private String achternaam;  // Achternaam van persoon
    private int geboorteDag;    // Geboortedag van persoon
    private int geboorteMaand;  // Geboortemaand van persoon
    private int geboorteJaar;   // Geboortejaar van persoon
    private char geslacht;      // Geslacht van persoon (m/v)
    private Dienblad dienblad;  // Dienblad van de persoon
    
    /**
     * Constructor:
     * Initialiseer de velden voor een persoon
     * @params bsn, voornaam, achternaam, geboorteDag, geboorteMaand, geboorteJaar, geslacht
     */
    public Persoon(int bsn, String voornaam, String achternaam, int geboorteDag, int geboorteMaand, int geboorteJaar, char geslacht)
    {
       setBsn(bsn);
       setVoornaam(voornaam);
       setAchternaam(achternaam);
       setGeslacht(geslacht);
       setGeboortedatum(geboorteDag, geboorteMaand, geboorteJaar);
    }
    
    /**
     * Constructor:
     * Deze constructor heeft geen parameters
     */
    public Persoon()
    {
        setGeslacht('o');
        setGeboortedatum(0,0,0);
    }
    /**
     * Methode:
     * Return het BSN nummer van een persoon
     * @return bsn
     */
    public int getBsn(){
        return bsn;
    }
   
    /**
     * Methode:
     * Return de voornaam van een persoon
     * @return voornaam
     */
    public String getVoornaam(){
        return voornaam;
    }
    
    /**
     * Methode:
     * Return de achternaam van een persoon
     * @return achternaam
     */
    public String getAchternaam(){
        return achternaam;
    }
    
    /**
     * Methode:
     * Return de geboortedatum van een persoon
     * (dd/mm/yyyy)
     * @return temp
     */
    public String getGeboortedatum()
    {
        String temp;
        if (geboorteDag==0 || geboorteMaand==0 || geboorteJaar==0)
        {
            temp="Onbekend";
        }
        else
        {
            temp = geboorteDag+ "/" +geboorteMaand+ "/" +geboorteJaar;
        }
        return temp;
    }
    
    /**
     * Methode:
     * Return het geslacht van een persoon
     * ('man'/'vrouw')
     * @return String geslacht;
     */
    public String getGeslacht(){
        if(geslacht == 'm')
        {
               return "man";
        }
        else if(geslacht == 'v')
        {
               return "vrouw";
        }
        else
        {
            return "onbekend";
        }
    }
    
    /**
     * Methode:
     * Defineer een nieuw BSN nummer voor een persoon
     * @param bsn
     */
    public void setBsn(int bsn){
        this.bsn = bsn;
    }
    
    /**
     * Methode:
     * Defineer een nieuwe voornaam voor een persoon
     */
    public void setVoornaam(String voornaam){
        this.voornaam = voornaam;
    }
    
    /**
     * Methode:
     * Defineer een nieuwe achternaam voor een persoon
     * @params achternaam
     */
    public void setAchternaam(String achternaam){
        this.achternaam = achternaam;
    }
    
    /**
     * Methode:
     * Defineer een nieuwe geboortedatum voor een persoon
     * (dd/mm/yyyy)
     * @params dag, maand, jaar
     */
    public void setGeboortedatum(int geboorteDag, int geboorteMaand, int geboorteJaar){
        if(geboorteMaand >= 1 && geboorteMaand <= 12)
        {
            int daylimit = 0;
            if(geboorteMaand == 1 || geboorteMaand == 3 || geboorteMaand == 5 || geboorteMaand == 7 || geboorteMaand == 8 || geboorteMaand == 10 || geboorteMaand == 12)
            {
                daylimit = 31;
            }
            else if(geboorteMaand == 2)
            {
                //SchrikkelgeboorteJaar berekenen voor februari
                if ((geboorteJaar % 400) == 0)
                {
                    daylimit = 29;
                }
                else
                {
                    daylimit = 28;
                }
            }
            else
            {
                daylimit = 30;
            }
            if(geboorteDag >= 1 && geboorteDag <= daylimit)
            {
                this.geboorteDag = geboorteDag;
            }
            else
            {
               this.geboorteDag = 0;
               System.out.println("De ingevulde geboorteDag heeft een onjuiste waarde!");
            }
            this.geboorteMaand = geboorteMaand;
        }
        else
        {
           this.geboorteMaand = 0;
           System.out.println("De ingevulde geboorteMaand heeft een onjuiste waarde!");
        }
        if(geboorteJaar >= 1900 && geboorteJaar <= 2100)
        {
            this.geboorteJaar = geboorteJaar;
        }
        else
        {
            this.geboorteJaar = 0;
            System.out.println("De ingevulde geboorteJaar heeft een onjuiste waarde!");
        }
    }

    
    /**
     * Methode:
     * Defineer een ander geslacht voor een persoon
     * ('m'/'v')
     * @params newGeslacht
     */
    public void setGeslacht(char geslacht){
        if(geslacht == 'm' || geslacht == 'v' || geslacht == 'M' || geslacht == 'V')
        {
            this.geslacht = Character.toLowerCase(geslacht);
        }
        else
        {
            System.out.println("De waarde "+ this.geslacht +" is geen juiste waarde voor het systeem");
        }
    }

    /**
     * Methode:
     * Laat de gegevens zien van een persoon in een terminal-venster
     */
    public void drukAf()
    {
        System.out.println("Naam: "+ getVoornaam() + " " + getAchternaam());
        System.out.println("BSN: "+ getBsn());
        System.out.println("Geboortedatum: "+ getGeboortedatum());
        System.out.println("Geslacht: "+ getGeslacht());
    }

    
    /**
    * Methode om dienblad te koppelen aan een persoon
    * Als het persoon geen dienblad heeft maakt dan een nieuwe aan.
    * @param dienblad
    */
    public void pakDienblad(Dienblad dienblad)
    {
        this.dienblad = dienblad;
    }
    
    /**
    * Methode om een artikel op een dienblad te zetten. 
    * @param artikel
    */
    public Dienblad getDienblad(){
        return dienblad;
    }

    
}
