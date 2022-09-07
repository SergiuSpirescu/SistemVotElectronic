package Model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

//Singleton Class
public class VoteSession {
    private static VoteSession theInstance = null; // Singleton instance

    public boolean isInitialized = false;
    private String voteSessionName; //name read from JSON
    private String voteSessionID; //id read from JSON
    private int numberOfBallots;
    private ArrayList<Ballot> ballotList;

    private VoteSession() {

        this.voteSessionName = "";
        this.voteSessionID = "";
        this.numberOfBallots = 0;
        this.ballotList = new ArrayList<>();
    }

    private VoteSession(boolean isInitialized, String voteSessionName, String voteSessionID, int numberOfBallots, ArrayList<Ballot> ballotList) {
        this.isInitialized = false;
        this.voteSessionName = voteSessionName;
        this.voteSessionID = voteSessionID;
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

}
