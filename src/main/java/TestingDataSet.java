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
    String path;

    public TestDataSet(String path) {
        allLines = new ArrayList<>();
        survivedValue = new ArrayList<>();
        featureValue = new ArrayList<>();
        this.path = path;
    }

    //extract the needed feature based on the choice, same implementation as for trainigDataSet
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
    public void loadFromFile() {
        Path pathsTest = Paths.get(path);
        try {
            allLines = Files.readAllLines(pathsTest);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error concerning training file directory");
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
