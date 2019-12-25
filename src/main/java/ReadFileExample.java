
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadFileExample {

    public static void main(String[] args){

        ArrayList<String> survivedValue =  new ArrayList<String>();
        ArrayList<String> featureValue =  new ArrayList<String>();

        Path orderPath = Paths.get("/Users/stepanov/IdeaProjects/DecisionTree/src/main/resources/train.csv");
        List<String> lines = null;
        try {
            lines = Files.readAllLines(orderPath);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error");
        }

        for (int i = 1; i < lines.size(); i++) {
            String[] split = lines.get(i).split(";");
            String nbSurvived = split[1];
            survivedValue.add(nbSurvived);
            String nbPclass = split[2];
            featureValue.add(nbPclass);
        }
        for (String e : featureValue){
            System.out.println(e);
        }

        for (int i=0;i<featureValue.size();i++){
            if (featureValue.get(i).equals("")){
                featureValue.remove(i);
                survivedValue.remove(i);
                i--;
            }
        }
    }
}
