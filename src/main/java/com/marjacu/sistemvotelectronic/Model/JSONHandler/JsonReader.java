package com.marjacu.sistemvotelectronic.Model.JSONHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marjacu.sistemvotelectronic.Model.VoteSession;
import com.marjacu.sistemvotelectronic.Model.VoteSessionContainer;
import java.io.File;
import java.io.IOException;


public class JsonReader {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static void initSession(String dataSource, VoteSession session) throws IOException {


        File file = new File(dataSource);
        VoteSessionContainer container = mapper.readValue(file, VoteSessionContainer.class);
        session.storeData(container);


        //TO-DO data integrity checks ?
//        session.setInitialized(true);
    }


}
