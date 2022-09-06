package Model;

import java.util.HashMap;

public class Ballot {

    protected String ballotType;
    protected HashMap<Integer, BaseCandidate> candidates;

    public String getBallotType() {
        return ballotType;
    }

    public void setBallotType(String ballotType) {
        this.ballotType = ballotType;
    }

    public HashMap<Integer, BaseCandidate> getCandidates() {
        return candidates;
    }

    public void addCandidate(int pos, BaseCandidate candidate) {
        this.candidates.put(pos, candidate);
    }
}
