package Model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListCandidate extends BaseCandidate implements ICandidate {

    private ArrayList<String> namesList;

    public ListCandidate() {
        super();
    }

    public ListCandidate(int i, String java_party, ArrayList<String> testList) {
    }

    public ArrayList<String> getNamesList() {
        return namesList;
    }

    public void setNamesList(ArrayList<String> namesList) {
        this.namesList = namesList;
    }
}
