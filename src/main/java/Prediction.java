import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Prediction {

    //Based on the data set, this class will assess the performance of the predictive model
    int correctlyClassifiedInstances;

    public Prediction() {
        this.correctlyClassifiedInstances = correctlyClassifiedInstances;
    }

    //calculate the number of correctly classified instances for the selected feature on the test set
    public void TestLines(ArrayList<String> featureValue, HashMap<String, Integer> model, ArrayList<String> survivedValue){
        for (int i = 0; i< featureValue.size(); i++){
            int prediction = 0;
            int reality = 0;
            for (Map.Entry<String, Integer> entry : model.entrySet()){
                if (featureValue.get(i).equals(entry.getKey())){
                    prediction = entry.getValue();
                    reality = Integer.parseInt(survivedValue.get(i));
                    if (prediction==reality){
                        correctlyClassifiedInstances++;
                    }
                }
            }
        }
    }

    //displays the performance result
    public int getCorrectlyClassifiedInstancesPercentage(ArrayList<String> featureValue){
        System.out.println("");
        System.out.println("Testing the model : " + System.lineSeparator());
        System.out.println("Correctly classified instances : " + (correctlyClassifiedInstances*100)/ featureValue.size() + "%");
        return (correctlyClassifiedInstances*100)/ featureValue.size();
    }
}
