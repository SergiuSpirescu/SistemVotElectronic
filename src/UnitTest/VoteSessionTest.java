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
import java.util.Collection;
import java.util.stream.Collectors;


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
            assertEquals("Test Session Name", testVoteSessionInstance.getVoteSessionName());
            System.out.println(testVoteSessionInstance.getVoteSessionName());
        }

        @Test
        public void testGetSessionID() {
            assertEquals("123456", testVoteSessionInstance.getVoteSessionID());
        }

        @Test
        public void testBallotListItems() {
           ArrayList<Ballot> ballots = testVoteSessionInstance.getBallotList();
           assertNotNull(ballots);
           testVoteSessionInstance.getBallotList()
                   .stream()
                   .collect(Collectors.toList())
                   .forEach(s -> System.out.println(s.getCandidateList()));
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
