package UnitTest;

import Controller.JSONHandler.JsonReader;

import Model.VoteSession;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class VoteSessionTest {


     VoteSession testVoteSessionInstance = VoteSession.getInstance();

        @Before
        public void setup() {
            String sourceFile = "resources/Data Inputs/SessionDataSample-Parliament.json";

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

        @After
        public void cleanup() {
            testVoteSessionInstance = null;
        }
    }
