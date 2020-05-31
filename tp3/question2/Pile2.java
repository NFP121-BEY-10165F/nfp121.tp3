package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2 implements PileI {
    /** par delegation : utilisation de la class Stack */
    private Stack<Object> stk;

    /** la capacite de la pile */
    private int capacite;

    /**
     * Creation d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit etre > 0
     */
    public Pile2(int taille) {
        if (taille <= 0)
            taille = CAPACITE_PAR_DEFAUT;
            
        stk=new Stack<Object>();
        this.capacite=taille;
        
    }

    // constructeur fourni
    public Pile2() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
       if(!this.estPleine())
        {
            capacite--;
            stk.push(o);
        }
    }

    public Object depiler() throws PileVideException {
        if(!this.estVide())
        {
           capacite++;
           return stk.pop();
        }
        return null;
    }

    public Object sommet() throws PileVideException {
        if (estVide())
            throw new PileVideException();
            
        return stk.peek();
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        return stk.empty();
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        return capacite==0;
    }

    /**
     * Retourne une representation en String d'une pile, contenant la
     * representation en String de chaque element.
     * 
     * @return une representation en String d'une pile
     */
    public String toString() {
        String s = "[";
       for(int i=stk.size()-1;i>0;i--)
         if(stk.get(i)!=null)
           s+=stk.get(i)+ ", ";
       if(stk.get(0)!=null)
        s+=stk.get(0);
        return s+"]";
    }

    public boolean equals(Object o) {
       Pile2 p1 = (Pile2)o;
        try{
            if(p1.taille()==this.taille()&&p1.capacite()==this.capacite())
            {
                for(int i=0;i<this.taille();i++)
                    if(!p1.depiler().equals(this.depiler()))
                        return false;
                return true;
            }
        }
        catch(PileVideException exp)
        {
           return p1.taille()==this.taille()&&p1.capacite()==this.capacite();
        }
        return false;
    }


    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    public int taille() {
        return stk.size();
    }


    public int capacite() {
        return capacite;
    }

} // Pile2.java