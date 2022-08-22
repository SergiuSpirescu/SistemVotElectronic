package Model;

import java.io.BufferedReader;
import java.util.ArrayList;


//Singleton Class
public class VoteSession {

    private static VoteSession theInstance = null; // Singleton instance
    private String sessionName; //name read from JSON
    private String precintID; //id read from JSON
    private ArrayList<Ballot> voteBallots;
    public boolean isInitialized = false;


    private VoteSession() {

        this.sessionName = "";
        this.precintID = "";
        this.voteBallots = new ArrayList<>();
    }

    public static VoteSession getInstance() {
        if (theInstance == null) {
            theInstance = new VoteSession();
        }
        return theInstance;
    }

    public void initSession(){

        String sesName;
        String precID;
        //Establish connection to data source



        //Fetch Data


        //Validate Data


        //Assign Data
//        setSessionName(sesName);
//        setPrecintID(precID);

        setSessionName("Test Session Name");
        setPrecintID("Test Precint ID");

        this.isInitialized = true;

    }

    public String getSessionName() {
        return this.sessionName;
    }

    private void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getPrecintID() {

        return precintID;
    }

    private void setPrecintID(String precintID)
    {
        this.precintID = precintID;
    }

}
