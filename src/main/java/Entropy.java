import java.util.*;

public class Entropy {
    //classe servant à determiner et afficher les différentes features
    //sur lesquelles il est possible de discriminer

    static HashMap<String, Integer> Selection;
    static List<Set<String>> Sets;
    Set<String> PassengerId;
    Set<String> Survived;
    Set<String> Pclass;
    Set<String> Name;
    Set<String> Sex;
    static Set<String> Age;
    Set<String> SibSp;
    Set<String> Parch;
    Set<String> Ticket;
    Set<String> Fare;
    Set<String> Cabin;
    Set<String> Embarked;

    public Entropy() {
        Selection = new HashMap<>();
        Sets = new ArrayList<>();
        PassengerId = new HashSet<>();
        Survived = new HashSet<>();
        Pclass = new HashSet<>();
        Name = new HashSet<>();
        Sex = new HashSet<>();
        Age = new HashSet<>();
        SibSp = new HashSet<>();
        Parch = new HashSet<>();
        Ticket = new HashSet<>();
        Fare = new HashSet<>();
        Cabin = new HashSet<>();
        Embarked = new HashSet<>();
    }

    public static String refactorAge(String age) {
        AgeCategory ageCategory;
        if (age.equals("")){
            return "";
        }
        if (Float.parseFloat(age) < 18) {
            ageCategory = AgeCategory.child;
        } else if (Float.parseFloat(age) < 60){
            ageCategory = AgeCategory.adult;
        } else {
            ageCategory = AgeCategory.senior;
        }
        Age.add(String.valueOf(ageCategory));
        return String.valueOf(ageCategory);
    }

    public void loadFeatures(List<String> allLines){
        for (int i = 1; i < allLines.size(); i++) {
            String[] doSplit = allLines.get(i).split(";");
            PassengerId.add(doSplit[0]);
            Pclass.add(doSplit[2]);
            Name.add(doSplit[3]);
            Sex.add(doSplit[4]);
            SibSp.add(doSplit[6]);
            Parch.add(doSplit[7]);
            Ticket.add(doSplit[8]);
            Fare.add(doSplit[9]);
            Cabin.add(doSplit[10]);
            Embarked.add(doSplit[11]);
        }
        Sets.add(PassengerId);
        Sets.add(Survived);
        Sets.add(Pclass);
        Sets.add(Name);
        Sets.add(Sex);
        Sets.add(Age);
        Sets.add(SibSp);
        Sets.add(Parch);
        Sets.add(Ticket);
        Sets.add(Fare);
        Sets.add(Cabin);
        Sets.add(Embarked);
    }

    public void featuresSelection(){
        if (PassengerId.size()<10) {
            Selection.put("PassengerId", 0);
        }
        if (Pclass.size()<10) {
            Selection.put("Pclass", 2);
        }
        if (Name.size()<10) {
            Selection.put("Name", 3);
        }
        if (Sex.size()<10) {
            Selection.put("Sex", 4);
        }
        Selection.put("Age", 5);
        if (SibSp.size()<10) {
            Selection.put("SibSp", 6);
        }
        if (Parch.size()<10) {
            Selection.put("Parch", 7);
        }
        if (Ticket.size()<10) {
            Selection.put("Ticket", 8);
        }
        if (Fare.size()<10) {
            Selection.put("Fare", 9);
        }
        if (Cabin.size()<10) {
            Selection.put("Cabin", 10);
        }
        if (Embarked.size()<10) {
            Selection.put("Embarked", 11);
        }
    }

    public void displaySelected(){
        System.out.println("");
        System.out.println("Available features : " + System.lineSeparator());
        for (Map.Entry<String, Integer> entry : Selection.entrySet()){
            System.out.println(entry.getKey() + " (" + entry.getValue() + ")");
        }
        System.out.println("");
    }
}
