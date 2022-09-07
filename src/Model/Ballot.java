package Model;

import java.util.HashMap;
import java.util.Set;

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

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        for (Integer ks : candidateList.keySet()) {
            BaseCandidate bc = candidateList.get(ks);
            stringBuilder.append(bc.getPartyName() + " ");
        }

        return stringBuilder.toString();
    }
}
