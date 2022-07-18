package Model;

import java.util.ArrayList;


//Singleton Class
public class VoteSession {

    private static VoteSession theInstance = null; // Singleton instance
    private String sessionName; //id read from JSON
    ArrayList<Ballot> voteBallots;


    private VoteSession() {}

    public VoteSession getVoteSession() {
        if (theInstance == null) {
            theInstance = new VoteSession();
        }
        return theInstance;
    }


    private void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getSessionName() {
        return this.sessionName;
    }

}
