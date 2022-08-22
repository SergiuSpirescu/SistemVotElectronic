package Model;

import java.io.BufferedReader;
import java.util.ArrayList;


//Singleton Class
public class VoteSession {

    private static VoteSession theInstance = null; // Singleton instance
    private String sessionName; //id read from JSON
    private String precintID;
    ArrayList<Ballot> voteBallots;


    private VoteSession() {

        this.sessionName = "";
        this.precintID = "";
        this.voteBallots = new ArrayList<>();
    }

    public static VoteSession getInstance() {
        if (theInstance == null) {
            theInstance = new VoteSession();
            initSession();
        }
        return theInstance;
    }

    //for testing purposes
    public static VoteSession getInstance(boolean test) {

        if (theInstance == null) {
            theInstance = new VoteSession();
            if (test) {
                initSession();
            }
        }
        return theInstance;
    }

    private static void initSession(){

        String sesName;
        String precID;
        //Establish connection to data source



        //Fetch Data


        //Validate Data


        //Assign Data
//        setSessionName(sesName);
//        setPrecintID(precID);

    }

    private void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    private void setPrecintID(String precintID) {
        this.precintID = precintID;
    }

    public String getSessionName() {
        return this.sessionName;
    }

    public String getPrecintID() {
        return precintID;
    }

}
