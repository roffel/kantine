import java.util.*;
/**
 * Kantine simulatie simuleert een kantine over een x aantal dagen.
 * 
 * @author Patrick Swijgman & Rutger Roffel 
 * @version 2.0
 */
public class KantineSimulatie {
     // kantine
     private Kantine kantine;
     // persoon1
     private Persoon persoon1;
     // dienblad1
     private Dienblad dienblad1;
     // kantine aanbod
     private KantineAanbod kantineaanbod;
     // random
     private Random random;
     // aantal artikelen
     private static final int AANTAL_ARTIKELEN=4;
    // artikelen
     private static final String[] artikelnamen=
     new String[] {"Koffie","Broodje pindakaas", "Broodje kaas", "Appelsap"};
     // prijzen
     private static double[] artikelprijzen=
     new double[]{1.50, 2.10, 1.65, 1.65};
     // minimum en maximum aantal artikelen per soort
     private static final int MIN_ARTIKELEN_PER_SOORT=600;
     private static final int MAX_ARTIKELEN_PER_SOORT=800;
     // minimum en maximum aantal personen per dag
     private static final int MIN_PERSONEN_PER_DAG=50;
     private static final int MAX_PERSONEN_PER_DAG=100;
     // minimum en maximum artikelen per persoon
     private static final int MIN_ARTIKELEN_PER_PERSOON=1;
     private static final int MAX_ARTIKELEN_PER_PERSOON=1;
     
     /**
     * Constructor
     */
     public KantineSimulatie() {
         // kantine
         kantine = new Kantine();
         
         random = new Random();
         int[] hoeveelheden=getRandomArray(AANTAL_ARTIKELEN,MIN_ARTIKELEN_PER_SOORT, MAX_ARTIKELEN_PER_SOORT);
         kantineaanbod = new KantineAanbod(artikelnamen, artikelprijzen, hoeveelheden);
         kantine.setKantineAanbod(kantineaanbod);
         
     }
     
     /**
     * Deze methode simuleert een aantal dagen in het
     * verloop van de kantine
     * @param dagen (aantal dagen om te simuleren)
     */
    public void simuleer(int dagen) {
        
         // for lus voor dagen
         for(int i=0;i<dagen;i++) {
         // bedenk hoeveel personen vandaag binnen lopen
         int aantalpersonen = getRandomValue(MIN_PERSONEN_PER_DAG, MAX_PERSONEN_PER_DAG);
        // laat de personen maar komen...
         for(int j=0;j<aantalpersonen;j++) {
             // maak persoon en dienblad aan, koppel ze
             persoon1 = new Persoon(1234,"Lammerd","Geertema",28,2,1984,'m');
             dienblad1 = new Dienblad();
             persoon1.pakDienblad(dienblad1);
             // bedenk hoeveel artikelen worden gepakt
             int aantalartikelen = getRandomValue(MIN_ARTIKELEN_PER_PERSOON, MAX_ARTIKELEN_PER_PERSOON);
             // genereer de “artikelnummers”, dit zijn indexen
             // van de artikelnamen array
             int[] tepakken = getRandomArray(aantalartikelen, 0, AANTAL_ARTIKELEN-1);
             
             // vind de artikelnamen op basis van
             // de indexen hierboven
             String[] artikelen = geefArtikelNamen(tepakken);
             
             //artikelHoeveelheidAftrekken(artikelen, aantalartikelen);
            
             // loop de kantine binnen, pak de gewenste
             // artikelen, sluit aan
             kantine.loopPakSluitAan(persoon1, artikelen);
             
         }
         // verwerk rij voor de kassa
         kantine.verwerkRijVoorKassa();       
         
         //
         checkArtikelHoeveelheidEnVulAan(MIN_ARTIKELEN_PER_PERSOON, MAX_ARTIKELEN_PER_PERSOON);
         
         // toon dagtotalen (artikelen en geld in kassa)
         System.out.println("Aantal artikelen verkocht: " + kantine.getKassa().aantalArtikelen());
         
         double geld = kantine.getKassa().hoeveelheidGeldInKassa();
         System.out.println("Geld in kassa: " +  Math.round(geld * 100.0)/100.0);
         System.out.println();
         // reset de kassa voor de volgende dag
         kantine.getKassa().resetKassa();
        
     }
    }
    
    /**
     * Methode om een array van random getallen liggend tussen min en
    max
     * van de gegeven lengte te genereren
     * @param lengte
     * @param min
     * @param max
     * @return De array met random getallen
     */
     private int[] getRandomArray(int lengte, int min, int max) {
         int[] temp=new int[lengte];
            for(int i=0;i<lengte;i++) {
                temp[i]=getRandomValue(min, max);
            }
            return temp;
     }
     
     /**
     * Methode om een random getal tussen min(incl) en
     * max(incl) te genereren.
     * @param min
     * @param max
     * @return Een random getal
     */
     private int getRandomValue(int min, int max) {
         return random.nextInt(max-min+1)+min;
     }
     
     /**
     * Methode om op basis van een array van indexen voor de array
     * artikelnamen de bijhorende array van artikelnamen te maken
     * @param indexen
     * @return De array met artikelnamen
     */
     private String[] geefArtikelNamen(int[] indexen) {
         String[] artikelen=new String[indexen.length];
         for(int i=0;i<indexen.length;i++) {
             artikelen[i]=artikelnamen[indexen[i]];
         }
         return artikelen;
     }
     
     /**
      * Methode om te kijken naar alle artikelen en controleren of de hoeveelheid lager is dan het minimum
      * Zo ja, dan wordt het random bijgevuld tussen het minimum en het maximum
      */
     private void checkArtikelHoeveelheidEnVulAan(int min, int max){
        
        for (HashMap.Entry<String, Integer> entry : kantineaanbod.getArtikelArray().entrySet())
        {
            if (entry.getValue() < min) {
                entry.setValue(getRandomValue(min, max));
                //System.out.println("Bijgevuld: " + entry.getKey() + " : " + entry.getValue());
            }
        }
    
     }
     
     /**
      * Methode om de artikelen af te trekken qua hoeveelheid aan de hand van de variabele aantalartikelen.
      * @param artikelen De array met artikelnamen die de persoon gekozen heeft (zie de methode: simuleer)
      * @param aantalartikelen Het getal dat van de artikelhoeveelheid moet worden afgetrokken
      */
     private void artikelHoeveelheidAftrekken(String[] artikelen, int aantalartikelen){
        for (String artikelnaam : artikelen) {
            for (HashMap.Entry<String, Integer> entry : kantineaanbod.getArtikelArray().entrySet())
            {
                if (entry.getKey().equals(artikelnaam)) {
                    if (entry.getValue() > 0) {
                       // System.out.println("Voor: " + entry.getKey() + " : " + entry.getValue());
                        entry.setValue(entry.getValue()-aantalartikelen);
                       // System.out.println("Na: " + entry.getKey() + " : " + entry.getValue());
                    }
                }
            }
        }
     }
     
}