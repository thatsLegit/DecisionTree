import java.util.*;

public class DecisionTree {

    Scanner sc;
    int feature;
    HashMap<String, Integer> model;

    public DecisionTree() {
        this.feature = feature;
        this.sc = new Scanner(System.in);
        this.model = new HashMap<>();
    }

    public void featureSelection(){
        boolean choiceIsOK;
        do {
            System.out.println("Select one of the available features : ");
            feature = sc.nextInt();
            choiceIsOK = true;
            if (feature!=0 & feature!=1 & feature!=2 & feature!=3 & feature!=4 & feature!=5 & feature!=6 & feature!=7 & feature!=8 & feature!=9 & feature!=10 & feature!=11){
                choiceIsOK = false;
            }
        } while (!choiceIsOK);
    }

    public Map<String, Integer> trainModel(){
        //compter le nombre d'observations de chaque classe
        //compter la somme de la survivance de la classe
        //faire une rapport des deux, si <0.5, c'est 0, sinon 1.
        Set set = Entropy.Sets.get(feature);
        HashMap<String, Integer> counter = new HashMap<>();
        for (Object entry : set){

        }



        return null;
    }

    public int getFeature() {
        return feature;
    }
}
