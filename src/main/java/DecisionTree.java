import java.util.*;

public class DecisionTree {

    //Here is the class where the training and the feature selection happen

    Scanner sc = new Scanner(System.in);
    HashMap<String, Integer> model;  //Map containing the different profiles and behaviors for a selected feature
    int feature; //int value of the selected feature

    public DecisionTree() {
        this.feature = feature;
        this.model = new HashMap<>();
    }

    public void featureSelection(HashMap<Integer, String> Selection){
        feature = featureChecker(Selection);
        System.out.println("");
    }

    private int featureChecker(HashMap<Integer, String> Selection){
        boolean featureOK = false;
        int value;
        do {
            System.out.println("Select one of the available features (enter the corresponding number) : ");
            value = sc.nextInt();
            for (Map.Entry<Integer, String> entry : Selection.entrySet()){
                if (value==entry.getKey()){
                    featureOK = true;
                    break;
                }
            }
        } while (!featureOK);
        return value;
    }

    public void trainModel(List<Set<String>> Sets, ArrayList<String> featureValue, ArrayList<String> survivedValue){
        Set<String> set = Sets.get(feature);
        for (String entry : set){
            System.out.println("profile : " + entry);
            int counter = 0;
            int Ssum=0;
            int position=0;
            for (int i = 0; i< featureValue.size(); i++){
                if (featureValue.get(i).equals(entry)){
                    counter++;
                    Ssum+=Integer.parseInt(survivedValue.get(i));
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


    public void displayResults() {
        for (Map.Entry<String, Integer> entry : model.entrySet()){
            System.out.println("Profile : " + entry.getKey() + " .....survivability : " + entry.getValue());
            System.out.println("");
        }
    }

    public int getFeature() {
        return feature;
    }

    public HashMap<String, Integer> getModel() {
        return model;
    }

    public String toString(){
        return "This decision tree is helping to decide whether a person is going to survive or not based on its " + Characteristics.Selection.get(feature);
    }
}
