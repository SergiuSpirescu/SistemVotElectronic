package Model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

//Singleton Class
public class VoteSession {

    private static VoteSession theInstance = null; // Singleton instance
    public boolean isInitialized = false;
    private String sessionName; //name read from JSON
    private String sessionID; //id read from JSON
    private int numberOfBallots;
    private ArrayList<Ballot> voteBallots;


    private VoteSession() {

        this.sessionName = "";
        this.sessionID = "";
        this.numberOfBallots = 0;
        this.voteBallots = new ArrayList<>();
    }

    public static VoteSession getInstance() {
        if (theInstance == null) {
            theInstance = new VoteSession();
        }
        return theInstance;
    }

    public void initSession() {

        String sesName;
        String precID;

        //Establish connection to data source


        //Fetch Data


        //Validate Data


        //Assign Data
//        setSessionName(sesName);
//        setPrecintID(precID);

        setSessionName("Test Session Name");
        setSessionID("Test Precint ID");

        this.isInitialized = true;

    }

    public String getSessionName() {
        return this.sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public void addBallot(Ballot ballot) {
        voteBallots.add(ballot);
    }

    public ArrayList<Ballot> getVoteBallots() {
        return this.voteBallots;
    }

    public void setSessionID(String id) {
        this.sessionID = id;
    }
    public String getSessionID() {
        return this.sessionID;
    }

    public void setNumberOfBallots(int number) {
        this.numberOfBallots = number;
    }

    public int getNumberOfBallots() {
        return this.numberOfBallots;
    }
}
