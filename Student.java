
/**
 * Klasse Student is een subklasse van de superklasse Persoon
 * In deze klasse worden Student specifieke velden gedefineerd en
 * kunnen deze worden opgehaald.
 * 
 * @author Rutger Roffel & Patrick Swijgman
 * @version 1.0
 */
public class Student extends Persoon
{
    // instance variables - replace the example below with your own
    private int studentNummer;
    private String studieRichting;

    /**
     * Constructor:
     * Initialiseer de velden voor een persoon
     * @params bsn, voornaam, achternaam, geboorteDag, geboorteMaand, geboorteJaar, geslacht, studentNummer, studieRichting
     */
    public Student(int bsn, String voornaam, String achternaam, int geboorteDag, int geboorteMaand, int geboorteJaar, char geslacht
                   ,int studentNummer, String studieRichting)
    {
        super(bsn,  voornaam,  achternaam,  geboorteDag,  geboorteMaand,  geboorteJaar,  geslacht);
        setStudentNummer(studentNummer);
        setStudieRichting(studieRichting);
    }

    /**
     * Methode - Geeft het studentnummer terug
     * 
     * @return studentNummer        Het nummer van een student 
     */
    public int getStudentNummer()
    {
        return studentNummer;
    }
    
     /**
     * Methode - Geeft de studie richting terug
     * 
     * @return studie richting      De studie richting van een student 
     */
    public String getStudieRichting()
    {
        return studieRichting;
    }
    
    /**
     * Methode - Zet het studentnummer 
     * 
     * @param studentNummer
     */
    public void setStudentNummer(int studentNummer)
    {
        this.studentNummer = studentNummer;
    }
    
     /**
     * Methode - Zet de studie richting 
     * 
     * @param studieRichting
     */
    public void setStudieRichting(String studieRichting)
    {
        this.studieRichting = studieRichting;
    }
    
    public void drukAf()
    {
        System.out.println("StudentNR: " + getStudentNummer());
        System.out.println("Studierichting: " + getStudieRichting());
    }
    
}
