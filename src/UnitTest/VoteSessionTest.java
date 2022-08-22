package UnitTest;

import Model.VoteSession;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

public class VoteSessionTest {


        VoteSession testVoteSessionInstance = VoteSession.getInstance(true, "Test Precint ID", "Test Session Name");

        @Test
        public void testGetSessionName() {
            assertEquals("Test Session Name", testVoteSessionInstance.getSessionName());
        }

        @Test
        public void testGetPrecintID() {
            assertEquals("Test Precint ID", testVoteSessionInstance.getPrecintID());
        }

    }
