package UnitTest;

import Model.VoteSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VoteSessionTest {


    @Before
    public void setUp() throws Exception {

        private static VoteSession testVoteSessionInstance = VoteSession.getInstance(false);
        testVoteSessionInstance.setSessionName("Test Session Name");
        testVoteSessionInstance.setPrecintID("Test ID");
        
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getInstance() {

    }

    @Test
    public void getSessionName() {

    }

    @Test
    public void getPrecintID() {
    }

}