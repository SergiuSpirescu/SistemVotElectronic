package Model;

import java.io.BufferedReader;
import java.util.ArrayList;


//Singleton Class
public class VoteSession {

    private static VoteSession theInstance = null; // Singleton instance
    private static String sessionName; //name rad from JSON
    private static String precintID; //id read from JSON
    private static ArrayList<Ballot> voteBallots;


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
    public static VoteSession getInstance(boolean test, String precintId, String sessionName) {

        if (theInstance == null) {
            theInstance = new VoteSession();
            if (!test) {
                initSession();
            } else {
                setPrecintID(precintId);
                setSessionName(sessionName);
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

    private static void setSessionName(String sessionName) {
        sessionName = sessionName;
    }

    private static void setPrecintID(String precintID) {
        precintID = precintID;
    }

    public String getSessionName() {
        return this.sessionName;
    }

    public String getPrecintID() {
        return precintID;
    }

}
