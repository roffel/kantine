/**
 * Maakt een kantine aan
 * @author Patrick Swijgman & Rutger Roffel 
 * @version 1.0
 */
public class Kantine {
     private Kassa kassa;
     private KassaRij kassarij;
     /**
     * Constructor
     */
     public Kantine() {
        kassarij=new KassaRij();
        kassa=new Kassa(kassarij);
     }
     /**
     * In deze methode wordt een Persoon en Dienblad
     * gemaakt en aan elkaar
     * gekoppeld. Maak twee Artikelen aan en plaats
     * deze op het dienblad.
     * Tenslotte sluit de Persoon zich aan bij de rij
     * voor de kassa.
     */
     public void loopPakSluitAan() {
         Persoon persoon1 = new Persoon(1234,"Geert","Lammerd",28,2,1984,'m');
         Dienblad dienblad1 = new Dienblad();
         Artikel artikel1 = new Artikel("Gehaktbal",2.95);
         Artikel artikel2 = new Artikel("Tosti",1.90);
         
         persoon1.pakDienblad(dienblad1);
         persoon1.pakArtikel(artikel1);
         persoon1.pakArtikel(artikel2);
         
         kassarij.sluitAchteraan(persoon1);
     }
     /**
     * Deze methode handelt de rij voor de kassa af.
     */
     public void verwerkRijVoorKassa() {
        while(kassarij.erIsEenRij()) {
             Persoon staatBijKassa = kassarij.eerstePersoonInRij();
             kassa.rekenAf(staatBijKassa);
        }
     }
     /**
     * Deze methode telt het geld uit de kassa
     * @return hoeveelheid geld in kassa
     */
     public double hoeveelheidGeldInKassa() {
        return kassa.hoeveelheidGeldInKassa();
     }
     /**
     * Deze methode geeft het aantal gepasseerde artikelen.
     * @return het aantal gepasseerde artikelen
     */
     public int aantalArtikelen(){
         return kassa.aantalArtikelen();
     }
    
     /**
     * Deze methode reset de bijgehouden telling van
     * het aantal artikelen
     * en "leegt" de inhoud van de kassa.
     */
     public void resetKassa() {
         kassa.resetKassa();
     }
}
