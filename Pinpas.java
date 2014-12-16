public class Pinpas extends Betaalwijze {
    private double kredietlimiet;
    
    /**
     * Methode om kredietlimiet te zetten
     * @param kredietlimiet
     */
    public void setKredietLimiet(double kredietlimiet) {
        //omitted
    }

    /**
     * Methode om betaling af te handelen
     */
    public boolean betaal(double tebetalen) {
        if (saldo+kredietlimiet >= tebetalen)
        {
            saldo -= tebetalen;
            return true;
        }
        return false;
    }
}