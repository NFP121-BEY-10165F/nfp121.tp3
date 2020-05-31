package question2;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer en partie par votre classe Pile de la question 1.
 * 
 * @frederic khoueiry
 * @1.0
 */
public class Pile implements PileI {

    private Object[] zone;
    private int ptr;

    public Pile(int taille) {
                if (taille < 0)
            taille = CAPACITE_PAR_DEFAUT;
        this.zone = new Object[taille];
        this.ptr = 0;
    }

    public Pile() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        this.zone[this.ptr] = o;
        this.ptr++;
    }

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        this.ptr--;
        return zone[ptr];
    }

    public Object sommet() throws PileVideException {
         if (estVide())
            throw new PileVideException();

        return zone[ptr-1] ;
    }

    public int capacite() {
        return zone.length-ptr;}

    public int taille() {
        return ptr;
    }

    public boolean estVide() {
        return ptr == 0;
    }

    public boolean estPleine() {
        return ptr == zone.length;
    }

    public boolean equals(Object o) {
        if(!(o instanceof Pile))
            return false;
        
        Pile pi = (Pile)o;

        if (pi.taille() == this.taille() && pi.capacite() == this.capacite()){
            for(int i=0; i <zone.length; i++){
                Object tmp = zone[i];
                for(int j =0; j<pi.zone.length; j++){
                    if(tmp != pi.zone[i]&&j==pi.zone.length-1)
                        return false;
                }
            }
            return true;
        }                
        return false;
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
       String s = "[";
       for(int i=zone.length-1;i>0;i--)
         if(zone[i]!=null)
           s+=zone[i]+ ", ";
       if(zone[0]!=null)
        s+=zone[0];
        return s+"]";
    }
}