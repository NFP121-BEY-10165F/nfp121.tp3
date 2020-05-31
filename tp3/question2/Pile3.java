package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;

/**
 * Décrivez votre classe PileVector ici.
 * 
 * @FREDERIC khoueiry
 * @1
 */
public class Pile3 implements PileI {

	private Vector<Object> v;
        private int capacite;
	public Pile3() {
		this(PileI.CAPACITE_PAR_DEFAUT);
	}

	public Pile3(int taille) {
        if(taille<=0)
            taille=CAPACITE_PAR_DEFAUT;
          
        v=new Vector<Object>();
        this.capacite=taille;
        
    }

	public void empiler(Object o) throws PilePleineException {
	if(this.estPleine())
            throw new PilePleineException();            
        v.add(o);
        capacite--;
	}

	public Object depiler() throws PileVideException {
		if(this.estVide())
            throw new PileVideException();
        capacite++;
        Object deleted=v.get(v.size()-1);
        v.remove(deleted);
        return deleted;
    }

	public Object sommet() throws PileVideException {
		if(this.estVide())
            throw new PileVideException();
        return v.get(v.size()-1);
    }

    public int taille() {
        return this.v.size();
    }

    public int capacite() {
        return capacite;
    }

    public boolean estVide() {
        return v.isEmpty();
    }

    public boolean estPleine() {
        return v.size()==capacite;
    }

    public String toString() {
        String s = "[";
       for(int i=v.size()-1;i>0;i--)
        if(v.get(i)!=null)
           s+=v.get(i)+ ", ";
       if(v.get(0)!=null)
        s+=v.get(0);
        return s+"]";
    }

    public boolean equals(Object o) {
        Pile3 p = (Pile3) o;
        try{
            if(p.taille()==this.taille()&&p.capacite()==this.capacite())
            {
                for(int i=0;i<this.taille();i++)
                    if(!p.depiler().equals(this.depiler()))
                        return false;
                return true;
            }
        }
        catch(PileVideException exp)
        {
           return p.taille()==this.taille()&&p.capacite()==this.capacite();
        }
        return false;
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

}
