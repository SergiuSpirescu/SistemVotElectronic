package UnitTest;

import Model.NominalCandidate;
import org.junit.Test;

import static org.junit.Assert.*;

public class NominalCandidateTest {

    @Test
    public void testGetCandidateName() {
        NominalCandidate candidate = new NominalCandidate("Full Candidate Name", 5, "Java Party");
        assertEquals("Full Candidate Name", candidate.getCandidateName());
    }

    @Test
    public void testSetCandidateName() {
        NominalCandidate candidate = new NominalCandidate("Full Candidate Name", 5, "Java Party");
        candidate.setCandidateName("New Name");
        assertEquals("New Name", candidate.getCandidateName());
    }

    @Test
    public void testGetPosition() {
        NominalCandidate candidate = new NominalCandidate("Full Candidate Name", 5, "Java Party");
        assertEquals(5, candidate.getPosition());

    }


}