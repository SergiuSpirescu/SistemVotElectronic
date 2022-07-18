package Model;

import java.util.ArrayList;

public class BaseCandidate {

    private ArrayList<String> candidateName;
    private int position;
    private int listSize;

    public ArrayList<String> getCandidateName() {
        return this.candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName.add(candidateName);
    }

    public int getPosition() {
        return this.position;
    }
}

