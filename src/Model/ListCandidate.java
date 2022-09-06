package Model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListCandidate extends BaseCandidate implements ICandidate {

    private int positionCount;
    private String partyName;
    private ArrayList<String> namesList;

    public ListCandidate() {
        super();
    }

    @Override
    public int getPositionCount() {
        return positionCount;
    }

    @Override
    public void setPositionCount(int positionCount) {
        this.positionCount = positionCount;
    }

    @Override
    public String getPartyName() {
        return partyName;
    }

    @Override
    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public ArrayList<String> getNamesList() {
        return namesList;
    }

    public void setNamesList(ArrayList<String> namesList) {
        this.namesList = namesList;
    }
}
