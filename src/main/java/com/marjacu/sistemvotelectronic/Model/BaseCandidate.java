package com.marjacu.sistemvotelectronic.Model;

import java.util.List;

public class BaseCandidate {

    private int positionCount;
    private String candidateID;
    private String partyName;
    private List<String> nameList;

    public BaseCandidate(int positionCount, String candidateID, String partyName, List<String> nameList) {
        this.positionCount = positionCount;
        this.candidateID = candidateID;
        this.partyName = partyName;
        this.nameList = nameList;
    }

    public BaseCandidate() {
    }

    public int getPositionCount() {
        return this.positionCount;
    }

    public void setPositionCount(int positionCount) {
        this.positionCount = positionCount;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public List<String> getNameList() {
        return nameList;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }

    @Override
    public String toString() {
        StringBuilder names = new StringBuilder();
        for (String s : this.nameList) {
            names.append("\n\t\t").append(s);
        }
        String plural;
        if (this.nameList.size() == 1) {
            plural = "Candidat";
        } else {
            plural = "Candidați";
        }

        return "Poziția " + positionCount +
                "\n\tID " + candidateID +
                "\n\tPartid " + partyName  +
                "\n\tNume " + plural + ":" + names;
    }

    public String getCandidateID() {
        return this.candidateID;
    }

    public void setCandidateID(String candidateID) {
        this.candidateID = candidateID;
    }
}

