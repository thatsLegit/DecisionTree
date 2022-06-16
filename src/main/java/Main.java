public class Main {
    public static void main(String[] args) {

        // Use the files provided in the resources package as some columns has changed
        // place
        // from the original files

        Characteristics characteristics = new Characteristics();
        DecisionTree decision = new DecisionTree();
        DataSet trainDataSet = new DataSet("/Users/iljastepanov/dev/Java/DecisionTree/src/main/resources/train.csv");
        DataSet testDataSet = new DataSet("/Users/iljastepanov/dev/Java/DecisionTree/src/main/resources/test.csv");
        Prediction prediction = new Prediction();

        trainDataSet.loadFromFile();
        characteristics.loadFeatures(trainDataSet.getAllLines());
        characteristics.featuresSelection();
        characteristics.displaySelected();
        decision.featureSelection(characteristics.getSelection());
        trainDataSet.extractFeature(trainDataSet.getAllLines(), decision.getFeature());
        trainDataSet.testNonNullValues();
        decision.trainModel(characteristics.getSets(), trainDataSet.getFeatureValue(), trainDataSet.getSurvivedValue());
        decision.displayResults();
        testDataSet.loadFromFile();
        testDataSet.extractFeature(testDataSet.getAllLines(), decision.getFeature());
        testDataSet.testNonNullValues();
        prediction.TestLines(testDataSet.getFeatureValue(), decision.getModel(), testDataSet.getSurvivedValue());
        prediction.getCorrectlyClassifiedInstancesPercentage(testDataSet.getFeatureValue());
        System.out.println(decision);
    }
}
