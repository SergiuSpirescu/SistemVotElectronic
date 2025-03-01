package com.marjacu;

import com.marjacu.sistemvotelectronic.Model.Ballot;
import com.marjacu.sistemvotelectronic.Model.VoteSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Ignore("Not implemented")
public class VoteSessionTest {

     VoteSession testVoteSessionInstance = VoteSession.getInstance();

        @Ignore ("Test Not Implemented")
        @Before
        public void setup() {
            String sourceFile = "resources/Data Inputs/simpleDataFile.json";

            if (!testVoteSessionInstance.isInitialized)
            {
//                try {
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
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

        @Ignore("Test Not Implemented")
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
