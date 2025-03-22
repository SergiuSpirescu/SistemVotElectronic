package com.marjacu.sistemvotelectronic.Model;

import java.util.ArrayList;
import java.util.List;

public class Ballot {


    private String ballotID;
    private String ballotName;
    private ArrayList<BaseCandidate> candidateList;

    public Ballot(String ballotID, String ballotName, ArrayList<BaseCandidate> candidateList) {
        this.ballotID = ballotID;
        this.ballotName = ballotName;
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

    public String getBallotName() {
        return ballotName;
    }

    public void setBallotName(String ballotName) {
        this.ballotName = ballotName;
    }

    public ArrayList<BaseCandidate> getCandidateList() {
        return candidateList;
    }

    public void setCandidateList(ArrayList<BaseCandidate> candidateList) {
        this.candidateList = candidateList;
    }

    @Override
    public String toString() {
        return "Ballot{" +
                "ballotID='" + ballotID + '\'' +
                "ballotName='" + ballotName + '\'' +
                ", candidateList=" + candidateList +
                '}';
    }
}
