package com.marjacu.sistemvotelectronic.Model;

import java.util.ArrayList;

//Singleton Class
public class VoteSession {
    private static VoteSession theInstance = null; // Singleton instance

    public boolean isInitialized = false;
    private String voteSessionID; //id read from JSON
    private String voteSessionName; //name read from JSON
    private String votePrecintID;
    private int numberOfBallots;
    private ArrayList<Ballot> ballotList;
    private VoteSession() {

        this.voteSessionName = "";
        this.voteSessionID = "";
        this.numberOfBallots = 0;
        this.ballotList = new ArrayList<>();
    }

    private VoteSession(boolean isInitialized, String voteSessionID, String voteSessionName, String votePrecintID, int numberOfBallots, ArrayList<Ballot> ballotList) {
        this.isInitialized = false;
        this.voteSessionName = voteSessionName;
        this.voteSessionID = voteSessionID;
        this.votePrecintID = votePrecintID;
        this.numberOfBallots = numberOfBallots;
        this.ballotList = ballotList;
    }

    public static VoteSession getInstance() {
        if (theInstance == null) {
            theInstance = new VoteSession();
        }
        return theInstance;
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

    public String getVotePrecintID() {
        return votePrecintID;
    }

    public void setVotePrecintID(String votePrecintID) {
        this.votePrecintID = votePrecintID;
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

    @Override
    public String toString() {
        return "VoteSession{" +
                ", voteSessionName='" + voteSessionName + '\'' +
                ", voteSessionID='" + voteSessionID + '\'' +
                ", numberOfBallots=" + numberOfBallots +
                ", ballotList=" + ballotList +
                '}';
    }

    public void storeData(VoteSessionContainer container) {

        this.setVoteSessionID(container.getVoteSessionID());
        this.setVoteSessionName(container.getVoteSessionName());
        this.setVotePrecintID(container.getVotePrecintID());
        this.setNumberOfBallots(container.getNumberOfBallots());
        this.setBallotList(container.getBallotList());
        this.setInitialized(true);
    }

}
