package Model.JSONHandler;



import Model.VoteSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class JsonReader {

    private static ObjectMapper mapper = new ObjectMapper();

    public static void initSession(String dataSource, VoteSession session) throws IOException {


        File file = new File(dataSource);
        VoteSession auxSession = VoteSession.getInstance();
        auxSession = mapper.readValue(file, VoteSession.class);


        session.setInitialized(true);
    }


}
