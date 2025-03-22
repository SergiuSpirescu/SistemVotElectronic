package com.marjacu.sistemvotelectronic.Model;

import java.util.List;

public class Ballot {


    private String ballotID;
    private List<BaseCandidate> candidateList;

    public Ballot(String ballotID, List<BaseCandidate> candidateList) {
        this.ballotID = ballotID;
        this.candidateList = candidateList;
    }

    public Ballot() {
    }

    public Ballot(String ballotID) {
        this.ballotID = ballotID;
    }

    public String getBallotID() {
        return ballotID;
    }

    public void setBallotID(String ballotID) {
        this.ballotID = ballotID;
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
                "ballotID='" + ballotID + '\'' +
                ", candidateList=" + candidateList +
                '}';
    }
}
