/**
 * Kantine simulatie simuleert een kantine over een x aantal dagen.
 * 
 * @author Patrick Swijgman & Rutger Roffel 
 * @version 1.0
 */
public class KantineSimulatie {
     private Kantine kantine;
     
     /**
     * Constructor
     */
     public KantineSimulatie() {
         kantine = new Kantine();
     }
     
     /**
     * Deze methode simuleert een aantal dagen in het
     * verloop van de kantine
     * @param dagen (aantal dagen om te simuleren)
     */
    public void simuleer(int dagen) {
         // for lus voor dagen
         for(int i=0; i<dagen; i++) {
         // per dag nu even vast 10+i personen naar binnen
         System.out.println("Dag: " + (i+1));
         // laten gaan, wordt volgende week veranderd...
         // for lus voor personen
             for(int j=0;j<10+i;j++){
                 kantine.loopPakSluitAan();
                }
             // verwerk rij voor de kassa
             kantine.verwerkRijVoorKassa();
             // toon dagtotalen (artikelen en geld in kassa)
             System.out.println("Aantal artikelen verkocht: " + kantine.aantalArtikelen());
             
             double geld = kantine.hoeveelheidGeldInKassa();
             System.out.println("Geld in kassa: " +  Math.round(geld * 100.0)/100.0);
             System.out.println();
             // reset de kassa voor de volgende dag
             kantine.resetKassa();
         }
     }
}