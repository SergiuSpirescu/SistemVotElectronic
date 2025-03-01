package com.marjacu;

import com.marjacu.sistemvotelectronic.Model.NominalCandidate;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

@Ignore("Not implemented")
public class NominalCandidateTest {

    @Ignore("Test Not Implemented")
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

    @Ignore ("Test Not Implemented")
    @Test
    public void testGetPosition() {
        NominalCandidate candidate = new NominalCandidate("Full Candidate Name", 5, "Java Party");
        assertEquals(5, candidate.getPositionCount());

    }

    @Test
    public void testSetPosition() {
        NominalCandidate candidate = new NominalCandidate("Full Candidate Name", 0, "Java Party");
        candidate.setPositionCount(8);
        assertEquals(8,candidate.getPositionCount());

    }


}