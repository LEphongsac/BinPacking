public class ObjectDonne {
    private int nom;
    private int poid;

    public ObjectDonne(int nom,int poid) {
        this.poid = poid;
        this.nom=nom;
    }

    @Override
    public String toString() {
        return "ObjectDonne{" +
                "nom=" + nom +
                ", poid=" + poid +
                '}';
    }

    public int getPoid() {
        return poid;
    }

    public int getNom() {
        return nom;
    }
}
