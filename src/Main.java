import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List<Sac> listSac = new ArrayList<>();
        int poidMax=0, sacopti=0,totalPoid = 0, essai;
        List<ObjectDonne> listObject = new ArrayList<>() ;
        float pourcentagePerformance = 0;
        //Nombre Essai que l'algorithme va executer
        for( essai=0;essai<100;essai++) {
            int i=0;
            sacopti=0; totalPoid = 0; poidMax=0;
            listObject.removeAll(listObject); listSac.removeAll(listSac);
            Random random = new Random();
            //Tire au hazard le poidMax
            poidMax  = random.nextInt(100)+1;
            //Cree des objets avec le poids aleatoire
            for(int k=0;k<5000;k++){
                double poid = Math.random();
                poid = poid * poidMax + 1;
                int poidInt = (int) poid;
                listObject.add(new ObjectDonne(k+1,poidInt));
                totalPoid += poidInt;
            }

            double a = totalPoid/poidMax;
            //Verifie si Nombre Sac Possible est double ou int. Si double, augment 1
            sacopti = (int)a;
            if (a!=sacopti){
                sacopti++;
            }
            //Ajoute premiere objet dans sac
            listSac.add(new Sac(i,poidMax));

            for (ObjectDonne objectDonne : listObject) {
                for (int j = 1; j <= i + 1; j++) {
                    if (!listSac.get(j - 1).getListObject().contains(objectDonne)) {
                        if (objectDonne.getPoid() <= listSac.get(j - 1).getPoidMax()) {
                            listSac.get(j - 1).getListObject().add(objectDonne);
                            listSac.get(j - 1).setPoidMax(listSac.get(j - 1).getPoidMax() - objectDonne.getPoid());
                            break;
                        } else {
                            //Verifie si le sac est plein ou pas. Et verifie si ce sac est le derniere sac ou pas
                            if (listSac.get(j - 1).getPoidMax() == 0 && listSac.size() != j) {
                                continue;
                            } else {
                                if (objectDonne.getPoid() > listSac.get(j - 1).getPoidMax() && listSac.size() != j) {
                                    continue;
                                } else {
                                    i++;
                                    listSac.add(new Sac(i, poidMax));
                                    listSac.get(i).getListObject().add(objectDonne);
                                    listSac.get(i).setPoidMax(listSac.get(i).getPoidMax() - objectDonne.getPoid());
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            pourcentagePerformance += sacopti/(float)listSac.size()*100;
        }
        float pourcentageTotal = pourcentagePerformance/essai;

        for(Sac sacTest: listSac) {
            System.out.println("Sac: " + sacTest.getNom()+". List: " + sacTest.getListObject().toString());
        }


        System.out.println("Nb de Sac optimal: "+(double)totalPoid/poidMax + ":"+totalPoid/poidMax);

        PrintWriter writer = new PrintWriter("test.csv");
        writer.print("Nb d'essai ,");
        writer.print("Nb Objet Total ,");
        writer.print("Nb Poids Total ,");
        writer.print("Poids Max du sac ,");
        writer.print("Nb Sac Total par Algo ,");
        writer.print("Nb Sac Possible ,");
        writer.println("Performance en %");
        writer.print(essai+",");
        writer.print(listObject.size()+",");
        writer.print(totalPoid+",");
        writer.print(poidMax+",");
        writer.print(listSac.size()+",");
        writer.print(sacopti+",");
        writer.println(pourcentageTotal+"%");
        writer.close();


    }
}
