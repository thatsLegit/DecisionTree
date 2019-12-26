import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TrainingDataSet implements DAO {

    static ArrayList<String> survivedValue;
    static ArrayList<String> featureValue;
    static List<String> allLines;

    public TrainingDataSet() {
        survivedValue = new ArrayList<>();
        featureValue = new ArrayList<>();
        allLines = new ArrayList<>();
    }

    //extract the needed feature based on the choice
    public void extractFeature(List<String> lines, int feature) {
        for (int i = 1; i < lines.size(); i++) {
            String[] split = lines.get(i).split(";");
            String nbSurvived = split[1];
            survivedValue.add(nbSurvived);
            if (feature == 5) {
                String ageCategory = Entropy.refactorAge(split[feature]);
                featureValue.add(ageCategory);
            }
            else if (feature == 9){
                String fareCategory = Entropy.refactorFare(split[feature]);
                featureValue.add(fareCategory);
            }
            else {
                String anyFeature = split[feature];
                featureValue.add(anyFeature);
            }
        }
    }

    //Don't forget to modify the name of your directory
    @Override
    public void loadFromFile() {
        Path orderPath = Paths.get("/Users/stepanov/IdeaProjects/DecisionTree/src/main/resources/train.csv");
        try {
            allLines = Files.readAllLines(orderPath);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error");
        }
    }

    //eliminate empty cells for the choosen feature
    @Override
    public void testNonNullValues(){
        for (int i=0;i<featureValue.size();i++){
            if (featureValue.get(i).equals("")){
                featureValue.remove(i);
                survivedValue.remove(i);
                i--;
            }
        }
    }

    public List<String> getAllLines() {
        return allLines;
    }
}

