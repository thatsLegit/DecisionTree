import java.util.Map;

public class Prediction {

    //Based on the data set, this class will assess the performance of the predictive model
    int correctlyClassifiedInstances;

    public Prediction() {
        this.correctlyClassifiedInstances = correctlyClassifiedInstances;
    }

    //calculate the number of correctly classified instances for the selected feature on the test set
    public void TestLines(){
        for (int i =0;i<TestDataSet.featureValue.size();i++){
            int prediction = 0;
            int reality = 0;
            for (Map.Entry<String, Integer> entry2 : DecisionTree.model.entrySet()){
                if (TestDataSet.featureValue.get(i).equals(entry2.getKey())){
                    prediction = entry2.getValue();
                    reality = Integer.parseInt(TestDataSet.survivedValue.get(i));
                    if (prediction==reality){
                        correctlyClassifiedInstances++;
                    }
                }
            }
        }
    }

    //displays the performance result
    public int getCorrectlyClassifiedInstancesPercentage(){
        System.out.println("");
        System.out.println("Testing the model : " + System.lineSeparator());
        System.out.println("Correctly classified instances : " + (correctlyClassifiedInstances*100)/TestDataSet.featureValue.size() + "%");
        return (correctlyClassifiedInstances*100)/TestDataSet.featureValue.size();
    }
}
