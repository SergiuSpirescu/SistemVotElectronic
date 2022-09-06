package UnitTest;

import Model.Ballot;
import Model.JSONHandler.JsonReader;

import Model.VoteSession;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;


public class VoteSessionTest {


     VoteSession testVoteSessionInstance = VoteSession.getInstance();

        @Before
        public void setup() {
            String sourceFile = "resources/Data Inputs/simpleDataFile.json";

            if (testVoteSessionInstance.isInitialized != true)
            {
                JsonReader.initSession(sourceFile, testVoteSessionInstance);
            }
        }

        @Test
        public void testGetSessionName() {
            assertEquals("Test Session Name", testVoteSessionInstance.getSessionName());
        }

        @Test
        @Ignore("Not implemented")
        public void testGetSessionID() {
        }

        @Test
        @Ignore("Not implemented")
        public void testBallotListItems() {
           ArrayList<Ballot> ballots = testVoteSessionInstance.getVoteBallots();

           assertNotNull(ballots);
           System.out.println(ballots);

        }

        @After
        public void cleanup() {
            testVoteSessionInstance = null;
        }
    }
