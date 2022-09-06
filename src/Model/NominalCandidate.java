package Model;

public class NominalCandidate extends BaseCandidate {

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    private String candidateName;

    public NominalCandidate(String candidateName, int position, String partyName){
        super(position, partyName);
        this.candidateName = candidateName;
    }
}
