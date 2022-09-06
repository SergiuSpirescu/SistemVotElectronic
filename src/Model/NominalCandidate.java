package Model;

public class NominalCandidate extends BaseCandidate implements ICandidate {

    private String candidateName;

    public NominalCandidate(String full_candidate_name, int i, String java_party) {
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public NominalCandidate(){
        super();
    }
}
