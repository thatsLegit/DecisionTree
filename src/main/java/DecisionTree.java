import java.util.*;

public class DecisionTree {

    Scanner sc = new Scanner(System.in);
    static HashMap<String, Integer> model;
    int feature;

    public DecisionTree() {
        this.feature = feature;
        this.model = new HashMap<>();
    }

    public void featureSelection(){
        do {
            System.out.println("Select one of the available features (enter the corresponding number) : ");
            feature = sc.nextInt();
            System.out.println("");
        } while (feature!=0 & feature!=2 & feature!=3 & feature!=4 & feature!=5 & feature!=6 & feature!=7 & feature!=8 & feature!=9 & feature!=10 & feature!=11);
    }

    public void trainModel(){
        //compter le nombre d'observations de chaque classe
        //compter la somme de la survivance de la classe
        //faire une rapport des deux, si <0.5, c'est 0, sinon 1.
        Set<String> set = Entropy.Sets.get(feature);
        for (String entry : set){
            System.out.println("profile : " + entry);
            int counter = 0;
            int Ssum=0;
            int position=0;
            for (int i=0;i<TrainingDataSet.featureValue.size();i++){
                if (TrainingDataSet.featureValue.get(i).equals(entry)){
                    counter++;
                    Ssum+=Integer.parseInt(TrainingDataSet.survivedValue.get(i));
                }
            }
            System.out.println("Population : " + counter);
            System.out.println("Number of survivors for the given profile : " + Ssum + System.lineSeparator());
            if (counter/2<Ssum){
                position = 1;
            }
            model.put(entry, position);
        }
    }

    public int getFeature() {
        return feature;
    }

    public HashMap<String, Integer> getModel() {
        for (Map.Entry<String, Integer> entry : model.entrySet()){
            System.out.println("Profile : " + entry.getKey() + " .....survivability : " + entry.getValue());
            System.out.println("");
        }
        return model;
    }
}
