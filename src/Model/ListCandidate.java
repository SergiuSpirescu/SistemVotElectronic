package Model;

import java.util.ArrayList;

public class ListCandidate extends BaseCandidate {

  private ArrayList<String> candidateNameList;

  public ListCandidate(int position, String partyName, ArrayList<String> nameList){
      super(position,partyName);
      this.candidateNameList = nameList;
  }


}
