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
        public void testGetSessionID() {
            assertEquals("123456", testVoteSessionInstance.getSessionID());
        }

        @Test
        public void testBallotListItems() {
           ArrayList<Ballot> ballots = testVoteSessionInstance.getVoteBallots();
           assertNotNull(ballots);
        }

        @After
        public void cleanup() {
            testVoteSessionInstance = null;
        }
    }
