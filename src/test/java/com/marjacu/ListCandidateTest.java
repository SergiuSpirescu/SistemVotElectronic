package com.marjacu;

import com.marjacu.sistemvotelectronic.Model.ListCandidate;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@Ignore("Not implemented")
public class ListCandidateTest {

    private ListCandidate candidate;

    @Before
    public void setup() {

        ArrayList<String> testList = new ArrayList<>();

        //to fill up testList with random names for testing

        candidate = new ListCandidate(8, "Java Party", testList);
    }

    @Ignore ("Test Not Implemented")
    @Test
    public void testGetCandidateNameList() {
//        assertEquals("Full Candidate Name", candidate.getCandidateNameList());

    //assert list of candidates fetched from the instance
        
    }

    @Ignore ("Test Not Implemented")
    @Test
    public void testGetPosition() {
        assertEquals(8,candidate.getPositionCount());

    }
    
}