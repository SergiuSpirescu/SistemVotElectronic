package UnitTest;

import Model.Ballot;
import Model.JSONHandler.JsonReader;

import Model.VoteSession;
import static org.junit.Assert.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;


public class VoteSessionTest {


     VoteSession testVoteSessionInstance = VoteSession.getInstance();

        @Before
        public void setup() {
            String sourceFile = "resources/Data Inputs/simpleDataFile.json";

            if (testVoteSessionInstance.isInitialized != true)
            {
                try {
                    JsonReader.initSession(sourceFile, testVoteSessionInstance);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        @Test
        public void testGetSessionName() {
            assertEquals("Test Session Name", testVoteSessionInstance.getSessionName());
            System.out.println(testVoteSessionInstance.getSessionName());
        }

        @Test
        public void testGetSessionID() {
            assertEquals("123456", testVoteSessionInstance.getSessionID());
        }

        @Test
        public void testBallotListItems() {
           ArrayList<Ballot> ballots = testVoteSessionInstance.getVoteBallots();
           assertNotNull(ballots);
            ballots.forEach(s -> System.out.println(s + " "));
        }

        @Test
        public void testGetNumberOfBallots() {
            assertEquals(1, testVoteSessionInstance.getNumberOfBallots());
        }

        @After
        public void cleanup() {
            testVoteSessionInstance = null;
        }
    }
