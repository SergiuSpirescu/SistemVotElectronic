package UnitTest;

import Model.SessionFetchAPI;
import Model.VoteSession;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VoteSessionTest {


//        VoteSession testVoteSessionInstance = null;
     VoteSession testVoteSessionInstance = VoteSession.getInstance();

        @Before
        public void setup() {
            SessionFetchAPI simulateAPI = mock(SessionFetchAPI.class);
            simulateAPI.initSession();

            if (testVoteSessionInstance.isInitialized != true)
            {
                simulateAPI.initSession();
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

        @After
        public void cleanup() {
            testVoteSessionInstance = null;
        }
    }
