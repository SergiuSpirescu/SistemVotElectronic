package Model;

import java.util.HashMap;

public class Ballot {

    protected HashMap<Integer, BaseCandidate> candidates;
    protected String ballotType;

    protected String getBallotType() {
        return ballotType;
    }

    protected void setBallotType(String ballotType) {
        this.ballotType = ballotType;
    }

    protected HashMap<Integer, BaseCandidate> getCandidates() {
        return candidates;
    }

    protected void addCandidate(int pos, BaseCandidate candidate) {
        this.candidates.put(pos, candidate);
    }
}
