package Model;

import java.util.List;

public class Ballot {


    private String ballotType;
    private List<BaseCandidate> candidateList;

    public Ballot(String ballotType, List<BaseCandidate> candidateList) {
        this.ballotType = ballotType;
        this.candidateList = candidateList;
    }

    public Ballot() {
    }

    public Ballot(String ballotType) {
        this.ballotType = ballotType;
    }

    public String getBallotType() {
        return ballotType;
    }

    public void setBallotType(String ballotType) {
        this.ballotType = ballotType;
    }

    public List<BaseCandidate> getCandidateList() {
        return candidateList;
    }

    public void setCandidateList(List<BaseCandidate> candidateList) {
        this.candidateList = candidateList;
    }

    @Override
    public String toString() {
        return "Ballot{" +
                "ballotType='" + ballotType + '\'' +
                ", candidateList=" + candidateList +
                '}';
    }
}
