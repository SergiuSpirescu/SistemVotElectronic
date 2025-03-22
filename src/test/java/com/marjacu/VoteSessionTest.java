package com.marjacu;

import com.marjacu.sistemvotelectronic.Model.Ballot;
import com.marjacu.sistemvotelectronic.Model.JSONHandler.JsonReader;
import com.marjacu.sistemvotelectronic.Model.VoteSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

//@Ignore("Not implemented")
public class VoteSessionTest {

     VoteSession testVoteSessionInstance = VoteSession.getInstance();

//        @Ignore ("Test Not Implemented")
        @Before
        public void setup() {
            String sourceFile = "resources\\Data Inputs\\simpleDataFile.json";

            if (!testVoteSessionInstance.isInitialized)
            {
                try {
                    JsonReader.initSession(sourceFile, testVoteSessionInstance);
                } catch (IOException e) {
                    throw new RuntimeException(e);
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

//        @Ignore("Test Not Implemented")
        @Test
        public void testBallotListItems() {
           ArrayList<Ballot> ballots = testVoteSessionInstance.getBallotList();
           assertEquals(4, ballots.size());
            new ArrayList<>(testVoteSessionInstance.getBallotList())
                   .forEach(s -> {
                       System.out.println("Ballot ID: " + s.getBallotID());
                       System.out.println("Ballot Name: " + s.getBallotName());
                       System.out.println(s.getCandidateList().toString());
                   });
        }

        @After
        public void cleanup() {
            testVoteSessionInstance = null;
        }
    }
