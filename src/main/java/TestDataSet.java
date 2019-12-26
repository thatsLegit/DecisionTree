import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TestDataSet implements DAO {

    static List<String> allLines;
    static ArrayList<String> survivedValue;
    static ArrayList<String> featureValue;

    public TestDataSet() {
        allLines = new ArrayList<>();
        survivedValue = new ArrayList<>();
        featureValue = new ArrayList<>();
    }

    public void extractFeature(List<String> lines, int feature) {
        if (feature != 5) {
            for (int i = 1; i < lines.size(); i++) {
                String[] split = lines.get(i).split(";");
                String nbSurvived = split[1];
                survivedValue.add(nbSurvived);
                String anyFeature = split[feature];
                featureValue.add(anyFeature);
            }
        } else {
            for (int i = 1; i < lines.size(); i++) {
                String[] split = lines.get(i).split(";");
                String nbSurvived = split[1];
                survivedValue.add(nbSurvived);
                String ageCategory = Entropy.refactorAge(split[5]);
                featureValue.add(ageCategory);
            }
        }
    }

    public void loadFromFile() {
        Path orderPath = Paths.get("/Users/stepanov/IdeaProjects/DecisionTree/src/main/resources/test.csv");
        try {
            allLines = Files.readAllLines(orderPath);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error");
        }
    }

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
}
