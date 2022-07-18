package Model;

import java.util.ArrayList;


//Singleton Class
public class VoteSession {

    private String sessionName; //id read from JSON
    private VoteSession theInstance;

    public VoteSession() {}

    public VoteSession getVoteSession() {
        if (theInstance == null) {
            theInstance = new VoteSession();
        }
        return theInstance;
    }


    ArrayList<Ballot> voteBallots;

    private void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getSessionName() {
        return this.sessionName;
    }

}
