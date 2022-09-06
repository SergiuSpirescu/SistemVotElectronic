package Model;

import java.util.HashMap;

public class Ballot {

    protected String ballotType;

    protected HashMap<Integer, BaseCandidate> candidateList;

    public String getBallotType() {
        return ballotType;
    }

    public void setBallotType(String ballotType) {
        this.ballotType = ballotType;
    }

    public HashMap<Integer, BaseCandidate> getCandidates() {
        return candidateList;
    }

    public void addCandidate(int pos, BaseCandidate candidate) {
        this.candidateList.put(pos, candidate);
    }

    public void setCandidateList(HashMap<Integer, BaseCandidate> candidateList) {
        this.candidateList = candidateList;
    }
}
