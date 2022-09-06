package Model.JSONHandler;


import Model.Ballot;
import Model.BaseCandidate;
import Model.VoteSession;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;


public class JsonReader {

    private static ObjectMapper mapper = new ObjectMapper();

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

           JsonNode ballotNode = mainNode.path("ballotList");
            final int numberOfBallots = mainNode.get("numberOfBallots").asInt();





        }


    }


}
