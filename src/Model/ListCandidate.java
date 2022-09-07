package Model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public void addCandidate(List<String> candidateList) {
        namesList.addAll(candidateList);
    }
}
