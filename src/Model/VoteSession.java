package Model;

import java.util.ArrayList;

public class VoteSession {

    String sessionName; //id read from JSON

    ArrayList<Ballot> voteBallots;

    private void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getSessionName() {
        return this.sessionName;
    }

    
}
