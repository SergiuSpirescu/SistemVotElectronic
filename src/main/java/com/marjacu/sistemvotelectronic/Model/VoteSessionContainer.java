package com.marjacu.sistemvotelectronic.Model;

import java.util.ArrayList;

public class VoteSessionContainer {


    public boolean isInitialized = false;
    private String voteSessionName; //name read from JSON
    private String voteSessionID; //id read from JSON
    private int numberOfBallots;
    private ArrayList<Ballot> ballotList;

    public VoteSessionContainer() {

        this.voteSessionName = "";
        this.voteSessionID = "";
        this.numberOfBallots = 0;
        this.ballotList = new ArrayList<>();
    }

    public VoteSessionContainer(boolean isInitialized, String voteSessionName, String voteSessionID, int numberOfBallots, ArrayList<Ballot> ballotList) {
        this.isInitialized = false;
        this.voteSessionName = voteSessionName;
        this.voteSessionID = voteSessionID;
        this.numberOfBallots = numberOfBallots;
        this.ballotList = ballotList;
    }

    public boolean isInitialized() {
        return isInitialized;
    }

    public void setInitialized(boolean initialized) {
        isInitialized = initialized;
    }

    public String getVoteSessionName() {
        return voteSessionName;
    }

    public void setVoteSessionName(String voteSessionName) {
        this.voteSessionName = voteSessionName;
    }

    public String getVoteSessionID() {
        return voteSessionID;
    }

    public void setVoteSessionID(String voteSessionID) {
        this.voteSessionID = voteSessionID;
    }

    public int getNumberOfBallots() {
        return numberOfBallots;
    }

    public void setNumberOfBallots(int numberOfBallots) {
        this.numberOfBallots = numberOfBallots;
    }

    public ArrayList<Ballot> getBallotList() {
        return ballotList;
    }

    public void setBallotList(ArrayList<Ballot> ballotList) {
        this.ballotList = ballotList;
    }
}
