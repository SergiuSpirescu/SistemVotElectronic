package Model;

import java.util.ArrayList;

public class BaseCandidate {

    private int position;
    private int listSize;
    private String partyName;

    public BaseCandidate(int position, String partyName) {
        this.position = position;
        this.partyName = partyName;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int pos) {
        this.position = pos;
    }
}

