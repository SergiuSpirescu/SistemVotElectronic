package Model.JSONHandler;


import Model.Ballot;
import Model.BaseCandidate;
import Model.ListCandidate;
import Model.VoteSession;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class JsonReader {

    private static ObjectMapper mapper = new ObjectMapper();

    public static void initSession(String dataSource, VoteSession session) throws IOException {

        if (session == null) {return;}

        File file = new File(dataSource);

        JsonNode mainNode = mapper.readTree(file); // getting the root node of the Json file

        if (mainNode.has("voteSessionID")) {
            session.setSessionID(mainNode.get("voteSessionID").asText("N/A"));
        }

        if (mainNode.has("voteSessionName")) {
            session.setSessionName(mainNode.get("voteSessionName").asText("N/A"));
        }

        if (mainNode.has("numberOfBallots")) {
            session.setNumberOfBallots(mainNode.get("numberOfBallots").asInt(-1));
        }

        if (mainNode.has("ballotList")) {

           JsonNode ballotNode = mainNode.path("ballotList"); // getting the node for the Json array for ballots

            final int numberOfBallots = mainNode.get("numberOfBallots").asInt();

            if (ballotNode.isArray()) {

                for (JsonNode jn : ballotNode) {

                    JsonNode candidateNode = ballotNode.path("candidateList"); // for each element, get the node for each of the candidates

                    if ((ballotNode.get("ballotType").asText().equals("List")) && (candidateNode.isArray())) { // if it is a List type of vote,
                                                                                                               // each position will have a list of names
                        for (JsonNode cn : candidateNode) {
                            ListCandidate lc = new ListCandidate() {};

                            lc.setPositionCount(candidateNode.get("positionCount").asInt());
                            lc.setPartyName(candidateNode.get("partyName").asText());
                            JsonNode namesList = candidateNode.path("candidateList");

                            if (namesList.isArray()) {

                                ArrayList<String> ar = new ArrayList<>();

                                for (JsonNode namesNode : namesList) {

                                    ar.add(namesNode.asText());
                                }

//                            session.getVoteBallots().add();
                        }
                        }
                    } else {

                    }
                }
            }



        }


    }


}
