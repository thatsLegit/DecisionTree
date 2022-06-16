import java.util.*;

public class Characteristics {

    //This class is choosing the most relevant features and displays them

    static HashMap<Integer, String> Selection; //Map of the features name + their int value
    List<Set<String>> Sets; //List of features, with all its profiles values in sets
    Set<String> PassengerId;
    Set<String> Survived;
    Set<String> Pclass;
    Set<String> Name;
    Set<String> Sex;
    static Set<String> Age; //special feature
    Set<String> SibSp;
    Set<String> Parch;
    Set<String> Ticket;
    static Set<String> Fare; //special feature
    Set<String> Cabin;
    Set<String> Embarked;

    public Characteristics() {
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

    //making categories for age
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

    //making categories for fare prices
    public static String refactorFare(String fare) {
        FareCategory fareCategory;
        if (fare.equals("")){
            return "";
        }
        if (Float.parseFloat(fare) < 10) {
            fareCategory = FareCategory.cheap;
        } else if (Float.parseFloat(fare) < 50){
            fareCategory = FareCategory.mediumPrice;
        } else {
            fareCategory = FareCategory.expensive;
        }
        Fare.add(String.valueOf(fareCategory));
        return String.valueOf(fareCategory);
    }

    //loading all features into Sets, so it can be them filtered by relevance
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
            Cabin.add(doSplit[10]);
            Embarked.add(doSplit[11]);
        }
        Sets.add(PassengerId); Sets.add(Survived); Sets.add(Pclass); Sets.add(Name); Sets.add(Sex); Sets.add(Age);
        Sets.add(SibSp); Sets.add(Parch); Sets.add(Ticket); Sets.add(Fare); Sets.add(Cabin); Sets.add(Embarked);
    }

    //feature filter (irrelevant features are eliminated from selection)
    public void featuresSelection(){
        if (PassengerId.size()<10) {
            Selection.put(0, "PassengerId");
        }
        if (Pclass.size()<10) {
            Selection.put(2, "Pclass");
        }
        if (Name.size()<10) {
            Selection.put(3, "Name");
        }
        if (Sex.size()<10) {
            Selection.put(4, "Sex");
        }
        Selection.put(5, "Age");
        if (SibSp.size()<10) {
            Selection.put(6, "SibSp");
        }
        if (Parch.size()<10) {
            Selection.put(7, "Parch");
        }
        if (Ticket.size()<10) {
            Selection.put(8, "Ticket");
        }
        Selection.put(9,"Fare");
        if (Cabin.size()<10) {
            Selection.put(10, "Cabin");
        }
        if (Embarked.size()<10) {
            Selection.put(11, "Embarked");
        }
    }

    //Display filtered features to be them selected for the decision tree
    public void displaySelected(){
        System.out.println("");
        System.out.println("Available features : " + System.lineSeparator());
        for (Map.Entry<Integer, String> entry : Selection.entrySet()){
            System.out.println(entry.getValue() + " (" + entry.getKey() + ")");
        }
        System.out.println("");
    }

    public HashMap<Integer, String> getSelection() {
        return Selection;
    }

    public List<Set<String>> getSets() {
        return Sets;
    }
}
