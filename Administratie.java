public class Administratie {
  /**
   * Deze methode berekent van de int array aantal de 
   * gemiddelde waarde
   * @param aantal
   * @return het gemiddelde
   */
  
  
  private static final int DAYS_IN_WEEK = 7;
  
  private Administratie(){
      //Je kan niet geen instantie maken van dit object
  }
  
  public static double berekenGemiddeldAantal(int[] aantal) {
    double totaleAantal = 0.00;
    for (int i = 0; i < aantal.length; i++) {
        totaleAantal += (double)aantal[i];
    }
    if (aantal.length > 0) {
        return (double)totaleAantal/aantal.length;
    }
    return 0.00;
  }

  /**
   * Deze methode berekent van de double array omzet de 
   * gemiddelde waarde
   * @param omzet
   * @return Het gemiddelde
   */
  public static double berekenGemiddeldeOmzet(double[] omzet) {
    double totaleOmzet = 0.00;
    for (int i = 0; i < omzet.length; i++) {
        totaleOmzet += omzet[i];
    }
    if (omzet.length > 0) {
        return totaleOmzet/omzet.length;
    }
    return 0.00;
  }
  
  public static double[] berekenDagOmzet(double[] omzet) {
      double[] temp = new double[DAYS_IN_WEEK];
      for (int i=0; i < DAYS_IN_WEEK; i++){
          int j = 0;
          while ((i+DAYS_IN_WEEK*j) < omzet.length) {
              temp[i] += omzet[i+DAYS_IN_WEEK*j];
              j++;
          }
      }
      return temp;
  }
}
