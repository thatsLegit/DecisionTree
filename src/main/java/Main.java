public class Main {
    public static void main(String[] args) {
        TrainingDataSet training = new TrainingDataSet();
        Entropy entropy = new Entropy();
        DecisionTree decision = new DecisionTree();
        TestDataSet testDataSet = new TestDataSet();
        Prediction prediction = new Prediction();
        training.loadFromFile();
        entropy.loadFeatures(training.getAllLines());
        entropy.featuresSelection();
        entropy.displaySelected();
        decision.featureSelection();
        training.extractFeature(training.getAllLines(), decision.getFeature());
        training.testNonNullValues();
        decision.trainModel();
        decision.getModel();
        testDataSet.loadFromFile();
        testDataSet.extractFeature(TestDataSet.allLines,decision.getFeature());
        testDataSet.testNonNullValues();
        prediction.TestLines();
        prediction.getCorrectlyClassifiedInstancesPercentage();
    }
}
