package Model.JSONHandler;


import Model.Ballot;
import Model.BaseCandidate;
import Model.VoteSession;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonReader {

    static ObjectMapper mapper = new ObjectMapper();

    public static void initSession(String dataSource, VoteSession session) throws IOException {

        if (session == null) {return;}

        File file = new File(dataSource);

        JsonNode mainNode = mapper.readTree(file);

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
            JsonNode ballotNode = mainNode.get("ballotList");

            Ballot ballotContainer = new Ballot();

            ballotContainer.setBallotType(ballotNode.get("ballotType").asText());

            //Nominal or List Ballot ?
            if (ballotContainer.getBallotType().equals("Nominal")) {

                //Nominal Ballot means parsing just one String as candidate name
                //First create Node inside the candidate json

                JsonNode candidateNode = ballotNode.get("candidateList");

            }


        }


    }


}
