package UnitTest;

import Model.VoteSession;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class VoteSessionTest {


//        VoteSession testVoteSessionInstance = null;
     VoteSession testVoteSessionInstance = VoteSession.getInstance();

        @Before
        public void setup() {
            if (testVoteSessionInstance.isInitialized != true)
            {
                testVoteSessionInstance.initSession();
            }
        }

        @Test
        public void testGetSessionName() {
            assertEquals("Test Session Name", testVoteSessionInstance.getSessionName());
        }

        @Test
        public void testGetPrecintID() {
            assertEquals("Test Precint ID", testVoteSessionInstance.getPrecintID());
        }

    }
