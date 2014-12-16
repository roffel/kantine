
/**
 * Write a description of class PersoonsVergelijker here.
 * 
 * @author Patrick Swijgman & Rutger Roffel
 * @version 1.0
 */
public class PersoonsVergelijker
{
    public static void main(String[] args){
        Persoon p1 = new Persoon(123,"Geert","Lammerd",28,02,2008,'m');
        Persoon p2 = p1;//new Persoon(123,"Geert","Lammerd",28,02,2008,'m');
        
        if (p1 == p2){
            System.out.println("p1 == p2: true");
        }
        
        if (p1.equals(p2)) {
            System.out.println("p1.equals(p2): true");
        }
        
        
    }
}
