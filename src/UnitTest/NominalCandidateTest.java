package UnitTest;

import Model.BaseCandidate;
import Model.NominalCandidate;

import static org.junit.Assert.*;

public class NominalCandidateTest {

    @org.junit.Test
    public void testGetCandidateName() {
        NominalCandidate candidate = new NominalCandidate("Full Candidate Name", 5, "Java Party");
        assertEquals("Full Candidate Name", candidate.getCandidateName());
    }

    @org.junit.Test
    public void testSetCandidateName() {
        NominalCandidate candidate = new NominalCandidate("Full Candidate Name", 5, "Java Party");
        candidate.setCandidateName("New Name");
        assertEquals("New Name", candidate.getCandidateName());
    }

    @org.junit.Test
    public void testGetPosition() {
        NominalCandidate candidate = new NominalCandidate("Full Candidate Name", 5, "Java Party");
        assertEquals(5, candidate.getPosition());

    }
}