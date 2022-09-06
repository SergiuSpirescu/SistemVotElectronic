package Model;

public abstract class BaseCandidate {

    private int positionCount;
    private String partyName;

    public BaseCandidate() {
    }

    public int getPositionCount() {
        return this.positionCount;
    }

    public void setPositionCount(int pos) {
        this.positionCount = pos;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }
}

