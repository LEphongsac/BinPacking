import java.util.ArrayList;
import java.util.List;

public class Sac {
    private int poidMax;
    private List<ObjectDonne> listObject;
    private int nom;

    public Sac(int nom,int poidMax) {
        this.poidMax = poidMax;
        listObject = new ArrayList<>();
        this.nom = nom;
    }

    public int getPoidMax() {
        return poidMax;
    }

    public int getNom() {
        return nom;
    }

    public void setPoidMax(int poidMax) {
        this.poidMax = poidMax;
    }

    public List<ObjectDonne> getListObject() {
        return listObject;
    }

    public void setListObject(List<ObjectDonne> listObject) {
        this.listObject = listObject;
    }
}
