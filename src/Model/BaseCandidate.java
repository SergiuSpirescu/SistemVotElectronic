package Model;

import java.util.List;

public class BaseCandidate {

    private int positionCount;
    private String partyName;
    private List<String> nameList;

    public BaseCandidate(int positionCount, String partyName, List<String> nameList) {
        this.positionCount = positionCount;
        this.partyName = partyName;
        this.nameList = nameList;
    }

    public BaseCandidate() {
    }

    public int getPositionCount() {
        return positionCount;
    }

    public void setPositionCount(int positionCount) {
        this.positionCount = positionCount;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public List<String> getNameList() {
        return nameList;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }

    @Override
    public String toString() {
        return "BaseCandidate{" +
                "positionCount=" + positionCount +
                ", partyName='" + partyName + '\'' +
                ", nameList=" + nameList.toString() +
                '}';
    }
}

